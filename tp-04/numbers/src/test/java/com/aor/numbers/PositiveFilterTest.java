package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    @Test
    public void positive(){

        PositiveFilter positiveFilter = new PositiveFilter();

        Assertions.assertEquals(true, positiveFilter.accept(3));
        Assertions.assertEquals(true, positiveFilter.accept(0));
        Assertions.assertEquals(false, positiveFilter.accept(-1));
        Assertions.assertEquals(false, positiveFilter.accept(-3));
        Assertions.assertEquals(true, positiveFilter.accept(6));
        Assertions.assertEquals(false, positiveFilter.accept(-2));
        Assertions.assertEquals(false, positiveFilter.accept(-1));
        Assertions.assertEquals(false, positiveFilter.accept(-3));
    }
}
