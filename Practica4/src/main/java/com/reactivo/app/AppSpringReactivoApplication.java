package com.reactivo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.*;

@SpringBootApplication
public class AppSpringReactivoApplication {

	final static String RUTA_ARCHIVO_DEMO = "/Users/jjaramillo/Documents/JAVA REACTIVO/App-Spring-Reactivo/src/main/demo.txt";
	final static String PROPIEDAD_ARCHIVOS_SIZE = "size";

	public static void main(String[] args) throws IOException {
		//ejemploStreams1();
		//ejemploStreams2();
		//ejemploOperacionesIntermedias(0, 30);
		//ejemploLeerArchivo();
		SpringApplication.run(AppSpringReactivoApplication.class, args);
	}

	private static void ejemploStreams1(){
		Stream<String> streamVacio = Stream.empty();
		if(streamVacio.count() >= 0){
			System.out.println("No hay elementos en el Stream");
		}

		Collection<String> coleccion = Arrays.asList("Juan", "Anibal", "Jesica");
		streamVacio = coleccion.stream();
		System.out.println("Elementos en el Stream " + streamVacio.count());
	}

	private static void ejemploStreams2(){
		Stream<String> streamGenerado = Stream.generate(() -> "Elemento").limit(5);
		System.out.println("Stream generado");
		//Imprimir el contenido del stream
		streamGenerado.forEach(System.out::println);

		Stream<Integer> streamIterado = Stream.iterate(40, n -> n+2).limit(20);
		System.out.println("Stream iterado");
		//Imprimir el contenido del stream iterado
		streamIterado.forEach(System.out::println);

		IntStream streamEnteros = IntStream.range(1,3);
		System.out.println("Stream de enteros");
		streamEnteros.forEach(System.out::println);
		LongStream streamLongs = LongStream.rangeClosed(1,3);
		System.out.println("Stream de longs");
		streamLongs.forEach(System.out::println);

		Random random = new Random();
		DoubleStream streamDoblesAleatorio = random.doubles(3);
		System.out.println("Stream de doubles aleatorio");
		//Uso de operaciones intermedias map y sorted(), tambien existe filter (filtrado)
		streamDoblesAleatorio.map(elemento -> elemento * 10).sorted().forEach(System.out::println);
	}

	private static void ejemploOperacionesIntermedias(int elementosAOmitir, int limite){
		//Ejemplo con distinct
		Collection<String> listaNombres = Arrays.asList("Hugo", "Paco", "Luis", "Pablo", "Lina", "Paco", "Maria", "Lina");
		Collection<String> listaApellidos = Arrays.asList("Diaz", "Arboleda", "Jimenez", "Perez");
		List<String> listaNombresDiferentes = listaNombres.stream()
											  	.distinct()
												.sorted()
												.collect(Collectors.toList());
		List<String> listaApellidosOrdenada = listaApellidos.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println(listaNombresDiferentes);
		System.out.println(listaApellidosOrdenada);

		System.out.println("Ejemplo con Flatmap:");

		//Ejemplo con flatMap
		List<List<String>> listaCompuestaNombresApellidos = List.of(listaNombresDiferentes, listaApellidosOrdenada);
		System.out.println(listaCompuestaNombresApellidos);
		System.out.println(listaCompuestaNombresApellidos.stream()
														.flatMap(Collection::stream)
														.collect(Collectors.toList()));

		//Ejemplo con skip y limit
		System.out.println("Los primeros "+limite+" numeros pares");
		List<Integer> listaNumeros = Stream.iterate(0, i -> i + 1)
									.filter(i -> i%2 == 0)
									.skip(elementosAOmitir)
									.limit(limite)
									.collect(Collectors.toList());
		System.out.println(listaNumeros);

		System.out.println("Los primeros "+limite+" numeros primos");
		List<Integer> listaNumerosPrimos = Stream.iterate(1, i -> i + 1)
				.filter(AppSpringReactivoApplication::esPrimo)
				.limit(limite)
				.collect(Collectors.toList());
		System.out.println(listaNumerosPrimos);
	}

	private static boolean esPrimo(Integer numero){
		for(int j = 2; j < numero; j++){
			if(numero % j == 0){
				return false;
			}
		}
		return true;
	}

	private static void ejemploLeerArchivo() throws IOException {
		Path pathArchivo = Path.of(RUTA_ARCHIVO_DEMO);
		System.out.println("Tamaño del archivo: " +Files.getAttribute(pathArchivo, PROPIEDAD_ARCHIVOS_SIZE) +" bytes");
		String actual = Files.readString(pathArchivo);
		System.out.println(actual);
	}



}
