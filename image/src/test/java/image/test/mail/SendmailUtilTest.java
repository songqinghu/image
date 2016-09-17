package image.test.mail;

import java.io.UnsupportedEncodingException;
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

import org.apache.commons.lang3.StringUtils;

import com.kuaikanwang.image.domain.bean.email.PicEmail;
import com.kuaikanwang.image.utils.mail.SendmailUtil;

public class SendmailUtilTest {

	  
    // 设置服务器
    private static String KEY_SMTP = "mail.smtp.host";
//    private static String VALUE_SMTP = "smtp.qq.com";
//    private static String VALUE_SMTP = "smtp.tom.com";
    private static String VALUE_SMTP = "smtp.163.com";
    // 服务器验证
    private static String KEY_PROPS = "mail.smtp.auth";
    private static boolean VALUE_PROPS = true;
    // 发件人用户名、密码
//    private String SEND_USER = "251518179@qq.com";
//    private String SEND_UNAME = "251518179@qq.com";
//    private String SEND_PWD = "bijhynwphiesbhad";
//    private String SEND_USER = "205483531@qq.com";
//    private String SEND_UNAME = "205483531@qq.com";
//    private String SEND_PWD = "pvugjmrvdftubhej";
    private String SEND_USER = "tanqiao0697237qu@163.com";
    private String SEND_PWD = "vow435499";
    private static String toUser="sqh2010304012@126.com";
//    private String SEND_USER = "dkwc7919@tom.com";
//    private String SEND_PWD = "aa2018";
    private String SEND_UNAME;
    // 建立会话
    private MimeMessage message;
    private Session s;
 
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
    /*
     * 初始化方法
     */
    public SendmailUtilTest() {
    	 SEND_UNAME = SEND_USER;
        Properties props = System.getProperties();
        props.setProperty(KEY_SMTP, VALUE_SMTP);
        props.put(KEY_PROPS, "true");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY); 
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");  
        props.setProperty("mail.smtp.socketFactory.port", "465");  
        //props.put("mail.smtp.auth", "true");
        s =  Session.getDefaultInstance(props, new Authenticator(){
              protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(SEND_UNAME, SEND_PWD);
              }});
        s.setDebug(true);
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
     */
    public void doSendHtmlEmail(String headName, String sendHtml,
            String receiveUser) {
        try {
            // 发件人
        	String nick=MimeUtility.encodeText("最愉阅官方");
        	
            InternetAddress from = new InternetAddress(nick + "<"+SEND_USER+">");
			
            message.setFrom(from);
            Transport transport = s.getTransport("smtp");
            // smtp验证，就是你用来发邮件的邮箱用户名密码
            transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
            
              for (int i = 0; i < 1; i++) {
				
            	  // 收件人
            	  InternetAddress to = new InternetAddress(receiveUser);
            	  message.setRecipient(Message.RecipientType.TO, to);
            	  // 邮件标题
            	  message.setSubject(headName);
            	  String content = sendHtml.toString();
            	  // 邮件内容,也可以使纯文本"text/plain"
            	  message.setContent(content, "text/html;charset=GBK");
            	  message.saveChanges();
            	  transport.sendMessage(message, message.getAllRecipients());
			}


           // 发送
            transport.close();
        } catch (AddressException   e) {
        	
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
    	for (int i = 0; i < 1; i++) {
    		SendmailUtilTest se = new SendmailUtilTest();
    		
    		String htmlBody="<body><img src=\"http://zuiyuyue.com/mail/click/reflact\" style=\"width:0px;height:0px\"/></body><h1>今天的美图到了,点击这里查看更多美图!</h1> ";
    		
    		se.doSendHtmlEmail("每日美图-9月16期",htmlBody, toUser);
		}
    	
//		String result="false";
//		String username = "weibopd3196@126.com";
//		String password = "xiaxrj97630";
////		String to = "zuiyuyue@126.com";
//		String to = "sqh2010304012@126.com";
////		String to = "295533359@qq.com";
////		String to = "251518179@qq.com";
////		String to = "205483531@qq.com";
//		Integer num = 1;
//		Long frequency = 14400l;
//		if(StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)&&StringUtils.isNotBlank(to)){
//				
//				PicEmail picEmail = new PicEmail();
//				picEmail.setPicUrl("http://www.2cto.com/meinv/uploads/allimg/160507/1-16050G44635-50.jpg ");
//				for (int i = 0; i < num; i++) {
//					//这里要防止发送太快了 14.4秒发送一封! 1小时 250封
//			    try {
//					long sendStart = System.currentTimeMillis();
//					
//					SendmailUtil sendmailUtil = new SendmailUtil(username,password);
//					sendmailUtil.doSendHtmlEmail(picEmail.getHeadName(), picEmail,to);
//					long sendEnd = System.currentTimeMillis();
//					frequency =frequency -(sendEnd-sendStart);
//					if(frequency>0){
//						Thread.sleep(frequency);
//					}
//				} catch (UnsupportedEncodingException |MessagingException|InterruptedException e) {
//					System.out.println("occur error is : "+ e);
//				} 
//				}
//				
//				
//				result ="success";
//		}
//		System.out.println(result);
    }
}
