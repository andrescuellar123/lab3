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

/**
*Description este constructor inicializa las variables
*@param name String el nombre del cliente
*@param identity String la identidad del cliente
*@param address String direccion del cliente
*@param cellphone String el telefono del cliente
*/
//constructor
public Client (String name, String identity, String address, String cellphone){
this.name = name;
this.identity = identity;
this.address = address;
this.cellphone = cellphone;
this.pets= new ArrayList<Pet>();
}
/**
*Description el metodo nos da el nombre del cliente
*@return String el nombre del cliente
*/
public String getName(){
    return name;
}
/**
*Description este metodo establece el nombre del cliente
*@param name String el nombre del cliente
*/
public void setName(String name){
	this.name = name;
}
/**
*Description el metodo nos da la idetificacion del cliente
*@return String la identidad del cliente
*/
public String getIdentity(){
	return identity;
}
/**
*Description este metodo establece la identidad del cliente
*@param identity String la identidad del cliente
*/
public void setIdentity(String identity){
	this.identity = identity;
}
/**
*Description el metodo nos da la direccion del cliente
*@return String la direccion del cliente
*/
public String getAddress(){
	return address;
}
/**
*Description este metodo establece la direccion del cliente
*@param address String el direccion del cliente
*/
public void setAddress(String address){
	this.address = address;
}
/**
*Description el metodo nos da el celular del cliente
*@return String el celular del cliente
*/
public String getCellphone(){
	return cellphone;
}
/**
*Description este metodo establece el telefono del cliente
*@param cellphone String el telefono del cliente
*/
public void setCellphone(String cellphone){
	this.cellphone=cellphone;
}
/**
*Description este metodo establece el arraylist de las mascotas
@return Pet el arraylist de las mascotas
*/
public ArrayList<Pet> getPets(){
	return pets;
}
/**
*Description este metodo agrega una mascota
*@param p Pet egrega una mascota
*/
public void addPet(Pet p) {
	pets.add(p);
}
/**
*Description este metodo encuentra una mascota
*@param name String el telefono del cliente
@return Pet encontrado
*/
public Pet findPet(String name) {
	Pet found=null;
	for(int i=0;i<pets.size();i++) {
		if(pets.get(i).getNamePet().equals(name)) {
			found= pets.get(i);
		}
	}
	return found;
	
}
}