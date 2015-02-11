import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Cliente {
private String nombre;
private String apellidos;
private String dni;
private Direccion direccion;
private Double num_socio;
private Double dto;

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public Direccion getDireccion() {
	return direccion;
}
public void setDireccion(Direccion direccion) {
	this.direccion = direccion;
}
public Double getNum_socio() {
	return num_socio;
}
public void setNum_socio(Double num_socio) {
	this.num_socio = num_socio;
}
public Double getDto() {
	return dto;
}
public void setDto(Double dto) {
	this.dto = dto;
}

public static void leerCliente() {
	ArrayList<Distribuidor> clientes = new ArrayList<Distribuidor>();
	try{
		
		FileInputStream fis2 = new FileInputStream("clientes.txt");
		InputStreamReader isr2 = new InputStreamReader(fis2, "UTF8");
		BufferedReader br2 = new BufferedReader(isr2);
		String linea = br2.readLine();
		String [] sitio;
		
		while(linea != null){
			Cliente cliente = new Cliente();
			Direccion direccion = new Direccion();
			sitio = linea.split("#");
			
			String client = sitio[0];
			String [] sitio2 = client.split(",");
			cliente.setNombre(sitio2[0]);
			cliente.setApellidos(sitio2[1]);
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
			
			//clientes.add(cliente);
			//linea = br.readLine();
		}
		for (int c=0;c<clientes.size();c++ ) {
			Direccion dir = new Direccion();
			System.out.println("\n Cliente n�: " + (c + 1));
			System.out.println("***********************");
			System.out.println("Nombre: " + (clientes.get(c).getNombre()));
		}
	}
	catch(Exception ioe) {
	System.out.println("Error: "+ioe);
	}
}

}
