package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.bean.book.BookChapter;
import com.kuaikanwang.image.domain.bean.book.BookContent;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.domain.result.ResultData;

public interface BookAccessService {

	
	public Integer findBookPageTotalByPageSize(Integer pageSize);
	
	public List<BookIntro> findBookListByPageNum(Integer pageNum,Integer pageSize);
	
	public ResultData<List<BookIntro>> findBookSearchByPageNum(String keyword,Integer pageNum, Integer pageSize);
	
	public boolean findIntroIdIsExit(Long introId);
	
	public BookIntro findBookIntroByIntroId(Long introId);
	
	public List<BookChapter> getNearBookChapterByIntroId(Long introId);
	
	
	public List<BookChapter> getAllBookChapterByIntroId(Long introId);
	
	public BookContent getBookContentByChapterIdInSolr(Long chapterId);
	
	public BookContent getBookContentByChapterId(Long chapterId);
	
	
	public Long getBookPreviousChapterId(Long chapterId);
	
	public Long getBookAfterChapterId(Long chapterId);
	
	public List<BookIntro> getHotBookListIndex(Long limit);
	
	public List<BookIntro> getBookListByType(Long pageNum,Long pageSize,Long booktype);
	
	public List<BookIntro> getBookListByEnd(Long pageNum,Long pageSize);

	public Long findBookPageTotalByPageSizeAndBookType(Long pageSize, Long type);
	
	public Long findBookPageTotalByPageSizeAndEnd(Long pageSize);
	
	public List<BookIntro> getBookListByAll();
	
}
