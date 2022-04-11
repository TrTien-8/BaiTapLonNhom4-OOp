/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaplonoop;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choose;
        
        do {
            showMenu();
            choose = scan.nextInt();
            
            switch(choose) {
                case 1:
                    input();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    searchByCMTND();
                    break;
                case 4:
                    setHeathStatus();
                    break;
                case 5:
                    setupPath();
                    break;
                case 6:
                    setupFollowStatus();
                    break;
                case 7:
                    showCitizenActive();
                    break;
                case 8:
                    showCitizenFollow();
                    break;
                case 9:
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Input failed!");
                    break;
            }
        } while(choose != 9);
    }
    
    static void showMenu() {
        System.out.println("1. Lập danh sách tất cả công dân tại Việt Nam");
        System.out.println("2. Tìm kiếm thông tin bệnh nhân theo tên");
        System.out.println("3. Tìm kiếm bệnh nhân theo CMTND");
        System.out.println("4. Thiết lập tình trạng sức khoẻ");
        System.out.println("5. Thiết lập lộ trình di chuyển của 1 bệnh nhân.");
        System.out.println("6. Thiết lập trạng thái bệnh nhân đã tiếp xúc vs một bệnh nhân dương tính COVID-19");
        System.out.println("7. Hiển thị danh sách bệnh nhân dương tính COVID-19");
        System.out.println("8. Hiển thị danh sách bệnh nhân đang theo dõi");
        System.out.println("9. Thoát");
        System.out.println("Choose: ");
    }

    private static void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter N: ");
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            Citizen citizen = new Citizen();
            citizen.input();
            
            if(citizen.getStatus() == Citizen.STATUS.ACTIVE) {
                
            }
            
//            DataMgr dataMgr = DataMgr.getInstance();
//            List<Citizen> citizens = dataMgr.getCitizens();
//            citizens.add(citizen);
            
            DataMgr.getInstance().getCitizens().add(citizen);
        }
    }

    private static void searchByName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name to search: ");
        String name = scan.nextLine();
        
        for (Citizen citizen : DataMgr.getInstance().getCitizens()) {
            if(citizen.getName().equalsIgnoreCase(name)) {
                citizen.display();
            }
        }
    }

    private static void searchByCMTND() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter CMTND to search: ");
        String cmtnd = scan.nextLine();
        
        for (Citizen citizen : DataMgr.getInstance().getCitizens()) {
            if(citizen.getCmtnd().equalsIgnoreCase(cmtnd)) {
                citizen.display();
                break;
            }
        }
    }

    private static void setHeathStatus() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter CMTND to search: ");
        String cmtnd = scan.nextLine();
        
        for (Citizen citizen : DataMgr.getInstance().getCitizens()) {
            if(citizen.getCmtnd().equalsIgnoreCase(cmtnd)) {
                citizen.inputStatus();
                break;
            }
        }
    }

    private static void setupPath() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter CMTND to search: ");
        String cmtnd = scan.nextLine();
        
        for (Citizen citizen : DataMgr.getInstance().getCitizens()) {
            if(citizen.getCmtnd().equalsIgnoreCase(cmtnd)) {
                if(citizen.getStatus() != Citizen.STATUS.NORMAL) {
                    citizen.inputPath();
                }
                
                break;
            }
        }
    }

    private static void setupFollowStatus() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter CMTND to search: ");
        String cmtnd = scan.nextLine();
        
        Citizen citizenFind = null;
        for (Citizen citizen : DataMgr.getInstance().getCitizens()) {
            if(citizen.getCmtnd().equalsIgnoreCase(cmtnd)) {
                if(citizen.getStatus() != Citizen.STATUS.NORMAL) {
                    citizenFind = citizen;
                }
                
                break;
            }
        }
        
        if(citizenFind != null) {
            for (Citizen citizen : DataMgr.getInstance().getCitizens()) {
                if(citizen.getStatus() == Citizen.STATUS.NORMAL) {
                    if(citizenFind.getPath().contains(citizen.getTmpAddress())) {
                        citizen.setStatus(Citizen.STATUS.FOLLOW);
                    }
                }
            }
        }
    }

    private static void showCitizenActive() {
        for (Citizen citizen : DataMgr.getInstance().getCitizens()) {
            if(citizen.getStatus() == Citizen.STATUS.ACTIVE) {
                citizen.display();
            }
        }
    }

    private static void showCitizenFollow() {
        for (Citizen citizen : DataMgr.getInstance().getCitizens()) {
            if(citizen.getStatus() == Citizen.STATUS.FOLLOW) {
                citizen.display();
            }
        }
    }
}
