package com.mjc813;

import com.google.gson.Gson;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;


import java.util.Calendar;

public class TestJson {

    @Test
    public void test() {
        PatientOfAnimal cat1 = new PatientOfAnimal(
                "야옹이", "eiskd922k399a",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                0
        );


        // https://github.com/google/gson/blob/main/UserGuide.md#primitives-examples
        // GSON 개발 시 참조할 주소
        Gson gson = new Gson();
//        gson.toJson(1);            // ==> 1
//        gson.toJson("abcd");       // ==> "abcd"
//        gson.toJson(Long.parseLong("10")); // ==> 10
//        int[] values = { 1 };
        String s = gson.toJson(cat1);       // ==> [1]
        System.out.println(s);

        PatientOfAnimal result = gson.fromJson(s, PatientOfAnimal.class);
        System.out.println(result);

        assertThat(result.getName()).isEqualTo("야옹이");
        assertThat(result.getId()).isEqualTo("eiskd922k399a");
//        assertThat(result.getDayOfHospitalize()).isEqualTo(cat1.getDayOfHospitalize());
//        assertThat(result.getCountOfVisitation()).isEqualTo(cat1.getCountOfVisitation());
    }
}
