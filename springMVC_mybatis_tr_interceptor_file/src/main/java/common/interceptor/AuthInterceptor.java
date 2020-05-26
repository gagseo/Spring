package common.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



//interceptor
//DispatcherServlet이 컨트롤러를 호출하기 전에
//요청을 가로채서 원하는 작업을 진행할수 있다.
//servletContainer -> filter(서브릿 호출하기 전에 요청을 가로 챌 수 있다. ) 
//      -> servlet -> interceptor(서블릿이 컨트롤러를 호출하기 전에 요청을 가로 챌 수 있다.) -> controller
//이벤트 발생시  LIstener가 호출
public class AuthInterceptor implements HandlerInterceptor{
   
   public Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
   
   //Controller가 수행 되기 전에 로직을 여기에 작성하면 된다.
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      
      //return 타입 : boolean
      //true 반환시 : 컨트롤러를 정상적으로 호출
      //false 반환시 : 컨트롤러를 호출하지 않음
      logger.info("[interceptor] : preHandle");
      HttpSession session = request.getSession(false);
      if(request.getRequestURI().contains("book/") && session.getAttribute("logInInfo") == null) {
         request.setAttribute("alertMsg", "로그인 이후 사용 가능한 기능입니다.");
         request.setAttribute("back", "back");
         RequestDispatcher rd = 
               request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
         
         rd.forward(request, response);
         
      }
      
      
      return /*HandlerInterceptor.super.preHandle(request, response, handler)*/ true;
   }

   //Controller가 수행되고 view를 호출하깆 전에 로직을 여기에 작성
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
      // TODO Auto-generated method stub
//      HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
   }

   //view가 호출이 완료된 후 로직을 여기에 작성
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
      // TODO Auto-generated method stub
//      HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
   }
   
   

}