package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {

    @Test
    public void divisibleBy(){

        DivisibleByFilter divisibleFilter = new DivisibleByFilter(3);

        Assertions.assertEquals(true, divisibleFilter.accept(3));
        Assertions.assertEquals(true, divisibleFilter.accept(9));
        Assertions.assertEquals(false, divisibleFilter.accept(-1));
        Assertions.assertEquals(true, divisibleFilter.accept(-3));


        divisibleFilter = new DivisibleByFilter(2);

        Assertions.assertEquals(true, divisibleFilter.accept(6));
        Assertions.assertEquals(true, divisibleFilter.accept(-2));
        Assertions.assertEquals(false, divisibleFilter.accept(-1));
        Assertions.assertEquals(false, divisibleFilter.accept(-3));
    }
}
