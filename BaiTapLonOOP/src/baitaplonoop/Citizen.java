/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaplonoop;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class Citizen {
    enum STATUS {
        NORMAL, FOLLOW, ACTIVE
    };
    
    String name, cmtnd, gender, address, tmpAddress;
    int age;
    STATUS status;

    List<String> path;
    
    public Citizen() {
        status = STATUS.NORMAL;
        path = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmtnd() {
        return cmtnd;
    }

    public void setCmtnd(String cmtnd) {
        this.cmtnd = cmtnd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTmpAddress() {
        return tmpAddress;
    }

    public void setTmpAddress(String tmpAddress) {
        this.tmpAddress = tmpAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = scan.nextLine();
        
        System.out.println("Enter CMTND: ");
        cmtnd = scan.nextLine();
        
        System.out.println("Enter gender: ");
        gender = scan.nextLine();
        
        System.out.println("Enter address: ");
        address = scan.nextLine();
        
        System.out.println("Enter template address: ");
        tmpAddress = scan.nextLine();
        
        System.out.println("Enter age: ");
        age = Integer.parseInt(scan.nextLine());
    }
    
    public void inputPath() {
        Scanner scan = new Scanner(System.in);
        
        for(;;) {
            System.out.println("Enter address: ");
            String addString = scan.nextLine();
            
            if(!path.contains(addString)) {
                path.add(addString);
            }
            
            System.out.println("Continue (Y) or Not (N): ");
            addString = scan.nextLine();
            
            if(addString.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
    
    public void inputStatus() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Normal");
        System.out.println("2. Follow");
        System.out.println("3. Active");
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        
        switch(choose) {
            case 1:
                status = STATUS.NORMAL;
                break;
            case 2:
                status = STATUS.FOLLOW;
                break;
            default:
                status = STATUS.ACTIVE;
                break;
        }
    }

    public void display() {
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "Citizen{" + "name=" + name + ", cmtnd=" + cmtnd 
                + ", gender=" + gender + ", address=" 
                + address + ", tmpAddress=" + tmpAddress 
                + ", age=" + age + ", status=" + getStringStatus() + '}';
    }
    
    public String getStringStatus() {
        switch(status) {
            case NORMAL:
                return "Normal";
            case FOLLOW:
                return "Follow";
            default:
                return "Active";
        }
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }
    
}
