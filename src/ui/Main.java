package ui;

import modelo.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
//Relacion
 private Scanner reader;
 private Veterinary vet;
 private Client cli;
 private Pet pe;
 
 public void init(){
	 
	 vet = new Veterinary("Mi pequenia mascota");
 }
 public Main() {

  init();
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
  System.out.println("*****************************2. informacion cliente   *********************************************************************************************************");
  System.out.println("**************************** 3. infromacion de mascota  *******************************************************************************************************");
  System.out.println("*****************************4. informacion del medicamento   *************************************************************************************************");
  System.out.println("*****************************5. informacion de la historia clinica ********************************************************************************************");
  System.out.println("**************************** 6. ********************************************************************************************************");
  System.out.println("*****************************7. Salir del sistema*************************************************************************************************************");
  System.out.println("**************************************************************************************************************************************************************");
  System.out.println("**************************************************************************************************************************************************************");
 
  while(userInput != 7){
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

   System.out.println("Cual es  la edad de su mascota? ");
   int ageOfPet = reader.nextInt();
   reader.nextLine();

   System.out.println("Cual es  tipo de su mascota? ");

   System.out.println("Perro ");
   System.out.println("Gato ");
   System.out.println("Pajaro ");
   System.out.println("Otro ");
   String animal = reader.nextLine();

   System.out.println("Cual es  el peso de su mascota? ");

   double weightOfPet = reader.nextDouble();
   reader.nextLine();
   
   Pet pet = new Pet(namePet, ageOfPet, animal, weightOfPet);
   clientsPets.add(pet);
   principal.addClient(client,clientsPets);
   System.out.println("Se ha añadido la mascota con exito");
   
	  }
	  }	  
   else if( userImput ==2){

   System.out.println(principal.showClinicalHistories());
   }
   else if(userImput == 3){

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


      Pet pets = principal.findPett(nameClie, idClie, namePe);

      ClinicalHistory newClinicalHistory = new ClinicalHistory( nameClie, namePe , symp, diag, stat, dateIn, pets);

      Medicament medicament = new Medicament(medi, dos, totaldos, frec);

      principal.hospitalizeVet(nameClie, idClie, namePe, newClinicalHistory, medicament);

	  System.out.println(principal.hospitalize(clientId, petName));

  }
  else if(userImput ==4){

    System.out.println(principal.ShowMedicamentInformation()); 
  }
  else if(userImput ==5){
     System.out.println("Cual es el dia actual?");
     int actualDay = reader.nextInt();
     reader.nextLine();

     System.out.println("Cual es el mes actual?");
     int actualMonth = reader.nextInt();
     reader.nextLine();

     System.out.println("Cual es el año actual?");
     int actualYear = reader.nextInt();
     reader.nextLine();

     principal.calculatedPay(actualDay, actualMonth, actualYear);
     System.out.println(principal.calculatedPay(actualDay, actualMonth, actualYear));


  }
  else if(userImput ==6){
    System.out.println(principal.showClients());

    System.out.println("Por favor digite la identificacion del usuario para dar de alto a su animal");
    String idClientt = reader.nextLong();
    reader.nextLine();

    System.out.println(" digite el nombre de su mascota para darle de alta");
    String nampe = reader.nextLine();

    System.out.println(principal.findToHospitalize(idClientt,nampe));
  }
  else{
	  
	  System.out.println("VUELVA PRONTO");
	  
	  }
	 }
   }
}