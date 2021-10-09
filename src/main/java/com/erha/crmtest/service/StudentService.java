package com.erha.crmtest.service;

import com.erha.crmtest.domain.Student;
import com.erha.crmtest.vo.StudentClassroomVo;

import java.util.List;

/**
 * @ClassNameStudentService
 * @Description TODO
 * @Author DELL
 * @Date 2021/10/815:50
 * @Version 1.0
 **/
public interface StudentService {
    Student getById(String id);

    void save(Student student);

    List<Student> getAll();

    List<Student> getLike(String like);

    List<Student> Like(Student student);

    List<Student> queryByIdList(List<Student> list);

    List<StudentClassroomVo> queryStudentClassName();
}
