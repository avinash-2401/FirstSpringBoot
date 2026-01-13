package com.SpringBoot.FirstSpringBoot.Model;

public class user {

    private int id;
    private String name ;
    private String gmail;

    public user(int id , String name , String gmail){

        this.id=id;
        this.name=name;
        this.gmail=gmail;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGamil(){
        return gmail;
    }
}
