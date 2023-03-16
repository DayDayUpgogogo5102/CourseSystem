package edu.hebust.CourseSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import edu.hebust.CourseSystem.dao.RoleMapper;
import edu.hebust.CourseSystem.dao.UserloginMapper;
import edu.hebust.CourseSystem.pojo.Role;
import edu.hebust.CourseSystem.pojo.Userlogin;
import edu.hebust.CourseSystem.service.UserLoginService;
import edu.hebust.CourseSystem.util.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("all")
public class UserLoginServiceImpl implements UserLoginService {


    @Autowired
    private UserloginMapper userloginMapper;
    @Autowired
    private RoleMapper roleMapper;

    /*
     * @Author: Longxiao Zhang
     * @Date: 2023/3/14 22:36
     * @Description 用户登录
     */
    @Override
    public R login(String username, String password) {

        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {

            LambdaQueryWrapper<Userlogin> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Userlogin::getUsername, username);
            queryWrapper.eq(Userlogin::getPassword, password);
            Userlogin userInfo = userloginMapper.selectOne(queryWrapper);

            if (userInfo != null) {
                String info = null;
                if (userInfo.getRole() != null) {
                    Role role = roleMapper.selectById(userInfo.getRole());
                    String roleName = role.getRolename();
                    if (StringUtils.isNotBlank(roleName)) {
                        userInfo.setRoleName(roleName);
                        info = roleName.equals("admin") ? "管理员" : (roleName.equals("teacher") ? "教师" : "学生");
                    }
                }
                return new R(true, info, userInfo);
            }else {
                return new R(false,"用户名或密码错误",null);
            }
        }else{
            return new R(false,"用户名或密码不能为空！",null);
        }
    }
}
