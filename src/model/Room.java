package model;

public class Room{

//attributes
private boolean available;
//Relations
private ClinicalHistory historyAsociated;
//constructor

public Room (boolean available){
    this.available=available;
    
}
public boolean getAvailable(){
	return available;
}
public void setAvailable(boolean available){
	this.available=available;
}

public void setHistoryAsociated(ClinicalHistory c) {
	historyAsociated=c;
}

public ClinicalHistory getClinicalHistory() {
	return historyAsociated;
}









}