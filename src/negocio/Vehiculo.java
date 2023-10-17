package negocio;

public class Vehiculo{
	//declaracion de atributos
	private String marca;
	private String color;
	private float precio;
	//constructor con parametros por lo que no uso setters
	public Vehiculo(String marca, String color, float precio){
		this.marca = marca;
		this.color = color;
		this.precio = precio;
		//Asigna los valores de los parametros a los atributos correspondientes
	}
	//metodos para acceder a los atributos
	public String getMarca(){
		return marca;
		//Metodo para obtener la marca
	}
	public String getColor(){
		return color;
	}

	public float getPrecio(){
		return precio;
	}
	//Para crear una cadena de chars para que asi cuando salga por pantalla pueda salir esa cadena de atributos y no la direccion de memoria 
	public String toString(){
		return  getMarca() + "," + getColor() + "," + getPrecio();
	}}
