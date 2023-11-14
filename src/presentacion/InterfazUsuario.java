package presentacion;

import java.util.ArrayList;

import negocio.*;
public class InterfazUsuario{
	private static String negrita = "\u001B[1m";
	private static String normal = "\033[0m";
	private static String rojo = "\u001B[31m";
	private static String blanco = "\u001B[37m";
	/**
	* Se definen variables de formato para cambiar el color y formato del texto en la consola. Esto se hace utilizando códigos de escape ANSI
	* Este método recibe un arreglo de cadenas de texto llamado instruccion.Crea una instancia de la clase Concesionario.Luego, el método verifica el contenido del primer elemento del arreglo instruccion para determinar qué acción debe realizar: Si el primer elemento es "mostrar" y la longitud del arreglo es 1, llama al método mostrarVehiculo para mostrar los vehículos en el concesionario. Si el primer elemento es "añadir" y la longitud del arreglo es 4, crea un objeto Vehiculo y lo añade al concesionario utilizando el método annadir. Si el primer elemento es "ayuda" y la longitud del arreglo es 1, llama al método ayuda para mostrar un mensaje de ayuda. Si ninguna de las condiciones anteriores se cumple, se imprime un mensaje de error en rojo y se muestra el mensaje de ayuda
	 */
	/**
 * Ejecuta las operaciones del concesionario basadas en las instrucciones proporcionadas.
 * 
 * @param instruccion Un array de cadenas que contiene las instrucciones a ejecutar.
 */
	public static void ejecutar(String[] instruccion){
		Concesionario concesionario = new Concesionario();
		if (instruccion.length == 0 ){
			System.out.println("Añadir parametros");
			ayuda();
		}
		else if (instruccion[0].equalsIgnoreCase( "mostrar") && instruccion.length == 1 ){
			mostrarVehiculo(concesionario);
		}else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 4){ 
			Vehiculo vehiculo = new Vehiculo (instruccion[1], instruccion[2], Integer.parseInt(instruccion[3]));
			concesionario.annadir(vehiculo);
		}else if (instruccion[0].equalsIgnoreCase("modificar") && instruccion.length == 5){
			Vehiculo vehiculomodificado = new Vehiculo(Integer.parseInt(instruccion[1]), instruccion[2], instruccion[3], Integer.parseInt(instruccion[4]));
			concesionario.modificar(vehiculomodificado);
		}else if (instruccion[0].equalsIgnoreCase("ayuda") && instruccion.length == 1){
			ayuda();
		} else if (instruccion[0].equalsIgnoreCase("borrar") && instruccion.length == 2) {
			Vehiculo vehiculo = new Vehiculo(Integer.parseInt(instruccion[1]));
			concesionario.borrar(vehiculo);
		} else {
			System.out.println(rojo + "El formato de utilizado en la entrada es incorrecto" + blanco);
			ayuda();
		}
	}
	/**
	 *Obtiene una lista de vehículos del concesionario utilizando el método getVehiculoConcesionario y la almacena en una lista llamada listaVehiculo. Luego, recorre la lista de vehículos y los imprime en la consola.
	 * public static void ejecutar(String[] instruccion){: Este método está definido como public, lo que significa que es accesible desde fuera de la clase sin necesidad de instanciar un objeto de esa clase. Es estático (static), lo que implica que pertenece a la clase en sí misma en lugar de a una instancia específica de la clase. Toma un arreglo de strings llamado instruccion como parámetro.
	 * Concesionario concesionario = new Concesionario();: Se crea una nueva instancia de la clase Concesionario. Esto probablemente inicializa una estructura de datos o una lista que contiene vehículos dentro del concesionario.
	 * El método procede a verificar diferentes condiciones basadas en el contenido del arreglo instruccion
	 * Comprueba si instruccion tiene longitud cero, en cuyo caso imprime un mensaje pidiendo agregar parámetros y llama al método ayuda() para proporcionar ayuda con el uso del programa.
	 * Verifica si la primera instrucción es "mostrar" y si la longitud es igual a 1, en cuyo caso llama al método mostrarVehiculo() pasando el objeto concesionario.
	 * Si la instrucción es "añadir" y la longitud es 4, crea un nuevo objeto Vehiculo con los parámetros proporcionados en instruccion[1], instruccion[2] e Integer.parseInt(instruccion[3]), y luego llama al método annadir() del objeto concesionario para agregar el vehículo.
	 * Si la instrucción es "modificar" y la longitud es 5, crea un nuevo objeto Vehiculo con los parámetros proporcionados en instruccion[1], instruccion[2], instruccion[3] e Integer.parseInt(instruccion[4]), y luego llama al método modificar() del objeto concesionario para modificar el vehículo correspondiente.
	 * Si la instrucción es "ayuda" y la longitud es 1, llama al método ayuda().
	 * Si la instrucción es "borrar" y la longitud es 2, crea un nuevo objeto Vehiculo con el parámetro proporcionado en Integer.parseInt(instruccion[1]), y luego llama al método borrar() del objeto concesionario para eliminar el vehículo correspondiente.
	 * En caso contrario, imprime un mensaje indicando que el formato utilizado en la entrada es incorrecto y llama al método ayuda() para proporcionar ayuda sobre el uso correcto del programa.
	 */
