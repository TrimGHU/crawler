package com.hugui.crawler.html;

import java.util.List;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Copyright © 2019 Obexx. All rights reserved.
 * 
 * @Title: BaoZhi.java
 * @Prject: crawler
 * @Package: com.hugui.crawler.html
 * @Description:
 * @author: HuGui
 * @date: 2019年5月9日 下午3:20:05
 * @version: V1.0
 */

public class BaoZhi implements HtmlBean {

	private static final long serialVersionUID = 1L;

	@Text
	@HtmlField(cssPath = "h6 > b")
	private String name;

	@HtmlField(cssPath = "ul > li > a")
	private List<HrefBean> baozhiUrls;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HrefBean> getBaozhiUrls() {
		return baozhiUrls;
	}

	public void setBaozhiUrls(List<HrefBean> baozhiUrls) {
		this.baozhiUrls = baozhiUrls;
	}

}
