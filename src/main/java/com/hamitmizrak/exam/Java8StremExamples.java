package com.hamitmizrak.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StremExamples {

    // Array
    public static List<String> arrayToList(){
        String[] cityArray={"malatya","elazığ","bingöl","çorum",  "diyarbakır","malatya"};
        List<String> cityList=new ArrayList<String>();
        cityList=List.of(cityArray);
        return cityList;
    }

    // Collect
    public static void collectMethod(){
        List<String> original= arrayToList();
        List<String> clone=original.stream().collect(Collectors.toList());
        // for each döngüsü
        for(String temp:clone){
            System.out.print(temp+"\n");
        }
    }

    // ForEach-1
    public static void forEach1Method(){
         arrayToList().stream().forEach((temp) -> {
            System.err.println(temp);
        });
    }

    // ForEach-2
    public static void forEach2Method(){
        arrayToList().stream().forEach(System.out::println);
    }

    // ForEach
    public static void forEach3Method(){
        arrayToList().forEach(System.out::println);
    }

    // Sorted Asc (Küçükten Büyüğe Doğru)
    public static void sortedMethodAsc() {
        //arrayToList().stream().sorted().forEach(System.out::println);
      List<String> sortList=  arrayToList().stream().sorted().collect(Collectors.toList());
      sortList.forEach(System.out::println);
    }

    // Sorted Asc (Küçükten Büyüğe Doğru)
    public static void sortedMethodDesc() {
        //arrayToList().stream().sorted().forEach(System.out::println);
        List<String> sortList=  arrayToList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        sortList.forEach(System.out::println);
    }


    public static void main(String[] args) {
        /*collectMethod();*/
        /*forEachMethod();*/
        /*forEach2Method();*/
        /*forEach3Method();*/
        /*sortedMethodAsc();*/
        sortedMethodDesc();
    }

}
