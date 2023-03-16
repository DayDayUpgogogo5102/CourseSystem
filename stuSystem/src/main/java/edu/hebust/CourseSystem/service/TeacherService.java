package edu.hebust.CourseSystem.service;


import edu.hebust.CourseSystem.util.result.PageResult;

public interface TeacherService {
    /**
     * 分页显示所有教师信息
     * @param currentPage
     * @return
     */
    PageResult showAllTeacher(int currentPage);
}
