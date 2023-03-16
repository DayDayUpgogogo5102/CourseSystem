package edu.hebust.CourseSystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.hebust.CourseSystem.dao.CourseMapper;
import edu.hebust.CourseSystem.pojo.Course;
import edu.hebust.CourseSystem.pojo.CourseCustom;
import edu.hebust.CourseSystem.service.CourseService;
import edu.hebust.CourseSystem.util.result.PageResult;
import edu.hebust.CourseSystem.util.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("all")
public class CourseServiceImpl implements CourseService {

    private final int PAGE_SIZE = 10;
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 分页查询所有课程信息
     *
     * @param currentPage
     * @return
     */
    @Override
    public PageResult showAllCourse(int currentPage) {
        PageResult pageResult = new PageResult(false, "查询失败", null, 0, 0);
        IPage<Course> iPage = new Page<>(currentPage, PAGE_SIZE);
        pageResult.setStatus(true);
        pageResult.setInfo("查询成功");
        IPage<CourseCustom> list = courseMapper.selectListCustom(iPage);
        if (list != null) {
            List<CourseCustom> records = list.getRecords();
            pageResult.setTotalRecordNum(list.getTotal());
            pageResult.setData(records);
            pageResult.setCount(records.size());
        } else {
            pageResult.setInfo("暂未添加课程！");
        }

        return pageResult;
    }

    /**
     * 删除课程
     *
     * @param courseID
     * @return
     */
    @Override
    public R deleteCourseByID(Integer courseID) {
        R r = new R(false, "删除失败！", null);
        if (courseID != null) {
            int flag = courseMapper.deleteById(courseID);
            if (flag > 0) {
                r.setStatus(true);
                r.setInfo("删除成功！");
            }
        }
        return r;
    }

    /**
     * 查询课程信息
     *
     * @param courseID
     * @return
     */
    @Override
    public R getCourseByID(Integer courseID) {
        R r = new R(false, "未找到课程！", null);
        if (courseID != null) {
            Course course = courseMapper.selectById(courseID);
            if (course != null) {
                r.setStatus(true);
                r.setInfo("查询成功！");
                r.setData(course);
            }
        }
        return r;
    }

    /**
     * 修改课程
     *
     * @param course
     * @return
     */
    @Override
    public R modifyCourse(Course course) {
        R result = new R(false,"修改失败！",null);
        if (course != null) {
            int flag = courseMapper.updateById(course);
            if(flag>0){
                result.setStatus(true);
                result.setInfo("修改成功！");
            }
        }
        return result;
    }

    /**
     * 增加课程
     * @param course
     * @return
     */
    @Override
    public R addCourse(Course course) {
        R result = new R(false,"添加失败！",null);
        if(course!=null){
            int flag = courseMapper.insert(course);
            if(flag>0){
                result.setStatus(true);
                result.setInfo("添加成功！");
            }
        }
        return result;
    }
}
