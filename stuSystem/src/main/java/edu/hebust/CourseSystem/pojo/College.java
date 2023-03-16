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
@TableName("college")
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "collegeID", type = IdType.AUTO)
    private Integer collegeid;

    /**
     * 课程名
     */
    @TableField("collegeName")
    private String collegename;


}
