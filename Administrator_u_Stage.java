/*
有问题,修改学生状态的时候不能与修改学生信息同时进行修改.
点击单选框事件和点击修改学生信息的按钮事件不能同时进行
 */
package com.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Scanner;

public class Administrator_u_Stage extends Application {
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/db6?useSSL=false";
    private static final String user="root";
    private static final String password="Mhy.0703";
    Connection conn =null;
    PreparedStatement ps= null;
    ResultSet rs =null;
    String selectsql="select * from student_inf where 学号=?";
    String sql="update student_inf  set 姓名=?, 班级=?, 专业=?,性别=?, 年级=?, 出生日期=?, 电话=?, Email=?, QQ=? where 学号=?";
    String sql2="update student_inf  set 状态=? where 学号=?";
    String sql3="update student_inf  set 状态=? where 学号=?";
    String sql4="update student_inf  set 状态=? where 学号=?";
    String sql5="update student_inf  set 状态=? where 学号=?";
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
        System.out.println("请输入需要修改的学号：");
        String sid=input.next();
        if(!Users_Login_Info.map_s.containsKey(Integer.parseInt(sid))){
            System.out.println("修改失败,学号不存在!");
        }
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
                RadioButton q=new RadioButton("在读");
                RadioButton w=new RadioButton("休学");
                RadioButton a=new RadioButton("毕业");
                RadioButton r=new RadioButton("退学");
                HBox hBox=new HBox(10,q,w,a,r);
                ToggleGroup toggleGroup=new ToggleGroup();
                q.setToggleGroup(toggleGroup);
                w.setToggleGroup(toggleGroup);
                a.setToggleGroup(toggleGroup);
                r.setToggleGroup(toggleGroup);
                TextField tf3_3=new TextField(rs.getString("姓名"));
                TextField tf4_3=new TextField(rs.getString("班级"));
                TextField tf5_3=new TextField(rs.getString("专业"));
                TextField tf6_3=new TextField(rs.getString("性别"));
                TextField tf7_3=new TextField(rs.getString("年级"));
                TextField tf8_3=new TextField(rs.getString("出生日期"));
                TextField tf9_3=new TextField(rs.getString("电话"));
                TextField tf10_3=new TextField(rs.getString("Email"));
                TextField tf11_3=new TextField(rs.getString("QQ"));
                rootGp.add(tf3_3,2,3);
                rootGp.add(tf4_3,2,4);
                rootGp.add(tf5_3,2,5);
                rootGp.add(tf6_3,2,6);
                rootGp.add(tf7_3,2,7);
                rootGp.add(tf8_3,2,8);
                rootGp.add(tf9_3,2,9);
                rootGp.add(tf10_3,2,10);
                rootGp.add(tf11_3,2,11);
                rootGp.add(hBox,2,12);
                q.setOnAction(e->{
                    try {
                        ps = conn.prepareStatement(sql2);
                        ps.setString(1,"在读");
                        ps.setString(2,sid);
                        ps.execute();
                        System.out.println("修改学生状态成功!");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                });
                w.setOnAction(e->{
                    try {
                        ps = conn.prepareStatement(sql3);
                        ps.setString(1,"休学");
                        ps.setString(2,sid);
                        ps.execute();
                        System.out.println("修改学生状态成功!");

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                });
                a.setOnAction(e->{
                    try {
                        ps = conn.prepareStatement(sql4);
                        ps.setString(1,"毕业");
                        ps.setString(2,sid);
                        ps.execute();
                        System.out.println("修改学生状态成功!");

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                });
                r.setOnAction(e->{
                    try {
                        ps = conn.prepareStatement(sql5);
                        ps.setString(1,"退学");
                        ps.setString(2,sid);
                        ps.execute();
                        System.out.println("修改学生状态成功!");

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                });
                ps = conn.prepareStatement(sql);
                button.setOnAction(e->{
                    try {
                        ps.setString(1,tf3_3.getText());
                        ps.setString(2,tf4_3.getText());
                        ps.setString(3,tf5_3.getText());
                        ps.setString(4,tf6_3.getText());
                        ps.setString(5,tf7_3.getText());
                        ps.setString(6,tf8_3.getText());
                        ps.setString(7,tf9_3.getText());
                        ps.setString(8,tf10_3.getText());
                        ps.setString(9,tf11_3.getText());
                        ps.setString(10,sid);
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
