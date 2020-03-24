package MySql;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //先指定MySql服务器的位置
        String url="jdbc:mysql://127.0.0.1:3306/java_14?useSSL=false&characterEncoding=utf8";
        //连接数据库的用户名
        String user="root";
        //连接数据库的密码
        String password="";
        Connection connection=DriverManager.getConnection(url,user,password);
        System.out.println(connection);

        //从Scanner中不断的读SQL,并执行
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.print("mysql>");
            String sql=scanner.nextLine();
            if(sql.equals("quit")){
                break;
            }
            //a.创建一个Statement语句
            Statement statement=connection.createStatement();
            //执行
            if(sql.startsWith("select")){
                ResultSet rs=statement.executeQuery(sql);
                int columnCount=rs.getMetaData().getColumnCount();
                while(rs.next()){
                    for(int i=1;i<=columnCount;i++){
                        String result=rs.getString(i);
                        System.out.print(result+"");
                    }
                    System.out.println();
                }
                rs.close();
            }else{
                int n=statement.executeUpdate(sql);
                System.out.printf("%d行受到的影响%n",n);
            }
            statement.close();

        }
        //4.关闭连接
        connection.close();
    }
}
