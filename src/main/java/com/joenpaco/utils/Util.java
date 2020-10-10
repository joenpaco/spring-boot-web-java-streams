package com.joenpaco.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.joenpaco.models.dtos.Product;

public class Util {

    @SuppressWarnings("resource")
	public static List<Product> getProducts(){
        // Cargamos el archivo ubicado en la carpeta resources.
        ClassLoader classLoader = Util.class.getClassLoader();
        Scanner sc = new Scanner(classLoader.getResourceAsStream("products.csv"));

        sc.nextLine(); // comenzamos a leer a partir de la segunda linea (la primera tiene solo los titulos)
        sc.useDelimiter(","); // separamos por comas para obtener las columnas

        List<Product>  products = new ArrayList<>();

        while(sc.hasNextLine()){
            //con los metodos nextXX() obtenemos las columnas en el orden en el que se encuentran en el archivo
            Product product = new Product();
            product.setId(sc.nextInt());
            product.setName(sc.next());
            product.setSupplier(sc.nextInt());
            product.setCategory(sc.nextInt());
            sc.next(); //saltamos la columna quantityPerUnit
            product.setUnitPrice(Double.parseDouble(sc.next()));
            product.setUnitsInStock(sc.nextInt());

            products.add(product); // agregamos el producto a la lista.

            sc.nextLine(); // pasamos a la siguiente linea
        }

        return products;
    }
}
