package com.kuaikanwang.image.spider.cto.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class CTOMainMysqlPipeline implements Pipeline{

	//将爬取到的真实图片地址存放在数据库中
	@Override
	public void process(ResultItems resultItems, Task task) {
		
		
		Map<String, Object> all = resultItems.getAll();
		
		List<String> urls = (List<String>) all.get("url");
		List<String> names = (List<String>) all.get("name");
		if(urls.size()>0&& names.size()>0){
			//仅仅打印第一个
			//System.out.println(urls.get(0));
			//System.out.println(names.get(0));
			insertDB(urls.get(0), names.get(0), CTOMainProcessor.getPre_id());
		}else{
			System.err.println("error : " + CTOMainProcessor.getPre_id());
		}
		
	}

	private boolean insertDB(String url,String name,int pre_id){
		Connection connection;
		try {
			connection = null;
					//ConnectionUtils.getConnection();
			if(url !=null && url.trim().length()>0){
				String selectsql = "select url from ctomainpic where url=?";
				
				PreparedStatement ps = connection.prepareStatement(selectsql);
				
				ps.setString(1, url);
				
				ResultSet rs = ps.executeQuery();
				
				int row = rs.getRow();
				if(row==0){
					String insertsql = "insert ctomainpic(name,url,pre_id) values(?,?,?)";
					
					PreparedStatement pps = connection.prepareStatement(insertsql);
					
					pps.setString(1, name);
					pps.setString(2, url);
					pps.setInt(3, pre_id);
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
		return false;
	}
	
}
