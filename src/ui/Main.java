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
 private Service ser;

 public Main() {
  init();
  reader = new Scanner(System.in);

}

public static void main(String[] args) {

Main m = new Main();
m.showMenu();

}

public void showMenu(){



  int userInput = 0;

  System.out.println("***************************************************************************************************************************************************************");
  System.out.println("*****************************VETERINARY MI PEQUEÑA MASCOTA ****************************************************************************************************");
  System.out.println("*****************************1. Registrarse con la mascota ****************************************************************************************************");
  System.out.println("*****************************2. hospitalizar la mascota    ****************************************************************************************************");
  System.out.println("**************************** 3. calcular lo de una semana  ****************************************************************************************************");
  System.out.println("*****************************4. dar D alta                 ****************************************************************************************************");
  System.out.println("**************************** 6. calcular el servicio       ****************************************************************************************************");
  System.out.println("*****************************7. promedio de los servicios  ******************************************************************************************************");
  System.out.println("*****************************8. total costo                **************************************************************************************************");
  System.out.println("*****************************9. generar reporte de servicios************************************************************************************************");
  System.out.println("*****************************10.reporte con fecha inicial y final*******************************************************************************************");
  System.out.println("*****************************11. Salir del sistema          *************************************************************************************************");
  System.out.println("**************************************************************************************************************************************************************");
  System.out.println("**************************************************************************************************************************************************************");
 
  while(userInput != 10){
	  if(userInput == 1){
		  		  
   System.out.println("Cual es el nombre del cliente?");
   String name = reader.nextLine();

   System.out.println("Cual es la identificacion?");
   String identity = reader.nextLine();

   System.out.println("Cual es su dirección? ");
   String address = reader.nextLine();

   System.out.println("Cual es su celular?");
   String cellphone = reader.nextLine();
   
   
  Client client= new Client (name, identity, address, cellphone);
  
  
   System.out.println("Cuantas mascotas quiere que atiendan ?");
   int numb = reader.nextInt();
   reader.nextLine();

   ArrayList<Pet> clientPet = new ArrayList<Pet>();
      for(int i = 0; i < numb ; i++){
   System.out.println("Cual es  el nombre de su mascota? ");
   String namePet = reader.nextLine();
   
   System.out.println("Cual es  el peso de su mascota? ");

   double weightPet = reader.nextDouble();
   reader.nextLine();
   
   System.out.println("Cual es  tipo de su mascota? ");

   System.out.println("Perro ");
   System.out.println("Gato ");
   System.out.println("Pajaro ");
   System.out.println("Otro ");
   String typeOfPet = reader.nextLine();

   System.out.println("Cual es  la edad de su mascota? ");
   int ageOfPet = reader.nextInt();
   reader.nextLine();

   System.out.println("Cual es  el alto de la mascota? ");
   double heightPet = reader.nextDouble();
   reader.nextDouble();
   
 
  
   
   Pet pet1 = new Pet( namePet, weightPet,  typeOfPet, ageOfPet , heightPet,  identity);
   clientPet.add(pet1);
   vet.addClient( name,  identity,  address,  cellphone);
   System.out.println("Se ha añadido la mascota con exito");
   
	}
	  }	  
   else if(userInput == 2){

      System.out.println("Cual es el id del cliente?");
      String identity = reader.nextLine();
      reader.nextLine();

      System.out.println("Cual es  el nombre de la mascota?");
      String petName = reader.nextLine();
	
	  System.out.println("Cual es  el dia de ingreso?");
      int day = reader.nextInt();
      reader.nextLine();

      System.out.println("Cual es  el mes de ingreso?");
      int month = reader.nextInt();
      reader.nextLine();

      System.out.println("Cual es  anio de ingreso? ");
      int year = reader.nextInt();
      reader.nextLine();

      HistorialDate da = new HistorialDate( day,  month,  year);
	  
	  System.out.println("Cual es  nombre del dueño? ");
      String name = reader.nextLine();

      System.out.println("Cual es  el id del cliente?");
      String identificationOfClient = reader.nextLine();
      reader.nextLine();

      System.out.println("Cual es  el nombre completo de la mascota?");
      String namePet = reader.nextLine();

      System.out.println("Cual es  el sintoma del animal?");
      String symptom = reader.nextLine();

      System.out.println("Cual es el diagnostico ?");
      String diagnostic = reader.nextLine();
	  
	  System.out.println("Cual es la raza ?");
      String race = reader.nextLine();

      System.out.println("Cual es el estado?");
      String state = reader.nextLine();
      reader.nextLine();

      System.out.println("Cual es el nombre del medicamento?");
      String nameM = reader.nextLine();

      System.out.println("Cual es la dosis?");
      double dose = reader.nextDouble();
      reader.nextLine();
	  
	  System.out.println("Cual es el costo dosis?");
      double doseCost = reader.nextDouble();
      reader.nextLine();
	  
      System.out.println("Cual es la frecuencia?");
      int frecuency = reader.nextInt();
      reader.nextLine();
	  
	   System.out.println("Cual es el peso?");
	  double weightPet = reader.nextDouble();
      reader.nextLine();
	  
       System.out.println("Cual es  tipo de su mascota? ");

      System.out.println("Perro ");
	  System.out.println("Gato ");
	  System.out.println("Pajaro ");
      System.out.println("Otro ");
      String typeOfPet = reader.nextLine();
	  
	  System.out.println("Cual es  la edad de su mascota? ");
      int ageOfPet = reader.nextInt();
      reader.nextLine();
	  
	  
	  
	
   System.out.println("Cual es su dirección? ");
   String address = reader.nextLine();

   System.out.println("Cual es su celular?");
   String cellphone = reader.nextLine();
   
   
  Client client= new Client (name, identity, address, cellphone);
	  
	 Client c = new Client(name, identity, address, cellphone);

    

      ClinicalHistory newClinicalHistory = new ClinicalHistory(  symptom,  diagnostic ,  state,  race,  namePet, weightPet ,  typeOfPet,  ageOfPet,  day,  month,  year,  c );

      Medicament medicament = new Medicament( nameM,  dose,  doseCost,  frecuency);

      vet.hospitilizeAPet( symptom,  diagnostic ,  race,  namePet, weightPet ,  typeOfPet,  ageOfPet,  day,  month,  year,  identificationOfClient);

	  System.out.println(vet.hospitilizeAPet( symptom,  diagnostic ,  race,  namePet, weightPet ,  typeOfPet,  ageOfPet,  day,  month,  year,  identificationOfClient));

  }
  
  else if(userInput ==3){
     System.out.println("Cual es el dia actual?");
     int currentDay = reader.nextInt();
     reader.nextLine();

  
     vet.earningsForWeek(currentDay);
     System.out.println(vet.earningsForWeek( currentDay));


  }
  else if(userInput ==4){

    System.out.println("Por favor digite el nombre del usuario para dar de alto a su animal");
    String namePet = reader.nextLine();
    reader.nextLine();


    System.out.println(vet. D_Alta( namePet));
  }


  else if(userInput == 5){

System.out.println("El costo del servicio de lavado de mascotas es:" + vet.costService1());
System.out.println("El costo del servicio de lavado de mascotas a domicilios es:" + vet.costService2());
System.out.println("El costo del servicio de corte de uñas de mascotas es:" + vet.costService3());
System.out.println("El costo del servicio de profilaxis dental mascotas es:" + vet.costService4());
System.out.println("El costo del servicio de aplicacion de vacunas para mascotas es:" + vet.costService5());

}
else if(userInput == 6){

System.out.println(vet.promeOfTheServices());


}
else if(userInput == 7){

System.out.println("El ingreso total de los servicios es:" + vet.calculateTotalService());

}
else if(userInput == 8){

System.out.println("El el reporte de los servicios es:" + ser.reportInformation());

}else if(userInput == 9){   


System.out.println("Por favor digite la fecha inicial de esta forma: anio/mes/dia : ");

String admissionDate = reader.nextLine();

System.out.println("Por favor digite la fecha final de esta forma: anio/mes/dia : ");

String departureDate = reader.nextLine();

System.out.println(vet.getReportWithDate(admissionDate,departureDate));


}
 
  else{
	  
	  System.out.println("VUELVA PRONTO");
	  
	  }
	}
}
public void init(){
 vet = new Veterinary("Mi pequenia mascota");
		
	 
	  
	  
	  
	  
	 Client Pepe = new Client("Pepe","1006098152","calle", "3308206");
	 Pet misifus = new Pet("misifus",15.0,"C",10,1.5,"1234");
	 ArrayList<Pet> petClient1 = new ArrayList<Pet>();
	 petClient1.add(misifus);
	 vet.addClient("Pepe","1006098152","calle", "3308206");
	   
	 Client Carlos = new Client("Carlos","1006098153","calle","3312678");
	 Pet Rodolfo = new Pet("Rodolfo",16.0,"D",5,1.9,"1235");
	 ArrayList<Pet> petClient2 = new ArrayList<Pet>();
	 petClient2.add(Rodolfo);
	 vet.addClient("Carlos","1006098153","calle","3312678");
	 
	 
	 

}

}