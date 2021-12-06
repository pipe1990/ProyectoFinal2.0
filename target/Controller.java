package co.edu.unbosque.controller;

import java.util.Scanner;

public class Controller {

	Scanner leer;
	public Controller() {
		leer = new Scanner(System.in);
		funcionar();
	}
	
	public void funcionar() {
		double KM = 0.0;
		double Monto = 0.0;
		String resul = "";
		
		System.out.println("=================================");
		System.out.println("Programa que calcula el monto de alquiler de un vehiculo");
		System.out.println("dependiendo los kilometros recorridos, teniendo en cuenta");
		System.out.println("que los kilometros tienen que ser un racional postivo.");
		System.out.println("=================================");
		
		//leer km
		System.out.println("Digite la cantidad de kilometros recorridos: " );
		KM = leer.nextDouble();

		
		// calcular formula
		if(KM > 0 && KM < 300 ) {
			
			Monto= 30 ;
			resul= "El monto a cancelar son "+ Monto + " USD.";
			
		}else if (KM >= 300 && KM < 1000){ 
			Monto= ((KM -300) *2) + 30;
			resul= "El monto a cancelar son "+ Monto + " USD.";
		}else if ( KM >= 1000){
			Monto= (KM -1000) * 1 + 1430;
			resul="El monto a cancelar son "+ Monto + " USD.";
		}else {	
			resul = "Señor usuario usted ha digitado la información incorrecta.";
		}
		// imprimir informacion
		
		System.out.println(resul);
		
	}
}
