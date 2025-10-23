/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author ICT
 */
package com.mycompany.assigment12;
import java.text.Normalizer;
import java.util.Scanner;

public class Assigment12 {
    protected String maNV;
    protected String hoTen;
    protected double luong;

    public Assigment12() {}
    public Assigment12(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNV() { return maNV; }
    public String getHoTen() { return hoTen; }
    public double getLuong() { return luong; }

    public void setMaNV(String maNV) { this.maNV = maNV; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public void setLuong(double luong) { this.luong = luong; }

    // 👉 Hàm đọc số an toàn, tránh lỗi nhập sai
    protected static double readDoubleSafe(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String raw = sc.nextLine();

                String s = Normalizer.normalize(raw, Normalizer.Form.NFKC)
                                      .replaceAll("\\p{M}", "")
                                      .replaceAll("[^0-9,.-]", "");

                if (s.contains(",") && s.contains(".")) {
                    int lastDot = s.lastIndexOf('.');
                    int lastComma = s.lastIndexOf(',');
                    if (lastComma > lastDot) {
                        s = s.replace(".", "");
                        s = s.replace(',', '.');
                    } else s = s.replace(",", "");
                } else if (s.contains(",")) {
                    s = s.replace(',', '.');
                }

                return Double.parseDouble(s);
            } catch (Exception e) {
                System.out.println("❌ Nhập sai định dạng số, vui lòng nhập lại!");
            }
        }
    }

    public double getThuNhap() {
        return luong;
    }

    public double getThueThuNhap() {
        double tn = getThuNhap();
        if (tn < 9000000) return 0;
        else if (tn <= 15000000) return (tn - 9000000) * 0.1;
        else return (tn - 15000000) * 0.12 + 600000;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap ma NV: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        luong = readDoubleSafe(sc, "Nhap luong: ");
    }

    public void xuat() {
        System.out.printf("[HANH CHINH] Ma NV: %-8s | Ho ten: %-20s | Luong: %10.2f | Thu nhap: %10.2f | Thue: %10.2f\n",
                maNV, hoTen, luong, getThuNhap(), getThueThuNhap());
    }
}
