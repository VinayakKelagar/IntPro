package com.example.blooddonar;

public class blooddonar {

    private String name;
    private String mno;
    private String email;
    private String pass;
    private String cpass;
    private String state;
    private String city;
    private String bloodgroup;
    private String type;



    public blooddonar(String name,String mno,String email,String pass,String cpass,String state,String city,String bloodgroup,String type)
    {
        this.name=name;
        this.mno=mno;
        this.email=email;
        this.pass=pass;
        this.cpass=cpass;
        this.state=state;
        this.city=city;
        this.bloodgroup=bloodgroup;
        this.type=type;
    }

    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }

    public String getmno(){
        return mno;
    }
    public void setmno(String mno){
        this.mno=mno;
    }

    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email=email;
    }

    public String getpass(){
        return pass;
    }
    public void setpass(String pass){ this.pass=pass;
    }

    public String getcpass(){
        return cpass;
    }
    public void setcpass(String cpass){
        this.cpass=cpass;
    }

    public String getstate(){
        return state;
    }
    public void setstate(String state){
        this.state=state;
    }

    public String getcity(){
        return city;
    }
    public void setcity(String city){
        this.city=city;
    }

    public String getbloodgroup(){
        return bloodgroup;
    }
    public void setbloodgroup(String bloodgroup){
        this.bloodgroup=bloodgroup;
    }

    public String gettype(){
        return type;
    }
    public void settype(String type){
        this.type=type;
    }


}
