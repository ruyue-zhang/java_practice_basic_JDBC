package com.thoughtworks;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

  public void save(List<Student> students) {
    students.forEach(this::save);
  }

  public void save(Student student) {
    // TODO:
    Connection conn = DbUtil.getConnection();
    String sql = "INSERT INTO student (id,name,gender,admission_year,birthday,class_id) values(?,?,?,?,?,?)";
    try {
      PreparedStatement ptmt = conn.prepareStatement(sql);
      ptmt.setString(1, student.getId());
      ptmt.setString(2, student.getName());
      ptmt.setString(3, student.getGender());
      ptmt.setInt(4, student.getAdmissionYear());
      ptmt.setDate(5, new Date(student.getBirthday().getTime()));
      ptmt.setString(6, student.getClassId());
      ptmt.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<Student> query() {
    // TODO:
    return new ArrayList<>();
  }

  public List<Student> queryByClassId(String classId) {
    // TODO:
    return new ArrayList<>();
  }

  public void update(String id, Student student) {
    // TODO:
  }

  public void delete(String id) {
    // TODO:
  }
}
