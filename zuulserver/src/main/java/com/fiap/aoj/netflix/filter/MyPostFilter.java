package com.fiap.aoj.netflix.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyPostFilter extends ZuulFilter {

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;
	public static String POST_FILTER_TYPE = "post";
	private static final Logger LOGGER = LoggerFactory.getLogger(MyPostFilter.class);

	@Autowired
	private FilterUtils filterUtils;

	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	public String filterType() {
		return POST_FILTER_TYPE;
	}

	public int filterOrder() {
		return FILTER_ORDER;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		LOGGER.debug("Adding the correlation id to the outbound headers {}",
		filterUtils.getCorrelationId());
		ctx.getResponse().addHeader(FilterUtils.CORRELATION_ID, filterUtils.getCorrelationId());
		LOGGER.debug("Complete outgoing request for {} ", ctx.getRequest().getRequestURI());
		return null;

	}
}
