package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiankangmubiaoDao;
import com.entity.JiankangmubiaoEntity;
import com.service.JiankangmubiaoService;
import com.entity.vo.JiankangmubiaoVO;
import com.entity.view.JiankangmubiaoView;

@Service("jiankangmubiaoService")
public class JiankangmubiaoServiceImpl extends ServiceImpl<JiankangmubiaoDao, JiankangmubiaoEntity> implements JiankangmubiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangmubiaoEntity> page = this.selectPage(
                new Query<JiankangmubiaoEntity>(params).getPage(),
                new EntityWrapper<JiankangmubiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangmubiaoEntity> wrapper) {
		  Page<JiankangmubiaoView> page =new Query<JiankangmubiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiankangmubiaoVO> selectListVO(Wrapper<JiankangmubiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiankangmubiaoVO selectVO(Wrapper<JiankangmubiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiankangmubiaoView> selectListView(Wrapper<JiankangmubiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangmubiaoView selectView(Wrapper<JiankangmubiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
