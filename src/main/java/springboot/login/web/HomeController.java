package springboot.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user/home")
public class HomeController extends BaseController {

    @GetMapping
    public ModelAndView home() {
        return super.view("user/home");
    }
}
