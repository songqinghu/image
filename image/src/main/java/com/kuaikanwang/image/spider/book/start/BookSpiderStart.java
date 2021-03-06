package com.kuaikanwang.image.spider.book.start;

import com.kuaikanwang.image.domain.bean.book.BookIntro;

/**
 * 图书爬取类
 * <p>Title: BookSpiderStart.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月3日上午9:42:38
 * @version 1.0
 */
public interface BookSpiderStart {
	
	
	public Long bookSpiderStart(long gwebId);

	public Long spiderBookIntro(Long bwebId,BookIntro bookIntro,Long spiderCount);
	
	public  void spiderAllBookIntro(long bwebId);
	
	public Long spiderOneBookStart(Long introId);
	
	
	
}
