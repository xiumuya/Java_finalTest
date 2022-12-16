package com.example.demo;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.util.ArrayList;

public class Primary_Stage extends Application {
    static String sid;
    Label lable1 = new Label("用户名：");
    Label lable2 = new Label("密码：");
    TextField tf = new TextField();
    PasswordField pf = new PasswordField();
    Button button = new Button("登录");
    Button button2 = new Button("点击进入学生版");
   static ArrayList<String>arrayList=new ArrayList<>();

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
        GridPane.setHalignment(button2, HPos.CENTER);
        rootGp.add(button2, 2, 5);
        button2.setOnAction(e -> {
            Student_Login_Stage stage2=new Student_Login_Stage();
            stage.hide();
                    try {
                        stage2.start(new Stage());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
        );
        button.setOnAction(e -> {
                    sid= tf.getText();
                    arrayList.add(sid);
                    Users_Login_Info.start();
                    for (Users users : Users_Login_Info.list_t) {
                        if (users.getid() == Integer.parseInt(tf.getText()) & users.getPassword().equals(pf.getText())) {
                            Administrator_Stage stage1=new Administrator_Stage();
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
        stage.setTitle("用户登录界面");
        stage.setScene(scene);
        stage.show();

    }

}
