package com.neuedu.entity;

import java.io.Serializable;
import java.sql.Date;


public class Student implements Comparable,Serializable {
    
    private String sno;
    private String sname;
    private String ssex;
    private int sage;
    private String sdept;
    private Date birthday;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  sno + '\t' +sname + '\t' + ssex + '\t' + sage +'\t'+ sdept + '\t' +birthday ;
    }

    @Override
    public int hashCode() {
        return sno.hashCode()+sname.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        Student sobj=(Student)obj;
        if(sobj==null){
            return false;
        }
        if(this==sobj){
            return true;
        }
       if(this.getSno().equals(sobj.getSno())){
           return true;
       }
       return false;
    }

    @Override
    public int compareTo(Object o) {
        return this.getSage()-((Student)o).getSage();
    }
}
