package springboot.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.login.service.UserRegisterService;
import springboot.login.service.models.UserRegisterModel;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

    private final UserRegisterService userRegisterService;

    public RegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @GetMapping
    public ModelAndView register(){
        return super.view("/register");
    }

    @PostMapping
    public ModelAndView registerConfirm(UserRegisterModel userRegisterModel){
        this.userRegisterService.registerUser(userRegisterModel);
        return redirect("/login");
    }
}
