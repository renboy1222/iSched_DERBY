/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.util;

import com.aldrin.isched.dao.impl.TimeDAOImpl;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Java Programming with Aldrin
 */
@Setter
@Getter
@ToString
public class TimeAvailable {

    private ArrayList<String> timeGiven;
    private ArrayList<String> timeNeedToRemove;
    private ArrayList<String> timeAvailable = new ArrayList<>();

    public TimeAvailable(ArrayList<String> timeGiven, ArrayList<String> timeNeedToRemove) {
        this.timeGiven = timeGiven;
        this.timeNeedToRemove = timeNeedToRemove;
        for (String add : timeGiven) {
            this.timeAvailable.add(add);
        }
        for (String remove : timeNeedToRemove) {
            this.timeAvailable.remove(remove);
        }
    }

    public static void main(String[] args) {
//        ArrayList<String> addList = new ArrayList<>();
//
//        // Add elements to the ArrayList
//        addList.add("Apple");
//        addList.add("Banana");
//        addList.add("Orange");
//        addList.add("Mango");
//        addList.add("Banana");
//        
//        ArrayList<String> removeList = new ArrayList<>();
//
//        // Add elements to the ArrayList
//        removeList.add("Apple");
//        removeList.add("Banana");
//        
//        TimeAvailable ta = new TimeAvailable(addList, removeList);
//        for(String fruits:ta.getTimeAvailable()){
//            System.out.println("fruit:"+fruits);
//        }
        TimeDAOImpl timeDAOImpl = new TimeDAOImpl();

        timeDAOImpl.comboBoxTimeAvailable();
        ArrayList<String> ta = new ArrayList<>();
        ArrayList<String> tr = new ArrayList<>();
        for (String a : timeDAOImpl.getTimeAvailable()) {
            ta.add(a);
            System.out.println("a"+a);  
        }
        ta.remove("09:00-10:30 AM");
        for (String a : ta) {
            System.out.println("r"+a);  
        }
        

//        TimeAvailable taa = new TimeAvailable(ta, tr);

    }

}
