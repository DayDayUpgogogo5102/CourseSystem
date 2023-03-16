package edu.hebust.CourseSystem.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("selectedcourse")
public class Selectedcourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("courseID")
    private Integer courseid;

    @TableField("studentID")
    private Integer studentid;

    /**
     * 成绩
     */
    @TableField("mark")
    private Integer mark;


}
