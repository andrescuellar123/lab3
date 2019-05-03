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
private double imc;
private String identity;
//Relations
private ArrayList<ClinicalHistory> histories;

//constructor

public Pet (String namePet, double weightPet, String typeOfPet, int ageOfPet , double heightPet, double imc, String identity){
this.namePet = namePet;
this.weightPet = weightPet;
this.typeOfPet =typeOfPet;
this.ageOfPet = ageOfPet;
histories= new ArrayList<ClinicalHistory>();
this.heightPet = heightPet;
this.imc= imc
this.identity = identity;
}
public void addClinicalHistory(ClinicalHistory c) {
	histories.add(c);
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
public double getHeightPet(){
	return heightPet;
}
public void setHeightPet(double heightPet){
	this.heightPet= heightPet;
}
public double getImc(){
	return imc;
}
public void setImc(double imc){
	this.imc = imc;
}
public String getIdentity(){
	return identity;
}
public void setIdentity(String identity){
	this.identity = identity;
}


//Pet imc

public  double calculatePetIMC(){
  double imc11 = 0;
  double imc22 = 0;

  imc11 +=getWeightPet();
  imc22 +=getHeightPet();


 imc = imc11 / (imc22 * imc22);

  return imc;
}



	//Show information about pet
	
 public String showInfoPet(){
 String msj = "";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "El nombre es:" + namePet + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "La edad es:" + ageOfPet + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "El peso es:" + weightPet + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj +="El tipo de mascota es:" + typeOfPet + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
	return msj;

}








}