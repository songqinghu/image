package com.kuaikanwang.image.controller.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.service.BookAccessService;
import com.kuaikanwang.image.service.GifAccessService;
import com.kuaikanwang.image.utils.PageNumberListUtils;

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
	
	@RequestMapping("/list")
	public ModelAndView showBookList(@RequestParam(defaultValue="1") int pageNum){
		
		//按照更新时间降序
		
		//判断一共可以展示的页数 
		Integer pageSize = 1;
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
	
	
	
	
}
