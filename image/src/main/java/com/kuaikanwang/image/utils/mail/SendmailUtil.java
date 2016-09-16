package com.kuaikanwang.image.utils.mail;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.domain.bean.email.PicEmail;
import com.kuaikanwang.image.spider.pic59.main.PicMainPageProcessor;

@Component
public class SendmailUtil {

	  
    // 设置服务器
    private static String KEY_SMTP = "mail.smtp.host";
//    private static String VALUE_SMTP = "smtp.qq.com";
    private static String VALUE_SMTP = "smtp.126.com";
    // 服务器验证
    private static String KEY_PROPS = "mail.smtp.auth";
    private static boolean VALUE_PROPS = true;
    // 发件人用户名、密码
    private String SEND_USER; //= "251518179@qq.com";
    private String SEND_UNAME; //= "251518179@qq.com";
    private String SEND_PWD;// = "bijhynwphiesbhad";
    // 建立会话
    private MimeMessage message;
    public Session s;
 
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
    /*
     * 初始化方法
     */
    public SendmailUtil() {
        Properties props = System.getProperties();
        props.setProperty(KEY_SMTP, VALUE_SMTP);
        props.put(KEY_PROPS, "true");
//        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY); 
//        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "25");  
//        props.setProperty("mail.smtp.port", "465");  
//        props.setProperty("mail.smtp.socketFactory.port", "465");  
        //props.put("mail.smtp.auth", "true");
        s =  Session.getDefaultInstance(props, new Authenticator(){
              protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(SEND_UNAME, SEND_PWD);
              }});
        s.setDebug(false);
        message = new MimeMessage(s);
    }
 
    /*
     * 初始化方法 新账户和密码 --必须要有账号和密码
     */
    public SendmailUtil(String username,String password) {
    	
    	if(username!=null && password !=null){
    	     SEND_USER = username;
    	     SEND_UNAME = username;
    	     SEND_PWD = password;
    	}
    	
    	Properties props = System.getProperties();
    	props.setProperty(KEY_SMTP, VALUE_SMTP);
    	props.put(KEY_PROPS, "true");
//    	props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY); 
//    	props.setProperty("mail.smtp.socketFactory.fallback", "false");
    	props.setProperty("mail.smtp.port", "25");  
//    	props.setProperty("mail.smtp.socketFactory.port", "465");  
    	//props.put("mail.smtp.auth", "true");
    	s =  Session.getDefaultInstance(props, new Authenticator(){
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(SEND_UNAME, SEND_PWD);
    		}});
    	s.setDebug(false);
    	message = new MimeMessage(s);
    }
    
    /**
     * 发送邮件
     * 
     * @param headName
     *            邮件头文件名
     * @param sendHtml
     *            邮件内容
     * @param receiveUser
     *            收件人地址
     * @throws UnsupportedEncodingException 
     * @throws MessagingException 
     */
    public void doSendHtmlEmail(String headName, String sendHtml,
            String receiveUser) throws UnsupportedEncodingException, MessagingException {
     
            // 发件人
        	String nick=MimeUtility.encodeText("最愉阅官方");
        	
            InternetAddress from = new InternetAddress(nick + "<"+SEND_USER+">");
			
            message.setFrom(from);
            // 收件人
            InternetAddress to = new InternetAddress(receiveUser);
            message.setRecipient(Message.RecipientType.TO, to);
            // 邮件标题
            message.setSubject(headName);
            String content = sendHtml.toString();
            // 邮件内容,也可以使纯文本"text/plain"
            message.setContent(content, "text/html;charset=GBK");
            message.saveChanges();
            Transport transport = s.getTransport("smtp");
            // smtp验证，就是你用来发邮件的邮箱用户名密码
            transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
            // 发送
            transport.sendMessage(message, message.getAllRecipients());
            
            transport.close();
       
    }
    /**
     * 发送邮件 --群发邮件
     * 
     * @param headName
     *            邮件头文件名
     * @param sendHtml
     *            邮件内容
     * @param receiveUser
     *            收件人地址
     * @throws UnsupportedEncodingException 
     * @throws MessagingException 
     */
    public void doSendHtmlEmail(String headName, PicEmail picEmail,
    		List<String> receiveUsers) throws UnsupportedEncodingException, MessagingException {
    	
    	// 发件人
    	String nick=MimeUtility.encodeText("最愉阅官方");
    	
    	InternetAddress from = new InternetAddress(nick + "<"+SEND_USER+">");
    	
    	message.setFrom(from);
    	Transport transport = s.getTransport("smtp");
    	// smtp验证，就是你用来发邮件的邮箱用户名密码
    	transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
    	for (String receiveUser : receiveUsers) {
    		// 收件人
    		InternetAddress to = new InternetAddress(receiveUser);
    		//InternetAddress to = new InternetAddress("295533359@qq.com");
    		message.setRecipient(Message.RecipientType.TO, to);
    		// 邮件标题
    		message.setSubject(headName);
    		picEmail.setEmail(receiveUser);
    		String content = picEmail.toString();
    		// 邮件内容,也可以使纯文本"text/plain"
    		message.setContent(content, "text/html;charset=GBK");
    		message.saveChanges();
    		// 发送
    		transport.sendMessage(message, message.getAllRecipients());
			
		}
    	
    	
    	transport.close();
    	
    }
 
    /**
     * 发送邮件 --群发邮件
     * 
     * @param headName
     *            邮件头文件名
     * @param sendHtml
     *            邮件内容
     * @param receiveUser
     *            收件人地址
     * @throws UnsupportedEncodingException 
     * @throws MessagingException 
     */
    public void doSendHtmlEmail(String headName, PicEmail picEmail,
    		String receiveUser) throws UnsupportedEncodingException, MessagingException {
    	
    	// 发件人
    	String nick=MimeUtility.encodeText("最愉阅官方");
    	
    	InternetAddress from = new InternetAddress(nick + "<"+SEND_USER+">");
    	
    	message.setFrom(from);
    	Transport transport = s.getTransport("smtp");
    	// smtp验证，就是你用来发邮件的邮箱用户名密码
    	transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
    		// 收件人
    		InternetAddress to = new InternetAddress(receiveUser);
    		//InternetAddress to = new InternetAddress("295533359@qq.com");
    		message.setRecipient(Message.RecipientType.TO, to);
    		// 邮件标题
    		message.setSubject(headName);
    		picEmail.setEmail(receiveUser);
    		String content = picEmail.toString();
    		// 邮件内容,也可以使纯文本"text/plain"
    		message.setContent(content, "text/html;charset=GBK");
    		message.saveChanges();
    		// 发送
    		transport.sendMessage(message, message.getAllRecipients());
    	
    	transport.close();
    	
    }
    
    public static void main(String[] args) {
//        SendmailUtil se = new SendmailUtil();
//        
//        PicEmail picEmail = new PicEmail();
//        
//        picEmail.setEmail("295533359@qq.com");
//        picEmail.setPicUrl("http://www.2cto.com/meinv/uploads/allimg/160618/1-16061Q52302.jpg ");
//        Transport transport = s.getTransport("smtp");
//        se.doSendHtmlEmail(picEmail.getHeadName(),picEmail.toString(), "295533359@qq.com");
    }
}
