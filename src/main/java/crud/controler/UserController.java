package crud.controler;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("userlist", userService.findAllUsers());
        return "userlist";
    }
    @RequestMapping(value = "/user-save", method = RequestMethod.POST)
    public String saveUser(@RequestParam(value = "name") String name,
                           @RequestParam(value = "last_name") String lastname,
                           @RequestParam(value = "email")String email) {
        User user = new User(name, lastname, email);
        userService.saveUser(user);
        return "redirect:/users";
    }
    @RequestMapping(value = "/user-save", method=RequestMethod.GET)
    public String saveUserPage() {
        return "saveuser";
    }
    @RequestMapping(value = "/user-update", method = RequestMethod.POST)
    public String updateUser(@RequestParam(value = "id")Long id,
                             @RequestParam(value = "name")String name,
                             @RequestParam(value = "last_name") String lastname,
                             @RequestParam(value = "email")String email) {
        User user = userService.findUser(id);
        user.setFirstName(name);
        user.setLastName(lastname);
        user.setEmail(email);
        userService.updateUser(user);
        return "redirect:/users";
    }
    @RequestMapping(value = "/user-update", method=RequestMethod.GET)
    public String updateUserPage() {
        return "updateuser";
    }
    @RequestMapping(value = "/user-delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        User user = userService.findUser(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }

}
