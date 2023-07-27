package mainApp;

import dao.MobileDao;
import dto.MobileDto;

import java.util.ArrayList;
import java.util.Scanner;

public class MobileMainApp {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        boolean status=true;
        while (status){
            System.out.println("1: Add New Mobile");
            System.out.println("2: Search Mobile");
            System.out.println("3: Delete Mobile");
            System.out.println("4: Exit");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    addMobile();
                    break;
                case 2:
                    System.out.println("1: Mobile By Company");
                    System.out.println("2: Mobile By Price");
                    System.out.println("3: Mobile By RAM");
                    System.out.println("4: Mobile By Camera");
                    System.out.println("5: End Operation");
                    int ch= sc.nextInt();
                    switch (ch){
                        case 1:
                            displayModelName();
                            break;
                        case 2:
                            displayByPrice();
                            break;
                        case 3:
                            displayByRam();
                            break;
                        case 4:
                            displayByCamera();
                            break;
                    }
                    break;
                case 3:
                    deleteRecord();
                    break;
                default:
                    System.out.println("Thank You For Visiting Our Mobile Shop");
                    status=false;
            }
        }
    }

    private static void deleteRecord() {
        System.out.println("Enter Model No");
        int modelNo= sc.nextInt();
        MobileDto mdt=new MobileDto();
        mdt.setModelNo(modelNo);
        MobileDao mdo=new MobileDao();
        int count=mdo.deleteRecord(mdt);
        System.out.println(count+" Mobile Deleted Successfully");
        System.out.println("=========================================");
    }

    private static void addMobile() {
        System.out.println("Enter Model No");
        int modelNo=sc.nextInt();
        System.out.println("Enter Model Name");
        String modelName= sc.next();
        System.out.println("Enter Company");
        String company= sc.next();
        System.out.println("Enter RAM Size");
        int ram=sc.nextInt();
        System.out.println("Enter Camera");
        int camera=sc.nextInt();
        System.out.println("Enter Price");
        double price= sc.nextDouble();

        MobileDto mdt=new MobileDto();
        mdt.setModelNo(modelNo);
        mdt.setModelName(modelName);
        mdt.setCompany(company);
        mdt.setRam(ram);
        mdt.setCamera(camera);
        mdt.setPrice(price);
        MobileDao mdo=new MobileDao();
        int count=mdo.insertMobile(mdt);
        System.out.println(count+" Company Inserted Successfully");
    }
    private static void displayModelName() {
        MobileDao mdo=new MobileDao();
        System.out.println("Enter Company");
        String companyName= sc.next();
        ArrayList<MobileDto> mobileList=mdo.displayModelName(companyName);
        System.out.println("Model");
        for (MobileDto m:mobileList){
            System.out.println(m.getModelName());
        }
        System.out.println("=====================================");
    }
    private static void displayByPrice() {
        MobileDao mdo=new MobileDao();
        System.out.println("Enter Starting Price");
        double start=sc.nextDouble();
        System.out.println("Enter End Price");
        double end=sc.nextDouble();
        ArrayList<MobileDto> mobileList=mdo.displayByPrice(start,end);
        System.out.println("ModelNo\tModelName\tCompany\t\tRAM\t\tCamera\t\tPrice");
        System.out.println("------------------------------------------------------------");
        for (MobileDto m:mobileList){
            System.out.println(m);
        }
        System.out.println("============================================================");
    }
    private static void displayByRam() {
        MobileDao mdo = new MobileDao();
        System.out.println("Select RAM Size");
        System.out.println("2\t\t4\t\t8\t\t16");
        int size = sc.nextInt();
        ArrayList<MobileDto> mobileList = mdo.displayByRam(size);
        System.out.println("ModelNo\tModelName\tCompany\t\tRAM\t\tCamera\t\tPrice");
        System.out.println("------------------------------------------------------------");
        for (MobileDto m : mobileList) {
            System.out.println(m);
        }
        System.out.println("============================================================");
    }
    private static void displayByCamera() {
        MobileDao mdo = new MobileDao();
        System.out.println("Enter Min RAM Size");
        double start = sc.nextDouble();
        System.out.println("Enter Max RAM Size");
        double end = sc.nextDouble();
        ArrayList<MobileDto> mobileList = mdo.displayByCamera(start, end);
        System.out.println("ModelNo\tModelName\tCompany\t\tRAM\t\tCamera\t\tPrice");
        System.out.println("------------------------------------------------------------");
        for (MobileDto m : mobileList) {
            System.out.println(m);
        }
        System.out.println("============================================================");

    }
    private static void displayRecords(){
        MobileDao mdo=new MobileDao();
        int choice= sc.nextInt();
        if (choice==1){
        }
    }
}
