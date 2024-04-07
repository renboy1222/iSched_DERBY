/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched;

/**
 *
 * @author Java Programming with Aldrin
 */
import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<String> arrayList = new ArrayList<>();

        // Add elements to the ArrayList
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        arrayList.add("Mango");
        arrayList.add("Banana");

        // Display the ArrayList before removal
        System.out.println("ArrayList before removal: " + arrayList);

        // Remove the element "Banana"
        arrayList.remove("Banana");
        arrayList.remove("Banana");

        // Display the ArrayList after removal
        System.out.println("ArrayList after removal: " + arrayList);
    }
}
