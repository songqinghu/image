package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.bean.book.BookChapter;
import com.kuaikanwang.image.domain.bean.book.BookContent;
import com.kuaikanwang.image.domain.bean.book.BookIntro;

public interface BookAccessService {

	
	public Integer findBookPageTotalByPageSize(Integer pageSize);
	
	public List<BookIntro> findBookListByPageNum(Integer pageNum,Integer pageSize);
	
	public boolean findIntroIdIsExit(Long introId);
	
	public BookIntro findBookIntroByIntroId(Long introId);
	
	public List<BookChapter> getNearBookChapterByIntroId(Long introId);
	
	
	public List<BookChapter> getAllBookChapterByIntroId(Long introId);
	
	
	public BookContent getBookContentByChapterId(Long chapterId);
	
	
	public Long getBookPreviousChapterId(Long chapterId);
	
	public Long getBookAfterChapterId(Long chapterId);
	
}