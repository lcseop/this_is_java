package com.mjc813;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student stu = new Student("이순신", "mjc928319", Major.InfoTelecom);

        TransJson tj = new TransJson();
        String strJson = tj.toJsonString(stu);
        System.out.println(strJson);

        Student res = (Student) tj.toObject(strJson, Student.class);
        if (res instanceof Student stu2) {
            System.out.println(stu2);
        }
        System.out.println(tj.hashCode());
        System.out.println(res.hashCode());
    }
}