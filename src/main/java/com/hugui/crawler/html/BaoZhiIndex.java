package com.hugui.crawler.html;

import java.util.List;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Copyright © 2019 Obexx. All rights reserved.
 * 
 * @Title: HuanqiushibaoIndex.java
 * @Prject: crawler
 * @Package: com.hugui.crawler.html
 * @Description:
 * @author: HuGui
 * @date: 2019年5月6日 下午4:57:50
 * @version: V1.0
 */

@Gecco(matchUrl = "http://www.jdqu.com", pipelines = { "consolePipeline", "baozhiIndex" })
public class BaoZhiIndex implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Request
	private HttpRequest httpRequest;

	@HtmlField(cssPath = "div.box:nth-child(1)")
	private List<BaoZhi> cankaoxiaoxi;

	@HtmlField(cssPath = "div.box:nth-child(4)")
	private List<BaoZhi> huanqiushibao;

	public HttpRequest getHttpRequest() {
		return httpRequest;
	}

	public List<BaoZhi> getCankaoxiaoxi() {
		return cankaoxiaoxi;
	}

	public void setCankaoxiaoxi(List<BaoZhi> cankaoxiaoxi) {
		this.cankaoxiaoxi = cankaoxiaoxi;
	}

	public List<BaoZhi> getHuanqiushibao() {
		return huanqiushibao;
	}

	public void setHuanqiushibao(List<BaoZhi> huanqiushibao) {
		this.huanqiushibao = huanqiushibao;
	}

	public void setHttpRequest(HttpRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

}
