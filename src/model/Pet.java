package model;

import java.util.ArrayList;

public class Pet{
	
//constants

public final static String DOG = "D";
public final static String CAT = "C";
public final static String BIRD = "B";
public final static String OTHER = "O";

//attributes

private String namePet;
private double weightPet;
private String typeOfPet;
private int ageOfPet;
//Relations
private ArrayList<ClinicalHistory> histories;

//constructor

public Pet (String namePet, double weightPet, String typeOfPet, int ageOfPet){
this.namePet = namePet;
this.weightPet = weightPet;
this.typeOfPet =typeOfPet;
this.ageOfPet = ageOfPet;
histories= new ArrayList<ClinicalHistory>();
}
public String getNamePet(){
	return namePet;
}
public void setNamePet(String namePet){
	this.namePet = namePet;
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
	this.typeOfPet = typeOfPet;
}
public int getAgeOfPet(){
	return ageOfPet;
}
public void setAgeOfPet(int ageOfPet){
	this.ageOfPet = ageOfPet;
}









}