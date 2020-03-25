package MySql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class 通过URL创建DataSource {
    private static DataSource dataSource;

    public static void main(String[] args) {
        String url="jdbc:mysql://127.0.0.1:3306/java_14?useSSL=false&characterEncoding=utf8";

        MysqlDataSource mysqlDataSource =new MysqlDataSource();
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setUrl(url);

        dataSource=mysqlDataSource;

        showTable();

    }

    private static void showTable(){
        try(Connection connection=dataSource.getConnection()){
            String sql="show tables";
            try(Statement statement=connection.createStatement()){
                try(ResultSet rs=statement.executeQuery(sql)){
                    while(rs.next()){
                        System.out.println(rs.getString(1));
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
