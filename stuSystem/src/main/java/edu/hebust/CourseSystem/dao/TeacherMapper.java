package edu.hebust.CourseSystem.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.hebust.CourseSystem.pojo.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 *  Mapper 接口
 *
 * @author zlxiao
 * @since 2023-03-14
 */
public interface TeacherMapper extends BaseMapper<Teacher> {


    @Select("SELECT teacher.*,collegeName FROM teacher,college WHERE teacher.`collegeID` = college.`collegeID`")
    IPage<Teacher> showAll(IPage<Teacher> iPage);
}
