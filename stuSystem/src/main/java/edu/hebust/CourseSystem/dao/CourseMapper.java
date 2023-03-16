package edu.hebust.CourseSystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.hebust.CourseSystem.pojo.Course;
import edu.hebust.CourseSystem.pojo.CourseCustom;
import org.apache.ibatis.annotations.Select;

/**
 *  Mapper 接口
 *
 * @author zlxiao
 * @since 2023-03-14
 */
public interface CourseMapper extends BaseMapper<Course> {

    @Select("SELECT course.*,collegeName FROM course,college where course.collegeID = college.collegeID " +
            "order by course.courseID")
    IPage<CourseCustom> selectListCustom(IPage<Course> currentPage);
}
