import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Distribuidor {

//propiedades	

	private String nombre;
	private String cif;
	private Direccion direccion;
	private Contacto personaContacto;

//constructor

	public Distribuidor(){}

//metodos getter y setter

	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getCif(){
		return cif;
	}
	public void setCif(String cif){
		this.cif = cif;
	}
	public Direccion getDireccion(){
		return direccion;
	}
	public void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}
	public Contacto getPersonaContacto(){
		return personaContacto;
	}
	public void setPersonaContacto(Contacto personaContacto){
		this.personaContacto = personaContacto;
	}
	
	public void leerDistrib(){
		Scanner sc = new Scanner(System.in);
		ArrayList<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
		int opcion = sc.nextInt();
		
		try{
			FileInputStream fis = new FileInputStream("distribuidores.txt");
			InputStreamReader isr = new InputStreamReader(fis, "UTF8");
			BufferedReader br = new BufferedReader(isr);
			String linea = br.readLine();
			String [] campos = null;
			
			while(linea != null){
				Distribuidor distribuidor = new Distribuidor();
				Direccion direccion = new Direccion();
				Contacto contacto = new Contacto();
				campos = linea.split("#");
				
				String distri = campos[0];
				String [] campos2 = distri.split(",");
				distribuidor.setNombre(campos2[0]);
				distribuidor.setCif(campos2[1]);
				
				//direccion
				distri = campos[1];
				campos2 = distri.split(",");
				direccion.setCiudad(campos2[0]);
				int entero = Integer.parseInt(campos2[1]);
				direccion.setCodigoPostal(entero);
				direccion.setCalle(campos2[2]);
				entero = Integer.parseInt(campos2[3]);
				direccion.setNumero(entero);
				distribuidor.setDireccion(direccion);
				
				//contacto
				distri = campos[2];
				campos2 = distri.split(",");
				contacto.setNombre(campos2[0]);
				contacto.setApellido(campos2[1]);
				entero = Integer.parseInt(campos2[2]);
				contacto.setTelefono(entero);
				entero = Integer.parseInt(campos2[3]);
				contacto.setEdad(entero);
				distribuidor.setPersonaContacto(contacto);
				
				distribuidores.add(distribuidor);
				linea = br.readLine();
			}
			for (int i=0;i<distribuidores.size() ;i++ ) {
				Direccion direc = new Direccion();
				Contacto contact = new Contacto();
				
				System.out.println("\nProveedor nº: " + (i + 1));
				System.out.println("****************************");
				System.out.println("Nombre: " + (distribuidores.get(i).getNombre()));
				System.out.println("Cif: " + (distribuidores.get(i).getCif()));
				direc = distribuidores.get(i).getDireccion();
				System.out.println("DirecciÃ³n:");
				System.out.println("-----------");
				System.out.println("\tCiudad: " + direc.getCiudad());
				System.out.println("\tCod.postal: " + direc.getCodigoPostal());
				System.out.println("\tCalle: " + direc.getCalle());
				System.out.println("\tCalle: " + direc.getNumero());
				contact = distribuidores.get(i).getPersonaContacto();
				System.out.println("Contacto:");
				System.out.println("-----------");
				System.out.println("\tNombre: " + contact.getNombre());
				System.out.println("\tApellido: " + contact.getApellido());
				System.out.println("\tnumero telefonico: " + contact.getTelefono());
				System.out.println("\tedad: " + contact.getEdad());
			}
		}catch(Exception ioe) {
		System.out.println("Error: "+ioe);	
		}	
	}
}
	