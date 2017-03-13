/**
 * 
 */
package com.opencodez.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.opencodez.util.ApplicationLogger;


@Component
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler  {

	private static final ApplicationLogger logger = ApplicationLogger.getInstance();
	
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		logger.entry();
		if(null != authentication && null != authentication.getDetails()) {
			try {
				logger.info("Session invalidated");
				request.getSession().invalidate();
			} catch (Exception e) {
			}
			setDefaultTargetUrl("/login?logout");
			super.onLogoutSuccess(request, response, authentication);
		}
	}

}
