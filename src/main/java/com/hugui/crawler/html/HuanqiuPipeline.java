package com.hugui.crawler.html;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.hugui.crawler.cache.BaozhiCache;

/**
 * Copyright © 2019 Obexx. All rights reserved.
 * 
 * @Title: HuanqiuPipeline.java
 * @Prject: crawler
 * @Package: com.hugui.crawler.html
 * @Description:
 * @author: HuGui
 * @date: 2019年5月10日 上午11:25:40
 * @version: V1.0
 */

@PipelineName("huanqiuPipeline")
public class HuanqiuPipeline implements Pipeline<Huanqiu> {

	@Override
	public void process(Huanqiu huanqiu) {
		HttpRequest currRequest = huanqiu.getRequest();

		// 下一页继续抓取
		int currPage = huanqiu.getCurrPage();
		int nextPage = currPage + 1;
		int totalPage = huanqiu.getTotalPage();

		BaozhiCache.push("HUANQIU-IMAGES", huanqiu.getPaperImage());

		if (nextPage <= totalPage) {
			String nextUrl = "";
			String currUrl = currRequest.getUrl();

			if (currUrl.indexOf('-') < 0) {
				nextUrl = StringUtils.replaceOnce(currUrl, ".html", "-" + nextPage + ".html");
			} else {
				nextUrl = StringUtils.replaceOnce(currUrl, "-" + currPage + ".html", "-" + nextPage + ".html");
			}

			SchedulerContext.into(currRequest.subRequest(nextUrl));
		}

		if (nextPage == totalPage) {
			BaozhiCache.push("TASK-STATUS:" + LocalDate.now().toString(), "FINISHED");
		}
	}

}
