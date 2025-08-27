package ar.com.servicioecu.interceptor.interceptor.interceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{
    
    private static final Logger logger= LoggerFactory.getLogger(LoadingTimeInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("PreHandler entrando..." + handler);
        logger.info("Status Code: " + response.getStatus());
        logger.info("Request Method: " + request.getMethod());
        logger.info("Request IP: " + request.getRemoteAddr());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseData= new HashMap<>();
        responseData.put("date:", new Date());
        responseData.put("detail", "unathorize");
        response.setContentType("application/json");
        response.setStatus(401);
        response.getWriter().write(mapper.writeValueAsString(responseData));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        logger.info("PostHandler saliendo..." + handler);
        System.out.println("Status Code: " + response.getStatus());
    }
}
