package com.servlet.cust;

import java.io.Serializable;

public class Cust implements Serializable{
	 private final long serialVersionUID = 1L;
	 private int custid;
	 private String custname;
	 private String custsex;
	 private String custtel;
	 private String custemail;
	 private String custsfz;
	 
	 public int getid(){
		 return custid;
	 }
	 public void setid(int id){
		this.custid=id;
	 }
	 
	 public String getname(){
		 return custname;
	 }
	 public void setname(String name){
		 this.custname=name;
	 }
	 
	 public String getsex(){
		 return custsex;
	 }
	 public void setsex(String sex){
		 this.custsex=sex;
	 }
	 
	 
	 public String gettel(){
		 return custtel;
	 }
	 public void settel(String tel){
		 this.custtel=tel;
	 }
	 
	 public String getemail(){
		 return custemail;
	 }
	 public void setemail(String email){
		 this.custemail=email;
	 }
	 
	 
	 public String getsfz(){
		 return custsfz;
	 }
	 public void setsfz(String sfz){
		 this.custsfz=sfz;
	 }

}
