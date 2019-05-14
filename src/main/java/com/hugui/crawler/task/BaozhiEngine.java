package com.hugui.crawler.task;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.hugui.crawler.cache.BaozhiCache;
import com.hugui.crawler.mail.MailService;

/**
 * Copyright © 2019 Obexx. All rights reserved.
 * 
 * @Title: BaozhiEngine.java
 * @Prject: crawler
 * @Package: com.hugui.crawler
 * @Description:
 * @author: HuGui
 * @date: 2019年5月7日 下午7:54:22
 * @version: V1.0
 */

@Service
public class BaozhiEngine {

	@Autowired
	private MailService mailService;

	@Scheduled(cron = "0 0/10 9-10 * * *")
	public void baozhiTask() {

		if (!StringUtils.isEmpty(BaozhiCache.get("TASK-STATUS:" + LocalDate.now().toString()))) {

			if (StringUtils.isEmpty(BaozhiCache.get("TASK-EMAIL-SEND:" + LocalDate.now().toString()))) {
				mailService.sendBaoZhiHtmlMail(new String[] { "530412087@qq.com", "450715946@qq.com" }, "环球时报",
						"baozhiMailTemplate");
				BaozhiCache.set("TASK-EMAIL-SEND:" + LocalDate.now().toString(), true);
				BaozhiCache.set("HUANQIU-IMAGES", null);
			}

			return;
		}

		String url = "http://www.jdqu.com";
		String classpath = "com.hugui.crawler.html";
		HttpRequest request = new HttpGetRequest(url);
		request.setCharset("gbk");
		GeccoEngine.create().classpath(classpath).start(request).interval(2000).run();
	}
}
