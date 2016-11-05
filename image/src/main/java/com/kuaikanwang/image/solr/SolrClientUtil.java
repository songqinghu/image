package com.kuaikanwang.image.solr;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.CommonParams;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kuaikanwang.image.domain.bean.book.BookContent;

@Service
public class SolrClientUtil implements InitializingBean{

	private HttpSolrClient client;
	
	private HttpSolrClient bookIntroClient;
	
	
	@Value("${solr.client.address.book}")
	private String bookUrl;
	@Value("${solr.client.address.bookIntro}")
	private String bookIntroUrl;
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		client = new HttpSolrClient(bookUrl);
		bookIntroClient = new HttpSolrClient(bookIntroUrl);
		
	}

	public HttpSolrClient getClient(){
		return client;
	}
	
	public HttpSolrClient getBookIntroClient(){
		return bookIntroClient;
	}
	
	
	
	public static void main(String[] args) throws SolrServerException, IOException {
		HttpSolrClient client = new HttpSolrClient("http://192.168.31.60:18001/solr/book");
		SolrQuery query = new SolrQuery();
		query.set(CommonParams.Q, "*:*");
		query.setStart(0);
		query.setRows(1);
		QueryResponse response = client.query(query);
		
		List<BookContent> beans = response.getBeans(BookContent.class);
		System.out.println(response.getQTime());
		for (BookContent bookContent : beans) {
			System.out.println(bookContent.getSolr_id());
			System.out.println(bookContent.getShowContent().subSequence(0, 100));
		}
	}
	
	
}
