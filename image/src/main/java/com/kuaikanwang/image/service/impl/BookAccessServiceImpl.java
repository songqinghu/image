package com.kuaikanwang.image.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.BookIntroMapper;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.service.BookAccessService;

@Service
@Transactional
public class BookAccessServiceImpl implements BookAccessService {

	@Resource
	private BookIntroMapper bookIntroMapper;
	
	/**
	 * 获取图书能展示的页数
	 * <p>Title: findBookPageTotalByPageSize</p>
	 * <p>Description: </p>
	 * @param pageSize
	 * @return
	 * @see com.kuaikanwang.image.service.BookAccessService#findBookPageTotalByPageSize(java.lang.Integer)
	 */
	@Override
	public Integer findBookPageTotalByPageSize(Integer pageSize) {
		
		Integer totalCount = bookIntroMapper.findBookfPageTotal();//总数目
		
		int totalPage = ((totalCount+pageSize -1)/pageSize);
		
		return totalPage;
	}

	/**
	 * 获取指定页面的图书列表信息
	 * <p>Title: findBookListByPageNum</p>
	 * <p>Description: </p>
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @see com.kuaikanwang.image.service.BookAccessService#findBookListByPageNum(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<BookIntro> findBookListByPageNum(Integer pageNum, Integer pageSize) {
		Map<String, Long> map = new HashMap<String,Long>();
		
		map.put("start", (long) ((pageNum-1)*pageSize));
		
		map.put("rows", (long)pageSize);
		
		List<BookIntro> books = bookIntroMapper.findBookListShow(map );
		
		return books;
	}

}
