package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {

    private List<Integer> list;

    ListFilterer(List<Integer> list){
        this.list = list;
    }

    public List<Integer> filter(IListFilter filter){

        List<Integer> listToRet = new ArrayList<>();

        for(Integer value: list){
            if(filter.accept(value)){
                listToRet.add(value);
            }
        }

        return listToRet;
    }
}
