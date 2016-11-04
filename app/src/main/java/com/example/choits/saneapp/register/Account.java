package com.example.choits.saneapp.register;

/**
 * Created by choits on 15. 10. 24..
 */
public class Account {

    private String name;
    private String age;
    private String gender;
    private String partner_gender;


    public Account(){
    }

    public Account(String gender, String partner_gender, String age, String name){
        this.partner_gender=partner_gender;
        this.age=age;
        this.name=name;
        this.gender=gender;
    }

    public void setName(String name){ this.name=name; }

    public void setAge(String age){ this.age=age; }

    public void setGender(String gender){ this.gender=gender; }

    public void setPartner_gender(String partner_gender){ this.partner_gender=partner_gender; }

    public String getName(){
        return this.name;
    }

    public String getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }

    public String getPartner_gender() { return this.partner_gender; }

}
