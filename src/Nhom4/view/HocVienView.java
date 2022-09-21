package Nhom4.view;

import Nhom4.entity.GiaoVien;
import Nhom4.entity.HocVien;
import Nhom4.entity.KhoaHoc;
import Nhom4.repository.Service;

import java.util.List;
import java.util.Scanner;

public class HocVienView {

    public static void view(){
        Scanner cin = new Scanner(System.in);
        Service service = new Service();

        System.out.println("________Tab Hoc Vien________");
        System.out.println("1. Enter Info ");
        System.out.println("2. Edit_All_Info");
        System.out.println("3. Edit_Name_By_Id");
        System.out.println("4. Output_List");
        System.out.println("5. Output_By_ID");
        System.out.println("6. Registration KhoaHoc");
        System.out.println("7. Cancel KhoaHoc");
        System.out.println("8. Sort By name");
        System.out.println("9. Delete By ID");
        System.out.println("10. Delete All");
        System.out.println("0. Close");
        System.out.println("____________________________");
        System.out.print("Enter_Your_Choice: ");
        int choice;
        boolean checkLoop = true;
        do {
            choice = cin.nextInt();
            switch (choice) {
                case 1: {
                    HocVien hv = HocVien.input();
                    HocVien last = service.getLastObject(HocVien.class);
                    hv.setId((last == null) ? 1 : last.getId() + 1);
//                    gv.setId(HocVien.getCount() + 1);
                    service.insert(hv);
//                    HocVien.incrementCount();
                }
                break;
                case 2: {
                    System.out.print("Enter id Hoc Vien need change: ");
                    int id = cin.nextInt();
                    HocVien hv = HocVien.input();
                    service.updateHocVien(id, hv);
                }
                break;
                case 3:{
                    try {
                        System.out.println("Enter id: ");
                        long id = cin.nextLong();
                        System.out.println("Enter name: ");
                        String name = cin.nextLine();
                        service.updateNameHocVienById(id, name);
                        System.out.println("Update Success");
                    }catch (Exception ex){
                        System.out.println("Error update");
                    }
                }
                break;
                case 4: {
                    List<HocVien> rs = service.getAll(HocVien.class);
                    for (HocVien hv : rs){
                        System.out.println(hv);
                    }
                }
                break;
                case 5: {
                    System.out.print("Enter id need find: ");
                    int id = cin.nextInt();
                    HocVien hv = service.findHocVienById(id);
                    if (hv == null) System.out.println("Cant Found");
                    else System.out.println(hv);
                }
                break;
                case 6: {
                    System.out.print("Enter id of KhoaHoc: ");
                    int khoaHocID = cin.nextInt();
                    System.out.print("Enter id of Hoc Vien: ");
                    int hocVienID = cin.nextInt();
                    service.registrationKhoaHoc(khoaHocID, hocVienID);
                }
                break;
                case 7: {
                    System.out.print("Enter id of KhoaHoc: ");
                    int khoaHocID = cin.nextInt();
                    System.out.print("Enter id of Hoc Vien: ");
                    int hocVienID = cin.nextInt();
                    service.cancelKhoaHoc(khoaHocID, hocVienID);
                }
                break;
                case 9: {
                    System.out.println("Enter id need remove: ");
                    int id = cin.nextInt();
                    service.deleteHocVienById(id);
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
