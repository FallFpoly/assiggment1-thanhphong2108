/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
package com.mycompany.assigment12;
import java.util.*;

public class MainAssigment2 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Assigment12> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= MENU QUAN LY NHAN VIEN =========");
            System.out.println("1. Nhap danh sach nhan vien");
            System.out.println("2. Xuat danh sach nhan vien");
            System.out.println("3. Tim nhan vien theo ma");
            System.out.println("4. Xoa nhan vien theo ma");
            System.out.println("5. Cap nhat thong tin nhan vien");
            System.out.println("6. Tim nhan vien theo khoang luong");
            System.out.println("7. Sap xep theo ho ten");
            System.out.println("8. Sap xep theo thu nhap");
            System.out.println("9. Xuat 5 nhan vien co thu nhap cao nhat");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("❌ Vui long nhap so tu 0 den 9!");
                continue;
            }

            switch (chon) {
                case 1 -> nhapDanhSach();
                case 2 -> xuatDanhSach();
                case 3 -> timTheoMa();
                case 4 -> xoaTheoMa();
                case 5 -> capNhatTheoMa();
                case 6 -> timTheoKhoangLuong();
                case 7 -> sapXepTheoHoTen();
                case 8 -> sapXepTheoThuNhap();
                case 9 -> xuat5NVThuNhapCaoNhat();
                case 0 -> {
                    System.out.println("👋 Ket thuc chuong trinh.");
                    return;
                }
                default -> System.out.println("❌ Lua chon khong hop le!");
            }
        }
    }

    static void nhapDanhSach() {
        while (true) {
            System.out.print("Chon loai nhan vien (1-Hanh chinh, 2-Tiep thi, 3-Truong phong, 0-Thoat): ");
            int loai = Integer.parseInt(sc.nextLine());
            if (loai == 0) break;

            Assigment12 nv;
            switch (loai) {
                case 1 -> nv = new Assigment12();
                case 2 -> nv = new TiepThi();
                case 3 -> nv = new TruongPhong();
                default -> {
                    System.out.println("❌ Loai khong hop le!");
                    continue;
                }
            }
            nv.nhap(sc);
            list.add(nv);
            System.out.println("✅ Da them: " + nv.getMaNV());
        }
    }

    static void xuatDanhSach() {
        System.out.println("\n--- DANH SACH NHAN VIEN ---");
        for (Assigment12 nv : list) nv.xuat();
    }

    static void timTheoMa() {
        System.out.print("Nhap ma nhan vien can tim: ");
        String ma = sc.nextLine();
        for (Assigment12 nv : list)
            if (nv.getMaNV().equalsIgnoreCase(ma)) { nv.xuat(); return; }
        System.out.println("❌ Khong tim thay nhan vien!");
    }

    static void xoaTheoMa() {
        System.out.print("Nhap ma nhan vien can xoa: ");
        String ma = sc.nextLine();
        Iterator<Assigment12> it = list.iterator();
        while (it.hasNext()) {
            Assigment12 nv = it.next();
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                it.remove();
                System.out.println("✅ Da xoa thanh cong!");
                return;
            }
        }
        System.out.println("❌ Khong tim thay nhan vien!");
    }

    static void capNhatTheoMa() {
        System.out.print("Nhap ma nhan vien can cap nhat: ");
        String ma = sc.nextLine();
        for (Assigment12 nv : list)
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                System.out.println("Nhap thong tin moi:");
                nv.nhap(sc);
                System.out.println("✅ Da cap nhat!");
                return;
            }
        System.out.println("❌ Khong tim thay nhan vien!");
    }

    static void timTheoKhoangLuong() {
        double min = Assigment12.readDoubleSafe(sc, "Nhap luong thap nhat: ");
        double max = Assigment12.readDoubleSafe(sc, "Nhap luong cao nhat: ");
        for (Assigment12 nv : list)
            if (nv.getLuong() >= min && nv.getLuong() <= max) nv.xuat();
    }

    static void sapXepTheoHoTen() {
        list.sort(Comparator.comparing(Assigment12::getHoTen));
        System.out.println("✅ Da sap xep theo ho ten.");
    }

    static void sapXepTheoThuNhap() {
        list.sort(Comparator.comparing(Assigment12::getThuNhap).reversed());
        System.out.println("✅ Da sap xep theo thu nhap.");
    }

    static void xuat5NVThuNhapCaoNhat() {
        list.sort(Comparator.comparing(Assigment12::getThuNhap).reversed());
        System.out.println("--- 5 NHAN VIEN CO THU NHAP CAO NHAT ---");
        for (int i = 0; i < Math.min(5, list.size()); i++)
            list.get(i).xuat();
    }
}