private static void mostrarVehiculo(Concesionario concesionario){
	ArrayList<Vehiculo> listaVehiculo = concesionario.getVehiculoConcesionario();
	for(Vehiculo vehiculo : listaVehiculo){
		System.out.println(vehiculo);
	}
}

	/**
	 * Este método muestra un mensaje de ayuda en la consola. Proporciona una descripción de las funcionalidades del programa, el formato de entrada requerido y ejemplos de uso.
	 */
private static void ayuda(){
	System.out.println("\n"+negrita+"DESCRIPCIÓN"+normal);
	System.out.println("\tEsta aplicacion ofrece las siguientes funcionalidades:\n\n" + 
			"\t- Permite añadir un nuevo vehiculo al concesionario\n" +
			"\t- Permite borrar un  vehiculo del concesionario\n" +
			"\t- Permite mostrar los vehiculos del concesionario\n"+
			 "\t- Permite modificar los vehiculos del concesionario");

System.out.println(negrita+"FORMATO"+normal);
System.out.println("\tPara añadir un nuevo vehiculo, se escribe:\n");
System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal añadir <marca> <color> <precio>" + normal + "\n");
System.out.println("\tPara añadir un nuevo vehiculo, se escribe:\n");
System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal modificar <Id> <marca> <color> <precio> <Id>" + normal + "\n");
System.out.println("\tPara mostrar los vehiculos del concesionario, se teclea:\n");
System.out.println("\t\t" + negrita +"java -cp bin puntoEntrada.Principal mostrar" + normal + "\n");
System.out.println("\tPara mostrar esta ayuda, se escribe:\n");
System.out.println("\t\t" + negrita +"java -cp bin puntoEntrada.Principal ayuda" + normal + "\n");
System.out.println(negrita+"Ejemplos"+normal);
System.out.println("\tEjemplo 1\n");
System.out.println("\t\t" + negrita +"java -cp bin puntoEntrada.Principal añadir Mercedes rojo 1000 12 " + normal + "\n");
System.out.println("\tEjemplo 2\n");
System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal mostrar" + normal+ "\n");
System.out.println("\tEjemplo 3\n");
System.out.println("\t\t" + negrita + "java -cp bin puntoEntrada.Principal ayuda" + normal + "\n");
System.out.println("\tPara borrar un vehiculo, se escribe:\n");
System.out.println("\t\t" + negrita +"java -cp bin puntoEntrada.Principal borrar <marca> <color> <precio> <Id> " + normal + "\n");
System.out.println("\tEjemplo 4\n");
System.out.println("\t\t" + negrita +"java -cp bin puntoEntrada.Principal borrar Mercedes rojo 1000 12" + normal + "\n");
}
}
