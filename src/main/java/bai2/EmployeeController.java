package bai2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeController implements IEmployeeController {

    ArrayList<Employee> listNhanVien = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public ArrayList<Employee> nhapThongTin() throws SQLException {
        String hoTen;
        String email;
        String soDienThoai;
        Date ngaySinh;
        String chucVu;
        System.out.println("Vui long nhap ten nhan vien: ");
        hoTen = sc.nextLine();

        while (true){
            Pattern p = Pattern.compile("^[a-zA-Z0-9]+([.]?[a-zA-Z0-9]+)+@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+$");
            while (true){
                System.out.println("Vui long nhap email nhan vien: ");
                email = sc.nextLine();
                Matcher m = p.matcher(email);
                boolean b = m.matches();
                if(b == true){
                    break;
                }else {
                    System.out.println("Vui long nhap email nhan vien dung dinh dang: ");
                }
            }

            Pattern p1 = Pattern.compile("^0[0-9]{9}$");
            while (true){
                System.out.println("Vui long nhap so dien thoai nhan vien: ");
                soDienThoai = sc.nextLine();
                Matcher m = p1.matcher(soDienThoai);
                boolean b = m.matches();
                if(b == true){
                    break;
                }else {
                    System.out.println("Vui long nhap so dien thoai nhan vien dung dinh dang: ");
                }
            }
            Pattern p2 = Pattern.compile("[0-9]{4}[-][0-9]{2}[-][0-9]{2}$");
            while (true){
                System.out.println("Vui long nhap ngay sinh nhan vien theo dinh dang yyyy-MM-dd: ");
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String d1 = sc.nextLine();
                    Matcher m = p2.matcher(d1);
                    boolean b = m.matches();
                    if (b == true){
                        Date d = sdf.parse(d1);
                        ngaySinh = d ;
                        break;
                    }else {
                        System.out.println("Vui long nhap ngay sinh nhan vien dung dinh dang: ");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            System.out.println("Vui long nhap chuc vu nhan vien: ");
            chucVu = sc.nextLine();

            Employee e = new Employee(hoTen, email, soDienThoai, ngaySinh, chucVu);
            listNhanVien.add(e);

            System.out.println("Vui long nhap 1 e tiep tuc, nhap 0 de ket thuc");
            int n = sc.nextInt();
            sc.nextLine();
            if(n == 1){
                continue;
            }else {
                break;
            }
        }
        for(int i= 0; i<listNhanVien.size(); i++){
            // Lấy ra đối tượng Connection kết nối vào DB.
            Connection connection = ConnectionUtils.getOracleConnection();
            // Tạo đối tượng Statement.
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO NEW_EMPLOYEE VALUES("+"'"+listNhanVien.get(i).getHoTen()+"'"+","
                    +"'"+listNhanVien.get(i).getEmail() +"'"+ ","
                    +"'"+listNhanVien.get(i).getSoDienThoai() +"'"+ ","
                    +"'"+listNhanVien.get(i).getNgaySinh().toString() +"'"+ ","
                    +"'"+listNhanVien.get(i).getChucVu()+"'"+")";
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
            ResultSet rs = statement.executeQuery(sql);
        }
        return listNhanVien;
    }

    public void xuatThongTin(ArrayList<Employee> listNhanVien){
        for (Employee e: listNhanVien) {
            System.out.println(e.toString());
        }
    }

}
