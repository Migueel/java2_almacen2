import java.util.Scanner;
import java.util.ArrayList;
//import java.io.File;
//import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
public static void main(String[] args) {
System.out.println("\nMenu:");
System.out.println("************************************************");
System.out.println("Leer y mostrar distribuidores------------------1");
System.out.println("Crear y mostrar lechugas-----------------------2");
System.out.println("Crear y mostrar manzanas-----------------------3");
System.out.println("Crear y mostrar tipos de leche-----------------4");
System.out.println("Leer y mostrar clientes------------------------5");
System.out.println("Salir------------------------------------------0");
System.out.println("************************************************");

Scanner sc = new Scanner(System.in);
ArrayList<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
int opcion = sc.nextInt();

while(opcion!=0){
	
	switch(opcion){
	
	case 1:
		Distribuidor distribuidor = new Distribuidor();
		distribuidor.leerDistrib();
		break;
	
	case 2:	
		Lechuga lechuga = new Lechuga();
		lechuga.crearLechuga();
		break;
	
	case 3:	
		Manzana manzana = new Manzana();
		manzana.crearManzana();
		break;
	
	case 4:
		Leche leche = new Leche();
		break;
		
	case 5:
	ArrayList<Distribuidor> clientes = new ArrayList<Distribuidor>();
	try{
	FileInputStream fis2 = new FileInputStream("clientes.txt");
	InputStreamReader isr2 = new InputStreamReader(fis2, "UTF8");
	BufferedReader br2 = new BufferedReader(isr2);
	String linea = br2.readLine();
	String [] sitio = null;
	while(linea != null){
	Cliente cliente = new Cliente();
	Direccion direccion = new Direccion();
	sitio = linea.split("#");
	String client = sitio[0];
	String [] sitio2 = client.split(",");
	cliente.setNombre(sitio2[0]);
	cliente.setApellido(sitio2[1]);
	cliente.setDni(sitio[2]);
	double doble = Double.parseDouble(sitio2[4]);
	cliente.setNum_socio(doble);
	doble = Double.parseDouble(sitio2[5]);
	cliente.setDto(doble);
	//direccion
	client = sitio[1];
	sitio2 = client.split(",");
	direccion.setCiudad(sitio2[0]);
	int entero = Integer.parseInt(sitio2[1]);
	direccion.setCodigoPostal(entero);
	direccion.setCalle(sitio2[2]);
	entero = Integer.parseInt(sitio2[3]);
	direccion.setNumero(entero);
	cliente.setDireccion(direccion);
	// clientes.add(cliente);
	// linea = br.readLine();
	}
	for (int c=0;c<clientes.size();c++ ) {
	Direccion dir = new Direccion();
	System.out.println("\n Cliente nº: " + (c + 1));
	System.out.println("***********************");
	System.out.println("Nombre: " + (clientes.get(c).getNombre()));
	}
	}
	catch(Exception ioe) {
	System.out.println("Error: "+ioe);
	}
	break;
	default:
	System.out.println("Eso no es una opción.....");
	break;
	
}
System.out.println("\n¿Que quieres hacer?: ");
System.out.println("\nMenu:");
System.out.println("------------------------------------------------");
System.out.println("Leer y mostrar distribuidores------------------1");
System.out.println("Crear y mostrar lechugas-----------------------2");
System.out.println("Crear y mostrar manzanas-----------------------3");
System.out.println("Crear y mostrar tipos de leche-----------------4");
System.out.println("Leer y mostrar clientes------------------------5");
System.out.println("Salir------------------------------------------0");
opcion = sc.nextInt();
}
}
}