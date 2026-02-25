package com.mjc813.gene;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestGeneric {

    @Test
    public void testGeneric() {
        Generic<String, Integer> human = new Generic<String, Integer>();
        assertThat(human).isNotNull();
        assertThat(human.size()).isEqualTo(0);

        human.add("홍길동", 25);
        human.add("김길동", 30);
        human.add("박길동", 50);
        human.add("이길동", 15);
        assertThat(human.size()).isEqualTo(4);

        assertThat(human.get("박길동")).isEqualTo(50);
        assertThat(human.get("이길동")).isEqualTo(15);

        human.remove("박길동");
        assertThat(human.size()).isEqualTo(3);

        human.change("홍길동", "이길동");
        assertThat(human.get("홍길동")).isEqualTo(15);
        assertThat(human.get("이길동")).isEqualTo(25);
    }
}
