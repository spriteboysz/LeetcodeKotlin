package javaweb.jdbc.library.Service;

import javaweb.jdbc.library.DAO.BookDAO03;
import javaweb.jdbc.library.DAO.RecordDAO03;
import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.DTO.Record;
import javaweb.jdbc.library.DTO.Student;

/**
 * Author: Deean
 * Date: 2023-09-02 21:34
 * FileName: src/main/java/javaweb/jdbc/library/Service
 * Description:
 */

public class BorrowBook03 {
    public boolean borrowBook01(Student student, Book book, int num) {
        BookDAO03 bookDAO = new BookDAO03();
        boolean flag1 = bookDAO.updateBook(book.getBid(), num);

        RecordDAO03 recordDAO = new RecordDAO03();
        Record record = new Record(0, student.getStuNum(), book.getBookNum(), num, "2023-9-2");
        boolean flag2 = recordDAO.insertRecord(record);
        return flag1 && flag2;
    }
}
