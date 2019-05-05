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
private double heightPet;
private String identity;
//Relations
private ArrayList<ClinicalHistory> histories;

//constructor
/**
*Description este constructor inicializa las variables
*@param namePet String el nombre del animal
*@param weightPet double el peso del animal
*@param typeOfPet String el tipo del animal
*@param ageOfPet int la edad del animal
*@param heightPet double la altura del animal
*@param identity String la identidad del animal
*/

public Pet (String namePet, double weightPet, String typeOfPet, int ageOfPet , double heightPet, String identity){
this.namePet = namePet;
this.weightPet = weightPet;
this.typeOfPet =typeOfPet;
this.ageOfPet = ageOfPet;
histories= new ArrayList<ClinicalHistory>();
this.heightPet = heightPet;
this.identity = identity;
}
public void addClinicalHistory(ClinicalHistory c) {
	histories.add(c);
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
	this.namePet = namePet;
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
*@param weightPet double el peso de la mascota
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
	this.typeOfPet = typeOfPet;
}
/**
*Description el metodo nos da los anios de la mascota
*@return int los anios de la mascota
*/
public int getAgeOfPet(){
	return ageOfPet;
}
/**
*Description este metodo establece los anios de la mascota
*@param ageOfPet int los anios de la mascota
*/
public void setAgeOfPet(int ageOfPet){
	this.ageOfPet = ageOfPet;
}
/**
*Description el metodo nos da el alto de la mascota
*@return double el alto de la mascota
*/
public double getHeightPet(){
	return heightPet;
}
/**
*Description este metodo establece el alto de la mascota
*@param heightPet double el alto de la mascota
*/
public void setHeightPet(double heightPet){
	this.heightPet= heightPet;
}
/**
*Description el metodo nos da la identidad
*@return String la identidad de la mascota
*/
public String getIdentity(){
	return identity;
}
/**
*Description este metodo establece la identidad de la mascota
*@param identity String la identidad de la mascota
*/
public void setIdentity(String identity){
	this.identity = identity;
}

/**
*Description This method allows to calculate the body mass index for a pet.
*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
*post: The BMI is calculated.
*@return The pet body mass index. Returns -1 if the height is zero  due to the division on zero does not exist.
*/

//Pet imc

public double calculateIBMOfAnimal(){

return weightPet/(heightPet * heightPet);

}



}


