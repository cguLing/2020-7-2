package com.servlet.emp;

import java.io.Serializable;

public class Emp implements Serializable {
	 private  final long serialVersionUID = 1L;
	 private int empid;
	 private String departid;
	 private String name;
	 private String sex;
	 private String cardid;
	 private String phone;
	 private String email;
	 private String faddress;
	 private String salary;
	 
	 public int getId(){
		 return empid;
	 }
	 public void setId(int id){
		this.empid=id;
	 }
	 
	 public String getDepid(){
		 return departid;
	 }
	 public void setDepid(String depid){
		this.departid=depid;
	 }
	 
	 public String getName(){
		 return name;
	 }
	 public void setName(String name){
		this.name=name;
	 }
	 
	 public String getSex(){
		 return sex;
	 }
	 public void setSex(String sex){
		this.sex=sex;
	 }
	 
	 public String getCardid(){
		 return cardid;
	 }
	 public void setCardid(String id){
		this.cardid=id;
	 }
	 
	 public String getPhone(){
		 return phone;
	 }
	 public void setPhone(String phone){
		this.phone=phone;
	 }
	 
	 public String getEmail(){
		 return email;
	 }
	 public void setEmail(String email){
		this.email=email;
	 }
	 
	 public String getFaddress(){
		 return faddress;
	 }
	 public void setFaddress(String address){
		this.faddress=address;
	 }
	 
	 public String getSalary(){
		 return salary;
	 }
	 public void setSalary(String salary){
		this.salary=salary;
	 }
	 
	 
}
