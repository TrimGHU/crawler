package com.hugui.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Copyright © 2019 HuGui. All rights reserved.
 * 
 * @Title: CrawlerApplication.java
 * @Prject: crawler
 * @Package: com.hugui.crawler
 * @Description:
 * @author: HuGui
 * @date: 2019年5月13日 下午2:03:07
 * @version: V1.0
 */

@SpringBootApplication
@EnableScheduling
public class CrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawlerApplication.class, args);
	}

}
