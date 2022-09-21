package Nhom4.view;

import Nhom4.entity.GiaoVien;
import Nhom4.entity.HocVien;
import Nhom4.entity.KhoaHoc;
import Nhom4.repository.Service;

import java.util.List;
import java.util.Scanner;

public class KhoaHocView {
    public static void view(){
        Scanner cin = new Scanner(System.in);
        Service service = new Service();

        System.out.println("________Tab Khoa Hoc________");
        System.out.println("1. Insert ");
        System.out.println("2. Edit_All_Info");
        System.out.println("3. Edit_Name_By_Id");
        System.out.println("4. Output_List");
        System.out.println("5. Output_By_ID");
        System.out.println("6. Edit GiaoVien");
        System.out.println("7. Sort By gia");
        System.out.println("8. Delete By ID");
        System.out.println("9. Delete All");
        System.out.println("10. Insert Hoc Vien");
        System.out.println("0. Close");
        System.out.println("____________________________");
        System.out.print("Enter_Your_Choice: ");
        int choice;
        boolean checkLoop = true;
        do {
            choice = cin.nextInt();
            switch (choice) {
                case 1: {
                    KhoaHoc kh = KhoaHoc.input();
                    KhoaHoc last = service.getLastObject(KhoaHoc.class);
                    kh.setId((last == null) ? 1 : last.getId() + 1);
                    System.out.print("Enter id Giao Vien: ");
                    int id = cin.nextInt();
//                    kh.setId(KhoaHoc.getCount() + 1);
                    kh.setGiaoVien(service.findGiaoVienById(id));
                    service.insert(kh);
//                    KhoaHoc.incrementCount();
                }
                break;
                case 2: {
                    System.out.print("Enter id Khoa Hoc need change: ");
                    int id = cin.nextInt();
                    KhoaHoc kh = KhoaHoc.input();
                    service.updateKhoaHoc(id, kh);
                }
                break;
                case 3:{
                    try {
                        System.out.println("Enter id: ");
                        long id = cin.nextLong();
                        System.out.println("Enter name: ");
                        String name = cin.nextLine();
                        service.updateNameKhoaHocById(id, name);
                        System.out.println("Update Success");
                    }catch (Exception ex){
                        System.out.println("Error update");
                    }
                }
                break;
                case 4: {
                    List<KhoaHoc> rs = service.getAll(KhoaHoc.class);
                    for (KhoaHoc kh : rs){
                        System.out.println(kh);
                    }
                }
                break;
                case 5: {
                    System.out.print("Enter id need find: ");
                    int id = cin.nextInt();
                    KhoaHoc kh = service.findKhoaHocById(id);
                    if (kh == null) System.out.println("Cant Found");
                    else System.out.println(kh);
                }
                break;
                case 6: {
                    System.out.print("Enter id of KhoaHoc: ");
                    int khoaHocID = cin.nextInt();
                    System.out.print("Enter id of new Giao Vien: ");
                    int giaoVienID = cin.nextInt();
                    service.updateGiaoVienOfKhoaHocById(khoaHocID, giaoVienID);
                }
                break;
                case 8: {
                    System.out.println("Enter id need remove: ");
                    int id = cin.nextInt();
                    service.deleteKhoaHocById(id);
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
