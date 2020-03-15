package MySql;

import java.sql.*;
import java.util.Scanner;

public class MySQLCilent {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册Driver
        //用Java语言的角度说：通过 反射机制（运行时操作类信息的一种方法)加载com.mysql.jdbc.Driver
        //可能抛异常
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //先指定MySql服务器的位置
        String url="jdbc:mysql://127.0.0.1:3306/java_14?useSSL=false&characterEncoding=utf8";
        String user="root";
        String password="";
        //也会抛出异常
        Connection connection=DriverManager.getConnection(url,user,password);
        System.out.println(connection);
        Scanner scanner=new Scanner(System.in);
        String sql=scanner.nextLine();
        /*while(true){
            String sql=scanner.nextLine();
            if(sql.equalsIgnoreCase("quit")){
            break;
            }
            string firstWord=sql.split(" ")[0];
            if(firstWord.equalsIgnoreCase("select")||
            //1.创建语句对象
            Statement statement=connection.createStatement();
            //2.执行语句
            int a=statement.executeUpdate(sql);
            System.out.println("受到影响的行数"+a);
            //3，关闭对象
            statement.close();
        }*/
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        //取到结果集元的信息
        ResultSetMetaData metaDate=rs.getMetaData();
        int columnCount=metaDate.getColumnCount();
        for(int i=0;i<columnCount;i++){
            String columnName=metaDate.getColumnName(i+1);
            System.out.print(columnName+" ");
        }
        System.out.println();
        while(rs.next()){
            for(int i=0;i<columnCount;i++){
                String value=rs.getString(i+1);
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}
