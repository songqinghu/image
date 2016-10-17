package com.kuaikanwang.image.dao;

import java.util.List;
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
	 * 查询指定书籍还未被爬取的最大章节数目
	 * <p>Title: findMaxNumberByWebId</p>
	 * <p>Description: </p>
	 * @param l 
	 * @return
	 */
	public Long findMaxNumberForBookChapter(long introId);
	
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

	/**
	 * 返回 已经爬取的isspider=2 及这本书的 number数最大的值的章节信息
	 * <p>Title: findBookChapterMaxNumberByIntroId</p>
	 * <p>Description: </p>
	 * @return
	 */
	public BookChapter findBookChapterMaxNumberByIntroId(Long introId);
	
	
	/**
	 * 根据introid获取最新的10章信息
	 */
	public List<BookChapter> getNearBookChapterByIntroId(Long introId);
	
	/**
	 * 获取全本小说的章节列表
	 * <p>Title: getAllBookChapterByIntroId</p>
	 * <p>Description: </p>
	 * @param introId
	 * @return
	 */
	public List<BookChapter> getAllBookChapterByIntroId(Long introId);
	
	/**
	 * 获取同一本小说的前一章id
	 * <p>Title: getBookPreviousChapterId</p>
	 * <p>Description: </p>
	 * @param chapterId
	 * @return
	 */
	public Long getBookPreviousChapterId(Long chapterId);
	/**
	 * 获取同一本小说的后一章的id
	 * <p>Title: getBookAfterChapterId</p>
	 * <p>Description: </p>
	 * @param chapterId
	 * @return
	 */
	public Long getBookAfterChapterId(Long chapterId);
	
	/**
	 * 增量部分获取指定书籍的章节数量
	 */
	public Long getAllBookChapterNumberByIntroId(Long introId);
	
}
