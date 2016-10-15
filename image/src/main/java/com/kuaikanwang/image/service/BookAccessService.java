package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.bean.book.BookIntro;

public interface BookAccessService {

	
	public Integer findBookPageTotalByPageSize(Integer pageSize);
	
	public List<BookIntro> findBookListByPageNum(Integer pageNum,Integer pageSize);
}
