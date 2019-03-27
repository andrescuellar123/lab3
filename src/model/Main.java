package ui;

import modelo.*;
import java.util.Scanner;

public class Main{
//Relacion
 private Scanner reader;

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
  System.out.println("*****************************VETERINARY MI PEQUEÑA MASCOTA***************************************************************************************************");
  System.out.println("*****************************1. Registrarse con la mascota   ********************************************************************************************************");
  System.out.println("*****************************2. informacion cliente  ********************************************************************************************************");
  System.out.println("**************************** 3. Crear nuevos kangaroos *******************************************************************************************************");
  System.out.println("*****************************4. Mostrar el Kangaroo con mas vocales*******************************************************************************************");
  System.out.println("*****************************5. ver fecha de vacuna        ***************************************************************************************************");
  System.out.println("**************************** 6. cambiar a los canguros********************************************************************************************************");
  System.out.println("*****************************7. Salir del sistema*************************************************************************************************************");
  System.out.println("**************************************************************************************************************************************************************");
  System.out.println("**************************************************************************************************************************************************************");
 
     
	  else if(userInput == 1){
		  
   System.out.println("Digite el nombre del cliente");
   String name = reader.nextLine();

   System.out.println("Digite su identificacion");
   String identity = reader.nextLong();
   reader.nextLine();

   System.out.println("Digite su dirección ");
   String address = reader.nextLine();

   System.out.println("Digite su celular");
   String cellphone = reader.nextLine();
   
   
  Clien client= new Client (String name, String identity, String address, String cellphone)
  
  
   System.out.println("Digite el numero de mascotas que quiere tener");
   int 	 = reader.nextInt();
   reader.nextLine();

   ArrayList<Pet> clientsPets = new ArrayList<Pet>();
   
    for(int i = 0; i < numberOfUser; i++){
   System.out.println("Digite el nombre de su mascota ");
   String namePet = reader.nextLine();

   System.out.println("Digite la edad de su mascota ");
   int ageOfPet = reader.nextInt();
   reader.nextLine();

   System.out.println("Digite el tipo de su mascota ");

   System.out.println("Perro ");
   System.out.println("Gato ");
   System.out.println("Pajaro ");
   System.out.println("Otro ");
   String typeOfM = reader.nextLine();

   System.out.println("Digite el peso de su mascota ");

   double weightOfPet = reader.nextDouble();
   reader.nextLine();
   
  Pet pet = new Pet(namePet, ageOfPet, typeOfPet, weightOfPet);
   clientsPets.add(pet);
   principal.addClient(client,clientsPets);
   System.out.println("Se ha añadido la mascota con exito");
 }
   
   else if( userImput ==2){

   System.out.println(principal.showClinicalHistories());
   }
   else if(userImput == 3){

    System.out.println("Ponga el id del cliente");
    long clientId = reader.nextLong();
    reader.nextLine();

    System.out.println("Ponga el nombre de la mascota");
    String petName = reader.nextLine();

    System.out.println(principal.hospitalize(clientId, petName));

  }
  else if(userImput ==4){

      System.out.println("Digite el dia de ingreso");
      int day = reader.nextInt();
      reader.nextLine();

      System.out.println("Digite el mes de ingreso");
      int month = reader.nextInt();
      reader.nextLine();

      System.out.println("Digite el año de ingreso ");
      int year = reader.nextInt();
      reader.nextLine();

      HistorialDated dateIn = new HistorialDated(dai, mon, yea);
	  
	  System.out.println("Digite el nombre del dueño ");
      String nameClie = reader.nextLine();

      System.out.println("Digite el id del cliente");
      long idClie = reader.nextLong();
      reader.nextLine();

      System.out.println("Digite el nombre completo de la mascota");
      String namePe = reader.nextLine();

      System.out.println("Digite el sintoma del animal");
      String symp = reader.nextLine();

      System.out.println("Digite el diagnostico ");
      String diag = reader.nextLine();

      System.out.println("Digite el estado");
      boolean stat = reader.nextBoolean();
      reader.nextLine();

      System.out.println("Digite el nombre del medicamento");
      String medi = reader.nextLine();

      System.out.println("Digite la dosis");
      double dos = reader.nextDouble();
      reader.nextLine();

      System.out.println("Digite la total de dosis");
      double totaldos = reader.nextDouble();
      reader.nextLine();

      System.out.println("Digite la frecuencia del medicamento");
      int frec = reader.nextInt();
      reader.nextLine();


      Pet pet2 = principal.findPett(nameClie, idClie, namePe);

      ClinicalHistory newMedRec = new ClinicalHistory( nameClie, namePe , symp, diag, stat, dateIn, pet2);

      Medicament medics = new Medicament(medi, dos, totaldos, frec);

      principal.hospitalizeVet(nameClie, idClie, namePe, newMedRec, medics);
  }
  else if(userImput ==5){
     System.out.println("Por favor digite el dia actual");
     int actualDay = reader.nextInt();
     reader.nextLine();

     System.out.println("Por favor digite el mes actual");
     int actualMonth = reader.nextInt();
     reader.nextLine();

     System.out.println("Por favor digite el año actual");
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

    System.out.println("Por favor digite el nombre de la mascota para darlo de alto");
    String nampe = reader.nextLine();

    System.out.println(principal.findToHospitalize(idClientt,nampe));
  }
  
	  

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  
	  }