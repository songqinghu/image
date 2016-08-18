package com.kuaikanwang.image.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.GetImageToLocalService;

@Service
@Transactional
public class GetImageToLocalServiceImpl implements GetImageToLocalService{

	@Resource
	private ImageAccessMapper imageAccessMapper;
	
	/**
	 * 下载指定preid的图片到本地的文件夹中
	 * <p>Title: downloadImage</p>
	 * <p>Description: </p>
	 * @param preId
	 * @return
	 * @see com.kuaikanwang.image.service.GetImageToLocalService#downloadImage(java.lang.Long)
	 */
	@Override
	public Long downloadImage(Long preId) {
		
		//获取指定preid的图片地址列表
		List<ImageList> imageLists = imageAccessMapper.findImageListByPid(preId);
		
		//循环使用httpconnection获取图片
		for (int i = 0; i < imageLists.size(); i++) {
			
			String url = imageLists.get(i).getPicUrl();
			
			byte[] btImg = getImageFromNetByUrl(url);  
		       if(null != btImg && btImg.length > 0){  
		           String fileName = imageLists.get(i).getPicName()+i+url.substring(url.lastIndexOf("."), url.length());  
		           //存到本地指定的目录下
		           writeImageToDisk(btImg, fileName,preId);  
		       }else{  
		           System.out.println("没有从该连接获得内容");  
		       } 
			
		}
		
		
		//返回下载的图片数目
		return (long) imageLists.size();
	}

   /** 
    * 将图片写入到磁盘 
    * @param img 图片数据流 
    * @param fileName 文件保存时的名称 
    */  
   public static void writeImageToDisk(byte[] img, String fileName,Long preId){  
       try {  
    	   File path = new File("C:\\Users\\庆龙\\Desktop\\最愉悦\\每日一图\\"+preId);
    	   if(!path.exists()){
    		   path.mkdirs();
    	   }
           File file = new File(path, fileName);
           FileOutputStream fops = new FileOutputStream(file);  
           fops.write(img);  
           fops.flush();  
           fops.close();  
           System.out.println("图片已经写入到C盘");  
       } catch (Exception e) {  
           e.printStackTrace();  
       }  
   }  
   /** 
    * 根据地址获得数据的字节流 
    * @param strUrl 网络连接地址 
    * @return 
    */  
   public static byte[] getImageFromNetByUrl(String strUrl){  
       try {  
           URL url = new URL(strUrl);  
           HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
           conn.setRequestMethod("GET");  
           conn.setConnectTimeout(5 * 1000);  
           InputStream inStream = conn.getInputStream();//通过输入流获取图片数据  
           byte[] btImg = readInputStream(inStream);//得到图片的二进制数据  
           return btImg;  
       } catch (Exception e) {  
           e.printStackTrace();  
       }  
       return null;  
   }  
	   /** 
	    * 从输入流中获取数据 
	    * @param inStream 输入流 
	    * @return 
	    * @throws Exception 
	    */  
	   public static byte[] readInputStream(InputStream inStream) throws Exception{  
	       ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	       byte[] buffer = new byte[1024];  
	       int len = 0;  
	       while( (len=inStream.read(buffer)) != -1 ){  
	           outStream.write(buffer, 0, len);  
	       }  
	       inStream.close();  
	       return outStream.toByteArray();  
	   }  
	
}
