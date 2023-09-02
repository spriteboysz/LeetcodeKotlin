package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Record;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordDAO03Test {
    RecordDAO03 recordDAO = new RecordDAO03();
    @Test
    void insertRecord() {
        Record record = new Record(0, "20220102", "20120101", 2, "2023-9-2");
        assertTrue(recordDAO.insertRecord(record));
    }

    @Test
    void deleteRecord() {
        assertTrue(recordDAO.deleteRecord(15));
    }
}