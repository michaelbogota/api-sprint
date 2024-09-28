package com.example.claseu;

import com.example.claseu.dto.Fruit;
import com.example.claseu.dto.MsjItem;
import com.example.claseu.dto.SetItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//************Elaborado por Lauren Caballero***********//
//*************** Y por Michael Alfonso **************//

@SpringBootApplication
@RestController
public class ClaseUApplication {

    //propiedad inicial de la clase
    private ArrayList<String> fruits = new ArrayList<String>();

    public static void main(String[] args) {
        SpringApplication.run(ClaseUApplication.class, args);
    }

    //constructor donde lleno el array de frutas
    public ClaseUApplication() {
        fruits.add("Manzana");
        fruits.add("Pera");
        fruits.add("Banano");
        fruits.add("Naranja");
        fruits.add("Papaya");
        fruits.add("Mango");
    }

    @GetMapping("/hello")
    public String helloWorld(String[] args) {
        return "Hello, World!";
    }

    @GetMapping("/fruits/{id}")
    public MsjItem setItems(@PathVariable String id) {
        try {
            return new MsjItem(fruits.get(Integer.parseInt(id)));
        } catch (Exception e) {
            return new MsjItem("No existe");
        }
    }


    @PostMapping("/fruits")
    public SetItem setItems(@RequestBody Fruit fruit) {
        fruits.add(fruit.getName());
        return new SetItem();
    }

    @GetMapping("/fruits")
    public ArrayList<String> getItems(String[] args) {
        return fruits;
    }

    @DeleteMapping("/fruits/{id}")
    public MsjItem deleteItems(@PathVariable String id) {
        try {
            return new MsjItem(fruits.remove(Integer.parseInt(id)));
        } catch (Exception e) {
            return new MsjItem("No existe");
        }
    }

    @PutMapping("/fruits/{id}")
    public MsjItem putItems(@PathVariable String id, @RequestBody Fruit fruit) {
        try {
            fruits.remove(Integer.parseInt(id));
            fruits.add(fruit.getName());
            return new MsjItem(fruit.getName());
        } catch (Exception e) {
            return new MsjItem("No existe");
        }
    }

}
