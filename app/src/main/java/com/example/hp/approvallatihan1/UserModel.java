package com.example.hp.approvallatihan1;

public class UserModel {
    private String name;
    private String age;

    public UserModel(String name, String age){
        this.name= name;
        this.age= age;

    }
    public UserModel(){

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}
