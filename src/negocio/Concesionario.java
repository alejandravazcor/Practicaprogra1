package negocio;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Concesionario{
	/**
 * Clase que representa un concesionario de vehículos.
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
		else vehiculo.setId(1);
		vehiculoConcesionario.add(vehiculo);
		volcarVehiculoConcesionario();
	}
	/**
 * Añade un vehículo al concesionario.
 * Si el concesionario no está vacío, asigna un ID al vehículo nuevo
 * basado en el último ID existente incrementado en uno. En caso contrario,
 * asigna al vehículo el ID 1.
 *
 * @param vehiculo El vehículo a añadir al concesionario.
 */

	public void borrar(Vehiculo vehiculo) {
		vehiculoConcesionario.remove(vehiculo);
		volcarVehiculoConcesionario();
	}

	public ArrayList<Vehiculo> getVehiculoConcesionario(){
		return vehiculoConcesionario;
	}
/**
 * Elimina un vehículo del concesionario.
 * 
 * @param vehiculo El vehículo a eliminar del concesionario.
 */

/**
 * Obtiene la lista de vehículos del concesionario.
 * 
 * @return La lista de vehículos del concesionario.
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
			Vehiculo vehiculo = new Vehiculo(Integer.parseInt(sc.next()),
					sc.next(),
					sc.next(),
					Integer.parseInt(sc.next()));
	vehiculoConcesionario.add(vehiculo);
	}
	sc.close();
}catch(IOException ex) {
		System.err.println("No hay habitantes inscritos");
	}
}
public void modificar(Vehiculo vehiculomodificado){
	for (Vehiculo vehiculo: vehiculoConcesionario){
		if (vehiculo.getId() == vehiculomodificado.getId()){
			vehiculo.setMarca(vehiculomodificado.getMarca());
			vehiculo.setColor(vehiculomodificado.getColor());
			vehiculo.setPrecio(vehiculomodificado.getPrecio());
			volcarVehiculoConcesionario();
			return;
	}
/**
 * Modifica un vehículo existente en el concesionario con la información proporcionada en un vehículo modificado.
 * 
 * @param vehiculomodificado El vehículo con la información actualizada que se utilizará para modificar el vehículo en el concesionario.
 */		
}
System.out.println("El vehiculo con el ID :"+ vehiculomodificado.getId() +" no se ha encontrado");
}

}



