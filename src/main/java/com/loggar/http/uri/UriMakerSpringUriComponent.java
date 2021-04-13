package com.loggar.http.uri;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Make Uri with UriComponents.
 *
 */
@Component("uriMaker")
public class UriMakerSpringUriComponent implements UriMaker {
	private String defaultPath = "/test";

	@Override
	public void setDefaultPath(String path) {
		this.defaultPath = path;
	}

	@Override
	public String makeUri_defalut() {
		if (this.defaultPath == null || this.defaultPath.trim().equals(""))
			defaultPath = "/test";
		UriComponents uc = UriComponentsBuilder.newInstance().path(defaultPath).queryParam("abc", 12).queryParam("abc2", "123").build();
		return uc.toUriString();
	}

	@Override
	public String makeUri(String path) {
		try {
			UriComponents uc = UriComponentsBuilder.newInstance().path(path).build();
			return uc.toUriString();
		} catch (Exception e) {
			return makeUri_defalut();
		}
	}

	@Override
	public String makeUri(String path, Map<String, ?> requestParams) {
		try {
			UriComponentsBuilder ucb = UriComponentsBuilder.newInstance().path(path);
			Set<String> set = requestParams.keySet();
			for (String s : set)
				ucb = ucb.queryParam(s, requestParams.get(s));
			UriComponents uc = ucb.build();
			return uc.toUriString();
		} catch (Exception e) {
			return makeUri_defalut();
		}
	}

	@Override
	public String makeUri(String uriDepth_1, String uriDepth_2) {
		try {
			UriComponents uc = UriComponentsBuilder.newInstance().path("/{uriDepth_1}/{uriDepth_2}").build().expand(uriDepth_1, uriDepth_2).encode();
			return uc.toUriString();
		} catch (Exception e) {
			return makeUri_defalut();
		}
	}

	@Override
	public String makeUri(String uriDepth_1, String uriDepth_2, Map<String, ?> requestParams) {
		try {
			UriComponentsBuilder ucb = UriComponentsBuilder.newInstance().path("/{uriDepth_1}/{uriDepth_2}");
			Set<String> set = requestParams.keySet();
			for (String s : set)
				ucb = ucb.queryParam(s, requestParams.get(s));
			UriComponents uc = ucb.build().expand(uriDepth_1, uriDepth_2).encode();
			return uc.toUriString();
		} catch (Exception e) {
			return makeUri_defalut();
		}
	}

	@Override
	public String makeUri(Map<String, ?> uriVariables, Map<String, ?> requestParams) {
		if (uriVariables == null || uriVariables.size() < 1) {
			return makeUri_defalut();
		}
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		for (int i = 0; i < uriVariables.size(); i++) {
			if (uriVariables.containsKey("uriDepth_" + (i + 1))) {
				sb.append("/{");
				sb.append("uriDepth_" + (i + 1));
				sb.append("}");
			}
		}

		try {
			UriComponentsBuilder ucb = UriComponentsBuilder.newInstance().path(sb.toString());
			if (requestParams != null && requestParams.size() > 0) {
				Set<String> set = requestParams.keySet();
				for (String s : set)
					ucb = ucb.queryParam(s, requestParams.get(s));
			}
			UriComponents uc = ucb.build().expand(uriVariables).encode();
			return uc.toUriString();
		} catch (Exception e) {
			return makeUri_defalut();
		}
	}

}