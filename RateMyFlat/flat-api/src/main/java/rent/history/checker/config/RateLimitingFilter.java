//package rent.history.checker.config;
//import io.github.bucket4j.Bucket;
//import io.github.bucket4j.Bandwidth;
//import io.github.bucket4j.Refill;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.Duration;
//
//@Component
//public class RateLimitingFilter implements Filter {
//  private final Bucket bucket;
//
//  public RateLimitingFilter() {
//	Bandwidth limit = Bandwidth.classic(100, Refill.greedy(100, Duration.ofMinutes(1)));
//	this.bucket = Bucket.builder().addLimit(limit).build();
//  }
//
//  @Override public void init(FilterConfig filterConfig) throws ServletException {
//
//  }
//
//  @Override
//  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//		  throws IOException, ServletException {
//	if (bucket.tryConsume(1)) {
//	  filterChain.doFilter(servletRequest, servletResponse);
//	}
//	else {
//	  ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
//	}
//  }
//
//  @Override public void destroy() {
//
//  }
//}