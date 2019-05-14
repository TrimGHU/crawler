package com.hugui.crawler.cache;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright © 2019 HuGui. All rights reserved.
 * 
 * @Title: BaozhiCache.java
 * @Prject: crawler
 * @Package: com.hugui.crawler.cache
 * @Description:
 * @author: HuGui
 * @date: 2019年5月13日 下午2:20:51
 * @version: V1.0
 */

public class BaozhiCache {

	private static LinkedHashMap<String, Object> baoZhiCacheMap = new LinkedHashMap<>();

	public static Object get(String key) {
		return baoZhiCacheMap.get(key);
	}

	public static void set(String key, Object obj) {
		baoZhiCacheMap.put(key, obj);
	}

	public static void push(String key, Object obj) {
		Object o = baoZhiCacheMap.get(key);
		if (o == null) {
			LinkedList<Object> list = new LinkedList<>();
			list.add(obj);
			set(key, list);
		} else {
			if (o instanceof List) {
				@SuppressWarnings("unchecked")
				List<Object> olist = (List<Object>) o;
				olist.add(obj);
				set(key, olist);
			}
		}
	}

	public static LinkedHashMap<String, Object> getBaoZhiCacheMap() {
		return baoZhiCacheMap;
	}
}
