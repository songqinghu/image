package com.kuaikanwang.image.dao;

import java.util.List;
import java.util.Map;

import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.domain.result.AppImageInfo;
import com.kuaikanwang.image.domain.result.DetailImage;
import com.kuaikanwang.image.domain.result.ImageList;

/**
 * 图片访问
 * <p>Title: ImageAccessMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月21日下午9:02:59
 * @version 1.0
 */
public interface ImageAccessMapper {

	/**
	 * 当前类目下的条目数
	 * <p>Title: getTotalPage</p>
	 * <p>Description: </p>ss
	 * @param type
	 * @return
	 */
	public int  getTotalPage(Integer type);
	
	/**
	 * 获取展示的指定分类下的图片列表 按照时间进行排序 分页
	 * <p>Title: getImageList</p>
	 * <p>Description: </p>
	 * @param query
	 * @return
	 */
	public List<ImageList> getImageList(ImageQuery query);
	
	/**
	 * 获取mainpic表中 指定pid 对应 图片的个数
	 * <p>Title: findDetailTotalCount</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 */
	public Integer findDetailTotalCount(Integer pid);
	
	
	public DetailImage getDetailImage(Map<String, Integer> map);
	
	

	/**
	 * 查询库中所有可以展示的图片数目
	 * <p>Title: getImageCount</p>
	 * <p>Description: </p>
	 * @return
	 */
	public int  getImageCountNum();
	
	/**
	 * 分页展示图片
	 */
	public List<AppImageInfo> findImageByPage(ImageQuery query);
	
	
	
	/**
	 * 获取最新的图片信息
	 */
	public List<ImageList> getLatestPicList(Integer num);
	
	
	
	/**
	 * 校验是否含有次pid
	 */
	
	public Integer findPreInfoByPid(Long pid);
	
	
	/**
	 * 获取 最多观看数目排序后的结果
	 */
	
	public List<ImageList> getCountPicList(Integer num);
	
	
	
	/**
	 * 通过pid 获取单张图片信息
	 */
	public ImageList getImageListByPid(ImageQuery query);
	/**
	 * 通过pid 获取上一张图片
	 */
	public ImageList getPreviousImageByPid(ImageQuery query);
	/**
	 * 通过pid 获取下一张图片
	 */
	public ImageList getNextImageByPid(ImageQuery query);
	
	
	
	/**
	 * 查询pre 中 最大可展示的pid的值
	 * <p>Title: getImageCount</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Integer  getMaxPid();
	
	/**
	 * 推荐的图片列表获取
	 */
	public List<ImageList> getRecommendImageList(Integer pid);
	
	/**
	 * 获取分类目录下浏览量最高的图片 用于首页展示
	 */
	public List<ImageList> getIndexImageListByType(Integer pictype);
	
	
	/**
	 * 获取主表某分类下图片总数
	 */
	public Integer getImageShowCountByImageType(Integer imagetype);
	
	/**
	 * 获取展示的指定分类下的图片详情  分页 用于m站展示
	 * <p>Title: findMWebImageList</p>
	 * <p>Description: </p>
	 * @param query
	 * @return
	 */
	public List<ImageList> findMWebImageList(ImageQuery query);
	
	/**
	 * 
	 * 获取指定的pid下的图片列表 mainpic
	 * <p>Title: findImageListByPid</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 */
	public List<ImageList> findImageListByPid(Long pid);
}
