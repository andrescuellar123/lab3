package model;
import java.util.GregorianCalendar;
import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.ArrayList;

public class Service{
	
	//constants
	public final static String BANIO       = "banio";
	public final static String BANIO_DOM   = "banio_dom";
	public final static String UNIAS       = "unias";
	public final static String DENTAL      = "dental";
	public final static String VACUNA      = "vacuna";
	
	//attributes 
	
	private double cost;
	private int date; // se puede hacer con los import date
	private String service;
	
	//relations
	private ArrayList<Client> cli;
	private ArrayList<Pet> pt;
	
	//constructor 
	
	public Service(double cost , int date , String service){
		this.cost = cost ;
		this.date = date;
		this.service = service;
	}
	
	public double getCost(){
		return cost;
	}
	public void setCost(double cost){
		this.cost = cost;
	}
	public int getDate(){
		return date;
	}
	public void setDate(int date){
		this.date = date;
	}
	public String getService(){
	return service;
	}
	public void setService(String service){
	this.service=service;
	}
	
	
	
	//nuevo servicio

public double calculateCostService(){
	double cost = 0;
	if(service.equals(BANIO)){
		cost = 20000;	
	}
	else if(service.equals( BANIO_DOM)){
		cost= 30000;
	}
	else if(service.equals(UNIAS )){
		cost= 8000;
	}
	else if(service.equals(DENTAL)){
		cost = 12000;
	}
	else if(service.equals(VACUNA)){
		cost = 45000;
	}
	return cost;
}
 

//dias 


}