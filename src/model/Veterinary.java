package model;

import java.util.ArrayList;

public class Veterinary{
//attributes
private String name;
//Relations
private ArrayList<Client> clients;
private Room[] rooms;
private ArrayList<ClinicalHistory> histories;
private ArrayList<Service> serviceVet;
//constructor
public Veterinary (String name){
	this.name= name;
	clients= new ArrayList<Client>();
	rooms= new Room[8];
	for(int i=0;i<rooms.length;i++) {
		rooms[i]=new Room(true);
	}
	histories = new ArrayList<ClinicalHistory>();
	serviceVet = new ArrayList<Service>();

}

public String getName(){
	return name=name;
}
/**
*Description este metodo establece el nombre de la veterinaria
*@param name String el nombre de la veterinaria
*/
public void setName(String name){
	this.name=name;
}




/**
*Description Este metodo obtiene el tipo de servicios
*@return Service el tipo de servicio
*/
public ArrayList<Service> getServiceVet(){
		return serviceVet;
	}

/**
*Description este metodo establece el tipo de servicios
*@param serviceVet ArrayList el tipo de servicio
**/

public void setTypeOfServiceVeterinary(ArrayList<Service> serviceVet){
		this.serviceVet = serviceVet;
	}

/**
*Description Este metodo agrega el tipo de servicios
*@param m typeOfService el tipo de servivio
*@param p Pet La mascota
*/
public void addServiceWithPet(Service m , Pet p){

serviceVet.add(m);
serviceVet.get((serviceVet.size()-1)).setPetTypeOfService(p);
}




/**
*Description este metodo agrega un cliente
*@param name String el nombre del cliente
*@param identity String la identidad del cliente
*@param address String la direcciondel cliente
*@param cellphone String el telefono del cliente
*/
public void addClient(String name, String identity, String address, String cellphone) {
	Client c= new Client(name, identity, address, cellphone);
	clients.add(c);
}
public int thereIsARoomAvaible() {
	int pos=-1;
	for(int i=0;i<rooms.length&&pos==-1;i++) {
		if(rooms[i].getAvailable()) {
			pos=i;
		}
	}
	return pos;
}
public ArrayList<ClinicalHistory> getReportOfClinicalHistoriesOfPetsHospitilized(){
	ArrayList<ClinicalHistory> report= new ArrayList<ClinicalHistory>();
	for(int i=0;i<rooms.length;i++) {
		if(!rooms[i].getAvailable()) {
			report.add(rooms[i].getClinicalHistory());
		}
	}
	return report;
}
public String getDataOfAClientByHisName(String name) {
	Client target= null;
	for(int i=0;i<clients.size();i++) {
		if(clients.get(i).getName().contentEquals(name)) {
			target= clients.get(i);
		}
	}
	return "name: "+target.getName()+" Identity: "+target.getIdentity()+" Address: "+target.getAddress();

}
/**
*Description este metodo trae los datos del cliente por el nombre de la mascota
*@param name String el nombre de la mascota
*@return String la respuesta
*/

public String getDataOfAClientByTheNameOfHisPet(String name) {
	Client target= null;
	boolean stop=false;
	for(int i=0;i<clients.size()&&!stop;i++) {
		if(clients.get(i).findPet(name)!= null) {
			stop=true;
			target= clients.get(i);
		}
	}
	String answer="";
	if(stop) {
		answer= "name: "+target.getName()+" Identity: "+target.getIdentity()+" Address: "+target.getAddress();
	}else {
		answer= "Client not found";
	}
	return answer;
}
/**
*Description este metodo da la hospitalizacion
*@param symptom String el sintoma de la mascota
*@param diagnostic String el diagnostico de la mascota
*@param race String la raza de la mascota
*@param namePet String el nombre de la mascota
*@param weightPet double el peso de la mascota
*@param typeOfPet String el tipo de la mascota
*@param ageOfPet int los anios de la mascota
*@param day int el dia de la hospitalizacion
*@param month int el mes de la hospitalizacion
*@param year int el anio de la hospitalizacion
*@param identificationOfClient String la idnetificacion del cliente
*@return boolean hospializado
*/

public boolean hospitilizeAPet(String symptom, String diagnostic , String race, String namePet,double weightPet , String typeOfPet, int ageOfPet, int day, int month, int year, String identificationOfClient) {
	Client target= null;
	for(int i=0;i<clients.size();i++) {
		if(clients.get(i).getIdentity().equals(identificationOfClient)) {
			target= clients.get(i);
		}
	}
	ClinicalHistory h= new ClinicalHistory(symptom, diagnostic, ClinicalHistory.STATE_OPEN, race, namePet, weightPet, typeOfPet, ageOfPet, day, month, year, target);
	int posOfRoom= thereIsARoomAvaible();
	boolean added=false;
	if(posOfRoom!=-1) {
		added=true;
		Room r= rooms[posOfRoom];
		r.setAvailable(false);
		r.setHistoryAsociated(h);
		histories.add(h);
		target.findPet(namePet).addClinicalHistory(h);
	}
	return added;
}
/**
*Description este metodo agrega una mascota
*@param identityOfClient String la identidad del cliente
*@param namePet String el nombre de la mascota
*@param weightPet double el peso de la mascota
*@param typeOfPet String el tipo de la mascota
*@param ageOfPet int los anios de la mascota
*@param heightPet double alto de la mascota
*@param identity String identidad de la mascota
*/
public void addPetToAClient(String identityOfClient, String namePet, double weightPet, String typeOfPet, int ageOfPet , double heightPet, String identity) {
	Pet p= new Pet(namePet, weightPet,  typeOfPet, ageOfPet , heightPet,  identity);
	Client target= null;
	for(int i=0;i<clients.size();i++) {
		if(clients.get(i).getIdentity().equals(identityOfClient)) {
			target= clients.get(i);
		}
	}
	target.addPet(p);

}
/**
*Description este metodo posicion del cuarto con el nombre
*@param namePet String el nombre de la mascota
*@return int la posicion
*/
public int positionRoomWithName(String namePet) {
	int position = -1;
	for(int i=0;i<rooms.length&& position==-1;i++) {
		if(rooms[i].getClinicalHistory().getNamePet().equals(namePet)) {
			position = i;
		}
	}

	return 	position;	
}
/**
*Description este metodo da d alta al animal
*@param  namePet String el nombre de la mascota
*@return String la informacion de la mascota
*/

public String D_Alta(String namePet){
	int pos = positionRoomWithName(namePet);
	Room r= rooms[pos];
	ClinicalHistory hist= r.getClinicalHistory();
	hist.setState(ClinicalHistory.STATE_CLOSE);
	r.setHistoryAsociated(null);
	r.setAvailable(true);

	return "Diagnostic: "+ hist.getDiagnostic()+ " Race: "+ hist.getRace() + " Name Pet: "+hist.getNamePet()+ "weight pet:" + hist.getWeightPet() +"type Of Pet: " + hist.getTypeOfPet() + "age of pet: " + hist.getAgeOfPet() ;

}
//nuevo info

/**
*Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
*pre: The client was created before.
*post: The address and /or phone number of the client is updated.
*@param  identity String of the client
*@param  nAddress String of the client. This param could be empty.
*@param  nPhone String number of the client. This param could be empty.
*/

public void updateBasicInformation( String identity, String nAddress, String nPhone){
	
	for(int i = 0; i < clients.size() ; i++ ){
		if(clients.get(i).getIdentity().equals(identity)){
				Client toModify = clients.get(i);
				if(nAddress!= null &&!nAddress.equals("")){
					toModify.setAddress(nAddress);
				}
				if(nPhone != null && !nPhone.equals("")){
					toModify.setCellphone(nPhone);
				}
				
			
		}
	}
}



/**
*Description esste metodo genera un reporte acerca de la informacion que se encuentre en esas fechas
*pre: la fecha se debe digitar  asi AAAA-MM-DD
*@param admissionDate String la fecha de ingreso
*@param DepartureDate String la fecha salida
*@return String el tipo de servicio que se le hizo a la mascota
*/
public String getReportWithDate(String admissionDate,String DepartureDate){
String msg = "";

for(int i = 0; i < serviceVet.size();i++){
Service de = serviceVet.get(i);

if(admissionDate.compareTo(de.getDate()) <= 0 && de.getDate().compareTo(DepartureDate) <= 0){

  msg = "El reporte es:" + "\n" +de.reportInformation();

}else{
  msg = "fecha erronea";
}


}

return msg;

}



/**
*Description esste metodo calcula cuantas veces aparece el servicio 1
*pre: Servicio !=null
*post: las veces que aparece el servicio 1
*@return int el numero de veces del servicio 1
*/
public int  calculateappearences1(){
	int i  = 0;

for(int p = 0; p < serviceVet.size(); p++){
Service services = serviceVet.get(i);
	if(services.getService().equals(Service.service1)){
			i++;
	}
}
return i;
}
/**
*Description este metodo calcula el servicio 1
*pre: Servicio !=null
*post: el costo del servicio 1
*@return double el costo del servicio
*/
public double calculatedService1(){
  double m = 0.0;

for(int i = 0; i < serviceVet.size(); i++){
Service services = serviceVet.get(i);

if(services.getService().equals(Service.service1)){
  m += Service.wash;
}

}
return m;
}







/**
*Description este metodo calcula cuantas veces aparece el servicio 2
*pre: Servicio !=null
*post: las veces que aparece el servicio 2
*@return int el numero de veces del servicio 2
*/
public int  calculateappearences2(){
	int i  = 0;

for(int p = 0; p < serviceVet.size(); p++){
Service services = serviceVet.get(i);
	if(services.getService().equals(Service.service2)){
			i++;
	}
}
return i;
}

/**
*Description este metodo calcula el servicio 2
*pre: Servicio !=null
*post: el costo del servicio 2
*@return double el costo del servicio
*/

public double calculatedService2(){
  double m = 0.0;

for(int i = 0; i < serviceVet.size(); i++){
Service services = serviceVet.get(i);

if(services.getService().equals(Service.service2)){
  m += Service.washPetDom;
}

}
return m;
}







/**
*Description esste metodo calcula cuantas veces aparece el servicio 3
*pre: Servicio !=null
*post: las veces que aparece el servicio 3
*@return int el numero de veces del servicio 3
*/
public int  calculateappearences3(){
	int i  = 0;

for(int p = 0; p < serviceVet.size(); p++){
Service services = serviceVet.get(i);
	if(services.getService().equals(Service.service3)){
			i++;
	}
}
return i;
}

/**
*Description este metodo calcula el servicio 3
*pre: Servicio !=null
*post: el costo del servicio 3
*@return double el costo del servicio
*/

public double calculatedService3(){
  double m = 0.0;

for(int i = 0; i < serviceVet.size(); i++){
Service services = serviceVet.get(i);

if(services.getService().equals(Service.service3)){
  m += Service.cut;
}

}
return m;
}





/**
*Description esste metodo calcula cuantas veces aparece el servicio 4
*pre: Servicio !=null
*post: las veces que aparece el servicio 4
*@return int el numero de veces del servicio 4
*/
public int  calculateappearences4(){
	int i  = 0;

for(int p = 0; p < serviceVet.size(); p++){
Service services = serviceVet.get(i);
	if(services.getService().equals(Service.service4)){
			i++;
	}
}
return i;
}

/**
*Description este metodo calcula el servicio 4
*pre: Servicio !=null
*post: el costo del servicio 4
*@return double el costo del servicio
*/

public double calculatedService4(){
  double m = 0.0;

for(int i = 0; i < serviceVet.size(); i++){
Service services = serviceVet.get(i);

if(services.getService().equals(Service.service4)){
  m += Service.dent;
}

}
return m;
}





/**
*Description esste metodo calcula cuantas veces aparece el servicio 5
*pre: Servicio !=null
*post: las veces que aparece el servicio 5
*@return int el numero de veces del servicio 5
*/
public int calculateappearences5(){
	int i  = 0;

for(int p = 0; p < serviceVet.size(); p++){
Service services = serviceVet.get(i);
	if(services.getService().equals(Service.service5)){
			i++;
	}
}
return i;
}

/**
*Description este metodo calcula el servicio 5
*pre: Servicio !=null
*post: el costo del servicio 5
*@return double el costo del servicio
*/

public double calculatedService5(){
  double m = 0.0;

for(int i = 0; i < serviceVet.size(); i++){
Service services = serviceVet.get(i);

if(services.getService().equals(Service.service5)){
  m += Service.vacunnes;
}

}
return m;
}

/**
* Description este metodo calcula la suma de  todos los servicios
* @return double el costo total de los servicios totales
*/
public double calculateTotalService(){
double h = 0.0;

h += (calculatedService1() + calculatedService2() + calculatedService3() + calculatedService4() + calculatedService5());

return h;

}


/**
*Description este metodo calcula el promedio de los costos 
*@return double el promedio de costos
*/
public double promeOfTheServices(){
double prom = 0.0;

prom += (calculatedService1() + calculatedService2() + calculatedService3() + calculatedService4() + calculatedService5())/( calculateappearences1()+ calculateappearences2()+ calculateappearences3()+ calculateappearences4()+ calculateappearences5());

return prom;

}



/**
* Description este metodo calcula la ganancia de la veterinaria en una semana
* @param currentDay int el dia actual
* @return double la ganancia en una semana
*/
public double earningsForWeek(int currentDay){

double week = 0.0;
int currentDate = (currentDay + 7);

if(currentDate > 30){
   week = calculateTotalService()/(currentDate % 30);
}else if(currentDate < 30){
   week = calculateTotalService()/currentDate;
}


return week;


}




}






