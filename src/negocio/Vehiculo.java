package negocio;
import java.math.BigDecimal;
public class Vehiculo{
	//declaracion de atributos
	private int id;
	private String marca;
	private String color;
	private int precio;
	/**
	 * constructor con parametros por lo que no uso setters
	 */
	public Vehiculo(int id, String marca, String color, int precio){
		this.id = id;
		this.marca = marca;
		this.color = color;
		this.precio = precio;;
		/**
		 * Asigna los valores de los parametros a los atributos correspondientes
		 */

	}
public Vehiculo(String marca, String color, int precio){
	this.marca = marca;
	this.color = color;
	this.precio = precio;
}

	public Vehiculo(int id){ this.id = id;}

	/**
	 * metodos para acceder a los atributos
	 */
	public void setPrecio(){
		this.precio = precio;
	}
	public String getMarca(){
		return marca;
	/**
	* Metodo para obtener la marca
	*/
	}
	public String getColor(){
		return color;
	}

	public int getPrecio(){
		return precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	* Para crear una cadena de chars para que asi cuando salga por pantalla pueda salir esa cadena de atributos y no la direccion de memoria
	 */
	@Override
	public String toString(){
		return  getId() + "," +  getMarca() + "," + getColor() + "," + getPrecio();
	}
	@Override
	public boolean equals(Object obj){
		Vehiculo veh = (Vehiculo) obj;
		return id == veh.id;
	}
/**
* public boolean equals(Object obj) {: Este método es una implementación de la interfaz equals. Recibe un objeto obj como parámetro y devuelve un valor booleano que indica si el objeto actual es igual al objeto pasado como argumento.
* Vehiculo veh = (Vehiculo) obj;: Esta línea intenta convertir el objeto obj a un objeto del tipo Vehiculo. Se realiza un casting explícito de Object (que es la clase base) a Vehiculo. Esto puede generar una excepción ClassCastException si el objeto obj no es realmente una instancia de la clase Vehiculo.
* return id == veh.id;: Aquí se compara el atributo id del objeto actual (this) con el atributo id del objeto veh (que es el objeto convertido a tipo Vehiculo). La comparación se hace utilizando el operador ==, lo que compara si los valores numéricos de los identificadores son iguales.
* Este método equals personalizado en la clase Vehiculo compara la igualdad basada únicamente en los valores de los atributos id de dos objetos Vehiculo. Si los identificadores (id) de los dos objetos son iguales, el método devuelve true; de lo contrario, devuelve false.
* @param marca
*/
public void setMarca(String marca){this.marca = marca;}
public void setColor(String color){this.color = color;}
public void setPrecio(int precio ){this.precio = precio;}
}
