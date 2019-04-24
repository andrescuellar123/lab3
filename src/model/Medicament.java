package model;
public class Medicament{
//attributes
private String name;
private double dose;
private double doseCost;
private int frecuency;

//constructor 
 
 public Medicament (String name, double dose, double doseCost, int frecuency){
	
	 this.name = name;
	 this.dose = dose;
	 this.doseCost= doseCost;
	 this.frecuency = frecuency;
	 
 }
 public String getName(){
	 return name;
 }
public void setName(String name){
	this.name= name;
}
public double getDose(){
	return dose;
}
public void setDose(double dose){
	this.dose=dose;
}
public double getDoseCost(){
	return doseCost;
}
public void setDoseCost(double doseCost){
	this.doseCost=doseCost;
}
public int getFrecuency(){
	return frecuency;
}
public void setrFrecuency(int frecuency){
	this.frecuency=frecuency;
}

//new medicament deberia ir en el main?




// medicament information

public String ShowMedicamentInformation(){
 String msj = "";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "El nombre es:" + name + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "La dosis es:" + dose + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "El costo de la dosis es:" + doseCost + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj +="La frecuencia es:" + frecuency + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
	return msj;

}



	
	
}