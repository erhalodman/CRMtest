package com.erha.crmtest;

import static org.junit.Assert.assertTrue;

import com.erha.crmtest.dao.StudentDao;
import com.erha.crmtest.domain.Student;
import com.erha.crmtest.service.Impl.StudentServiceImpl;
import com.erha.crmtest.service.StudentService;
import com.erha.crmtest.util.ServiceFactory;
import com.erha.crmtest.util.myBatisUtil;
import com.erha.crmtest.vo.StudentClassroomVo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    StudentService studentService = (StudentService) ServiceFactory.getService(new StudentServiceImpl());

    @Test
    public void test01(){
        SqlSession sqlSession = myBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //PageHelper.startPage(1,2);
        List<Student> students = mapper.selectAll();
        System.out.println(students);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = myBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.selectById("0002");
        System.out.println(student);
    }

    @Test
    public void test03(){
        SqlSession sqlSession = myBatisUtil.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Integer i = mapper.createStudent(new Student("0005", "李四", "12", "lisi@qq.com"));
        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public void test04(){
        StudentService studentService = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        studentService.save(new Student("0006", "张三", "19", "zhangsan@qq.com"));
    }

    @Test
    public void getLike(){
        StudentService studentService = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        List<Student> list = studentService.getLike("三");
        list.forEach(System.out::println);
    }

    @Test
    public void Like(){
        List<Student> like = studentService.Like(new Student(null, "王", null, null));
        Iterator<Student> iterator = like.iterator();
        while(iterator.hasNext()){
            Student next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void selectBuIdList(){
        List<Student> ids = new ArrayList<>();
        ids.add(new Student("0004", null, null, null));
        ids.add(new Student("0002", null, null, null));
        ids.add(new Student("0003", null, null, null));
        ids.add(new Student("0008", null, null, null));
        ids.add(new Student("0099", null, null, null));
        List<Student> students = studentService.queryByIdList(ids);
        students.forEach(System.out::println);
    }

    @Test
    public void selectClassroomVos(){
        List<StudentClassroomVo> studentClassroomVos = studentService.queryStudentClassName();
        studentClassroomVos.forEach(System.out::println);
    }
}
