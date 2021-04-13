package com.loggar.http.uri;

import java.util.Map;

public interface UriMaker {
	void setDefaultPath(String path);

	String makeUri_defalut();

	String makeUri(String path);

	String makeUri(String path, Map<String, ?> requestParams);

	String makeUri(String uriDepth_1, String uriDepth_2);

	String makeUri(String uriDepth_1, String uriDepth_2, Map<String, ?> requestParams);

	String makeUri(Map<String, ?> uriVariables, Map<String, ?> requestParams);
}
