package Nhom4.entity;

public class HoaDonDetail {
    private Long id;
    private String nameSp;
    private int soLuong;
    private long donGia;

    private HocVien hocVien;
    private KhoaHoc khoaHocs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSp() {
        return nameSp;
    }

    public void setNameSp(String nameSp) {
        this.nameSp = nameSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public KhoaHoc getKhoaHocs() {
        return khoaHocs;
    }

    public void setKhoaHocs(KhoaHoc khoaHocs) {
        this.khoaHocs = khoaHocs;
    }

    @Override
    public String toString() {
        return "HoaDonDetail{" +
                "id=" + id +
                ", nameSp='" + nameSp + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}
