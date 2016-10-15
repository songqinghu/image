package com.kuaikanwang.image.dao;

import java.util.Map;

import com.kuaikanwang.image.domain.bean.book.BookChapter;

public interface BookChapterMapper {
	
	/**
	 * 查询章节目录列表是否存在
	 * <p>Title: findBookByUrl</p>
	 * <p>Description: </p>
	 * @param url
	 * @return
	 */
	public long findBookByUrl(String url);
	
	/**
	 * 插入图书章节信息
	 * <p>Title: insertBookIntro</p>
	 * <p>Description: </p>
	 * @param bookIntro
	 */
	public void insertBookChapter(BookChapter bookchapter);
	
	/**
	 * 更新指定图书的number 用户排序
	 * <p>Title: updateBookNumber</p>
	 * <p>Description: </p>
	 * @param bookIntro
	 */
	public void updateBookNumber(Map<String, Long> map);
	

	/**
	 * 查询还未被爬取的图书最大数目
	 * <p>Title: findMaxNumberByWebId</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Long findMaxNumberForBookChapter();
	
	/**
	 * 按照顺序获取要爬取的列表
	 * <p>Title: findSpiderChapter</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	public BookChapter findSpiderChapter(Map<String, Long> map);
	
	/**
	 * 更新章节的爬取状态 为中间状态
	 * <p>Title: updateChapterSpiderStatus</p>
	 * <p>Description: </p>
	 * @param status
	 */
	public void updateChapterSpiderStatus(Map<String, Long> map);
	
	/**
	 * 更新中间态为已经爬取
	 * <p>Title: updateChapterIsSpider</p>
	 * <p>Description: </p>
	 */
	public void updateChapterIsSpider();
	
	
}
