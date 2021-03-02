package com.priscilla.web.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Login confirmation
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    // Before target method executing
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            // Not logged in, return to login page
            request.setAttribute("msg", "Please log in first to view your favorite list");
            request.getRequestDispatcher("/login").forward(request, response);
            return  false;
        } else {
            // Logged in, allow request
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
