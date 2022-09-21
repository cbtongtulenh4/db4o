package Nhom4.view;

import Nhom4.entity.GiaoVien;
import Nhom4.entity.HocVien;
import Nhom4.repository.Service;

import java.util.List;
import java.util.Scanner;

public class GiaoVienView {
    public static void view(){
        Scanner cin = new Scanner(System.in);
        Service service = new Service();

        System.out.println("________Tab Giao Vien________");
        System.out.println("1. Append ");
        System.out.println("2. Edit_All_Info");
        System.out.println("3. Edit_Name_By_Id");
        System.out.println("4. Output_List");
        System.out.println("5. Output_By_ID");
        System.out.println("6. Sort By name");
        System.out.println("7. Delete By ID");
        System.out.println("8. Delete All");
        System.out.println("0. Close");
        System.out.println("____________________________");
        System.out.print("Enter_Your_Choice: ");
        int choice;
        boolean checkLoop = true;
        do {
            choice = cin.nextInt();
            switch (choice) {
                case 1: {
                    GiaoVien gv = GiaoVien.input();
                    GiaoVien last = service.getLastObject(GiaoVien.class);
                    gv.setId((last == null) ? 1 : last.getId() + 1);
//                    gv.setId(GiaoVien.getCount() + 1);
                    service.insert(gv);
//                    GiaoVien.incrementCount();
                }
                break;
                case 2: {
                    System.out.print("Enter id Giao Vien need change: ");
                    int id = cin.nextInt();
                    GiaoVien gv = GiaoVien.input();
                    service.updateGiaoVien(id, gv);
                }
                break;
                case 3:{
                    try {
                        System.out.println("Enter id: ");
                        long id = cin.nextLong();
                        System.out.println("Enter name: ");
                        String name = cin.nextLine();
                        service.updateNameGiaoVienById(id, name);
                        System.out.println("Update Success");
                    }catch (Exception ex){
                        System.out.println("Error update");
                    }
                }
                break;
                case 4: {
                    List<GiaoVien> rs = service.getAll(GiaoVien.class);
                    for (GiaoVien gv : rs){
                        System.out.println(gv);
                    }
                }
                break;
                case 5: {
                    System.out.print("Enter id need find: ");
                    int id = cin.nextInt();
                    GiaoVien gv = service.findGiaoVienById(id);
                    if (gv == null) System.out.println("Cant Found");
                    else System.out.println(gv);
                }
                break;
                case 7: {
                    System.out.println("Enter id need remove: ");
                    int id = cin.nextInt();
                    service.deleteGiaoVienById(id);
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
