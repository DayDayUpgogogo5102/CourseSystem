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
@TableName("userlogin")
public class Userlogin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userID", type = IdType.AUTO)
    private Integer userid;

    @TableField("userName")
    private String username;

    @TableField("password")
    private String password;

    /**
     * 角色权限
     */
    @TableField("role")
    private Integer role;

    // 角色权限名(冗余)
    @TableField(exist = false)
    private String roleName;


}
