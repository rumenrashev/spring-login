package springboot.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.login.service.models.UserLoginModel;
import springboot.login.service.models.UserRegisterModel;

@Controller
public class LoginController extends BaseController {

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        return super.view("/login");
    }

    @GetMapping("/error")
    public ModelAndView modelAndView(){
        return super.view("error");
    }
}
