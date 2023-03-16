package edu.hebust.CourseSystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.hebust.CourseSystem.dao.TeacherMapper;
import edu.hebust.CourseSystem.pojo.Teacher;
import edu.hebust.CourseSystem.service.TeacherService;
import edu.hebust.CourseSystem.util.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("all")
public class TeacherServiceImpl implements TeacherService {
    private final int PAGE_SIZE = 5;

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 分页显示所有教师信息
     * @param currentPage
     * @return
     */
    @Override
    public PageResult showAllTeacher(int currentPage) {
        PageResult res = new PageResult(false,"查询失败",null,0,0);
        if(currentPage>=0){
            IPage<Teacher> iPage = new Page<>(currentPage,PAGE_SIZE);
            IPage<Teacher> pageResult = teacherMapper.showAll(iPage);
            if(pageResult != null) {
                List<Teacher> list = pageResult.getRecords();
                if(list != null){
                    res.setStatus(true);
                    res.setInfo("查询成功！");
                    res.setData(list);
                    res.setTotalRecordNum(pageResult.getTotal());
                    res.setCount(list.size());
                }else{
                    res.setStatus(true);
                    res.setInfo("没有教师信息！");
                }

            }
        }
        return res;
    }
}
