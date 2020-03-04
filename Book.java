package StringDemo;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String TSBN;
    private String title;
    private String author;
    private int price;
    public Book(String TSBN,String title,String author,int price){
        this.TSBN=TSBN;
        this.title=title;
        this.author=author;
        this.price=price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(TSBN, book.TSBN);
    }

    @Override
    public int compareTo(Book o){
              return this.price-o.price;
    }

    public static void main(String[] args) {
        Book a=new Book("11","老人与海","海明威",50);
        Book b=new Book("12","红楼梦","曹雪芹",56);
    }



}
