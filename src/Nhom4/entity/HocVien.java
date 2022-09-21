package Nhom4.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class HocVien{
    private Long id;
    private String ten;
    private String soDt;
    private int tuoi;
    private String cmt;

    private static long count = 1;
    
    private Set<KhoaHoc> khoaHocs = new HashSet<>();

    public void removeKhoaHoc(long id){
        KhoaHoc khoaHoc = this.khoaHocs.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (khoaHoc != null){
            khoaHoc.getHocViens().remove(this);
            this.khoaHocs.remove(khoaHoc);
        }
    }

    public void addKhoaHoc(KhoaHoc khoaHoc){
        khoaHoc.getHocViens().add(this);
        this.khoaHocs.add(khoaHoc);
    }

    public HocVien() {
    }

    public HocVien(String ten, String soDt, int tuoi, String cmt) {
        this.ten = ten;
        this.soDt = soDt;
        this.tuoi = tuoi;
        this.cmt = cmt;
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

    public static void setCount(long count) {
        HocVien.count = count;
    }

    public static HocVien input(){
        Scanner cin = new Scanner(System.in);
        HocVien hv = new HocVien();
        System.out.println("Enter HocVien: ");
        System.out.print("\t Ten:"); hv.setTen(cin.nextLine());
        System.out.print("\t soDt:"); hv.setSoDt(cin.nextLine());
        System.out.print("\t tuoi:"); hv.setTuoi(cin.nextInt());
        System.out.print("\t cmt:"); hv.setCmt(cin.nextLine());
        return hv;
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

    public Set<KhoaHoc> getKhoaHocs() {
        return khoaHocs;
    }

    public void setKhoaHocs(Set<KhoaHoc> khoaHocs) {
        this.khoaHocs = khoaHocs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HocVien hocVien = (HocVien) o;
        return Objects.equals(id, hocVien.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HocVien{" +
                "id=" + id +
                super.toString() +
                ", khoaHocs=" + khoaHocs +
                '}';
    }
}
