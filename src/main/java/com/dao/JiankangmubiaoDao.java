package com.dao;

import com.entity.JiankangmubiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangmubiaoVO;
import com.entity.view.JiankangmubiaoView;


/**
 * 健康目标
 * 
 * @author 
 * @email 
 * @date 2024-01-28 21:09:32
 */
public interface JiankangmubiaoDao extends BaseMapper<JiankangmubiaoEntity> {
	
	List<JiankangmubiaoVO> selectListVO(@Param("ew") Wrapper<JiankangmubiaoEntity> wrapper);
	
	JiankangmubiaoVO selectVO(@Param("ew") Wrapper<JiankangmubiaoEntity> wrapper);
	
	List<JiankangmubiaoView> selectListView(@Param("ew") Wrapper<JiankangmubiaoEntity> wrapper);

	List<JiankangmubiaoView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangmubiaoEntity> wrapper);

	
	JiankangmubiaoView selectView(@Param("ew") Wrapper<JiankangmubiaoEntity> wrapper);
	

}
