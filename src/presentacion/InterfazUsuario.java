package presentacion;

import java.util.ArrayList;

import negocio.*;
public class InterfazUsuario{
	private static String negrita = "\u001B[1m";
	private static String normal = "\033[0m";
	private static String rojo = "\u001B[31m";
	private static String blanco = "\u001B[37m";
	public static void ejecutar(String[] instruccion){
		Concesionario concesionario = new Concesionario();
		if (instruccion[0].equalsIgnoreCase( "mostrar") && instruccion.length == 1){
			mostrarVehiculo(concesionario);
		}else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 4){
			Vehiculo vehiculo = new Vehiculo( instruccion[1], instruccion[2], Float.parseFloat(instruccion [3]));
			concesionario.annadir(vehiculo);
}else if (instruccion[0].equalsIgnoreCase("ayuda") && instruccion.length == 1){
	ayuda();
}else{ System.out.println(rojo+ "El formato de utilizado en la entrada es incorrecto" + blanco);
	ayuda();
}
	}
private static void mostrarVehiculo(Concesionario concesionario){
	ArrayList<Vehiculo> listaVehiculo = concesionario.getVehiculoConcesionario();
	for(Vehiculo vehiculo : listaVehiculo){
		System.out.println(vehiculo);
	}
}
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
