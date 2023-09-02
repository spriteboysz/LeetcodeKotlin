package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-02 14:44
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class BookDAO03 {

    public boolean insertBook(Book book) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "insert into books values(null,?,?,?,?,?,?)";
        try {
            cnt = queryRunner.update(sql, book.getBookNum(), book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookDesc(), book.getBookStock());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public boolean deleteBook(int bid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "delete from books where bid = ?";
        try {
            cnt = queryRunner.update(sql, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public boolean updateBook(int bid, int num) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "update books set book_stock = book_stock - ? where bid = ?";
        try {
            cnt = queryRunner.update(sql, num, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public Book queryBook(int bid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        Book book = null;
        String sql = "select * from books where bid = ?";
        try {
            // book = queryRunner.query(sql, new BeanHandler<>(Book.class), bid);
            book = queryRunner.query(sql, resultSet -> {
                Book book1 = new Book();
                while (resultSet.next()) {
                    book1.setBid(bid);
                    book1.setBookNum(resultSet.getString("book_num"));
                    book1.setBookName(resultSet.getString("book_name"));
                    book1.setBookAuthor(resultSet.getString("book_author"));
                    book1.setBookPrice(resultSet.getFloat("book_price"));
                    book1.setBookDesc(resultSet.getString("book_desc"));
                    book1.setBookStock(resultSet.getInt("book_stock"));
                }
                return book1;
            }, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> queryBook() {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<Book> books2 = new ArrayList<>();
        String sql = "select * from books";
        try {
            books2 = queryRunner.query(sql, resultSet -> {
                List<Book> books = new ArrayList<>();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setBid(resultSet.getInt("bid"));
                    book.setBookNum(resultSet.getString("book_num"));
                    book.setBookName(resultSet.getString("book_name"));
                    book.setBookAuthor(resultSet.getString("book_author"));
                    book.setBookPrice(resultSet.getFloat("book_price"));
                    book.setBookDesc(resultSet.getString("book_desc"));
                    book.setBookStock(resultSet.getInt("book_stock"));
                    books.add(book);
                }
                return books;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books2;
    }
}
