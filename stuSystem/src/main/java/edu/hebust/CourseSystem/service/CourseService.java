package edu.hebust.CourseSystem.service;

import edu.hebust.CourseSystem.pojo.Course;
import edu.hebust.CourseSystem.util.result.PageResult;
import edu.hebust.CourseSystem.util.result.R;

public interface CourseService {
    /**
     * 分页查询所有课程信息
     * @param currentPage
     * @return
     */
    PageResult showAllCourse(int currentPage);

    /**
     * 删除课程
     * @param courseID
     * @return
     */
    R deleteCourseByID(Integer courseID);

    /**
     * 查询课程信息
     * @return
     * @param courseID
     */
    R getCourseByID(Integer courseID);

    /**
     * 修改课程
     * @param course
     * @return
     */
    R modifyCourse(Course course);

    /**
     * 增加课程
     * @param course
     * @return
     */
    R addCourse(Course course);
}
