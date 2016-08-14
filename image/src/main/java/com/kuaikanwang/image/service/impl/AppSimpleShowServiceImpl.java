package com.kuaikanwang.image.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.AppSimpleShowMapper;
import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.domain.bean.AppVersion;
import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.domain.result.AppImageInfo;
import com.kuaikanwang.image.service.AppSimpleShowService;

@Service
@Transactional
public class AppSimpleShowServiceImpl implements AppSimpleShowService {

	
	@Autowired
	private ImageAccessMapper imageAccess;
	
	@Resource
	private AppSimpleShowMapper appSimpleShowMapper;
	
	
	/**
	 * 查询总的页数
	 * <p>Title: findTotalPageNum</p>
	 * <p>Description: </p>
	 * @param pageSize
	 * @return
	 */
	public Integer findTotalPageNum(int pageSize){
		
		 int totalCount = imageAccess.getImageCountNum();//这里应该缓存
		 
		 int totalPage = ((totalCount+pageSize -1)/pageSize);
		
		 return totalPage;
	}
	
	/**
	 * 分页展示图片
	 * <p>Title: findImageByPage</p>
	 * <p>Description: </p>
	 * @return
	 */
	public List<AppImageInfo> findImageByPage(int pageNum,int pageSize){
		
		ImageQuery query = new ImageQuery();
		
		query.setStart((pageNum-1)*pageSize);
		query.setRows(pageSize);
		
		return imageAccess.findImageByPage(query);
	}

	/**
	 * 获取库中最新的版本号嘛
	 * <p>Title: versionCheck</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.kuaikanwang.image.service.AppSimpleShowService#versionCheck()
	 */
	@Override
	public AppVersion versionCheck() {
		
		return appSimpleShowMapper.versionCheck();
	}
	
	
	
	
	
	
}
