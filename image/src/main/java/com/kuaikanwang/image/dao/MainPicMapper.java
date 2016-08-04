package com.kuaikanwang.image.dao;

import java.util.List;
import java.util.Map;

import com.kuaikanwang.image.domain.bean.MainPic;
import com.kuaikanwang.image.domain.bean.PrePic;

/**
 * 操作prepic表
 * <p>Title: PrePicMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月2日下午9:49:51
 * @version 1.0
 */
public interface MainPicMapper {

	/**
	 * 通过url查询个数
	 * <p>Title: findPrePicByUrl</p>
	 * <p>Description: </p>
	 * @return
	 */
	public  long  findMainPicByUrl(String url);
	
	/**
	 * 插入数据到数据库中
	 */
	public void insertMainPic(MainPic pic);

	
}
