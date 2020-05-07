// 예외다루기
package bitcamp.app2;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ErrorController {

  @RequestMapping("/error")
  public ModelAndView error(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("status", request.getAttribute("javax.servlet.error.status_code"));
    mv.addObject("reason", request.getAttribute("javax.servlet.error.message"));
    mv.setViewName("error2");
    return mv;
  }
}


