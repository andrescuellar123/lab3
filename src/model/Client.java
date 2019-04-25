package model;
import java.util.ArrayList;


public class Client{

//attributes

private String name;
private String identity;
private String address;
private String cellphone;
//Relations
private ArrayList<Pet> pets;

//constructor
public Client (String name, String identity, String address, String cellphone){
this.name = name;
this.identity = identity;
this.address = address;
this.cellphone = cellphone;
this.pets= new ArrayList<Pet>();
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
public String getCellphone(){
	return cellphone;
}
public void setCellphone(String cellphone){
	this.cellphone=cellphone;
}
public ArrayList<Pet> getPets(){
	return pets;
}
public void addPet(Pet p) {
	pets.add(p);
}

public Pet findPet(String name) {
	Pet found=null;
	for(int i=0;i<pets.size();i++) {
		if(pets.get(i).getNamePet().equals(name)) {
			found= pets.get(i);
		}
	}
	return found;
	
}
//information of the client

 public String showInfoClient(){
 String msj = "";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "El nombre es:" + name + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "La edad es:" + identity + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "El peso es:" + address + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj +="El tipo de mascota es:" + cellphone + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 
 for(int o = 0; 0 < pets.size(); o++){
	
	msj += pets.get(o).showInfoPet();
	 
	 
 }
	return msj;

}














}