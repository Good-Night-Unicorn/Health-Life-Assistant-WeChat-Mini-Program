package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiankangmubiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiankangmubiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangmubiaoView;


/**
 * 健康目标
 *
 * @author 
 * @email 
 * @date 2024-01-28 21:09:32
 */
public interface JiankangmubiaoService extends IService<JiankangmubiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangmubiaoVO> selectListVO(Wrapper<JiankangmubiaoEntity> wrapper);
   	
   	JiankangmubiaoVO selectVO(@Param("ew") Wrapper<JiankangmubiaoEntity> wrapper);
   	
   	List<JiankangmubiaoView> selectListView(Wrapper<JiankangmubiaoEntity> wrapper);
   	
   	JiankangmubiaoView selectView(@Param("ew") Wrapper<JiankangmubiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangmubiaoEntity> wrapper);

   	

}

