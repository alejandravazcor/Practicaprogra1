package negocio;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Concesionario{
	//construtor de la clase padron
	private ArrayList<Vehiculo> vehiculoConcesionario = new ArrayList<>();
	public Concesionario(){
		cargarVehiculo();
	}
	public void annadir (Vehiculo vehiculo){
		vehiculoConcesionario.add(vehiculo);
		volcarVehiculoConcesionario();
	}
	public ArrayList<Vehiculo> getVehiculoConcesionario(){
		return vehiculoConcesionario;
	}
private void volcarVehiculoConcesionario(){
	try{
		FileWriter fw = new FileWriter ("concesionario.csv");
		for(Vehiculo vehiculo : vehiculoConcesionario){
			fw.write(vehiculo.getMarca() + "," +
					vehiculo.getColor() + "," +
					vehiculo.getPrecio() + "\n");
		}
		fw.close(); 
	}catch(IOException ex){
		System.err.println(ex);
	}
}
private void cargarVehiculo(){
	try{
		File fichero = new File("concesionario.csv");
		//Para crear fichero si no existe todavia
		fichero.createNewFile();
		Scanner sc = new Scanner(fichero);
		sc.useDelimiter(",|\n");
		while(sc.hasNext()){
			Vehiculo vehiculo = new Vehiculo(sc.next(),
					sc.next(),
					Float.parseFloat(sc.next()));
	vehiculoConcesionario.add(vehiculo);
	}
	sc.close();
}catch(IOException ex){
	System.err.println("No hay habitantes inscritos");
}
}
}

