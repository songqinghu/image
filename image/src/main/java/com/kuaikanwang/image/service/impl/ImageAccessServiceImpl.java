package com.kuaikanwang.image.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.domain.enums.ImageType;
import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.IImageAccessService;

@Service
@Transactional
public class ImageAccessServiceImpl implements IImageAccessService {

	@Autowired
	private ImageAccessMapper imageAccess;
	
	
	/**
	 * 查询指定分类下的总页数
	 * <p>Title: findTotalPageNum</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Integer findTotalPageNum(Integer type){
		
		
		 int totalCount = imageAccess.getTotalPage(ImageType.getTypeName(type));
		 
		 int totalPage = ((totalCount+19)/20);
		
		 return totalPage;
	}
	
	
	
	public List<ImageList> findImageList(Integer pageNum ,String pictype){
		

		 ImageQuery query = new ImageQuery();
		 
		 query.setPictype(pictype);
		 query.setStart((pageNum-1)*20);
		 
		 List<ImageList> imageList = imageAccess.getImageList(query);
		
		 return imageList;
	}
	
	
	
}
