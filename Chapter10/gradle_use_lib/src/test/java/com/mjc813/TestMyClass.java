package com.mjc813;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestMyClass {

    @Test
    public void testGson() {
        Gson gs = new Gson();
        MyClass mc = new MyClass();

        String s = gs.toJson(mc);
        MyClass mc2 = gs.fromJson(s, MyClass.class);
        assertThat(mc2.getMyArray().length).isEqualTo(mc.getMyArray().length);
        assertThat(mc2.getMyArray()).isEqualTo(mc.getMyArray());
    }

    @Test
    public void testMain() {
        assertThat(2+1).isEqualTo(3);
        assertThat(4+2).isEqualTo(6);
//        assertEquals(4, 2+2);
    }

    @Test
    public void testMain2() {
        assertThat("aaa").isEqualTo("aa" + "a").isAlphabetic();
//        assertEquals("aaa", "aa" + "a");
    }
}
