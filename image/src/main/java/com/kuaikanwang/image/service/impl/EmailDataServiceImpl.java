package com.kuaikanwang.image.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.MainEmailMapper;
import com.kuaikanwang.image.service.EmailDataService;
@Service
@Transactional
public class EmailDataServiceImpl implements EmailDataService {

	@Resource
	private MainEmailMapper mainEmailMapper;
	
	/**
	 * 统计用户点击邮箱次数
	 * <p>Title: emailReflact</p>
	 * <p>Description: </p>
	 * @param email
	 * @return
	 */
	public boolean emailReflact(String email){
		
		long num = mainEmailMapper.findMainEmailByEmail(email);
		
		if(num>0){
			mainEmailMapper.updateClickCountByEmail(email);
			return true;
		}
		
		return false;
	}
	
	/**
	 * 统计用户点击邮件进入网站的次数
	 * <p>Title: emailDetail</p>
	 * <p>Description: </p>
	 * @param email
	 * @return
	 */
	public  boolean emailDetail(String email){
		
		long num = mainEmailMapper.findMainEmailByEmail(email);
		
		if(num>0){
			mainEmailMapper.updateDetailCountByEmail(email);
			return true;
		}
		
		return false;
	}
	
	
}
