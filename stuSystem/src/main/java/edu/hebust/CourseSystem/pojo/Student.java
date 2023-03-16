package edu.hebust.CourseSystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    @TableId(value = "userID",type = IdType.AUTO)
    private Integer userID;

    // 用户名
    @TableField("userName")
    private String userName;
    // 性别
    private String sex;
    // 出生日期
    @TableField("birthYear")
    private Date birthYear;
    // 入学时间
    private Date grade;
    // 院系ID
    @TableField("collegeID")
    private Integer collegeID;

    // 院系名称（冗余）
    @TableField(exist = false)
    private String collegeName;

}
