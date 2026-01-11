package com.entity.model;

import com.entity.CanyuhuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 参与活动
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-01-28 21:09:32
 */
public class CanyuhuodongModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 活动简介
	 */
	
	private String huodongjianjie;
		
	/**
	 * 活动类型
	 */
	
	private String huodongleixing;
		
	/**
	 * 活动要求
	 */
	
	private String huodongyaoqiu;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 报名人数
	 */
	
	private Integer canyurenshu;
		
	/**
	 * 活动时间
	 */
	
	private String huodongshijian;
		
	/**
	 * 参与时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date canyushijian;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 年龄
	 */
	
	private String nianling;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
				
	
	/**
	 * 设置：活动简介
	 */
	 
	public void setHuodongjianjie(String huodongjianjie) {
		this.huodongjianjie = huodongjianjie;
	}
	
	/**
	 * 获取：活动简介
	 */
	public String getHuodongjianjie() {
		return huodongjianjie;
	}
				
	
	/**
	 * 设置：活动类型
	 */
	 
	public void setHuodongleixing(String huodongleixing) {
		this.huodongleixing = huodongleixing;
	}
	
	/**
	 * 获取：活动类型
	 */
	public String getHuodongleixing() {
		return huodongleixing;
	}
				
	
	/**
	 * 设置：活动要求
	 */
	 
	public void setHuodongyaoqiu(String huodongyaoqiu) {
		this.huodongyaoqiu = huodongyaoqiu;
	}
	
	/**
	 * 获取：活动要求
	 */
	public String getHuodongyaoqiu() {
		return huodongyaoqiu;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：报名人数
	 */
	 
	public void setCanyurenshu(Integer canyurenshu) {
		this.canyurenshu = canyurenshu;
	}
	
	/**
	 * 获取：报名人数
	 */
	public Integer getCanyurenshu() {
		return canyurenshu;
	}
				
	
	/**
	 * 设置：活动时间
	 */
	 
	public void setHuodongshijian(String huodongshijian) {
		this.huodongshijian = huodongshijian;
	}
	
	/**
	 * 获取：活动时间
	 */
	public String getHuodongshijian() {
		return huodongshijian;
	}
				
	
	/**
	 * 设置：参与时间
	 */
	 
	public void setCanyushijian(Date canyushijian) {
		this.canyushijian = canyushijian;
	}
	
	/**
	 * 获取：参与时间
	 */
	public Date getCanyushijian() {
		return canyushijian;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
			
}
