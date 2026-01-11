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


import com.dao.JiankangjiluDao;
import com.entity.JiankangjiluEntity;
import com.service.JiankangjiluService;
import com.entity.vo.JiankangjiluVO;
import com.entity.view.JiankangjiluView;

@Service("jiankangjiluService")
public class JiankangjiluServiceImpl extends ServiceImpl<JiankangjiluDao, JiankangjiluEntity> implements JiankangjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangjiluEntity> page = this.selectPage(
                new Query<JiankangjiluEntity>(params).getPage(),
                new EntityWrapper<JiankangjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangjiluEntity> wrapper) {
		  Page<JiankangjiluView> page =new Query<JiankangjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiankangjiluVO> selectListVO(Wrapper<JiankangjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiankangjiluVO selectVO(Wrapper<JiankangjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiankangjiluView> selectListView(Wrapper<JiankangjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangjiluView selectView(Wrapper<JiankangjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiankangjiluEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiankangjiluEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiankangjiluEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
