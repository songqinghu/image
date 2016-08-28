package com.kuaikanwang.image.dao;

import com.kuaikanwang.image.domain.bean.gif.MainGif;

public interface MainGifMapper {


	/**
	 * 通过url查询个数
	 * <p>Title: findPrePicByUrl</p>
	 * <p>Description: </p>
	 * @return
	 */
	public  long  findMainGifByUrl(String url);
	
	/**
	 * 插入数据到数据库中
	 */
	public void insertMainGif(MainGif gif);
}
