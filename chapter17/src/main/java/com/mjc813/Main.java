package com.mjc813;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Example example = new Example();

        System.out.println("----------------p725 스트림");
        example.streamExample();
        System.out.println("----------------p727 병렬 처리 스트림");
        example.parallelStreamExample();
        System.out.println("----------------p729 중간 처리와 최종 처리");
        example.streamPipeLineExample();
        System.out.println("----------------p732 컬렉션으로부터 스트림 얻기");
        example.collectionStreamExample();
        System.out.println("----------------p733 배열로부터 스트림 얻기");
        example.arrayStreamExample();
        System.out.println("----------------p734 숫자 범위로부터 스트림 얻기");
        example.rangeStreamExample();
        System.out.println("----------------p736 파일로부터 스트림 얻기");
        example.fileStreamExample();;
        System.out.println("----------------p738 요소 필터링");
        example.filteringExample();
        System.out.println("----------------p741 요소 맵핑");
        example.mapExample();
        example.mapExample2();
        System.out.println("----------------p744 요소를 복수 개의 요소로 변환");
        example.flatMappingExample();
        System.out.println("----------------p749 Comparable을 이용한 정렬");
        example.sortingExample();
        example.sortingExample2();
        System.out.println("----------------p752 요소를 하나씩 처리");
        example.loopingExample();
        System.out.println("----------------p753 요소 조건 만족 여부");
        example.matchingExample();
        System.out.println("----------------p755 스트림이 제공하는 기본 집계 값");
        example.aggregateExample();
        System.out.println("----------------p758 Optional");
        example.optionalExample();
        System.out.println("----------------p760 요소 커스텀 집계 (reduce)");
        example.reductionExample();
        System.out.println("----------------p763 요소 수집");
        example.collectExample();
//        System.out.println("----------------p771 병렬 스트림 사용");
//        example.parallelExample();
        System.out.println("----------------확인문제 5");
        example.exam05();
        System.out.println("----------------확인문제 6");
        example.exam06();
        System.out.println("----------------확인문제 7");
        example.exam07();
        System.out.println("----------------확인문제 8");
        example.exam08();
    }
}