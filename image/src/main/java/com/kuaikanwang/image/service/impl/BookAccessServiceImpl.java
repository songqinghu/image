package com.kuaikanwang.image.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.CommonParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.BookChapterMapper;
import com.kuaikanwang.image.dao.BookContentMapper;
import com.kuaikanwang.image.dao.BookIntroMapper;
import com.kuaikanwang.image.domain.bean.book.BookChapter;
import com.kuaikanwang.image.domain.bean.book.BookContent;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.service.BookAccessService;
import com.kuaikanwang.image.solr.SolrClientUtil;
import com.kuaikanwang.image.spider.pipeline.PreMysqlPipeline;

@Service
@Transactional
public class BookAccessServiceImpl implements BookAccessService {

	private static Logger logger = LoggerFactory.getLogger(PreMysqlPipeline.class);
	
	@Resource
	private BookIntroMapper bookIntroMapper;
	
	@Resource
	private BookChapterMapper bookChapterMapper;
	
	@Resource
	private BookContentMapper bookContentMapper;
	
	@Resource
	private SolrClientUtil solrClientUtil;
	
	/**
	 * 获取图书能展示的页数
	 * <p>Title: findBookPageTotalByPageSize</p>
	 * <p>Description: </p>
	 * @param pageSize
	 * @return
	 * @see com.kuaikanwang.image.service.BookAccessService#findBookPageTotalByPageSize(java.lang.Integer)
	 */
	@Override
	public Integer findBookPageTotalByPageSize(Integer pageSize) {
		
		Integer totalCount = bookIntroMapper.findBookfPageTotal();//总数目
		
		int totalPage = ((totalCount+pageSize -1)/pageSize);
		
		return totalPage;
	}

	public Long findBookPageTotalByPageSizeAndBookType(Long pageSize,Long bookType) {
		
		Long totalCount = bookIntroMapper.findBookPageTotalByBookType(bookType);//总数目
		
		long totalPage = ((totalCount+pageSize -1)/pageSize);
		
		return totalPage;
		
	}
	/**
	 * 查询全本书籍数目
	 * <p>Title: findBookPageTotalByPageSizeAndEnd</p>
	 * <p>Description: </p>
	 * @param pageSize
	 * @return
	 */
	public Long findBookPageTotalByPageSizeAndEnd(Long pageSize) {
		
		Long totalCount = bookIntroMapper.findBookPageTotalByEnd();//总数目
		
		long totalPage = ((totalCount+pageSize -1)/pageSize);
		
		return totalPage;
		
	}
	
	/**
	 * 
	 */
	
