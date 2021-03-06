package com.kuaikanwang.image.controller.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuaikanwang.image.domain.bean.book.BookChapter;
import com.kuaikanwang.image.domain.bean.book.BookContent;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.domain.bean.book.BookType;
import com.kuaikanwang.image.domain.result.ResultData;
import com.kuaikanwang.image.service.BookAccessService;
import com.kuaikanwang.image.utils.PageNumberListUtils;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

/**
 * 手机访问m站控制
 * <p>Title: MBookAccessController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月15日下午5:46:33
 * @version 1.0
 */
@Controller
@RequestMapping("/m/book")
public class MBookAccessController {

	
	@Autowired
	private BookAccessService bookAccessServiceImpl;
	
	/**
	 * 展示m站首页信息
	 * <p>Title: showBookIndex</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView showBookIndex(){
		
	
	    //需要展示的信息 强推 各个分类 暂时定 强推三个 每个分类一个
		List<BookIntro> hotBooks = bookAccessServiceImpl.getHotBookListIndex(3l);
		//各个分类的信息
		
		Set<Long> types = CommonCacheUtil.getBookTypeCache().keySet();
		
		HashMap<Long, List<BookIntro>> booktypes = new HashMap<Long,List<BookIntro>>();
		
		for (Long type : types) {
			List<BookIntro> books = bookAccessServiceImpl.getBookListByType(1l, 5l, type);
			booktypes.put(type, books);
		}
		
		Map<String, Object> model  = new HashMap<String,Object>();
		
		model.put("hotBooks", hotBooks);
		model.put("booktypes", booktypes);
	     
		return new ModelAndView("/mbookindex",model);
	}
	/**
	 * 按照指定的图书分类返回数据 --默认10个一页
	 * <p>Title: showBookType</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/type/{type}/{pageNum}")
	public ModelAndView showBookType(@PathVariable Long type,@PathVariable Long pageNum){
		
		if(!CommonCacheUtil.getBookTypeCache().containsKey(type)){
			type=1l;
		}
		Long pageSize = 10l;
	    Long totalPage = bookAccessServiceImpl.findBookPageTotalByPageSizeAndBookType(pageSize,type);//先展示2个试试看
		//对页数参数做处理
		if(pageNum <1){
			pageNum=1l;
		}else if(pageNum > totalPage ){
			pageNum = totalPage;
		}
		
		
		
		//查询
		List<BookIntro> books = bookAccessServiceImpl.getBookListByType(pageNum, pageSize, type);
		//分页问题
		
		Map<String, Object> model  = new HashMap<String,Object>();
		
		BookType bookType = new BookType();
		bookType.setBookTypeId(type);
		bookType.setBookTypeName(CommonCacheUtil.getBookTypeCache().get(type));
		model.put("books", books);
		model.put("bookType", bookType);
		model.put("maxPage", totalPage);
		model.put("nowPage", pageNum);
		//要暂时的列表页
		List<Integer> pageList = PageNumberListUtils.getPageNumList4M(pageNum, totalPage);
		
		model.put("pageList", pageList);
		
		return new ModelAndView("/mbooksortdetail",model);
		
	}
	
	/**
	 * 按照指定的图书分类返回数据 --默认10个一页
	 * <p>Title: showBookType</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/end/{pageNum}")
	public ModelAndView showEndBook(@PathVariable Long pageNum){
		
		Long pageSize = 1l;
	    Long totalPage = bookAccessServiceImpl.findBookPageTotalByPageSizeAndEnd(pageSize);//先展示2个试试看
		//对页数参数做处理
		if(pageNum <1){
			pageNum=1l;
		}else if(pageNum > totalPage ){
			pageNum = totalPage;
		}
		
		
		
		//查询
		List<BookIntro> books = bookAccessServiceImpl.getBookListByEnd(pageNum, pageSize);
		//分页问题
		
		Map<String, Object> model  = new HashMap<String,Object>();

		model.put("books", books);
		model.put("maxPage", totalPage);
		model.put("nowPage", pageNum);
		//要暂时的列表页
		List<Integer> pageList = PageNumberListUtils.getPageNumList4M(pageNum, totalPage);
		
		model.put("pageList", pageList);
		
		return new ModelAndView("/mbookend",model);
		
	}
	
	/**
	 * 搜索指定的图书
	 * <p>Title: showBookList</p>
	 * <p>Description: </p>
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/search")
	public ModelAndView showBookSearch( String q,@RequestParam(defaultValue="1") int pageNum){
		
		if(q!=null &&q.length()>20){
			q =q.substring(0, 10);
		}
		
		//判断一共可以展示的页数 
		Integer pageSize = 5;
		
		//进行查询获取动态图列表
		
		ResultData<List<BookIntro>> result = bookAccessServiceImpl.findBookSearchByPageNum(q, pageNum, pageSize);
		
		Map<String, Object> model  = new HashMap<String,Object>();
		if(result!=null && result.getTotalCount()>0){
			model.put("list",result.getData());
			int totalPage = (int) ((result.getTotalCount()+pageSize -1)/pageSize);
			model.put("maxPage", totalPage);
			model.put("nowPage", pageNum);
			//要暂时的列表页
			List<Integer> pageList = PageNumberListUtils.getPageNumList4M(pageNum, totalPage);
			
			model.put("pageList", pageList);
			model.put("totalCount","1");
		}else{
			model.put("totalCount","0");
		}
	
     
		return new ModelAndView("/mbooksearch",model);
		
	}
	
	/**
	 * 分页展示所有的图书
	 * <p>Title: showBookList</p>
	 * <p>Description: </p>
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView showBookList(@RequestParam(defaultValue="1") int pageNum){
		
		//按照更新时间降序
		
		//判断一共可以展示的页数 
		Integer pageSize = 5;
		Integer totalPage = bookAccessServiceImpl.findBookPageTotalByPageSize(pageSize);//先展示2个试试看
		//对页数参数做处理
		if(pageNum <1){
			pageNum=1;
		}else if(pageNum > totalPage ){
			pageNum = totalPage;
		}
		
		//进行查询获取动态图列表
		
		List<BookIntro> bookList = bookAccessServiceImpl.findBookListByPageNum(pageNum, pageSize);
		
		Map<String, Object> model  = new HashMap<String,Object>();
		
		model.put("list", bookList);
		model.put("maxPage", totalPage);
		model.put("nowPage", pageNum);
		//要暂时的列表页
		List<Integer> pageList = PageNumberListUtils.getPageNumList4M(pageNum, totalPage);
		
		model.put("pageList", pageList);
	
     
		return new ModelAndView("/mbook",model);
		
	}
	
	/**
	 * 根据图书ID获取图书简介及最近的10章图书信息
	 */
	@RequestMapping("/detail/intro/{introId}")
	public ModelAndView showBookIntro(@PathVariable Long introId){
		
		//查询id是否可用或者存在
		boolean flag = bookAccessServiceImpl.findIntroIdIsExit(introId);
		if(!flag){
			introId=1l;//这里先写死,应该推荐最热门的图书的
		}
		
		BookIntro bookIntro = bookAccessServiceImpl.findBookIntroByIntroId(introId); 
		//获取最近10章的章节名称
		List<BookChapter> chapters = bookAccessServiceImpl.getNearBookChapterByIntroId(introId);
		
		
		Map<String, Object> model  = new HashMap<String,Object>();
		
		model.put("bookIntro", bookIntro);
		model.put("chapters", chapters);
		
		return new ModelAndView("/mbookchapter",model);
	}
	
