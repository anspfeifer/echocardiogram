//package com.heart.echo.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//@Component
//public class NoContentFilter extends OncePerRequestFilter{
//
//	private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		
//		log.info("Content-Type: " + response.getContentType());
//		
////		if (response.getContentType() == null ||
////			response.getContentType().equals("") || 
////			response.getContentType().isEmpty()){
////				response.setStatus(HttpStatus.NO_CONTENT.value());
////		}
//		
//	}
//
//}
