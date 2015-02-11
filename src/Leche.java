import java.util.ArrayList;
import java.util.Scanner;


public class Leche extends Producto{

//propiedades
	
	private String tipoLeche;
	private Double eurosLitro;

//constructor

	public Leche(){}

//metodos getter y setter
	
	public String getTipoLeche(){
		return tipoLeche;
	}
	public void setTipoLeche(String tipoLeche) {
		this.tipoLeche = tipoLeche;
	}
	public Double getEurosLitro(){
		return eurosLitro;
	}
	public void setEurosLitro(Double eurosLitro){
		this.eurosLitro = eurosLitro;
	}
	
 
	public static void crearLeche(){
		
		ArrayList<Leche> leches = new ArrayList<Leche>();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n¿Cuantas variedades de leche quieres insertar?: ");
		int opcion = sc.nextInt();
		
		for(int l = 0; l < opcion; l++) {
			Leche leche = new Leche();
			System.out.println("\nTipo de leche: ");
			leche.setTipoLeche(sc.next());
			System.out.println("Procedencia de la leche: ");
			leche.setProcedencia(sc.next());
			System.out.println("€/L: ");
			leche.setEurosLitro(sc.nextDouble());
			System.out.println("Nombre del distribuidor: ");
		
			Distribuidor distribuidor = new Distribuidor();
			ArrayList<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
			
			distribuidor.setNombre(sc.next());
			for(int d = 0; d < distribuidores.size(); d++) {
				if((distribuidores.get(d).getNombre()).equalsIgnoreCase(distribuidor.getNombre())) {
					leche.setDistribuidor(distribuidores.get(d));
				}
			}
			leches.add(leche);
		}
		System.out.println("\nLeche: \n");
		
		for(int m = 0; m < leches.size(); m++) {
			System.out.println("Variedad de leche nº" + (m + 1));
			System.out.println("----------------------");
			System.out.println("Tipo de leche: "+(leches.get(m).getTipoLeche()));
			System.out.println("Prcedencia: "+(leches.get(m).getProcedencia()));
			System.out.println("€/L: "+(leches.get(m).getEurosLitro()));
			//distribuidor
			Distribuidor distribuidor = leches.get(m).getDistribuidor();
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