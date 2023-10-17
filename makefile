limpiar:
	rm -rf bin
compilar:limpiar
	find -name "*.java" | xargs javac -cp bin -d bin
