package model;

import java.util.ArrayList;

public class Veterinary{
//attributes
private String name;
//Relations
private ArrayList<Client> clients;
private Room[] rooms;
private ArrayList<ClinicalHistory> histories;
//constructor
public Veterinary (String name){
	this.name= name;
	clients= new ArrayList<Client>();
	rooms= new Room[8];
	for(int i=0;i<rooms.length;i++) {
		rooms[i]=new Room(true);
	}
	histories = new ArrayList<ClinicalHistory>();
}
public String getName(){
	return name=name;
}
public void setName(String name){
	this.name=name;
}

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
public void addPetToAClient(String identityOfClient, String namePet, double weightPet, String typeOfPet, int ageOfPet) {
	Pet p= new Pet(namePet, weightPet, typeOfPet, ageOfPet);
	Client target= null;
	for(int i=0;i<clients.size();i++) {
		if(clients.get(i).getIdentity().equals(identityOfClient)) {
			target= clients.get(i);
		}
	}
	target.addPet(p);

}

public int positionRoomWithName(String namePet) {
	int position = -1;
	for(int i=0;i<rooms.length&& position==-1;i++) {
		if(rooms[i].getClinicalHistory().getNamePet().equals(namePet)) {
			position = i;
		}
	}

	return position;	
}

public String D_Alta(String namePet){
	int pos = positionRoomWithName(namePet);
	Room r= rooms[pos];
	ClinicalHistory hist= r.getClinicalHistory();
	hist.setState(ClinicalHistory.STATE_CLOSE);
	r.setHistoryAsociated(null);
	r.setAvailable(true);

	return "Diagnostic: "+ hist.getDiagnostic()+ " Race: "+ hist.getRace() + " Name Pet: "+hist.getNamePet()+ "weight pet:" + hist.getWeightPet() +"type Of Pet: " + hist.getTypeOfPet() + "age of pet: " + hist.getAgeOfPet() ;

}




}






