package com.kuaikanwang.image.dao;

import com.kuaikanwang.image.domain.bean.book.BookContent;

public interface BookContentMapper {
	
	/**
	 * 查询章节是否被抓取过了
	 * <p>Title: findBookByUrl</p>
	 * <p>Description: </p>
	 * @param url
	 * @return
	 */
	public long findBookByChapterId(Long chapterId);
	
	/**
	 * 插入图书章节信息
	 * <p>Title: insertBookIntro</p>
	 * <p>Description: </p>
	 * @param bookIntro
	 */
	public void insertBookContent(BookContent bookContent);
	
	
	
	
}
