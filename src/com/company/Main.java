package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("MyTreeSet: ");
        MyTreeSet();

        System.out.println("..........................................................");

        System.out.println("MyTreeMap: ");
        MyTreeMap();
    }

    private static void MyTreeSet() {
        MyTreeSet<Integer> myTreeSet = new MyTreeSet<>();

        myTreeSet.add(1);
        myTreeSet.add(2);
        myTreeSet.add(3);
        myTreeSet.add(4);
        myTreeSet.add(5);
        myTreeSet.add(6);
        System.out.println(myTreeSet);

        myTreeSet.remove(6);
        System.out.println(myTreeSet);

        System.out.println(myTreeSet.contains(3));
        System.out.println(myTreeSet.contains(-100));
        System.out.println(myTreeSet.size());
    }

    private static void MyTreeMap() {
        MyTreeMap<String> myTreeMap = new MyTreeMap<>();

        myTreeMap.put("5", 5);
        myTreeMap.put("2", 2);
        myTreeMap.put("7", 7);
        myTreeMap.put("10", 10);
        myTreeMap.put("1", 1);
        myTreeMap.put("10", 10);
        myTreeMap.put("6", 6);
        System.out.println(myTreeMap);
        myTreeMap.print();
        System.out.println(myTreeMap);

        myTreeMap.remove("6");
        System.out.println(myTreeMap);

        System.out.println(myTreeMap.containsValue(5));
        System.out.println(myTreeMap.containsKey("1"));
        System.out.println(myTreeMap.containsValue(100));
        System.out.println(myTreeMap.containsKey("45"));
        System.out.println(myTreeMap.size());
    }
}