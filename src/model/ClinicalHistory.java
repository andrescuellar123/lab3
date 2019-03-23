package model;

import java.util.ArrayList;

public class ClinicalHistory{
	
//constants
public final static String STATE_OPEN = "abierto";
public final static String STATE_CLOSE= "cerrado";	

//attributes
private String symptom;
private String diagnostic;
private boolean state;
private String race;
private String namePet;
private double weightPet;
private String typeOfPet;
private int ageOfPet;

//Relations
private HistorialDate admissionDate;
private ArrayList<Medicament> medicaments;
private Client owner;


public ClinicalHistory (String symptom, String diagnostic , boolean state, String race, String namePet,double weightPet , String typeOfPet, int ageOfPet, int day, int month, int year, Client c){
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
public boolean getState(){
	return state;
}
public void setDiagnostic(boolean state){
	this.state=state;
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

}