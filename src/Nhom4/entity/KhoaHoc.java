package Nhom4.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class KhoaHoc {
    private Long id;
    private String ten;
    private int soTiet;
    private long gia;
    private String startDay;
    private String endDay;
    private GiaoVien giaoVien;
    private Set<HocVien> hocViens = new HashSet<>();

    private static long count = 1;

    public static KhoaHoc input(){
        Scanner cin = new Scanner(System.in);
        KhoaHoc kh = new KhoaHoc();
        System.out.println("Info New Khoa Hoc:");
        System.out.print("\t- Ten: ");
        kh.ten = cin.nextLine();
        System.out.print("\t -Gia: ");
        kh.setGia(cin.nextLong());
        System.out.print("\t -So Tiet: ");
        kh.setSoTiet(cin.nextInt());
        System.out.print("\t -Start day: ");
        kh.setStartDay(cin.nextLine());
        System.out.print("\t -End day: ");
        kh.setEndDay(cin.nextLine());
        return kh;
    }

    public KhoaHoc(){
    }

    public KhoaHoc(Long id, String ten, int soTiet, long gia, String startDay, String endDay) {
        this.id = id;
        this.ten = ten;
        this.soTiet = soTiet;
        this.gia = gia;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public static long getCount() {
        return count;
    }

    public static void incrementCount() {
        count++;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = (gia < 0) ? 0 : gia;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public Set<HocVien> getHocViens() {
        return hocViens;
    }

    public void setHocViens(Set<HocVien> hocViens) {
        this.hocViens = hocViens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhoaHoc khoaHoc = (KhoaHoc) o;
        return Float.compare(khoaHoc.gia, gia) == 0 && Objects.equals(id, khoaHoc.id) && Objects.equals(ten, khoaHoc.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, gia);
    }

    @Override
    public String toString() {
        return "KhoaHoc{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", soTiet=" + soTiet +
                ", gia=" + gia +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", giaoVien=" + giaoVien +
                ", hocViens=" + hocViens +
                '}';
    }
}
