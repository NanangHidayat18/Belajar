package com.example.hp.approvallatihan1;

public class UserModel {
    private String name;
    private String cuti;
    private String year;

    public UserModel(String name, String cuti, String year){
        this.name= name;
        this.cuti= cuti;
        this.year= year;

    }

    public UserModel(){

    }
    public String getName(){ return name; }
    public void setName(String name){
        this.name= name;
    }
    public String getCuti(){
        return cuti;
    }
    public void setCuti(String cuti) {
        this.cuti = cuti;
    }
    public String getYear(){
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
}
