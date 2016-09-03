package com.kuaikanwang.image.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.GifAccessMapper;
import com.kuaikanwang.image.domain.bean.gif.GifList;
import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.service.GifAccessService;
@Service
@Transactional
public class GifAccessServiceImpl implements GifAccessService{

	
	
	@Resource
	private GifAccessMapper gifAccessMapper;
	
	/**
	 * 获取gif能展示的页数
	 * <p>Title: findGifPageTotalByPageSize</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Integer findGifPageTotalByPageSize(Integer pageSize){
		
		//后期加入缓存 --1小时更新一次 ---加入mybatis自带的缓存机制
		
		Integer totalCount = gifAccessMapper.findGifPageTotal();//总数目
		
		int totalPage = ((totalCount+pageSize -1)/pageSize);
		
		return totalPage;
	}
	
	
	
	
	public List<GifList> findGifListByPageNum(Integer pageNum,Integer pageSize){
		
		
		ImageQuery query = new ImageQuery();
		
		query.setStart((pageNum-1)*pageSize);
		
		query.setRows(pageSize);
		
		List<GifList> gifList = gifAccessMapper.findGifListShow(query);
		
		return gifList;
	}
	
	
	
	
	
	
	
}
