package com.servlet.depart;

import java.io.Serializable;

public class Depart  implements Serializable{
	 private  static final long serialVersionUID = 1L;
	 private  String depid;
	 private  String deper;
	 private  String depdsc;
	 
	 public String getid(){
		 return depid;
	 }
	 public void setid(String id){
		this.depid=id;
	 }
	 
	 public String geter(){
		 return deper;
	 }
	 public void seter(String er){
		 this.deper=er;
	 }
	 
	 public  String getdsc(){
		 return depdsc;
	 }
	 public void setdsc(String dsc){
		 this.depdsc=dsc;
	 }

}
