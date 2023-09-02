package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Student;
import javaweb.jdbc.library.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-02 20:05
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class StudentDAO03 {
    public boolean insertStudent(Student student) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "insert into students(stu_num, stu_name, stu_gender, stu_age, stu_class, stu_desc) values (?,?,?,?,?,?)";
        try {
            cnt = queryRunner.update(sql, student.getStuNum(), student.getStuName(), student.getStuGender(), student.getStuAge(), student.getStuClass(), student.getStuDesc());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public boolean deleteStudent(int sid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "delete from students where sid = ?";
        try {
            cnt = queryRunner.update(sql, sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public Student queryStudent(int sid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        Student student1 = null;
        String sql = "select * from students where sid = ?";
        try {
            student1 = queryRunner.query(sql, resultSet -> {
                Student student = new Student();
                if (resultSet.next()) {
                    student.setsId(sid);
                    student.setStuNum(resultSet.getString("stu_num"));
                    student.setStuName(resultSet.getString("stu_name"));
                    student.setStuGender(resultSet.getString("stu_gender"));
                    student.setStuAge(resultSet.getInt("stu_age"));
                    student.setStuClass(resultSet.getInt("stu_class"));
                    student.setStuDesc(resultSet.getString("stu_desc"));
                }
                return student;
            }, sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student1;
    }

    public List<Student> queryStudent() {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<Student> students = new ArrayList<>();
        String sql = "select * from students";
        try {
            students = queryRunner.query(sql, new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        System.out.println(new StudentDAO03().queryStudent(1));
        List<Student> students = new StudentDAO03().queryStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
