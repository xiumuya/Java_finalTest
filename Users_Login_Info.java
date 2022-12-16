package com.example.demo;
import java.util.ArrayList;
import java.util.List;

class  Users {
    private String password;
    private int id;

    public Users() {
        super();
    }

    public Users(int id,String password) {
        this.password = password;
        this.id = id;
    }

    public void setinfo(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getid() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getinfo() {
        return "password:" + password + "\n" + "\n" + "id:" + id;
    }

    @Override
    public String toString() {
        return "password:" + password + "\n" + "\n" + "id:" + id;
    }
}
 class Users_Login_Info {
     static List<Users> list_s = new ArrayList<>();
     static List<Users> list_t = new ArrayList<>();
    public static void start() {
        Users user1 = new Users(2008001, "mhy.0703");
        Users user2 = new Users(2021001, "mhy.0703");
        Users user3 = new Users(2021002, "mhy.0703");
        Users user4 = new Users(2021003, "mhy.0703");
        Users user5 = new Users(2021004, "mhy.0703");
        Users user6 = new Users(2021005, "mhy.0703");
        Users user7 = new Users(2021006, "mhy.0703");
        Users user8 = new Users(2021007, "mhy.0703");
        Users user9 = new Users(2021008, "mhy.0703");
        Users user10 = new Users(2021009, "mhy.0703");
        Users user11 = new Users(2021010, "mhy.0703");

        list_t.add(user1);
        list_s.add(user2);
        list_s.add(user3);
        list_s.add(user4);
        list_s.add(user5);
        list_s.add(user6);
        list_s.add(user7);
        list_s.add(user8);
        list_s.add(user9);
        list_s.add(user10);
        list_s.add(user11);
    }
}

