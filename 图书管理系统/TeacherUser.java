package ManagerBook;

import java.util.Scanner;

public class TeacherUser extends User{
    @Override
    public void menu(){
        System.out.println("=================");
        System.out.println("1.上架");
        System.out.println("2.下架");
        System.out.println("3.现有书展示");
        System.out.println("=================");
        System.out.println("请输入您的选择:");


    }
    @Override
    public void operation(int select){
        switch(select){
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                listBook();
                break;
        }
    }
    private void listBook(){
        BookShelf bookshelf=BookShelf.getBookShelf();
        Book[] books=bookshelf.getBook();
        System.out.println("书名,当前数量，总数");
        for(Book book:books){
            System.out.println(book.title +"\t"+book.currentCount +"\t"+book.totalCount);
        }
    }
    private void removeBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入书名:");
        String title=scanner.nextLine();
        BookShelf bookshelf=BookShelf.getBookShelf();
        bookshelf.remove(title);
    }

    private void addBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入书名:");
        String title=scanner.nextLine();
        System.out.println("这次上架多少本");
        int count=scanner.nextInt();
        Book book=new Book();
        book.title=title;
        book.totalCount=count;
        book.currentCount=count;
        BookShelf bookshelf=BookShelf.getBookShelf();
        bookshelf.add(book);
        System.out.println("上架成功");
    }
}
