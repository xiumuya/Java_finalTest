package com.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;
import java.util.ArrayList;

public class Administrator_insert_Stage extends Application {
    static ArrayList<String> array = new ArrayList<>();
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/db6?useSSL=false";
    private static final String user = "root";
    private static final String password = "Mhy.0703";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql="insert into student_inf values(?,?,?,?,?,?,?,?,?,?,?)";
    Label lable1_1 = new Label("项目");
    Label lable1_2 = new Label("申报值");
    Label lable2_1 = new Label("学号");
    Label lable3_1 = new Label("姓名");
    Label lable4_1 = new Label("班级");
    Label lable5_1 = new Label("专业");
    Label lable6_1 = new Label("性别");
    Label lable7_1 = new Label("年级");
    Label lable8_1 = new Label("出生日期");
    Label lable9_1 = new Label("电话");
    Label lable10_1 = new Label("Email");
    Label lable11_1 = new Label("QQ");
    Label lable12_1 = new Label("状态");


    @Override
    public void start(Stage stage) throws SQLException {
        GridPane rootGp = new GridPane();
        rootGp.setPadding(new Insets(10, 8, 10, 8));
        rootGp.setHgap(150);
        rootGp.setVgap(30);
        Button button = new Button("增加记录");
        rootGp.add(button,1,13);
        rootGp.add(lable1_1,0,1);
        rootGp.add(lable1_2,1,1);
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
//        RadioButton q=new RadioButton("在读");
//        RadioButton w=new RadioButton("休学");
//        RadioButton a=new RadioButton("毕业");
//        RadioButton r=new RadioButton("退学");
//        HBox hBox=new HBox(10,q,w,a,r);
//        ToggleGroup toggleGroup=new ToggleGroup();
//        q.setToggleGroup(toggleGroup);
//        w.setToggleGroup(toggleGroup);
//        a.setToggleGroup(toggleGroup);
//        r.setToggleGroup(toggleGroup);
//rootGp.add(hBox,1,12);
        TextField tf2_2=new TextField();
        TextField tf3_2=new TextField();
        TextField tf4_2=new TextField();
        TextField tf5_2=new TextField();
        TextField tf6_2=new TextField();
        TextField tf7_2=new TextField();
        TextField tf8_2=new TextField();
        TextField tf9_2=new TextField();
        TextField tf10_2=new TextField();
        TextField tf11_2=new TextField();
        TextField tf12_2=new TextField();
        rootGp.add(tf2_2,1,2);
        rootGp.add(tf3_2,1,3);
        rootGp.add(tf4_2,1,4);
        rootGp.add(tf5_2,1,5);
        rootGp.add(tf6_2,1,6);
        rootGp.add(tf7_2,1,7);
        rootGp.add(tf8_2,1,8);
        rootGp.add(tf9_2,1,9);
        rootGp.add(tf10_2,1,10);
        rootGp.add(tf11_2,1,11);
        rootGp.add(tf12_2,1,12);
        try {
            conn = DriverManager.getConnection(url, user, password);
            Class.forName(driver);
            ps = conn.prepareStatement(sql);
            button.setOnAction(e->{
                        try {
                            ps.setString(1,tf2_2.getText());
                            ps.setString(2,tf3_2.getText());
                            ps.setString(3,tf4_2.getText());
                            ps.setString(4,tf5_2.getText());
                            ps.setString(5,tf6_2.getText());
                            ps.setString(6,tf7_2.getText());
                            ps.setString(7,tf8_2.getText());
                            ps.setString(8,tf9_2.getText());
                            ps.setString(9,tf10_2.getText());
                            ps.setString(10,tf11_2.getText());
                            ps.setString(11,tf12_2.getText());
                            if(Users_Login_Info.map_s.containsKey(Integer.parseInt(tf2_2.getText()))){
                                System.out.println("添加失败,学号已经存在");
                            }
                            else {
                                    System.out.println("添加学号为:  "+tf2_2.getText()+"的学生信息成功!");}
                            ps.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
            }
            );


        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(rootGp, 400, 200);
        stage.setTitle("基本信息");
        stage.setScene(scene);
        stage.show();
    }
}
