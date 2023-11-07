package negocio;
import java.math.BigDecimal;
public class Vehiculo{
	//declaracion de atributos
	private String marca;
	private String color;
	private int precio;
	private int id;
	/**
	 * constructor con parametros por lo que no uso setters
	 */
	public Vehiculo(String marca, String color, int precio, int id){
		this.marca = marca;
		this.color = color;
		this.precio = precio;
		this.id = id;
		/**
		 * Asigna los valores de los parametros a los atributos correspondientes
		 */

	}

	public Vehiculo(String next, String next1, String next2) {
		this.marca = marca;
		this.color = color;
		this.precio = precio;
	}
	public Vehiculo(int Id){ this.id = id;}

	/**
	 * metodos para acceder a los atributos
	 */
	public void setPrecio(){
		this.precio = precio;
	}
	public String getMarca(){
		return marca;
		//Metodo para obtener la marca
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
		return  getId() + "," + getMarca() + "," + getColor() + "," + getPrecio();
	}
	@Override
	public boolean equals(Object obj){
		Vehiculo veh = (Vehiculo) obj;
		return id == veh.id;
	}
}
