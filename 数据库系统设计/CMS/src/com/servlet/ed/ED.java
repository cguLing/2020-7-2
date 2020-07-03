package com.servlet.ed;

import java.io.Serializable;

public class ED  implements Serializable{
	 private  final long serialVersionUID = 1L;
	 private  int empID;
	 private  String depID;
	 private  String post;
	 
	 public int getempID(){
		 return empID;
	 }
	 public void setempID(int empID2){
		this.empID=empID2;
	 }
	 
	 public String getdepID(){
		 return depID;
	 }
	 public void setdepID(String depID){
		 this.depID=depID;
	 }
	 
	 public  String getpost(){
		 return post;
	 }
	 public void setpost(String post){
		 this.post=post;
	 }

}