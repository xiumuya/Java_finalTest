package com.example.demo;

import com.example.demo.Administrator_Stage;
import com.example.demo.Users;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class Student_Login_Stage extends Application {
    static String sid;
    Label lable1 = new Label("用户名：");
    Label lable2 = new Label("密码：");
    TextField tf = new TextField();
    PasswordField pf = new PasswordField();
    Button button = new Button("登录");
    @Override
    public void start(Stage stage) throws Exception {
        GridPane rootGp = new GridPane();
        rootGp.setPadding(new Insets(10, 8, 10, 8));
        rootGp.setHgap(5);
        rootGp.setVgap(10);
        tf.setPromptText("输入用户名");
        pf.setPromptText("请输入密码：");
//        tf.setPrefSize(100,20);
//        pf.setPrefSize(100,20);
        button.setPrefSize(60, 20);
//        button2.setPrefSize(150,20);
        rootGp.add(lable1, 1, 0);
        rootGp.add(lable2, 1, 1);
        rootGp.add(tf, 2, 0);
        rootGp.add(pf, 2, 1);
        GridPane.setHalignment(button, HPos.CENTER);
        rootGp.add(button, 2, 3);
        button.setOnAction(e -> {
                    sid= tf.getText();
                    Users_Login_Info.start();
                    for (Users users : Users_Login_Info.list_s) {
                        if (users.getid() == Integer.parseInt(tf.getText()) & users.getPassword().equals(pf.getText())) {
                            Student_Stage stage1=new Student_Stage();
                            stage.hide();
                            try {
                                stage1.start(new Stage());
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                    }

                }
        );
        Scene scene = new Scene(rootGp, 400, 200);
        stage.setTitle("学生登录界面");
        stage.setScene(scene);
        stage.show();


    }

}

