package model;

import java.util.ArrayList;

public class Service{
//Constantes
public final static double wash = 20000;
public final static double washPetDom = 30000;
public final static double cut = 8000;
public final static double dent = 12000;
public final static double vacunnes = 45000;

public final static String service1 = "Lavado ";
public final static String service2 = "Lavado a domicilio";
public final static String service3 = "corte de unias";
public final static String service4 = " dental";
public final static String service5 = "vacunas";



//Atributos
private String service;
private double cost;
private String date;
private Long identifyPet;
private Long identifyClient;
private Pet petTypeOfService;

//Relaciones

/**
 *Description este es el constructor que inicializa las variables
*@param service String el servicio
*@param cost double el costo del servicio
*@param date String la fecha en la que se hizo
*@param identifyPet long el pet que tiene el servicio
*@param identifyClient long la identificacion del animalito
*@param petTypeOfService Pet la mascota
*/


public Service(String service, double cost ,String date,Long identifyPet,Long identifyClient, Pet petTypeOfService){

this.service = service;
this.cost = cost;
this.date = date;
this.identifyPet = identifyPet;
this.identifyClient = identifyClient;
this.petTypeOfService = petTypeOfService;


}

/**
 *Description este metodo trae el servicio
*@return String  el servicio
*/
public String getService(){
  return service;
}
/**
*Description este metodo da el servicio
*@param service String el servicio
*/
public void setService(String service){
  this.service = service;
}
/**
*Description este metodo trae el costo del servicio
*@return double el costo del servicio
*/
public double getCost(){
  return cost;
}
/**
*Description este metodo establece el costo del servicio
*@param cost double el costo del servicio
*/
public void setCost(double cost){
  this.cost = cost;
}
/**
*Description este metodo trae la fecha del servicio
*@return String la fecha en la que se hizo
*/
public String getDate(){
  return date;
}
/**
*Description este metodo da la fecha del servicio
*@param date String la fecha que se hizo
*/
public void setDate(String date){
  this.date = date;
}
/**
*Description este metodo trae la identificacion de la mascota
*@return long la identificacion de la mascota
*/
public Long getIdentifyPet(){
  return identifyPet;
}
/**
*Description este metodo da la identificacion de la mascota
*@param identifyPet long la identificacion de la mascota
*/
public void setIdentifyPet(Long identifyPet){
  this.identifyPet = identifyPet;
}
/**
*Description este metodo trae la identificacion del cliente
*@return long  la identificacion del cliente
*/
public Long getIdentifyClient(){
  return identifyClient;
}
/**
*Description este metodo ed la identificacion del cliente
*@param identifyClient long la identificacion del cliente
*/
public void setIdentifyClientId(Long identifyClient){
  this.identifyClient = identifyClient;
}
/**
 *Description este metodo trae el arraylist de las mascotas
*@return Pet  el arraylist de las mascotas
*/
public Pet getPetTypeOfService(){
  return petTypeOfService;
}
/**
*Description este metodo llena el arraylist de las mascotas
*@param petTypeOfService Pet el arraylist de mascotas
*/
public void setPetTypeOfService(Pet petTypeOfService){
	this.petTypeOfService = petTypeOfService;

}

/**
*Description este metodo genera un reporte de la informacion de los servicios
*@return String reporte de los servicios
*/
public String reportInformation(){
String msj = "";

msj = "El servicio que se realizo fue :" + service;
msj = "Con un precio de :" + cost;
msj = "En la fecha :" + date;
msj = "La identificacion de la mascota es:" + identifyPet;
msj = "La identificacion del cliente es:" + identifyClient;

return msj;
}
}