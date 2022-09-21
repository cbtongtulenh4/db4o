package Nhom4.entity;

import java.util.Objects;

public abstract class Nguoi {
    private String ten;
    private String soDt;
    private int tuoi;
    private String cmt;

    public Nguoi(){

    }

    public Nguoi(String ten, String soDt, int tuoi, String cmt) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nguoi nguoi = (Nguoi) o;
        return Objects.equals(ten, nguoi.ten) && Objects.equals(soDt, nguoi.soDt) && Objects.equals(tuoi, nguoi.tuoi) && Objects.equals(cmt, nguoi.cmt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ten, soDt, tuoi, cmt);
    }

    @Override
    public String toString() {
        return "ten='" + ten + '\'' +
                ", soDt='" + soDt + '\'' +
                ", tuoi='" + tuoi + '\'' +
                ", cmt='" + cmt + '\'';
    }
}
