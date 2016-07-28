package com.kuaikanwang.image.spider.cto.pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

//2cto 的地址预处理到 mysql数据库中
public class CTOPreMysqlPipeline implements Pipeline {

	@Override
	public void process(ResultItems resultItems, Task task) {

		Map<String, Object> all = resultItems.getAll();
		//下次抓取的列表地址
		List<String> urls = (List<String>) all.get("urls");
		//图片名称
		List<String> names = (List<String>) all.get("names");
		//列表图片地址
		List<String> murls = (List<String>) all.get("murls");
		//保证链接数

		
		
		
	}

	
	private boolean  insertDB(String url,String name){
		synchronized (this) {
			
			Connection connection;
			try {
				connection =null; 
				//ConnectionUtils.getConnection();
				if(url !=null && url.trim().length()>0){
					String selectsql = "select url from ctoprepic where url=?";
					
					PreparedStatement ps = connection.prepareStatement(selectsql);
					
					ps.setString(1, url);
					
					ResultSet rs = ps.executeQuery();
					
					int row = rs.getRow();
					if(row==0){
						String insertsql = "insert ctoprepic(name,url,pictype) values(?,?,?)";
						
						PreparedStatement pps = connection.prepareStatement(insertsql);
						
						pps.setString(1, name);
						pps.setString(2, url);
						//	pps.setString(3, CTOMeunListUtils.getPictype());
						
						pps.executeUpdate();
						
						pps.close();
						
					}
					rs.close();
					ps.close();
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
