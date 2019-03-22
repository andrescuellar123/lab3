package model;
public class Medicaments{
//attributes
private String name;
private double dose;
private double doseCost;
private int frecuency;

//constructor 
 
 public Medicaments (String name, double dose, double doseCost, int frecuency){
	
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
	
	
}