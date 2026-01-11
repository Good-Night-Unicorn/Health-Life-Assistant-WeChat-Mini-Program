package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiankangmubiaoEntity;
import com.entity.view.JiankangmubiaoView;

import com.service.JiankangmubiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康目标
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-28 21:09:32
 */
@RestController
@RequestMapping("/jiankangmubiao")
public class JiankangmubiaoController {
    @Autowired
    private JiankangmubiaoService jiankangmubiaoService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangmubiaoEntity jiankangmubiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiankangmubiao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiankangmubiaoEntity> ew = new EntityWrapper<JiankangmubiaoEntity>();

		PageUtils page = jiankangmubiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangmubiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangmubiaoEntity jiankangmubiao, 
		HttpServletRequest request){
        EntityWrapper<JiankangmubiaoEntity> ew = new EntityWrapper<JiankangmubiaoEntity>();

		PageUtils page = jiankangmubiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangmubiao), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangmubiaoEntity jiankangmubiao){
       	EntityWrapper<JiankangmubiaoEntity> ew = new EntityWrapper<JiankangmubiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangmubiao, "jiankangmubiao")); 
        return R.ok().put("data", jiankangmubiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangmubiaoEntity jiankangmubiao){
        EntityWrapper< JiankangmubiaoEntity> ew = new EntityWrapper< JiankangmubiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangmubiao, "jiankangmubiao")); 
		JiankangmubiaoView jiankangmubiaoView =  jiankangmubiaoService.selectView(ew);
		return R.ok("查询健康目标成功").put("data", jiankangmubiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangmubiaoEntity jiankangmubiao = jiankangmubiaoService.selectById(id);
        return R.ok().put("data", jiankangmubiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangmubiaoEntity jiankangmubiao = jiankangmubiaoService.selectById(id);
        return R.ok().put("data", jiankangmubiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangmubiaoEntity jiankangmubiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiankangmubiao);
        jiankangmubiaoService.insert(jiankangmubiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangmubiaoEntity jiankangmubiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiankangmubiao);
        jiankangmubiaoService.insert(jiankangmubiao);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangmubiaoEntity jiankangmubiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangmubiao);
        jiankangmubiaoService.updateById(jiankangmubiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangmubiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
