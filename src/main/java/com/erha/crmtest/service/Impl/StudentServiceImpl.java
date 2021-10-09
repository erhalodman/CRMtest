package com.erha.crmtest.service.Impl;

import com.erha.crmtest.dao.StudentDao;
import com.erha.crmtest.domain.Student;
import com.erha.crmtest.service.StudentService;
import com.erha.crmtest.util.myBatisUtil;
import com.erha.crmtest.vo.StudentClassroomVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameStudentServiceImpl
 * @Description TODO
 * @Author DELL
 * @Date 2021/10/815:52
 * @Version 1.0
 **/
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = myBatisUtil.getSqlSession().getMapper(StudentDao.class);

    @Override
    public Student getById(String id) {
        Student student = studentDao.selectById(id);
        return student;
    }

    @Override
    public void save(Student student) {
        studentDao.createStudent(student);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.selectAll();
    }

    @Override
    public List<Student> getLike(String like) {
        return studentDao.selectByNameLike(like);
    }

    @Override
    public List<Student> Like(Student student) {
        return studentDao.selectByLike(student);
    }

    @Override
    public List<Student> queryByIdList(List<Student> list) {
        return studentDao.selectBuIdList(list);
    }

    @Override
    public List<StudentClassroomVo> queryStudentClassName() {
        return studentDao.selectClassroomVos();
    }

}
