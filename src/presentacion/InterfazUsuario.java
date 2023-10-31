package presentacion;

import java.util.ArrayList;

import negocio.*;
public class InterfazUsuario{
	private static String negrita = "\u001B[1m";
	private static String normal = "\033[0m";
	private static String rojo = "\u001B[31m";
	private static String blanco = "\u001B[37m";
	//Se definen variables de formato para cambiar el color y formato del texto en la consola. Esto se hace utilizando códigos de escape ANSI
	//Este método recibe un arreglo de cadenas de texto llamado instruccion.Crea una instancia de la clase Concesionario.Luego, el método verifica el contenido del primer elemento del arreglo instruccion para determinar qué acción debe realizar: Si el primer elemento es "mostrar" y la longitud del arreglo es 1, llama al método mostrarVehiculo para mostrar los vehículos en el concesionario. Si el primer elemento es "añadir" y la longitud del arreglo es 4, crea un objeto Vehiculo y lo añade al concesionario utilizando el método annadir. Si el primer elemento es "ayuda" y la longitud del arreglo es 1, llama al método ayuda para mostrar un mensaje de ayuda. Si ninguna de las condiciones anteriores se cumple, se imprime un mensaje de error en rojo y se muestra el mensaje de ayuda
	public static void ejecutar(String[] instruccion){
		Concesionario concesionario = new Concesionario();
		if (instruccion[0].equalsIgnoreCase( "mostrar") && instruccion.length == 1){
			mostrarVehiculo(concesionario);
		}else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 5){
			int instruccion3 = Integer.parseInt(instruccion[3]);
			Vehiculo vehiculo = new Vehiculo( instruccion[1], instruccion[2], Integer.parseInt(instruccion [3]), Integer.parseInt(instruccion [4]));
			concesionario.annadir(vehiculo);
		}else if (instruccion[0].equalsIgnoreCase("ayuda") && instruccion.length == 1){
			ayuda();
		}else{ System.out.println(rojo+ "El formato de utilizado en la entrada es incorrecto" + blanco);
			ayuda();
		}
	}
	//Obtiene una lista de vehículos del concesionario utilizando el método getVehiculoConcesionario y la almacena en una lista llamada listaVehiculo. Luego, recorre la lista de vehículos y los imprime en la consola.
private static void mostrarVehiculo(Concesionario concesionario){
	ArrayList<Vehiculo> listaVehiculo = concesionario.getVehiculoConcesionario();
	for(Vehiculo vehiculo : listaVehiculo){
		System.out.println(vehiculo);
	}
}
	//Este método muestra un mensaje de ayuda en la consola. Proporciona una descripción de las funcionalidades del programa, el formato de entrada requerido y ejemplos de uso.
private static void ayuda(){
	System.out.println("\n"+negrita+"DESCRIPCIÓN"+normal);
	System.out.println("\tEsta aplicacion ofrece las siguientes funcionalidades:\n\n" + 
			"\t- Permite añadir un nuevo vehiculo al concesionario\n" +
			"\t- Permite mostrar los vehiculos del concesionario");
System.out.println(negrita+"FORMATO"+normal);
System.out.println("\tPara añadir un nuevo vehiculo, se escribe:\n");
System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal añadir <marca> <color> <precio>" + normal + "\n");
System.out.println("\tPara mostrar los vehiculos del concesionario, se teclea:\n");
System.out.println("\t\t" + negrita +"java -cp bin puntoEntrada.Principal mostrar" + normal + "\n");
System.out.println("\tPara mostrar esta ayuda, se escribe:\n");
System.out.println("\t\t" + negrita +"java -cp bin puntoEntrada.Principal ayuda" + normal + "\n");
System.out.println(negrita+"Ejemplos"+normal);
System.out.println("\tEjemplo 1\n");
System.out.println("\t\t" + negrita +"java -cp bin puntoEntrada.Principal añadir Mercedes rojo 10" + normal + "\n");
System.out.println("\tEjemplo 2\n");
System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal mostrar" + normal+ "\n");
System.out.println("\tEjemplo 3\n");
System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal ayuda" + normal + "\n");
}
}
