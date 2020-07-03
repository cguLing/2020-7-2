package com.servlet.el;

import java.io.Serializable;

public class EL  implements Serializable{
	 private  final long serialVersionUID = 1L;
	 private  int empid;
	 private  String isAdmin;
	 private  String pw;
	 
	 public int getid(){
		 return empid;
	 }
	 public void setid(int id){
		this.empid=id;
	 }
	 
	 public String getisAdmin(){
		 return isAdmin;
	 }
	 public void setisAdmin(String isAdmin){
		 this.isAdmin=isAdmin;
	 }
	 
	 public  String getpw(){
		 return pw;
	 }
	 public void setpw(String pw){
		 this.pw=pw;
	 }

}
