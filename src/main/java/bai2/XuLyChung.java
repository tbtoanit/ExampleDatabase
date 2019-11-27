package bai2;

import java.sql.SQLException;
import java.util.ArrayList;

public class XuLyChung {
    public static void main(String[] args) {

        ArrayList<Employee> listNhanVien = new ArrayList<>();

        IEmployeeController i = new EmployeeController();
        try{
            listNhanVien = i.nhapThongTin();
        }catch (SQLException e){
            e.printStackTrace();
        }
        i.xuatThongTin(listNhanVien);


    }
}
