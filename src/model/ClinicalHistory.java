package model;

import java.util.ArrayList;

public class ClinicalHistory{
	
//constants
public final static String STATE_OPEN = "abierto";
public final static String STATE_CLOSE= "cerrado";	

//attributes
private String symptom;
private String diagnostic;
private String state;
private String race;
private String namePet;
private double weightPet;
private String typeOfPet;
private int ageOfPet;

//Relations
private HistorialDate admissionDate;
private ArrayList<Medicament> medicaments;
private Client owner;


public ClinicalHistory (String symptom, String diagnostic , String state, String race, String namePet,double weightPet , String typeOfPet, int ageOfPet, int day, int month, int year, Client c){
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
	return namePet= namePet;
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

public void addMedicament(String name, double dose, double doseCost, int frecuency) {
	Medicament m= new Medicament(name, dose, doseCost, frecuency);
	medicaments.add(m);
}


	
	for(int i=0;i<medicaments.size();i++) {
		double howManyTimesItHasBeenApplied=24/medicaments.get(i).getFrecuency();
		double costPerDay= howManyTimesItHasBeenApplied*medicaments.get(i).getDoseCost();
		double totalCost=costPerDay*days;
		cost+=totalCost;
	}
	
	return cost;
}

}