import java.util.ArrayList;
import java.util.Scanner;

public class Manzana extends  Producto{

//propiedades

	private String tipoManzana;
	private String color;
	private Double eurosKilo;

//constructor

	public Manzana(){}

//metodos getter y setter

	public String getTipoManzana(){
		return tipoManzana;
	}
	public void setTipoManzana(String tipoManzana) {
		this.tipoManzana = tipoManzana;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color = color;
	}
	public Double getEurosKilo(){
		return eurosKilo;
	}
	public void setEurosKilo(Double eurosKilo){
		this.eurosKilo = eurosKilo;
	}
	
	public static void crearManzana(){
		Scanner sc = new Scanner(System.in);
		ArrayList<Manzana> manzanas = new ArrayList<Manzana>();
		
		System.out.println("\n¿Cuantas manzanas quieres insertar?: ");
		int opcion = sc.nextInt();
		
		for(int m = 0; m < opcion; m++) {
			Manzana manzana = new Manzana ();
			
			System.out.println("\nTipo de manzana: ");
			manzana.setTipoManzana(sc.next());
			System.out.println("Procedencia de la manzana: ");
			manzana.setProcedencia(sc.next());
			System.out.println("Color: ");
			manzana.setColor(sc.next());
			System.out.println("€/U : ");
			manzana.setEurosKilo(sc.nextDouble());
			System.out.println("Nombre del distribuidor: ");
			Distribuidor distribuidor = new Distribuidor();
			distribuidor.setNombre(sc.next());
			
			ArrayList<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
			
			for(int d = 0; d < distribuidores.size(); d++) {
				if((distribuidores.get(d).getNombre()).equalsIgnoreCase(distribuidor.getNombre())) {
					manzana.setDistribuidor(distribuidores.get(d));
				}
			}
			manzanas.add(manzana);
		}
		System.out.println("\nManzanas: \n");
		
		for(int m = 0; m < manzanas.size(); m++) {
			System.out.println("Manzana nº" + (m + 1));
			System.out.println("------------");
			System.out.println("Tipo de manzana: "+(manzanas.get(m).getTipoManzana()));
			System.out.println("Prcedencia: "+(manzanas.get(m).getProcedencia()));
			System.out.println("Color: "+(manzanas.get(m).getColor()));
			System.out.println("€/Kg: "+(manzanas.get(m).getEurosKilo()));
			Distribuidor distribuidor = manzanas.get(m).getDistribuidor();
			System.out.println("Distribuidor: ");
			System.out.println("\tNombre: "+distribuidor.getNombre());
			System.out.println("\tCIF: "+distribuidor.getCif());
			//contacto
			System.out.println("\t\tNombre: "+(distribuidor.getPersonaContacto()).getNombre());
			System.out.println("\t\tApellido: "+(distribuidor.getPersonaContacto()).getApellido());
			System.out.println("\t\tTelefono: "+(distribuidor.getPersonaContacto()).getTelefono());
			//direccion
			System.out.println("\t\tCiudad: "+(distribuidor.getDireccion()).getCiudad());
			System.out.println("\t\tCódigo postal: "+(distribuidor.getDireccion()).getCodigoPostal());
			System.out.println("\t\tCalle: "+(distribuidor.getDireccion()).getCalle());
			System.out.println("\t\tNumero: "+(distribuidor.getDireccion()).getNumero());
		}
	}
	
}
