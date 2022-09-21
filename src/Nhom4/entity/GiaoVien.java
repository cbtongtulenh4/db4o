package Nhom4.entity;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GiaoVien{
    private Long id;
    private String ten;
    private String soDt;
    private int tuoi;
    private String cmt;
    private long luong;

    private static long count = 1;

    private Set<KhoaHoc> khoaHocs = new HashSet<>();

    public void removeKhoaHoc(long id){
        KhoaHoc khoaHoc = this.khoaHocs.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (khoaHoc != null){
            khoaHoc.setGiaoVien(null);
            this.khoaHocs.remove(khoaHoc);
        }
    }

    public void addKhoaHoc(final KhoaHoc khoaHoc){
        khoaHoc.setGiaoVien(this);
        this.khoaHocs.add(khoaHoc);
    }

    public GiaoVien(){
    }

    public GiaoVien(String ten, String soDt, int tuoi, String cmt, long luong) {
        this.ten = ten;
        this.soDt = soDt;
        this.tuoi = tuoi;
        this.cmt = cmt;
        this.luong = luong;
    }

    public static GiaoVien input(){
        Scanner cin = new Scanner(System.in);
        GiaoVien gv = new GiaoVien();
        System.out.println("Enter GiaoVien: ");
        System.out.print("\t Ten: "); gv.setTen(cin.nextLine());
        System.out.print("\t soDt: "); gv.setSoDt(cin.nextLine());
        System.out.print("\t tuoi: "); gv.setTuoi(cin.nextInt());
        cin.nextLine();
        System.out.print("\t cmt: "); gv.setCmt(cin.nextLine());
        System.out.print("\t luong: "); gv.setLuong(cin.nextLong());
        return gv;
    }

    public static long getCount() {
        return count;
    }

    public static void incrementCount() {
        count++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLuong() {
        return luong;
    }

    public void setLuong(long luong) {
        this.luong = (luong < 0) ? 0 : luong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public Set<KhoaHoc> getKhoaHocs() {
        return khoaHocs;
    }

    public void setKhoaHocs(Set<KhoaHoc> khoaHocs) {
        this.khoaHocs = khoaHocs;
    }

    @Override
    public String toString() {
        return "GiaoVien{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", soDt='" + soDt + '\'' +
                ", tuoi=" + tuoi +
                ", cmt='" + cmt + '\'' +
                ", luong=" + luong +
                ", khoaHocs=" + khoaHocs +
                '}';
    }
}
