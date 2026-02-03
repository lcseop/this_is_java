package com.mjc813.machine;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestCalculator {
    @Test
    public void testAdd() {
        // assertEqual(왼쪽값, 오른쪽값); 옛날 방식
        // assertThat(실제값).isEqualTo(기대값).메소드2().메소드3(); 최신 방식
        Calculator cal = new Calculator();
        assertThat(cal.add(1, 2, 3, 7, 9)).isEqualTo(22L);
        assertThat(cal.add(-33, -77, -909)).isEqualTo(-1019L);
        assertThat(cal.add(99999, 88888, 77777, 66666, 55555)).isEqualTo(388885L);
    }
}
