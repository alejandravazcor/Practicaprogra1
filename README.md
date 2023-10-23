# Practicaprogra1
# CatalogoCoches
Esta aplicación está creada con el propósito de funcionar como un catálogo, en el que el usuario pueda añadir y ver impreso por pantalla los coches que este haya añadido con sus atributos correspondientes.
## Instalación 
Para instalar el programa debe escribir "make jar"
## Ejecución 
Para ejecutar debe escribir "java -jar añadir <Marca> <Color> <Precio>"
Por ejemplo, "java -jar añadir "Mercedes" "Rojo" 408000
## Uso del *make*
## Suprime los directorios bin y html, elimina los ficheros .jar, los .class y .txt.
    make limpiar
## Crea el directorio bin y allí almacena los .class que ha compilado durante la ejecución del make. 
    make compilar
## Crea el .jar
    make jar
## Crea el directorio html y los ficheros .html.
    make javadoc
## Estructura interna de la aplicacion
La aplicación esta estructurada en dos partes negocio y presentación:
## Negocio 
En negocio se encuentra la clase Concesionario, esta se encarga de gestionar la información de vehículos en un concesionario. Además, de la clase Vehiculo 
## Presentación
En presentación encontramos la Interfaz de Usuario es la clase principal que contiene la lógica para interactuar con el programa.
