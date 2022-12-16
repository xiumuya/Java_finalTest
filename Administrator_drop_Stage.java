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

public class Administrator_drop_Stage extends Application {
    static ArrayList<String> array = new ArrayList<>();
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/db6?useSSL=false";
    private static final String user = "root";
    private static final String password = "Mhy.0703";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "delete from student_inf where 学号=?";

    @Override
    public void start(Stage stage) throws Exception {
        GridPane rootGp = new GridPane();
        rootGp.setPadding(new Insets(10, 8, 10, 8));
        rootGp.setHgap(30);
        rootGp.setVgap(15);
        Label label=new Label("学号");
        TextField tf =new TextField();
        Button button =new Button("删除");
        rootGp.add(label,0,0);
        rootGp.add(tf,1,0);
        rootGp.add(button,1,1);
        conn = DriverManager.getConnection(url, user, password);
        Class.forName(driver);
        ps = conn.prepareStatement(sql);
        button.setOnAction(e->{
                    try {
                        ps.setString(1,tf.getText());
                        ps.execute();
                        Users_Login_Info.start();
                        if(Users_Login_Info.map_s.containsKey(Integer.parseInt(tf.getText()))){
                        System.out.println("删除学号为"+tf.getText()+"的学生成功!");
                        }
                        else {
                            System.out.println("删除失败,学号不存在!");
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        );
        Scene scene = new Scene(rootGp, 400,  200);
        stage.setTitle("删除学生信息");
        stage.setScene(scene);
        stage.show();


    }
}
