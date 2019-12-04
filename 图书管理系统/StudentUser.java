package ManagerBook;

import java.util.Scanner;

public class StudentUser extends User{
    @Override
    public void menu(){
        System.out.println("=================");
        System.out.println("1.借书");
        System.out.println("2.还书");
        System.out.println("3.现有书情况");
        System.out.println("=================");
        System.out.println("请输入您的选择:");
    }
    @Override
    public void operation(int select){
        switch(select){
            case 1:
                borrowBook();
                break;
            case 2:
                backBook();
                break;
            case 3:
                listBook();
                break;
        }


    }
    private void backBook(){
        System.out.println("请输入书名");
        Scanner scanner=new Scanner(System.in);
        String title=scanner.nextLine();
        BookShelf bookshelf=BookShelf.getBookShelf();
        Book[] books=bookshelf.getBook();
        for(Book book:books){
            if(book.title.equals(title)){
                book.currentCount++;
            }
        }
        System.out.println("没这本书");
    }
    private void borrowBook() {
        System.out.println("请输入书名");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        BookShelf bookshelf = BookShelf.getBookShelf();
        Book[] books = bookshelf.getBook();
        for (Book book : books) {
            if (book.title.equals(title)) {
                if (book.currentCount > 0) {
                    book.currentCount--;
                    System.out.println("成功");
                    return;
                } else {
                    System.out.println("已借完");
                    return;
                }
            }
        }
        System.out.println("没有这本书");
    }

private void listBook(){
    BookShelf bookShelf = BookShelf.getBookShelf();
    Book[] books = bookShelf.getBook();
    System.out.println("书名, 当前数量, 总数");
    for(Book book:books){
        System.out.println(book.title +"\t"+book.currentCount +"\t"+book.totalCount);
    }
    }
}