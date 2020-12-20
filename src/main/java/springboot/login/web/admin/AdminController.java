package springboot.login.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import springboot.login.persistance.entities.User;
import springboot.login.service.AdminService;
import springboot.login.web.BaseController;

import java.util.List;

@Controller
public class AdminController extends BaseController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView){
        modelAndView.setViewName("/admin/admin");
        modelAndView.addObject("users",this.adminService.showUsers());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id) {
        this.adminService.deleteUser(id);
        return redirect("/admin");
    }

}
