package model;

public class HistorialRecord{

//relationship
private Pet namePet ;
private Client nameClient;


//constructor
public HistorialRecord (Pet namePet, Client nameClient ){
	
	this.namePet = namePet ;
	this.nameClient = nameClient;
}
public Pet getNamePet(){
	return namePet;
}
public void setNamePet (Pet namePet){
	this.namePet = namePet;
}
public  Client nameClient (){
	return nameClient;
}
public void setNameClient( Client nameClient){
	this.nameClient = nameClient;
}




}





