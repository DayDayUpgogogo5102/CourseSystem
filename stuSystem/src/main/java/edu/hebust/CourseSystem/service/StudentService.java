package edu.hebust.CourseSystem.service;


import edu.hebust.CourseSystem.pojo.Student;
import edu.hebust.CourseSystem.util.result.PageResult;
import edu.hebust.CourseSystem.util.result.R;

public interface StudentService {
    /**
     * 分页查询所有学生
     * @param currentPage
     * @return
     */
    PageResult showAllStudents(int currentPage);

    /**
     * 删除学生
     * @param studentID
     * @return
     */
    R deleteStuById(Integer studentID);

    /**
     * 添加学生
     * @param student
     * @return
     */
    R addStudent(Student student);

    /**
     * 查询学生
     * @param stuID
     * @return
     */
    R getStuById(Integer stuID);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    R modifyStudent(Student student);
}
