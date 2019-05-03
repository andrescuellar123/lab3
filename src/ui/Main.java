package ui;

import model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
//Relacion
 private Scanner reader;
 private Veterinary vet;
 private Client cli;
 private Pet pe;
 private Medicament me;
 
 public void init(){
	 
	 vet = new Veterinary("Mi pequenia mascota");
	 
	   Pet pet1 = new Pet("misifus",15.0,"C",10,1.5,15.0,"1234");
	  Pet pet2 = new Pet("Rodolfo",16.0,"D",5,1.9,16.0,"1235");
	  
	  
	  
	 Client client1 = new Client("Pepe","1006098152","calle", 3308206);
	 Client client2 = new Client("Carlos","1006098153","calle",3312678);
 }
 public Main() {

  reader = new Scanner(System.in);

}

public static void main(String[] args) {

Main m = new Main();
m.init();
m.showMenu();

}

public void showMenu(){



  int userInput = 0;

  System.out.println("***************************************************************************************************************************************************************");
  System.out.println("*****************************VETERINARY MI PEQUEÑA MASCOTA ****************************************************************************************************");
  System.out.println("*****************************1. Registrarse con la mascota    *************************************************************************************************");
  System.out.println("*****************************2. informacion cliente y mascota *************************************************************************************************");
  System.out.println("**************************** 3. infromacion actual  ***********************************************************************************************************");
  System.out.println("*****************************4. informacion del medicamento   *************************************************************************************************");
  System.out.println("*****************************5. informacion de la historia clinica ********************************************************************************************");
  System.out.println("**************************** 6. ********************************************************************************************************");
  System.out.println("*****************************7. Salir del sistema*************************************************************************************************************");
  System.out.println("**************************************************************************************************************************************************************");
  System.out.println("**************************************************************************************************************************************************************");
 
  while(userInput != 5){
	  if(userInput == 1){
		  		  
   System.out.println("Cual es el nombre del cliente?");
   String name = reader.nextLine();

   System.out.println("Cual es la identificacion?");
   String identity = reader.nextLine();

   System.out.println("Cual es su dirección? ");
   String address = reader.nextLine();

   System.out.println("Cual es su celular?");
   String cellphone = reader.nextLine();
   
   
  Clien client= new Client (name, identity, address, cellphone);
  
  
   System.out.println("Cuantas mascotas que quiere tener?");
   int numb = reader.nextInt();
   reader.nextLine();

   ArrayList<Pet> clientsPets = new ArrayList<Pet>();
      for(int i = 0; i < numb ; i++){
   System.out.println("Cual es  el nombre de su mascota? ");
   String namePet = reader.nextLine();
   
     System.out.println("Cual es  el peso de su mascota? ");

   double weightOfPet = reader.nextDouble();
   reader.nextLine();
   
      System.out.println("Cual es  tipo de su mascota? ");

   System.out.println("Perro ");
   System.out.println("Gato ");
   System.out.println("Pajaro ");
   System.out.println("Otro ");
   String animal = reader.nextLine();

   System.out.println("Cual es  la edad de su mascota? ");
   int ageOfPet = reader.nextInt();
   reader.nextLine();

   System.out.println("Cual es  el alto de la mascota? ");
   double heightPet = reader.nextDouble();
   reader.nextDouble();
   
   
   System.out.println("Cual es  el imc de la mascota? ");
   double imc = reader.nextDouble();
   reader.nextDouble();
 
   
   Pet pet = new Pet( namePet, weightPet,  typeOfPet, ageOfPet , heightPet, imc,  identity);
   clientsPets.add(pet);
   vet.addClient(client,clientsPets);
   System.out.println("Se ha añadido la mascota con exito");
   
	}
	  }	  
   else if(userImput == 2){

      System.out.println("Cual es el id del cliente?");
      long clientId = reader.nextLong();
      reader.nextLine();

      System.out.println("Cual es  el nombre de la mascota?");
      String petName = reader.nextLine();
	
	  System.out.println("Cual es  el dia de ingreso?");
      int day = reader.nextInt();
      reader.nextLine();

      System.out.println("Cual es  el mes de ingreso?");
      int month = reader.nextInt();
      reader.nextLine();

      System.out.println("Cual es  año de ingreso? ");
      int year = reader.nextInt();
      reader.nextLine();

      HistorialDated dateIn = new HistorialDated(dai, mon, yea);
	  
	  System.out.println("Cual es  nombre del dueño? ");
      String nameClie = reader.nextLine();

      System.out.println("Cual es  el id del cliente?");
      long idClie = reader.nextLong();
      reader.nextLine();

      System.out.println("Cual es  el nombre completo de la mascota?");
      String namePe = reader.nextLine();

      System.out.println("Cual es  el sintoma del animal?");
      String symp = reader.nextLine();

      System.out.println("Cual es el diagnostico ?");
      String diag = reader.nextLine();

      System.out.println("Cual es el estado?");
      boolean stat = reader.nextBoolean();
      reader.nextLine();

      System.out.println("Cual es el nombre del medicamento?");
      String medi = reader.nextLine();

      System.out.println("Cual es la dosis?");
      double dos = reader.nextDouble();
      reader.nextLine();

      System.out.println("Cual es la  dosis total?");
      double totaldos = reader.nextDouble();
      reader.nextLine();

      System.out.println("Cual es la frecuencia del medicamento?");
      int frec = reader.nextInt();
      reader.nextLine();


      Pet pets = vet.findPett(nameClie, idClie, namePe);

      ClinicalHistory newClinicalHistory = new ClinicalHistory( nameClie, namePe , symp, diag, stat, dateIn, pets);

      Medicament medicament = new Medicament(medi, dos, totaldos, frec);

      vet.hospitalizeVet(nameClie, idClie, namePe, newClinicalHistory, medicament);

	  System.out.println(vet.hospitalize(clientId, petName));

  }
  
  else if(userImput ==3){
     System.out.println("Cual es el dia actual?");
     int actualDay = reader.nextInt();
     reader.nextLine();

     System.out.println("Cual es el mes actual?");
     int actualMonth = reader.nextInt();
     reader.nextLine();

     System.out.println("Cual es el año actual?");
     int actualYear = reader.nextInt();
     reader.nextLine();

     vet.calculatedPay(actualDay, actualMonth, actualYear);
     System.out.println(vet.calculatedPay(actualDay, actualMonth, actualYear));


  }
  else if(userImput ==4){
    System.out.println(vet.showClients());

    System.out.println("Por favor digite la identificacion del usuario para dar de alto a su animal");
    String idClientt = reader.nextLong();
    reader.nextLine();

    System.out.println(" digite el nombre de su mascota para darle de alta");
    String nampe = reader.nextLine();

    System.out.println(vet.findToHospitalize(idClientt,nampe));
  }
  else{
	  
	  System.out.println("VUELVA PRONTO");
	  
	  }
	 }
   }
   
 
	  
	
  
}