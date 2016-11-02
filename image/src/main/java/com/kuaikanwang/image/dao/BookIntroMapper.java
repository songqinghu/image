package com.kuaikanwang.image.dao;

import java.util.List;
import java.util.Map;

import com.kuaikanwang.image.domain.bean.book.BookIntro;

public interface BookIntroMapper {
	
	/**
	 * 查询章节目录列表是否存在
	 * <p>Title: findBookByUrl</p>
	 * <p>Description: </p>
	 * @param url
	 * @return
	 */
	public long findBookByUrl(String url);
	
	/**
	 * 插入图书简介信息
	 * <p>Title: insertBookIntro</p>
	 * <p>Description: </p>
	 * @param bookIntro
	 */
	public void insertBookIntro(BookIntro bookIntro);
	
	/**
	 * 查询未被爬取过章节列表的图书
	 */
	
	public List<BookIntro> findBookIntroByIsSpider();

	/**
	 * 获取总的可用图书
	 * <p>Title: findGifPageTotal</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Integer findBookfPageTotal();
	
	/**
	 * 获取指定分类的图书总数
	 * <p>Title: findBookPageTotalByBookType</p>
	 * <p>Description: </p>
	 * @param bookType
	 * @return
	 */
	public Long findBookPageTotalByBookType(Long bookType);
	/**
	 * 获取指定完本的图书总数
	 * <p>Title: findBookPageTotalByBookType</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Long findBookPageTotalByEnd();
	
	/**
	 * 根据 pageSize 和 pageNum 根据最后更新时间降序
	 */
	public List<BookIntro> findBookListShow(Map<String, Long> map);
	
	
	/**
	 * 更新指定书籍最新的章节信息
	 */
	public void updateNewChapter4Intro(BookIntro bookIntro);
	
	
	public Long  findIntroIdIsExit(Long introId);
	
	/**
	 * 查询详细图书简介
	 */
	public BookIntro findBookIntroByIntroId(Long introId);
	
	
	/**
	 * 获取增量爬取的introbook 一次100条 循环取完
	 */
	public List<BookIntro> getIncrBookIntroByPage(Long start);
	
	/**
	 * 获取指定数目的倒叙热度未完结书籍
	 */
	public List<BookIntro> getHotBookList(Long limit);
	
	/**
	 * 根据图书id获取指定区间的图书
	 * <p>Title: getBookListByType</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	public List<BookIntro> getBookListByType(Map<String, Long> map);
	/**
	 * 获取完结的图书 指定区间的图书
	 * <p>Title: getBookListByType</p>
	 * <p>Description: </p>
	 * @param map
	 * @return
	 */
	public List<BookIntro> getBookListByEnd(Map<String, Long> map);
	
	
	
}
