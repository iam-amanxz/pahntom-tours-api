package com.ssdgroupc.app.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Date: May 26-2020 AuthEntryPointJwt component.
 * 
 * @author aman
 * @version 1.0
 * @category Security
 */
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger LOGGER = LogManager.getLogger(AuthEntryPointJwt.class.getName());

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		LOGGER.error("Unauthorized error: {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}

}
