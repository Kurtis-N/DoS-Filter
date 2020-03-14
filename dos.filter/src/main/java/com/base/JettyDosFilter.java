package com.base;

import org.eclipse.jetty.servlets.DoSFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kurtisniedling on 2020-03-11.
 */

@Component
public class JettyDosFilter extends DoSFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JettyDosFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);

        setEnabled(true);

        setMaxRequestsPerSec(1);    // Default is 25. Maximum number of requests from a connection per second. Requests in excess of this are first delayed, then throttled.
        setDelayMs(3000);           // Delay imposed on all requests over the rate limit, before they are considered at all
        //setMaxWaitMs(50);         // Length of time, in ms, to blocking wait for the throttle semaphore. Default is 50 ms.
        //setThrottledRequests(5);  // Number of requests over the rate limit able to be considered at once. Default is 5.
        //setThrottleMs(3000L);     //Length of time, in ms, to async wait for semaphore. Default is 30000L.
        //setMaxRequestsPerSec(3000L);    //Length of time, in ms, to allow the request to run. Default is 30000L.
        //setMaxIdleTrackerMs(3000L); //Length of time, in ms, to keep track of request rates for a connection, before deciding that the user has gone away, and discarding it. Default is 30000L.
        setInsertHeaders(true);     //Defaults to true. Insert the DoSFilter headers into the response.
        setTrackSessions(true);     //Defaults to true. Usage rate is tracked by session if a session exists.
        //setRemotePort(false);     //Defaults to false.  If true and session tracking is not used, then rate is tracked by IP and port (effectively connection).
        //setWhitelist(new String("0:0:0:0:0:0:0:1,192.169.0.1"));    //A comma-separated list of IP addresses that will not be rate limited.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(request, response, filterChain);

        //List all headers found on response
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        for(String header: httpResponse.getHeaderNames()) {
            //LOGGER.info("Header found: "+ header +" : " + httpResponse.getHeader(header));
        }
    }
}
