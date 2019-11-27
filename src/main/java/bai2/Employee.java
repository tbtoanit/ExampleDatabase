package bai2;

import java.util.Date;

public class Employee {
    private String hoTen;
    private String email;
    private String soDienThoai;
    private Date ngaySinh;
    private String chucVu;

    public Employee(String hoTen, String email, String soDienThoai, Date ngaySinh, String chucVu){
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "hoTen='" + hoTen + '\'' +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", chucVu='" + chucVu + '\'' +
                '}';
    }
}
