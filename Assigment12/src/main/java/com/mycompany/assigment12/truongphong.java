package com.mycompany.assigment12;


public class truongphong extends Assigment12 {
    private double luongTrachNhiem;

    public truongphong(String ma, String hoTen, double luong, double luongTrachNhiem) {
        super(ma, hoTen, luong);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public double getLuongTrachNhiem() { return luongTrachNhiem; }
    public void setLuongTrachNhiem(double luongTrachNhiem) { this.luongTrachNhiem = luongTrachNhiem; }

    @Override
    public double getThuNhap() {
        return luong + luongTrachNhiem;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Trách nhiệm: %.0f", luongTrachNhiem);
    }
}
