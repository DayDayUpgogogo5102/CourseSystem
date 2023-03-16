package edu.hebust.CourseSystem.service;


import edu.hebust.CourseSystem.util.result.R;

public interface UserLoginService {
    //用户登录
    R login(String username, String password);
}
