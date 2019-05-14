package com.hugui.crawler.html;

import java.time.LocalDate;
import java.util.List;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;

/**
 * Copyright © 2019 Obexx. All rights reserved.
 * 
 * @Title: BaozhiIndexPipeline.java
 * @Prject: crawler
 * @Package: com.hugui.crawler.pipeline
 * @Description:
 * @author: HuGui
 * @date: 2019年5月7日 下午4:59:27
 * @version: V1.0
 */

@PipelineName("baozhiIndex")
public class BaozhiIndexPipeline implements Pipeline<BaoZhiIndex> {

	@Override
	public void process(BaoZhiIndex baozhiIndex) {
		List<BaoZhi> huanqiushibaos = baozhiIndex.getHuanqiushibao();

		// 只抓取当天的报纸数据, 后续每天定时抓取
		for (BaoZhi hqsb : huanqiushibaos) {
			List<HrefBean> hrefs = hqsb.getBaozhiUrls();
			for (HrefBean href : hrefs) {

				String link = href.getUrl();
				String[] arr = link.split("/");

				if (LocalDate.now().getDayOfYear() == LocalDate
						.of(Integer.valueOf(arr[3]), Integer.valueOf(arr[4]), Integer.valueOf(arr[5])).getDayOfYear()) {
					String url = "http://www.jdqu.com" + href.getUrl().replace(".html", "-1.html");
					HttpRequest currRequest = baozhiIndex.getHttpRequest();
					SchedulerContext.into(currRequest.subRequest(url));
				}
			}
		}
	}
}
