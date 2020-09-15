package com.fiap.aoj.netflix.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyPreFilter extends ZuulFilter {

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;
	public static String PRE_FILTER_TYPE = "pre";
	private static final Logger LOGGER = LoggerFactory.getLogger(MyPreFilter.class);

	@Autowired
	private FilterUtils filterUtils;

	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	public String filterType() {
		return PRE_FILTER_TYPE;
	}

	public int filterOrder() {
		return FILTER_ORDER;
	}

	private boolean isCorrelationIdPresent() {
		return filterUtils.getCorrelationId() != null;
	}

	private String generateCorrelationId() {
		return java.util.UUID.randomUUID().toString();
	}

	@Override
	public Object run() throws ZuulException {
		if (isCorrelationIdPresent()) {
			LOGGER.debug("correlation-id is present {}", filterUtils.getCorrelationId());
			} else {
			filterUtils.setCorrelationId(generateCorrelationId());
			LOGGER.debug("correlation-id is generated {}", filterUtils.getCorrelationId());
			}
			RequestContext ctx = RequestContext.getCurrentContext();
			LOGGER.debug("procesing incoming request for {}", ctx.getRequest().getRequestURI());
			return null;
	}
}
