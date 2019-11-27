package bai2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEmployeeController {
    ArrayList<Employee> nhapThongTin() throws SQLException;
    void xuatThongTin(ArrayList<Employee> listNhanVien);
}
