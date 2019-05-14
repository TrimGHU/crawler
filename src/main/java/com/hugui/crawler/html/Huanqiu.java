package com.hugui.crawler.html;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Copyright © 2019 Obexx. All rights reserved.
 * 
 * @Title: Huanqiu.java
 * @Prject: crawler
 * @Package: com.hugui.crawler.html
 * @Description:
 * @author: HuGui
 * @date: 2019年5月10日 上午10:51:15
 * @version: V1.0
 */

@Gecco(matchUrl = "http://www.jdqu.com/html/ckxx/{year}/{month}/{day}/{papernum}-{page}.html", pipelines = {
		"consolePipeline", "huanqiuPipeline" })
public class Huanqiu implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Request
	private HttpRequest request;

	@Text
	@HtmlField(cssPath = "option[selected=selected]")
	private int currPage;
	
	@Text
	@HtmlField(cssPath = "div.paging > ul > span > font > b")
	private int totalPage;

	@Image({ "data-lazy-img", "src" })
	@HtmlField(cssPath = "#demo")
	private String paperImage;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getPaperImage() {
		return paperImage;
	}

	public void setPaperImage(String paperImage) {
		this.paperImage = paperImage;
	}

}