	/**
	 * 获取全本小说的章节列表信息
	 * <p>Title: showBookChapter</p>
	 * <p>Description: </p>
	 * @param introId
	 * @return
	 */
	@RequestMapping("/detail/chapter/{introId}")
	public ModelAndView showBookChapter(@PathVariable Long introId){
		
		//查询id是否可用或者存在
		boolean flag = bookAccessServiceImpl.findIntroIdIsExit(introId);
		if(!flag){
			introId=1l;//这里先写死,应该推荐最热门的图书的
		}
		
		BookIntro bookIntro = bookAccessServiceImpl.findBookIntroByIntroId(introId); 
		
		List<BookChapter> chapters = bookAccessServiceImpl.getAllBookChapterByIntroId(introId);
		
		
		
		Map<String, Object> model  = new HashMap<String,Object>();
		
		model.put("bookIntro", bookIntro);
		
		model.put("chapters", chapters);
		
		return new ModelAndView("/mbookchapterdetail",model);
		
	}
	
	/**
	 * 获取指定小说的章节内容信息
	 * <p>Title: showBookChapter</p>
	 * <p>Description: </p>
	 * @param introId
	 * @return
	 */
	@RequestMapping("/detail/content/{introId}/{chapterId}")
	public ModelAndView showBookContent(@PathVariable Long introId,@PathVariable Long chapterId){
		
		//查询id是否可用或者存在
		boolean flag = bookAccessServiceImpl.findIntroIdIsExit(introId);
		if(!flag){
			introId=1l;//这里先写死,应该推荐最热门的图书的
		}
		BookIntro bookIntro = bookAccessServiceImpl.findBookIntroByIntroId(introId); 
		BookContent bookContent = null;
		
		bookContent = bookAccessServiceImpl.getBookContentByChapterIdInSolr(chapterId);
		if(bookContent ==null){
			bookContent = bookAccessServiceImpl.getBookContentByChapterId(chapterId);
			byte[] content = bookContent.getContent();
			
			bookContent.setShowContent(new String(content));
			bookContent.setChapter_id(chapterId);
			
			
		}
		

		//先后章节id
		Long prev = bookAccessServiceImpl.getBookPreviousChapterId(chapterId);
		Long after = bookAccessServiceImpl.getBookAfterChapterId(chapterId);

		
		Map<String, Object> model  = new HashMap<String,Object>();
		
		model.put("bookIntro", bookIntro);
		
		model.put("bookContent", bookContent);
		
		if(prev !=null){
			model.put("prev", prev);
		}else{
			model.put("prev", 0);
		}
		if(after !=null){
			model.put("after", after);
		}else{
			model.put("after", 0);
		}
		return new ModelAndView("/mbookcontent",model);
	}
}
