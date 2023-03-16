package edu.hebust.CourseSystem.controller;


import edu.hebust.CourseSystem.pojo.Course;
import edu.hebust.CourseSystem.pojo.Student;
import edu.hebust.CourseSystem.service.CourseService;
import edu.hebust.CourseSystem.service.StudentService;
import edu.hebust.CourseSystem.service.TeacherService;
import edu.hebust.CourseSystem.util.result.PageResult;
import edu.hebust.CourseSystem.util.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * @Author: Longxiao Zhang
 * @Date: 2023/3/15 8:46
 * @Description 管理员端
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;


    //查询所有课程
    @GetMapping("/showAllCourse")
    public PageResult showAllCourse(@RequestParam(defaultValue = "1") int currentPage) {
        return courseService.showAllCourse(currentPage);
    }

    //删除课程
//    @DeleteMapping("/deleteCourseByID")
    @GetMapping("/deleteCourseByID")
    public R deleteCourseByID(@RequestParam Integer courseID) {
        return courseService.deleteCourseByID(courseID);
    }

    //通过查询课程
    @GetMapping("/getCourseByID")
    public R getCourseByID(@RequestParam Integer courseID) {
        return courseService.getCourseByID(courseID);
    }

    //修改课程
    @PostMapping("/modifyCourse")
    public R modifyCourse(@RequestBody Course course) {
        return courseService.modifyCourse(course);
    }

    //增加课程
    @PostMapping("/addCourse")
    public R addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    //分页显示所有学生
    @GetMapping("/showAllStudents")
    public PageResult showAllStudents(@RequestParam(defaultValue = "1") int currentPage){
        return studentService.showAllStudents(currentPage);
    }

    //删除学生
    @GetMapping("/deleteStudentByID")
    public R deleteStudentByID(@RequestParam Integer studentID){
        return studentService.deleteStuById(studentID);
    }

    //添加学生
    @PostMapping("/addStudent")
    public R addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //查询学生
    @GetMapping("/getStudentByID")
    public R getStuById(@RequestParam Integer stuID){
        return  studentService.getStuById(stuID);
    }

    //更新学生
    @PostMapping("/modifyStudent")
    public R modifyStudent(@RequestBody Student student){
        return studentService.modifyStudent(student);
    }

    //分页显示所有教师信息
    @GetMapping("/showAllTeacher")
    public PageResult showAllTeacher(@RequestParam int currentPage){
        return teacherService.showAllTeacher(currentPage);
    }

}
