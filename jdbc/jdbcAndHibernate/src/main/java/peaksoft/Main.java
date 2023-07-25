package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        //UserImplOnJdbc
//        Scanner scannerNum=new Scanner(System.in);
//        Scanner scannerWord=new Scanner(System.in);
//        int num;
//        UserService userService=new UserServiceImpl();
//        while(true) {
//            System.out.println("""
//                    \n
//                    1-connect to database
//                    2-create table users
//                    3-save user
//                    4-remove user by id
//                    5-get all users
//                    6-clean users table""");
//            switch (num = scannerNum.nextInt()) {
//                case 1-> Util.getConnection();
//                case 2->userService.createUsersTable();
//                case 3->
//                {
//                    System.out.println("Input user's name: ");
//                    String name=scannerWord.nextLine();
//                    System.out.println("Input user's last name: ");
//                    String lastName=scannerWord.nextLine();
//                    System.out.println("Input user's age: ");
//                    int age=scannerNum.nextInt();
//                    userService.saveUser(name,lastName ,(byte) age);
//                }
//                case 4->
//                {
//                    System.out.println("Input id you want to remove user by!");
//                    long id=scannerNum.nextLong();
//                    userService.removeUserById(id);
//                }
//                case 5->userService.getAllUsers().forEach(System.out::println);
//                case 6->userService.cleanUsersTable();
//            }
//
//        }

        //UserImplOnHibernate
        Scanner scannerNum=new Scanner(System.in);
        Scanner scannerWord=new Scanner(System.in);
        int num;
        UserService userService=new UserServiceImpl();
        while(true) {
            System.out.println("""
                    \n
                    1-connect to database
                    2-drop table users
                    3-save user
                    4-remove user by id
                    5-get all users
                    6-clean users table""");
            switch (num = scannerNum.nextInt()) {
                case 2->userService.dropUsersTable();
                case 3->{
                    System.out.println("Input user's name: ");
                    String name=scannerWord.nextLine();
                    System.out.println("Input user's last name: ");
                    String lastName=scannerWord.nextLine();
                    System.out.println("Input user's age: ");
                    int age=scannerNum.nextInt();
                    userService.saveUser(name,lastName, (byte) 22);
                }
                case 4->{
                    System.out.println("Input user's id you want to remove: ");
                    long id=scannerNum.nextLong();
                    userService.removeUserById(id);
                }
                case 5->userService.getAllUsers().forEach(System.out::println);
                case 6->userService.cleanUsersTable();

            }
        }


    }
}
