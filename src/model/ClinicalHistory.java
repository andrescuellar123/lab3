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
public String getSymptom(){
	return symptom;
}
public void setSymptom(String symptom){
	this.symptom=symptom;
}
public String getDiagnostic(){
	return diagnostic;
}
public void  setDiagnostic(String diagnostic ){
	this.diagnostic=diagnostic;
}
public String getState(){
	return state;
}

public String getRace(){
	return race;
}
public void setRace(String race){
	this.race=race;
}
public String getNamePet(){
	return namePet;
}
public void setNamePet(String namePet){
	this.namePet=namePet;
}
public double getWeightPet(){
	return weightPet;
}
public void setWeightPet(double weightPet){
	this.weightPet = weightPet;
}
public String getTypeOfPet(){
	return typeOfPet;
}
public void setTypeOfPet(String typeOfPet){
	this.typeOfPet=typeOfPet;
}
public int getAgeOfPet(){
	return ageOfPet;

}
public void setAgeOfPet(int ageOfPet){
	this.ageOfPet=ageOfPet;
}

//añadir nuevo medicamento
/**
*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: New medicines were added to the patient clinic story.
*@param The medicine name. This param must be not null.
*@param The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned.
*@param The medicine cost by each dose. This param could be empty.
*@param The frequency of medicine application. This param could be empty.
*@return A message that indiques if medicine was added to the patient clinic story
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

//nuevas notas un String?






}










	
