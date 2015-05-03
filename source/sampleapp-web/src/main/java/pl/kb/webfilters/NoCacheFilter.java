package pl.kb.webfilters;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/html/sys/admin/*")
public class NoCacheFilter implements Filter {

	private static final Logger LOG = LoggerFactory
			.getLogger(NoCacheFilter.class);

	@Override
	public void doFilter(final ServletRequest request,
			final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		LOG.info("invoked");

		final HttpServletRequest httpReq = (HttpServletRequest) request;
		final HttpServletResponse httpRes = (HttpServletResponse) response;

		// Skip JSF resources (CSS/JS/Images/etc)
		if (!httpReq.getRequestURI().startsWith(
				httpReq.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) {
			LOG.info("filtering");
			httpRes.setHeader("Cache-Control",
					"no-cache, no-store, must-revalidate"); // HTTP 1.1.
			httpRes.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			httpRes.setDateHeader("Expires", 0); // Proxies.
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Nothing to do
	}

	@Override
	public void destroy() {
		// Nothing to do
	}
}
