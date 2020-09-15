package com.fiap.aoj.netflix.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;

@Component
public class FilterUtils {

	public static final String CORRELATION_ID = "my-correlation-id";

	public String getCorrelationId() {
		RequestContext ctx = RequestContext.getCurrentContext();
		if (ctx.getRequest().getHeader(CORRELATION_ID) != null) {
			return ctx.getRequest().getHeader(CORRELATION_ID);
		} else {
			return ctx.getZuulRequestHeaders().get(CORRELATION_ID);
		}
	}

	public void setCorrelationId(String correlationId) {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader(CORRELATION_ID, correlationId);
	}
}
