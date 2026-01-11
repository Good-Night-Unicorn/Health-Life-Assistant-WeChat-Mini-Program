package com.entity.view;

import com.entity.JiankangjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 健康记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-28 21:09:32
 */
@TableName("jiankangjilu")
public class JiankangjiluView  extends JiankangjiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiankangjiluView(){
	}
 
 	public JiankangjiluView(JiankangjiluEntity jiankangjiluEntity){
 	try {
			BeanUtils.copyProperties(this, jiankangjiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
