package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    private List<Integer> list;

    @BeforeEach
    public void init(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void deduplicate() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);

        IListSorter sorter = Mockito.mock(IListSorter.class);

        Mockito.when(sorter.sort()).thenReturn(Arrays.asList(1,2,4,5));

        List<Integer> distinct = deduplicator.deduplicate(sorter);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list);

        IListSorter sorter = Mockito.mock(IListSorter.class);

        Mockito.when(sorter.sort()).thenReturn(Arrays.asList(1,2,2,4));

        List<Integer> distinct = deduplicator.deduplicate(sorter);

        Assertions.assertEquals(expected, distinct);
    }
}
