package model;
public class HistorialDate{

//attributes
private int day;
private int month ;
private int year;

//constructor
/**
*Description este constructor inicializa las variables
*@param day int dia de la historia clinica
*@param month int mes de la historia clinica
*@param year int anio de la historia clinica 
*/
public HistorialDate (int day, int month, int year ){
	this.day= day;
	this.month=month;
	this.year= year;
}
/**
*Description el metodo nos da los dia de la historia
*@return int el dia de la mascota
*/
public int getDay(){
	return day;
}
/**
*Description este metodo establece el dia de la historia
*@param day int el dia de la historia
*/
public void setDay(int day){
	this.day = day;
}
/**
*Description el metodo nos da los dia de la historia
*@return int el dia de la mascota
*/
public int getMonth(){
	return month;
}
/**
*Description este metodo establece el mes de la historia
*@param month int el mes de la historia
*/
public void setMonth(int month){
	this.month= month;

}
/**
*Description el metodo nos da los anios de la historia
*@return int el anios de la mascota
*/
public int getYear(){
	return year;
}
/**
*Description este metodo establece el anio de la historia
*@param year int el anio de la historia
*/
public void setYear(int year){
	this.year=year;
}


}