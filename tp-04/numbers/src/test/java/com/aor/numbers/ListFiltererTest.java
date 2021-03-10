package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void filterer(){
        ListFilterer filterer = new ListFilterer(Arrays.asList(1,4,5,6,9,28,14));

        IListFilter ifilter = Mockito.mock(IListFilter.class);

        Mockito.when(ifilter.accept(Mockito.anyInt())).thenReturn(false);

        List<Integer> result = filterer.filter(ifilter);

        Assertions.assertEquals(Arrays.asList(), result);

        Mockito.when(ifilter.accept(Mockito.anyInt())).thenReturn(true);

        result = filterer.filter(ifilter);

        Assertions.assertEquals(Arrays.asList(1,4,5,6,9,28,14), result);

        Mockito.when(ifilter.accept(Mockito.anyInt())).thenAnswer(f -> (int)(f.getArgument(0)) % 2 == 0);

        result = filterer.filter(ifilter);

        Assertions.assertEquals(Arrays.asList(4,6,28,14), result);
    }
}
