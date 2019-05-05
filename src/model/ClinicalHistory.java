package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.print.attribute.standard.DateTimeAtCompleted;

public class ClinicalHistory{
	
//constants
public final static String STATE_OPEN  = "abierto";
public final static String STATE_CLOSE = "cerrado";	
public final static String BANIO       = "banio";


//attributes
private String symptom;
private String diagnostic;
private String state;
private String race;
private String namePet;
private double weightPet;
private String typeOfPet;
private int    ageOfPet;



//Relations
private HistorialDate admissionDate;
private HistorialDate altaDate;
private ArrayList<Medicament> medicaments;
private Client owner;

//constructor
/**
*Description este constructor inicializa las variables
*@param symptom String el nombre de la mascota
*@param diagnostic String la identidad del cliente
*@param state String direccion de la mascota
*@param race String el telefono de la mascota
*@param namePet String nombre de la mascota
*@param weightPet double dpeso de la mascota
*@param typeOfPet String tipo de mascota
*@param ageOfPet int anios de la mascota
*@param day int dia de la historia clinica
*@param month int mes de la historia clinica
*@param year int anio de la historia clinica
*@param c Client es el cliente 
*/
public ClinicalHistory (String symptom, String diagnostic , String state, String race, String namePet,double weightPet , String typeOfPet, int ageOfPet, int day, int month, int year, Client c ){
	this.symptom = symptom;
	this.diagnostic = diagnostic;
	this.state = state;
	this.race = race;
	this.namePet = namePet;
	this.weightPet = weightPet;
	this.typeOfPet = typeOfPet;
	this.ageOfPet = ageOfPet;
	admissionDate = new HistorialDate(day, month, year);
	medicaments= new ArrayList<Medicament>();
	owner= c;
	
}
public void setState(String s) {
	state= s;
}
/**
*Description el metodo nos da el sintoma de la mascota
*@return String el nombre de la mascota
*/
public String getSymptom(){
	return symptom;
}
/**
*Description este metodo establece el sintoma de la mascota
*@param symptom String el sintoma de la mascota
*/
public void setSymptom(String symptom){
	this.symptom=symptom;
}
/**
*Description el metodo nos da el diagnostico de la mascota
*@return String el estado de la mascota
*/
public String getDiagnostic(){
	return diagnostic;
}/**
*Description este metodo establece el diagnostico de la mascota
*@param diagnostic String el diagnostico de la mascota
*/
public void  setDiagnostic(String diagnostic ){
	this.diagnostic=diagnostic;
}
/**
*Description el metodo nos da el estado de la mascota
*@return String el estado de la mascota
*/
public String getState(){
	return state;
}

/**
*Description el metodo nos da la raza de la mascota
*@return String el raza de la mascota
*/
public String getRace(){
	return race;
}
/**
*Description este metodo establece la raza de la mascota
*@param race String la raza de la mascota
*/
public void setRace(String race){
	this.race=race;
}
/**
*Description el metodo nos da el nombre de la mascota
*@return String el nombre de la mascota
*/
public String getNamePet(){
	return namePet;
}
/**
*Description este metodo establece el nombre de la mascota
*@param namePet String el nombre de la mascota
*/
public void setNamePet(String namePet){
	this.namePet=namePet;
}
/**
*Description el metodo nos da el peso de la mascota
*@return double el peso de la mascota
*/
public double getWeightPet(){
	return weightPet;
}
/**
*Description este metodo establece el peso de la mascota
*@param weightPet String el peso de la mascota
*/
public void setWeightPet(double weightPet){
	this.weightPet = weightPet;
}
/**
*Description el metodo nos da el tipo de la mascota
*@return String el tipo de la mascota
*/
public String getTypeOfPet(){
	return typeOfPet;
}
/**
*Description este metodo establece el tipo de la mascota
*@param typeOfPet String el tipo de la mascota
*/
public void setTypeOfPet(String typeOfPet){
	this.typeOfPet=typeOfPet;
}
/**
*Description el metodo nos da los anios de la mascota
*@return int el anios de la mascota
*/
public int getAgeOfPet(){
	return ageOfPet;

}
/**
*Description este metodo establece el anio de la mascota
*@param ageOfPet int el anio de la mascota
*/
public void setAgeOfPet(int ageOfPet){
	this.ageOfPet=ageOfPet;
}

//añadir nuevo medicamento
/**
*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: New medicines were added to the patient clinic story.
*@param  name String. This param must be not null.
*@param  dose double, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned.
*@param  doseCost String by each dose. This param could be empty.
*@param   frecuency String of medicines application. This param could be empty.
*@return A String message that indiques if medicine was added to the patient clinic story
*/

public String addMedicament(String name, double dose, String doseCost, String frecuency) {
	boolean error=false;
	String message="";
	if(doseCost==null || doseCost.equals("")){
		error=true;
		message= "error al añadir";
	}
	if(frecuency== null || frecuency.equals("")){
		error=true;
		message= "error al añadir";
	}
	if(!error){
		double convertedCost= Double.parseDouble(doseCost);
		int convertedFrecuency= Integer.parseInt(frecuency);
		Medicament m= new Medicament(name, dose, convertedCost, convertedFrecuency);
		medicaments.add(m);
		message= "exito al añadir";
	}
	
	return message;
	
}


public int countDays(int endDay, int endMonth, int endYear) {
	GregorianCalendar fin= new GregorianCalendar(endYear, endMonth, endDay);
	GregorianCalendar ini= new GregorianCalendar(admissionDate.getYear(),admissionDate.getMonth(),admissionDate.getDay());
	int cont=0;
	while(fin.compareTo(ini)!=0) {
		ini.add(GregorianCalendar.DAY_OF_MONTH, 1);
		cont++;
	}
	return cont;
}


public double calculateCost(int endDay, int endMonth, int endYear) {
	int days= countDays(endDay, endMonth, endYear);
	double cost=0;
	if(typeOfPet.equals(Pet.CAT)) {
		if(weightPet>=1&& weightPet<=3) {
			cost= 10000;
		}else if( weightPet>=3.1 && weightPet>=10) {
			cost= 12000;
		}else if (weightPet>= 10.1 && weightPet <= 20){
			cost= 15000;
		}else if (weightPet > 20){
			cost= 20000;
		}
	}else if( typeOfPet.equals(Pet.DOG)) {
		if(weightPet>=1&& weightPet<=3) {
			cost= 15000;
		}else if( weightPet>=3.1 && weightPet>=10) {
			cost= 17000;
		}else if (weightPet>= 10.1 && weightPet <= 20){
			cost= 20000;
		}else if (weightPet > 20){
			cost= 25000;
		}

	}else if( typeOfPet.equals(Pet.BIRD)) {
		if(weightPet>=1&& weightPet<=3) {
			cost= 10000;
		}else if( weightPet>=3.1 && weightPet>=10) {
			cost= 12000;
		}else if (weightPet>= 10.1 && weightPet <= 20){
			cost= 20000;
		}else if (weightPet > 20){
			cost= 25000;
		}

	}else if( typeOfPet.equals(Pet.OTHER)) {
		if(weightPet>=1&& weightPet<=3) {
			cost= 10000;
		}else if( weightPet>=3.1 && weightPet>=10) {
			cost= 17000;
		}else if (weightPet>= 10.1 && weightPet <= 20){
			cost= 30000;
		}else if (weightPet > 20){
			cost= 33000;
		}


		return cost;
	}


	for(int i=0;i<medicaments.size();i++) {
		double howManyTimesItHasBeenApplied=24/medicaments.get(i).getFrecuency();
		double costPerDay= howManyTimesItHasBeenApplied*medicaments.get(i).getDoseCost();
		double totalCost=costPerDay*days;
		cost+=totalCost;
	}

	return cost;


}

//nuevas notas 

/**
*Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: New notes were added to the possible diagnostic in the patient clinic story.
*@param notes String The notes of possible diagnostic. This param must be not null.
*/
public void addNotes(String notes){

setDiagnostic(notes + getDiagnostic());

}








}










	
