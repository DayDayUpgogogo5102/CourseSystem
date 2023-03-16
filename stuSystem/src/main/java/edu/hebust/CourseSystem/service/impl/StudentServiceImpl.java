package edu.hebust.CourseSystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.hebust.CourseSystem.dao.StudentMapper;
import edu.hebust.CourseSystem.pojo.Student;
import edu.hebust.CourseSystem.service.StudentService;
import edu.hebust.CourseSystem.util.result.PageResult;
import edu.hebust.CourseSystem.util.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("all")
public class StudentServiceImpl implements StudentService {
    private final int PAGE_SIZE = 5;
    private R res = new R(false, "添加失败", null);


    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询所有学生
     *
     * @param currentPage
     * @return
     */
    @Override
    public PageResult showAllStudents(int currentPage) {
        PageResult result = new PageResult(false, "查询失败！", null, 0, 0);
        IPage<Student> iPage = new Page<>(currentPage, PAGE_SIZE);
        if (currentPage > 0) {
            IPage<Student> pageList = studentMapper.showAllStu(iPage);
            if (pageList != null) {
                List<Student> list = pageList.getRecords();
                result.setStatus(true);
                if (list != null) {
                    result.setInfo("查询成功！");
                    result.setData(list);
                    result.setCount(list.size());
                    result.setTotalRecordNum(pageList.getTotal());
                } else {
                    result.setInfo("没有学生信息！");
                }
            }
        }
        return result;
    }

    /**
     * 删除学生
     *
     * @param studentID
     * @return
     */
    @Override
    public R deleteStuById(Integer studentID) {
        R res = new R(false, "删除失败！", null);
        if (studentID != null) {
            int flag = studentMapper.deleteById(studentID);
            if (flag > 0) {
                res.setStatus(true);
                res.setInfo("删除成功！");
            }
        }
        return res;
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @Override
    public R addStudent(Student student) {
        if (student != null) {
            int flag = studentMapper.insert(student);
            if (flag > 0) {
                res.setStatus(true);
                res.setInfo("添加成功！");
            }
        }
        return res;
    }

    /**
     * 查询学生
     *
     * @param stuID
     * @return
     */
    @Override
    public R getStuById(Integer stuID) {
        if (stuID != null) {
            Student student = studentMapper.selectByIdCustom(stuID);
            res.setData(student);
            res.setStatus(true);
            res.setInfo("查询成功！");
        }
        return res;
    }


    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public R modifyStudent(Student student) {
        if(student != null ){
            int flag = studentMapper.updateById(student);
            if(flag>0){
                res.setStatus(true);
                res.setInfo("修改成功！");
            }
        }
        return res;
    }




}
