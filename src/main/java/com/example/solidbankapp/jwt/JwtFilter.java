package com.example.solidbankapp.jwt;

import com.example.solidbankapp.exceptions.Teapot;
import com.example.solidbankapp.service.CustomUserDetails;
import com.example.solidbankapp.service.CustomUserDetailsService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static io.jsonwebtoken.lang.Strings.hasText;

@Component
@Log
public class JwtFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        logger.info("do filter...");
//        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
//        logger.info(token);
//        if (token != null && jwtProvider.validateToken(token)) {
//            String userLogin = jwtProvider.getLoginFromToken(token);
//            CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
//            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(auth);
//            filterChain.doFilter(servletRequest, servletResponse);
//        }

//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//            throws IOException, ServletException {
//        logger.info("do filter...");
//        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
//        if (token != null) {
//            if (jwtProvider.validateToken(token)) {
//                String userLogin = jwtProvider.getLoginFromToken(token);
//                CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
//                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails,
//                        null, customUserDetails.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("do filter...");
        String token = getTokenFromRequest((HttpServletRequest) request);
        if (token != null) {
            if (jwtProvider.validateToken(token)) {
                String userLogin = jwtProvider.getLoginFromToken(token);
                CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails,
                        null, customUserDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }

//        logger.info("user's uri " + ((HttpServletRequest) servletRequest).getRequestURI());
//            if(((HttpServletRequest) servletRequest).getRequestURI().contains("/auth")
//                    || ((HttpServletRequest) servletRequest).getRequestURI().contains("/register")
//                    || ((HttpServletRequest) servletRequest).getRequestURI().contains("/swagger-ui/index.html")
//                    || ((HttpServletRequest) servletRequest).getRequestURI().contains("/v3/api-docs/**")
//                    || ((HttpServletRequest) servletRequest).getRequestURI().contains("/swagger-ui/**")
//                    || ((HttpServletRequest) servletRequest).getRequestURI().contains("/accounts/**")
//            ){
//                logger.info("filter passed");
//                filterChain.doFilter(servletRequest, servletResponse);
//            }else {
//                    throw new Teapot("Not authorized");
//            }

//}

//    private String getTokenFromRequest(HttpServletRequest request) {
//        String bearer = request.getHeader(AUTHORIZATION);
//        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
//            return bearer.substring(7);
//        }
//        return null;
//    }

    private String getTokenFromRequest(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        String token = null;
        String username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    username = jwtProvider.extractUsername(token);
                }
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null || token != null) {
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                    if (Boolean.TRUE.equals(jwtProvider.validateToken(token))) {
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails, null, userDetails.getAuthorities());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
            }
        }
        return null;
    }
}