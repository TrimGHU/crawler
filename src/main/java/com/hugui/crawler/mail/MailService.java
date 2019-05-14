package com.hugui.crawler.mail;

import java.time.LocalDate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.hugui.crawler.cache.BaozhiCache;

/**
 * Copyright © 2019 Obexx. All rights reserved.
 * 
 * @Title: MailService.java
 * @Prject: crawler
 * @Package: com.hugui.crawler.mail
 * @Description:
 * @author: HuGui
 * @date: 2019年5月13日 上午10:39:19
 * @version: V1.0
 */

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine engine;

	private static final String FROM = "hugui_19870607@126.com";

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void sendBaoZhiHtmlMail(String[] tos, String subject, String htmlName) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(FROM);
			helper.setTo(tos);
			helper.setSubject(subject);

			Context context = new Context();
			context.setVariable("date", LocalDate.now().toString());
			context.setVariable("images", BaozhiCache.get("HUANQIU-IMAGES"));
			helper.setText(engine.process(htmlName, context), true);
			mailSender.send(message);
		} catch (MessagingException e) {
			logger.error("发送html邮件时发生异常！{}", e.getMessage());
		}
	}
}
