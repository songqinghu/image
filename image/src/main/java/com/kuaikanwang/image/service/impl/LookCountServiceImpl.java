package com.kuaikanwang.image.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.dao.LookCountMapper;
import com.kuaikanwang.image.service.LookCountService;


@Service
@Transactional
public class LookCountServiceImpl implements LookCountService{

	
	@Autowired
	private ImageAccessMapper imageAccess;
	
	
	@Resource
	private LookCountMapper lookCountMapper;
	
	@Override
	public void addCountByPid(Long pid) {
		
		
		Integer count = imageAccess.findPreInfoByPid(pid);//确认存在mainpic表中
		
		if(count > 0){
			
			//查询此信息是否存在 不存在插入 存在 更新
			
			Integer isInsert = lookCountMapper.findPreInfoByPid(pid);
			
			if(isInsert ==0){
				//不存在 插入
				lookCountMapper.insertLookCountInfo(pid);
				
			}else{
				//存在 更新
				lookCountMapper.updateLookCountInfo(pid);
			}
		}
	}

	
	
	
	
	
	
}
