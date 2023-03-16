package edu.hebust.CourseSystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/*
* @Author: Longxiao Zhang
* @Date: 2023/3/14 21:12
* @Description 教师实体类
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userID",type = IdType.AUTO)
    private Integer userID;

    // 用户名
    private String userName;
    //性别
    private String sex;
    //出生年份
    @TableField("birthYear")
    private Date birthYear;
    //学历
    private String degree;
    //职称
    private String title;

    //入职时间
    @TableField("grade")
    private Date grade;
    //院系
    private Integer collegeID;

    //院系名称(冗余)
    @TableField(exist = false)
    private String collegeName;
}
