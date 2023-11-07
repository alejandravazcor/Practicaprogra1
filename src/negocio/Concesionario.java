package negocio;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Concesionario{
	/**
	 * construtor de la clase padron
	 */

	private ArrayList<Vehiculo> vehiculoConcesionario = new ArrayList<>();
	public Concesionario(){
		cargarVehiculo();
	}
	/**
	 * Este método recibe un objeto de la clase Vehiculo como argumento y lo agrega a la lista vehiculoConcesionario. Luego, llama al metodo volcarVehiculoConcesionario para guardar la información actualizada en un archivo CSV
	 */

	public void annadir (Vehiculo vehiculo){
		if (!vehiculoConcesionario.isEmpty()) vehiculo.setId(vehiculoConcesionario.get(vehiculoConcesionario.size() - 1).getId()+1);
		vehiculoConcesionario.add(vehiculo);
		volcarVehiculoConcesionario();
	}
	/**
	 * Este método permite obtener la lista de vehículos almacenados en el concesionario
	 */

	public void borrar(Vehiculo vehiculo) {
		vehiculoConcesionario.remove(vehiculo);
		volcarVehiculoConcesionario();
	}

	public ArrayList<Vehiculo> getVehiculoConcesionario(){
		return vehiculoConcesionario;
	}


	/**
	 * Este método guarda la información de los vehículos en un archivo CSV llamado "concesionario.csv". Utiliza un bucle para recorrer la lista de vehículos y escribe cada vehículo en una línea del archivo CSV. Cada línea contiene información como la marca, el color y el precio del vehículo.
	 */
	private void volcarVehiculoConcesionario(){
	try{
		FileWriter fw = new FileWriter ("concesionario.csv");
		for(Vehiculo vehiculo : vehiculoConcesionario){
			fw.write(vehiculo.getId() + ","+ vehiculo.getMarca() + "," +
					vehiculo.getColor() + "," +
					vehiculo.getPrecio() + "\n");
		}
		fw.close(); 
	}catch(IOException ex){
		System.err.println(ex);
	}
}

	/**
	 * Este método se utiliza para cargar la información de los vehículos desde el archivo "concesionario.csv" al iniciar el programa. Verifica si el archivo existe y, si no existe, lo crea. Luego, utiliza un Scanner para leer el contenido del archivo CSV, parsear los datos y crear objetos Vehiculo, que son agregados a la lista vehiculoConcesionario.
	 */

private void cargarVehiculo(){
	try {
		File fichero = new File("concesionario.csv");

	/**
	 * Para crear fichero si no existe todavia
	 */

		fichero.createNewFile();
		Scanner sc = new Scanner(fichero);
		sc.useDelimiter(",|\n");
		while(sc.hasNext()){
			Vehiculo vehiculo = new Vehiculo(sc.next(),
					sc.next(),
					Integer.parseInt(sc.next()),
					Integer.parseInt(sc.next()));
	vehiculoConcesionario.add(vehiculo);
	}
	sc.close();
}catch(IOException ex) {
		System.err.println("No hay habitantes inscritos");
	}

}
}


