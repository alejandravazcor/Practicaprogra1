package comprobaciones;

import negocio.Vehiculo;

public class Comprobador
{
	public static void main(String[]args){
		Vehiculo vehiculo1 = new Vehiculo ("Mercedes", "Rojo", 10, 10);
	System.out.println(vehiculo1.getMarca() + vehiculo1.getColor() + vehiculo1.getPrecio());
}}
