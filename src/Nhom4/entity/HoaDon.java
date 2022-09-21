package Nhom4.entity;

import java.util.HashSet;
import java.util.Set;

public class HoaDon {
    private Long id;
    private long thanhTien;

    private Set<HoaDonDetail> hoaDonDetails = new HashSet<>();

    public HoaDon(){

    }

    public HoaDon(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }
}
