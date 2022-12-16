package com.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student_Stage extends Application {
    static ArrayList<String>array=new ArrayList<>();
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/db6?useSSL=false";
    private static final String user="root";
    private static final String password="Mhy.0703";
    Connection conn =null;
    PreparedStatement ps= null;
    ResultSet rs =null;
    String selectsql="select * from student_inf where 学号=?";
    String sql="update student_inf  set 电话=?, Email=?, QQ=? where 学号=?";
    Label lable1_1=new Label("项目");
    Label lable1_2=new Label("原值");
    Label lable1_3=new Label("申报值");
    Label lable2_1=new Label("学号");
    Label lable3_1=new Label("姓名");
    Label lable4_1=new Label("班级");
    Label lable5_1=new Label("专业");
    Label lable6_1=new Label("性别");
    Label lable7_1=new Label("年级");
    Label lable8_1=new Label("出生日期");
    Label lable9_1=new Label("电话");
    Label lable10_1=new Label("Email");
    Label lable11_1=new Label("QQ");
    Label lable12_1=new Label("状态");

    @Override
    public void start(Stage stage ) throws SQLException {
        GridPane rootGp = new GridPane();
        rootGp.setPadding(new Insets(10, 8, 10, 8));
        rootGp.setHgap(150);
        rootGp.setVgap(30);
        Button button =new Button("增加记录");
        Scanner input =new Scanner(System.in);
        System.out.println("请输入查找的学号：");
        String sid=input.next();
        try{
            conn = DriverManager.getConnection(url, user, password);

            Class.forName(driver);
            ps = conn.prepareStatement(selectsql);
            ps.setString(1,sid);
            rs = ps.executeQuery();
            if (rs.next()) {
                Label lable2_2 = new Label(rs.getString("学号"));
                Label lable3_2 = new Label(rs.getString("姓名"));
                Label lable4_2 = new Label(rs.getString("班级"));
                Label lable5_2 = new Label(rs.getString("专业"));
                Label lable6_2 = new Label(rs.getString("性别"));
                Label lable7_2 = new Label(rs.getString("年级"));
                Label lable8_2 = new Label(rs.getString("出生日期"));
                Label lable9_2 = new Label(rs.getString("电话"));
                Label lable10_2 = new Label(rs.getString("Email"));
                Label lable11_2 = new Label(rs.getString("QQ"));
                Label lable12_2 = new Label(rs.getString("状态"));
                rootGp.add(lable2_2,1,2);
                rootGp.add(lable3_2,1,3);
                rootGp.add(lable4_2,1,4);
                rootGp.add(lable5_2,1,5);
                rootGp.add(lable6_2,1,6);
                rootGp.add(lable7_2,1,7);
                rootGp.add(lable8_2,1,8);
                rootGp.add(lable9_2,1,9);
                rootGp.add(lable10_2,1,10);
                rootGp.add(lable11_2,1,11);
                rootGp.add(lable12_2,1,12);
                TextField tf9_3=new TextField(rs.getString("电话"));
                TextField tf10_3=new TextField(rs.getString("Email"));
                TextField tf11_3=new TextField(rs.getString("QQ"));
                rootGp.add(tf9_3,2,9);
                rootGp.add(tf10_3,2,10);
                rootGp.add(tf11_3,2,11);
                ps = conn.prepareStatement(sql);
                button.setOnAction(e->{
                    try {
                        ps.setString(1,tf9_3.getText());
                        ps.setString(2,tf10_3.getText());
                        ps.setString(3,tf11_3.getText());
                        ps.setString(4,sid);
                        ps.execute();
                        System.out.println("修改记录成功");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        rootGp.add(button,2,13);
        rootGp.add(lable1_1,0,1);
        rootGp.add(lable1_2,1,1);
        rootGp.add(lable1_3,2,1);
        rootGp.add(lable2_1,0,2);
        rootGp.add(lable3_1,0,3);
        rootGp.add(lable4_1,0,4);
        rootGp.add(lable5_1,0,5);
        rootGp.add(lable6_1,0,6);
        rootGp.add(lable7_1,0,7);
        rootGp.add(lable8_1,0,8);
        rootGp.add(lable9_1,0,9);
        rootGp.add(lable10_1,0,10);
        rootGp.add(lable11_1,0,11);
        rootGp.add(lable12_1,0,12);
        Scene scene = new Scene(rootGp, 400,  200);
        stage.setTitle("基本信息");
        stage.setScene(scene);
        stage.show();
    }
}
