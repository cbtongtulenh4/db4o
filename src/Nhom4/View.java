package Nhom4;

import Nhom4.entity.GiaoVien;
import Nhom4.entity.HocVien;
import Nhom4.entity.KhoaHoc;
import Nhom4.repository.Service;
import Nhom4.view.GiaoVienView;
import Nhom4.view.HocVienView;
import Nhom4.view.KhoaHocView;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        Service service = new Service();

        System.out.println("________DangKyKhoaHocOnline________");
        System.out.println("1. Tab Giao Vien ");
        System.out.println("2. Tab Hoc Vien");
        System.out.println("3. Tab Khoa Hoc");
        System.out.println("4. Get Sum of KhoaHoc");
        System.out.println("5. Get Sum of GiaoVien");
        System.out.println("6. Get Sum of HocVien");
        System.out.println("7. Get List Khoa Hoc not Started yet");
        System.out.println("8. Get List Khoa Hoc Started");
        System.out.println("0. Close");
        System.out.println("____________________________");
        System.out.print("Enter_Your_Choice: ");
        int choice;
        boolean checkLoop = true;
        do {
            choice = cin.nextInt();
            switch (choice) {
                case 1: {
                    GiaoVienView.view();
                }
                break;
                case 2: {
                    HocVienView.view();
                }
                case 3: {
                    KhoaHocView.view();
                }
                break;
                case 4: {
                    System.out.println("Sum of KhoaHoc: " + service.countSumOfObject(KhoaHoc.class));
                }
                break;
                case 5: {
                    System.out.println("Sum of GiaoVien: " + service.countSumOfObject(GiaoVien.class));
                }
                break;
                case 6: {
                    System.out.println("Sum of HocVien: " + service.countSumOfObject(HocVien.class));
                }
                break;
                case 7: {
                    List<KhoaHoc> khoaHocs = service.findAllKhoaHocNotStart();
                    System.out.println("List Khoa Hoc not Started yet: ");
                    for(KhoaHoc kh : khoaHocs){
                        System.out.println(kh);
                    }
                }
                break;
                default:
                    checkLoop = false;
                    break;
            }
            if (checkLoop) {
                System.out.print("New_Edit_Choice: ");
            }
        } while (checkLoop);
    }

}