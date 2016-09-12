package com.kuaikanwang.image.controller.common;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.service.EmailDataService;

/**
 * 邮箱数据统计
 * <p>Title: EmailDataController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月12日下午9:50:54
 * @version 1.0
 */
@Controller
@RequestMapping("/email/click")
public class EmailDataController {

	@Resource
	private EmailDataService emailDataServiceImpl;
	
	
	/**
	 * 邮件点击统计
	 * <p>Title: emailReflact</p>
	 * <p>Description: </p>
	 * @param email
	 * @return
	 */
	@RequestMapping("/reflact")
	@ResponseBody
	public Boolean emailReflact(String email){
		if(email!=null){
			return emailDataServiceImpl.emailReflact(email);
		}
		return true;
	}
	@RequestMapping("/detail")
	public String emailDetailClick(String email){
		
		if(email!=null){
			emailDataServiceImpl.emailDetail(email);
		}
		
		return "redirect:http://www.zuiyuyue.com";
	}
	
	
	
}
