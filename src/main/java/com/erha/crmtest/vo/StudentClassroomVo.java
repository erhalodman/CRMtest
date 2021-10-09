package com.erha.crmtest.vo;

/**
 * @ClassNameStudentClassroomVo
 * @Description TODO
 * @Author DELL
 * @Date 2021/10/913:53
 * @Version 1.0
 **/
public class StudentClassroomVo {
    private String id;
    private String name;
    private String age;
    private String email;
    private String className;

    public StudentClassroomVo(String id, String name, String age, String email, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.className = className;
    }

    public StudentClassroomVo() {
    }

    @Override
    public String toString() {
        return "StudentClassroomVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
