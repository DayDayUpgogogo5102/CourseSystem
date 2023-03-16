package edu.hebust.CourseSystem.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlxiao
 * @since 2023-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "courseID", type = IdType.AUTO)
    private Integer courseid;

    /**
     * 课程名称
     */
    @TableField("courseName")
    private String coursename;

    @TableField("teacherID")
    private Integer teacherid;

    /**
     * 开课时间
     */
    @TableField("courseTime")
    private String coursetime;

    /**
     * 开课地点
     */
    @TableField("classRoom")
    private String classroom;

    /**
     * 学时
     */
    @TableField("courseWeek")
    private Integer courseweek;

    /**
     * 课程类型
     */
    @TableField("courseType")
    private String coursetype;

    /**
     * 所属院系
     */
    @TableField("collegeID")
    private Integer collegeid;

    /**
     * 学分
     */
    @TableField("score")
    private Integer score;


}
