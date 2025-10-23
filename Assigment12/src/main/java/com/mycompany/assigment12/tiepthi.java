package com.mycompany.assigment12;


public class tiepthi extends Assigment12 {
    private double doanhSo;
    private double tyLeHueHong;

    public tiepthi(String ma, String hoTen, double luong, double doanhSo, double tyLeHueHong) {
        super(ma, hoTen, luong);
        this.doanhSo = doanhSo;
        this.tyLeHueHong = tyLeHueHong;
    }

    public double getDoanhSo() { return doanhSo; }
    public void setDoanhSo(double doanhSo) { this.doanhSo = doanhSo; }
    public double getTyLeHueHong() { return tyLeHueHong; }
    public void setTyLeHueHong(double tyLeHueHong) { this.tyLeHueHong = tyLeHueHong; }

    @Override
    public double getThuNhap() {
        return luong + doanhSo * tyLeHueHong;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | DS: %.2f | HH: %.2f%%", doanhSo, tyLeHueHong * 100);
    }
}
