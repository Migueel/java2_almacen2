import java.util.ArrayList;
import java.util.Scanner;


public class Lechuga {

//propiedades

	private String tipoLechuga;
	private String procedencia;
	private String color;
	private Double eurosUnidad;
	private Distribuidor distribuidor;

//constructor

	public Lechuga(){}

//métodos getter y setter

	public String getTipoLechuga(){
		return tipoLechuga;
	}
	public void setTipoLechuga(String tipoLechuga) {
		this.tipoLechuga = tipoLechuga;
	}
	public String getProcedencia(){
		return procedencia;
	}
	public void setProcedencia(String procedencia){
		this.procedencia = procedencia;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color = color;
	}
	public Double getEurosUnidad(){
		return eurosUnidad;
	}
	public void setEurosUnidad(Double eurosUnidad){
		this.eurosUnidad = eurosUnidad;
	}
	public Distribuidor getDistribuidor(){
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor){
		this.distribuidor = distribuidor;
	}
	
	public void crearLechuga(){
		
		ArrayList<Lechuga> lechugas = new ArrayList<Lechuga>();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n¿Cuantas lechugas quieres insertar?: ");
		int opcion = sc.nextInt();
		//crear
		for(int o = 0; o < opcion; o++) {
			Lechuga lechuga = new Lechuga();
			
			System.out.println("\nTipo de lechuga: ");
			lechuga.setTipoLechuga(sc.next());
			System.out.println("Procedencia de la lechuga: ");
			lechuga.setProcedencia(sc.next());
			System.out.println("Color: ");
			lechuga.setColor(sc.next());
			System.out.println("€/Uni: ");
			lechuga.setEurosUnidad(sc.nextDouble());
			System.out.println("Nombre del distribuidor: ");
			
			Distribuidor distribuidor = new Distribuidor();
			ArrayList<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
			
			distribuidor.setNombre(sc.next());
			for(int d = 0; d < distribuidores.size(); d++) {
				if((distribuidores.get(d).getNombre()).equalsIgnoreCase(distribuidor.getNombre())) {
					lechuga.setDistribuidor(distribuidores.get(d));
				}
			}
			lechugas.add(lechuga);
		}
		//mostrar
		System.out.println("\nLechugas: \n");
		
		for(int m = 0; m < lechugas.size(); m++) {
			System.out.println("Lechuga nº" + (m + 1));
			System.out.println("***********************");
			System.out.println("Tipo de lechuga: "+(lechugas.get(m).getTipoLechuga()));
			System.out.println("Prcedencia: "+(lechugas.get(m).getProcedencia()));
			System.out.println("Color: "+(lechugas.get(m).getColor()));
			System.out.println("€/Kg: "+(lechugas.get(m).getEurosUnidad()));
			Distribuidor distribuidor = lechugas.get(m).getDistribuidor();
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