package com.kuaikanwang.image.dao;

import java.util.List;
import java.util.Map;

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
public interface PrePicMapper {

	/**
	 * 通过url查询个数
	 * <p>Title: findPrePicByUrl</p>
	 * <p>Description: </p>
	 * @return
	 */
	public  long  findPrePicByUrl(String url);
	
	/**
	 * 插入数据到数据库中
	 */
	public void insertPrePic(PrePic prepic);

	
	/**
	 * 根据web_id获取指定的信息
	 */
	public PrePic findPrePicByWebId(Map<String, Long> map);
	
	
	/**
	 * 查询最大个数
	 */
	public Long findMaxNumberByWebId(Long webId);
	
	/**
	 * 抓取后增加抓取次数
	 */
	public void UpdateSpiderCountByPreId(Long preId);
}
