package springboot.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.login.service.UserRegisterService;
import springboot.login.service.models.UserRegisterModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

    private final UserRegisterService userRegisterService;

    public RegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @GetMapping()
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserRegisterModel userRegisterModel = new UserRegisterModel();
        modelAndView.addObject("user",userRegisterModel);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView registerConfirm(
            @Valid @ModelAttribute("user") UserRegisterModel userRegisterModel, BindingResult bindingResult){

        return view(this.userRegisterService.registerUser(userRegisterModel,bindingResult));
    }
}
