package edu.hebust.CourseSystem.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.hebust.CourseSystem.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 *  Mapper 接口
 *
 * @author zlxiao
 * @since 2023-03-14
 */
public interface StudentMapper extends BaseMapper<Student> {

    @Select("SELECT student.*,collegeName FROM student,college WHERE student.`collegeID` = college.`collegeID`")
    IPage<Student> showAllStu(IPage<Student> iPage);

    @Select("SELECT student.*,collegeName FROM student,college WHERE student.collegeID = college.collegeID and userID=#{stuID}")
    Student selectByIdCustom(Integer stuID);
}
