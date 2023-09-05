package org.example.numbers;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> list = new ArrayList<>();
        for(int i:intList){
            if((i > 0) && (i %2 == 0)){
                list.add(i);
            }
            Collections.sort(list);

        }
        for(int i:list){
            System.out.println(i);
        }
    }
}
