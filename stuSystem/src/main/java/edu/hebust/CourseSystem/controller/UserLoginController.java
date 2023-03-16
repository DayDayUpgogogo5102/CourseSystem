package edu.hebust.CourseSystem.controller;

import edu.hebust.CourseSystem.pojo.Userlogin;
import edu.hebust.CourseSystem.service.UserLoginService;
import edu.hebust.CourseSystem.util.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
//@CrossOrigin
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;


    @PostMapping("/login")
//    public R login(@RequestParam("Username") String Username, @RequestParam("Password") String Password){
    public R login(@RequestBody Map<String,String> loginInfo){
        String username = loginInfo.get("Username");
        String password = loginInfo.get("Password");

        return userLoginService.login(username,password);
    }
}
