package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Administrator_Menu extends Application {
    public Scene scene = null;
    public static final int WIDTH = 300;
    public static final int HEIGTH = 300;
    public final MenuBar menuBar = new MenuBar();
    public final Menu menu = new Menu("操作");

    public final MenuItem add = new MenuItem("添加");
    public final MenuItem update = new MenuItem("修改");
    public final MenuItem drop = new MenuItem("删除");
    public final MenuItem search = new MenuItem("查询");

    public void initComponents() {
        scene = new Scene(new BorderPane(), WIDTH, HEIGTH);
        BorderPane root = (BorderPane) scene.getRoot();
        menuBar.getMenus().add(menu);
        menu.getItems().addAll(add,update,drop,search);
        root.setTop(menuBar);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        stage.setTitle("管理员菜单界面");
        stage.setScene(scene);
        stage.show();
        add.setOnAction(e->{

        }
        );
        update.setOnAction(e->{
            Administrator_u_Stage administrator_u_stage=new Administrator_u_Stage();
                    try {
//                        stage.hide();
                        administrator_u_stage.start(new Stage());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
        );
        drop.setOnAction(e->{
            Administrator_drop_Stage administrator_drop_stage=new Administrator_drop_Stage();
                    try {
                        administrator_drop_stage.start(new Stage());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                }
        );
        search.setOnAction(e->{
            Administrator_search_Stage administrator_search_stage=new Administrator_search_Stage();
                    try {
                        administrator_search_stage.start(new Stage());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
        );

    }
}