	/**
	 * 获取指定页面的图书列表信息
	 * <p>Title: findBookListByPageNum</p>
	 * <p>Description: </p>
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @see com.kuaikanwang.image.service.BookAccessService#findBookListByPageNum(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<BookIntro> findBookListByPageNum(Integer pageNum, Integer pageSize) {
		Map<String, Long> map = new HashMap<String,Long>();
		
		map.put("start", (long) ((pageNum-1)*pageSize));
		
		map.put("rows", (long)pageSize);
		
		List<BookIntro> books = bookIntroMapper.findBookListShow(map );
		
		for (BookIntro bookIntro : books) {
			
			String introInfo = bookIntro.getIntroInfo();
			String result = introInfo.replaceAll("<br>", "")
					.replaceAll("</br>", "")
					.replaceAll("<p>", "")
					.replaceAll("</p>", "");
			bookIntro.setIntroInfo(result);
		}
		
		
		
		return books;
	}
	
	/**
	 * 查询图书id是否可用或者存在
	 * <p>Title: findIntroIdIsExit</p>
	 * <p>Description: </p>
	 * @return
	 */
	public boolean findIntroIdIsExit(Long introId){
		
		Long count = bookIntroMapper.findIntroIdIsExit(introId);
		if(count>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据introId查询图书信息
	 * <p>Title: findBookIntroByIntroId</p>
	 * <p>Description: </p>
	 * @param introId
	 * @return
	 */
	public BookIntro findBookIntroByIntroId(Long introId){
		
		BookIntro bookIntro = bookIntroMapper.findBookIntroByIntroId(introId);
		
		return bookIntro;
	}

	/**
	 * 获取最新的10的章节
	 * <p>Title: getNearBookChapterByIntroId</p>
	 * <p>Description: </p>
	 * @param introId
	 * @return
	 * @see com.kuaikanwang.image.service.BookAccessService#getNearBookChapterByIntroId(java.lang.Long)
	 */
	@Override
	public List<BookChapter> getNearBookChapterByIntroId(Long introId) {
		
		List<BookChapter> chapters = bookChapterMapper.getNearBookChapterByIntroId(introId);
		
		return chapters;
	}

	
	@Override
	public List<BookChapter> getAllBookChapterByIntroId(Long introId) {
		
		List<BookChapter> chapters = bookChapterMapper.getAllBookChapterByIntroId(introId);
		
		return chapters;
	}

	public BookContent getBookContentByChapterIdInSolr(Long chapterId){
		SolrQuery query = new SolrQuery();
		query.set(CommonParams.Q,"chapter_id:"+chapterId);
		query.setStart(0);
		query.setRows(1);
		QueryResponse response;
		try {
			response = solrClientUtil.getClient().query(query);
			List<BookContent> bookContents = response.getBeans(BookContent.class);
			if(bookContents.size()>0){
				return bookContents.get(0);
			}
		} catch (SolrServerException | IOException  e) {
			logger.error("select book content to solr occor error,the chapterid is :" +chapterId);
		} 
		return null;
	}
	
	@Override
	public BookContent getBookContentByChapterId(Long chapterId) {

		BookContent bookContent = bookContentMapper.getBookContentByChapterId(chapterId);
		
		return bookContent;
	}

	@Override
	public Long getBookPreviousChapterId(Long chapterId) {
		
		Long prev = bookChapterMapper.getBookPreviousChapterId(chapterId);
		
		return prev;
	}

	@Override
	public Long getBookAfterChapterId(Long chapterId) {
		
		Long after = bookChapterMapper.getBookAfterChapterId(chapterId);
		return after;
	}
	
	
	/**
	 * 获取未完结图书按照从高到低排序指定获取的数量 num 最大为20个
	 * <p>Title: getHotBookListIndex</p>
	 * <p>Description: </p>
	 * @param num
	 * @return
	 */
	public List<BookIntro> getHotBookListIndex(Long limit){
		
		if(limit > 20){
			limit =20l;
		}
		List<BookIntro> hotBooks = bookIntroMapper.getHotBookList(limit);
		
		for (BookIntro bookIntro : hotBooks) {
			
			String introInfo = bookIntro.getIntroInfo();
			String result = introInfo.replaceAll("<br>", "")
					.replaceAll("</br>", "")
					.replaceAll("<p>", "")
					.replaceAll("</p>", "");
			bookIntro.setIntroInfo(result);
		}
		
		return hotBooks;
	}
	
	/**
	 * 根据分类id获取相应的图书列表--->观看量排序
	 * <p>Title: getBookListByType</p>
	 * <p>Description: </p>
	 * @param start
	 * @param limit
	 * @param booktype
	 * @return
	 */
	public List<BookIntro> getBookListByType(Long pageNum,Long pageSize,Long booktype){
		
		if(pageNum<1){
			pageNum=1l;
		}
		
		Map<String, Long> map = new HashMap<String,Long>();
		
		map.put("start", pageSize*(pageNum-1));
		map.put("limit", pageSize);
		map.put("bookTypeNum", booktype);
		
		List<BookIntro> books = bookIntroMapper.getBookListByType(map);
		
		for (BookIntro bookIntro : books) {
			
			String introInfo = bookIntro.getIntroInfo();
			String result = introInfo.replaceAll("<br>", "")
					.replaceAll("</br>", "")
					.replaceAll("<p>", "")
					.replaceAll("</p>", "");
			bookIntro.setIntroInfo(result);
		}
		
		return books;
	}
	
	/**
	 * 获取完结的图书列表--->观看量排序
	 * <p>Title: getBookListByType</p>
	 * <p>Description: </p>
	 * @param start
	 * @param limit
	 * @param booktype
	 * @return
	 */
	public List<BookIntro> getBookListByEnd(Long pageNum,Long pageSize){
		
		if(pageNum<1){
			pageNum=1l;
		}
		
		Map<String, Long> map = new HashMap<String,Long>();
		
		map.put("start", pageSize*(pageNum-1));
		map.put("limit", pageSize);
		
		List<BookIntro> books = bookIntroMapper.getBookListByEnd(map);
		
		for (BookIntro bookIntro : books) {
			
			String introInfo = bookIntro.getIntroInfo();
			String result = introInfo.replaceAll("<br>", "")
					.replaceAll("</br>", "")
					.replaceAll("<p>", "")
					.replaceAll("</p>", "");
			bookIntro.setIntroInfo(result);
		}
		
		return books;
	}
	
	
	

}
