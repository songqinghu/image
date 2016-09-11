package com.kuaikanwang.image.controller.common;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.component.email.SendEmailService;

@Controller
@RequestMapping("/email")
public class EmailSendController {

	@Resource
	private SendEmailService sendEmailServiceImpl;
	
	@RequestMapping("/test")
	@ResponseBody
	public Long sendTest(){
		
		return sendEmailServiceImpl.sendEmail(0);
		
	}
	
}
