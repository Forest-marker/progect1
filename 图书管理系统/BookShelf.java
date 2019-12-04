package ManagerBook;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    //建立了一个私有对象
    private static final BookShelf instance=new BookShelf() ;
    BookShelf (){

    }
    public static BookShelf getBookShelf(){
        return instance;
    }
    //创建了一个Book类型的顺序表
    List<Book> list=new ArrayList<>();

    public void add(Book book){
        //加书
        list.add(book);
    }
    public Book[] getBook(){
        Book[] array=new Book[list.size()];
        //转换为对象数组
        list.toArray(array);
        return array;
    }
    public void remove(String title){
        int index=-1;
        //找到相同书名对应的下标记录下来
        for(int i=0;i<list.size();i++){
            Book book=list.get(i);
            if(book.title.equals(title)){
                index=i;
                break;
            }
        }
        if(index!=-1){
            //移除此本书的相关信息
            list.remove(index);
        }
    }

}
