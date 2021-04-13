package com.loggar.http.uri;

import static org.junit.Assert.assertTrue;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UriMakerTest {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private UriMaker um;

	@Before
	public void before() {
		this.um = new UriMakerSpringUriComponent();
	}

	@Test
	public void uri_maker_1() {
		String path = "/test";

		String testUri = um.makeUri(path);
		logger.debug(testUri);
		assertTrue(testUri.equals("/test"));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("abc", 123);
		params.put("abcd", "abcd");

		testUri = um.makeUri(path, params);
		logger.debug(testUri);
		assertTrue(testUri.equals("/test?abc=123&abcd=abcd"));

		testUri = um.makeUri("test1", "test2", params);
		logger.debug(testUri);
		assertTrue(testUri.equals("/test1/test2?abc=123&abcd=abcd"));

		Map<String, Object> uriPaths = new HashMap<String, Object>();
		uriPaths.put("uriDepth_1", "test1");
		uriPaths.put("uriDepth_2", "test2");
		uriPaths.put("uriDepth_3", "test3");

		testUri = um.makeUri(uriPaths, params);
		logger.debug(testUri);
		assertTrue(testUri.equals("/test1/test2/test3?abc=123&abcd=abcd"));
	}
}