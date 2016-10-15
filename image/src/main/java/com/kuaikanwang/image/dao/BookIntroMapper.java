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
	 * 根据 pageSize 和 pageNum 根据最后更新时间降序
	 */
	public List<BookIntro> findBookListShow(Map<String, Long> map);
	
	
}
