package ManagerBook;

import java.util.Scanner;

public class Main {
    //选择对象
    private static User login(){
        System.out.println("请选择 1. 老师 2. 学生");
        Scanner scanner=new Scanner(System.in);
        User u=null;
        int select=scanner.nextInt();
        switch(select){
            case 1:
                //上转型对象
                u=new TeacherUser();
                break;
            case 2:
                //上转型对象
                u=new StudentUser();
                break;
        }
        return u;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(true){
            User u=login();
            u.menu();
            //选择菜单选项
            int select=scanner.nextInt();
            u.operation(select);
        }
    }
}
