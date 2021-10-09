package com.erha.crmtest.dao;

import com.erha.crmtest.domain.Student;
import com.erha.crmtest.vo.StudentClassroomVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> selectAll();

    Student selectById(@Param("id")String id);

    Integer createStudent(Student student);

    List<Student> selectByNameLike(String like);

    List<Student> selectByLike(Student student);

    List<Student> selectBuIdList(List<Student> list);

    List<StudentClassroomVo> selectClassroomVos();
}
