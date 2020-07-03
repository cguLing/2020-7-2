package com.servlet.proj;

import java.io.Serializable;

public class Proj  implements Serializable{
	 private  final long serialVersionUID = 1L;
	 private  String projid;
	 private  String depid;
	 private  int projer;
	 private  int custid;
	 private  String projname;
	 private  String projtext;
	 private  String projstart;
	 private  String projsta;
	 private  String projend;
	 
	 public String getid(){
		 return projid;
	 }
	 public void setid(String id){
		this.projid=id;
	 }
	 
	 public String getdid(){
		 return depid;
	 }
	 public void setdid(String did){
		 this.depid=did;
	 }
	 
	 public  int geter(){
		 return projer;
	 }
	 public void seter(int er){
		 this.projer=er;
	 }
	 
	 public int getcid(){
		 return custid;
	 }
	 public void setcid(int cid){
		 this.custid=cid;
	 }
	 
	 public String getname(){
		 return projname;
	 }
	 public void setname(String name){
		this.projname=name;
	 }
	 
	 public String gettext(){
		 return projtext;
	 }
	 public void settext(String text){
		 this.projtext=text;
	 }
	 
	 public  String getstart(){
		 return projstart;
	 }
	 public void setstart(String start){
		 this.projstart=start;
	 }

	 public String getsta(){
		 return projsta;
	 }
	 public void setsta(String sta){
		 this.projsta=sta;
	 }
	 
	 public  String getend(){
		 return projend;
	 }
	 public void setend(String end){
		 this.projend=end;
	 }
}

