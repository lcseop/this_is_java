package com.mjc813;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Example example = new Example();

        System.out.println("--------------- p784 1 바이트 출력");
        example.writeExample();
        System.out.println("--------------- p786 바이트 배열 출력");
        example.writeByteArrayExample();
        System.out.println("--------------- p789 1 바이트 읽기");
        example.readExample();
        System.out.println("--------------- p792 바이트 배열 읽기");
        example.readByteArrayExample();
        System.out.println("--------------- p793 파일 복사");
        example.copyExample();
        System.out.println("--------------- p795 문자 출력");
        example.stringWriteExample();
        System.out.println("--------------- p797 문자 읽기");
        example.stringReadExample();
        System.out.println("--------------- p801 보조 스트림");
        example.characterConvertStreamExample();
        System.out.println("--------------- p803 성능 향상 스트림");
        example.bufferExample();
        System.out.println("--------------- p805 성능 향상 스트림 - 자바 소스 행단위로 읽기");
        example.readLineExample();
        System.out.println("--------------- p807 기본 타입 스트림");
        example.dataInputOutputStreamExample();
        System.out.println("--------------- p809 프린트 스트림");
        example.printStreamExample();
        System.out.println("--------------- p811 객체 스트림");
        example.objectInputOutputStreamExample();
        System.out.println("--------------- p817 File 클래스");
        example.fileExample();
        System.out.println("--------------- p820 Files 클래스");
        example.filesExample();
        System.out.println("--------------- 확인문제 7번");
        example.exam07();
        System.out.println("--------------- 확인문제 10번");
        example.exam10();
    }

    public static void SmapleOutputStream() {
        OutputStream os = null;
        try {
            os = new FileOutputStream("./test.txt");
            os.write(10);
            os.write(20);
            os.write(30);
            os.flush();
        } catch(Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if ( os != null ) {
                    os.close();
                }
            } catch (IOException e) {}
        }
    }
}