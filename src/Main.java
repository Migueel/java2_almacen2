import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) {
		
			System.out.println("\nMenu:");
			System.out.println("*******************************************");
			System.out.println("Mostrar distribuidores------------------1");
			System.out.println("Guardad lechugas------------------------2");
			System.out.println("Guardar manzanas------------------------3");
			System.out.println("Guardar variedades de leche-------------4");
			System.out.println("Mostrar clientes------------------------5");
			System.out.println("Salir-----------------------------------0");
			System.out.println("*******************************************");
		
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
		int opcion = sc.nextInt();
		
		while(opcion!=0){
			
			switch(opcion){
			
			case 1:
			Distribuidor.leerDistrib();
				break;
			
			case 2:	
				Lechuga.crearLechuga();
				break;
			
			case 3:	
				Manzana.crearManzana();
				break;
			
			case 4:
				Leche.crearLeche();
				break;
				
			case 5:
				Cliente.leerCliente();
				break;
			
			default:
				System.out.println("Elige una opción válida");
				break;
			
			}
			opcion = sc.nextInt();
		}
	}
}