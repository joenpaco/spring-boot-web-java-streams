package com.joenpaco;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joenpaco.models.dtos.Product;
import com.joenpaco.utils.Util;

@SpringBootApplication
public class SpringBootWebJavaStreamsApplication implements CommandLineRunner {
	
	@Autowired
	private Product product;
	
	@Autowired
	private Util util;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebJavaStreamsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("**********LISTADO DEL NOMBRE DE TODOS LOS PRODUCTOS**********");
		
		List<Product> products = Util.getProducts();
		
		Stream<String> streams = products.stream().map(Product::getName);
		//SENTENCIA SQL EQUIVALENTE: select `productName` from products
		
		List<String> lista = streams.collect(Collectors.toList());
		
		lista.forEach(System.out::println);
		
		System.out.println("**********FIN DEL LISTADO DEL NOMBRE DE TODOS LOS PRODUCTOS******************************");
		System.out.println("*****************************************************************************************");
		
		System.out.println("*****************************************************************************************");
		System.out.println("**********LISTADO DEL NOMBRE DE LOS PRODUCTOS QUE CUMPLEN UNA CONDICIÓN******************");
		
		streams = products.stream().filter(producto -> producto.getUnitsInStock()<10).map(Product::getName);
		//SENTENCIA SQL EQUIVALENTE: select `productName` from products where `unitsInStock` < 10
		
		streams.collect(Collectors.toList()).forEach(System.out::println);
		
		//lista2.forEach(System.out::println);
		
		System.out.println("**********FIN DEL LISTADO DEL NOMBRE DE LOS PRODUCTOS QUE CUMPLEN UNA CONDICIÓN**********");
		System.out.println("*****************************************************************************************");
		
	}

}
