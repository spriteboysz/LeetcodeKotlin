package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Record;
import javaweb.jdbc.library.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Author: Deean
 * Date: 2023-09-02 21:27
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class RecordDAO03 {
    public boolean insertRecord(Record record) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "insert into records(stu_num, book_num, record_stock,record_date) values(?,?,?,?)";
        int cnt = 0;
        try {
            cnt = queryRunner.update(sql, record.getStuNum(), record.getBookNum(), record.getRecordStock(), record.getRecordDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public boolean deleteRecord(int rid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = "delete from records where rid = ?";
        int cnt = 0;
        try {
            cnt = queryRunner.update(sql, rid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }
}
