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
}