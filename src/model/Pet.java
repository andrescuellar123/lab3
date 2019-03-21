package model;
public class Pet{
	
//constants

public final static  dog = "D";
public final static cat = "C";
public final static bird = "B";
public final static other = "O";

//attributes

private String namePet;
private double weightPet;
private String typeOfPet;
private int ageOfPet;

//constructor

public Pet (String namePet, double weightPet, String typeOfPet, int ageOfPet){
this.namePet = namePet;
this.weightPet = weightPet;
this.typeOfPet =typeOfPet;
this.ageOfPet = ageOfPet;
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