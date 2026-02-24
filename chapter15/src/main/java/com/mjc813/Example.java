package com.mjc813;

import java.util.*;

public class Example {
    public void arrayListExample() {
        List<Board> list = new ArrayList<>();

        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        int size = list.size();
        System.out.println("총 객체 수 : " + size);
        System.out.println();

        Board board = list.get(2);
        System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());
        System.out.println();

        for(int i = 0; i < list.size(); i++) {
            Board b = list.get(i);
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
        System.out.println();

        list.remove(2);
        list.remove(2);

        for (Board b : list) {
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
    }

    public void linkedListExample() {
        List<String> list1 = new ArrayList<String>();

        List<String> list2 = new LinkedList<String>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ", (endTime-startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ", (endTime-startTime));
    }

    public void hashSetExample() {
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Java");
        set.add("Spring");

        int size = set.size();
        System.out.println("총 객체 수: " + size);

        Set<Member> set2 = new HashSet<Member>();

        set2.add(new Member("홍길동", 30));
        set2.add(new Member("홍길동", 30));

        System.out.println("총 객체 수: " + set2.size());
    }

    public void hashSetIteratorExample() {
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if (element.equals("JSP")) {
                iterator.remove();
            }
        }

        set.remove("JDBC");

        for (String element : set) {
            System.out.println(element);
        }
    }

    public void hashMapExample() {
        Map<String, Integer> map = new HashMap<>();

        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        String key = "홍길동";
        int value = map.get(key);
        System.out.println(key + " : " + value);
        System.out.println();

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();
    }
}
