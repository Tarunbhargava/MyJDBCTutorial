package myPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
        //driver load
        //conn estalish
        //statement create
        //execute - query
        //conn close

        public void createDatabase() {
            try {
                String url = "jdbc:mysql://localhost:3306/";
                String userName = "root";
                String password = "Tarun@1299";

                Connection conn = DriverManager.getConnection(url, userName, password);
                Statement stm = conn.createStatement();

                String query = "create database codingwallah";
                stm.execute(query);
                System.out.println("Database created successfully ");
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/codingwallah";
            //String db = "codingwallagh";
            String userName = "root";
            String password = "Tarun@1299";

            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();

            String query = "create table student(sid int(3),sname varchar(20), semail varchar(200))";
            stm.execute(query);
            System.out.println("Table created successfully ");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "codingwallah";
            String userName = "root";
            String password = "Tarun@1299";

            Connection conn = DriverManager.getConnection(url+db, userName, password);
            String query = "INSERT into student(sid,sname, semail) VALUES (?,?,?)";


            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, 11);
            pstm.setString(2,"boom");
            pstm.setString(3,"boom@gmail.com");


            //pstm.execute();
            pstm.executeUpdate();
            System.out.println("data inserted successfully ");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "codingwallah";
            String userName = "root";
            String password = "Tarun@1299";

            Connection conn = DriverManager.getConnection(url+db, userName, password);
            String query = "Select * from student";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                System.out.println("id = "+rs.getInt(1));
                System.out.println("id = "+rs.getString(2));
                System.out.println("id = "+rs.getString(3));

            }

            System.out.println("read successfully ");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "codingwallah";
            String userName = "root";
            String password = "Tarun@1299";

            Connection conn = DriverManager.getConnection(url+db, userName, password);
            String query = "UPDATE student set sid = ? where sname = ?";


            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, 12);
            pstm.setString(2,"boom");

             pstm.execute();
            System.out.println("data updated successfully ");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {
    }
}

