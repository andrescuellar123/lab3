package model;
public class client{

//attributes
private String name;
private String identity;
private String address;
private String cellphone;

//constructor
public client (String name, String identity, String address, String cellphone){
this.name = name;
this.identity = identity;
this.address = address;
this.cellphone = cellphone;
}
public String getName(){
    return name;
}
public void setName(String name){
	this.name = name;
}
public String getIdentity(){
	return identity;
}
public void setIdentity(String identity){
	this.identity = identity;
}
public String getAddress(){
	return address;
}
public void setAddress(String address){
	this.address = address;
}

















}