package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {

    private Integer divisibleBy;

    DivisibleByFilter(Integer num){
        if(num == 0) this.divisibleBy = 1;
        else this.divisibleBy = num;
    }

    public boolean accept(Integer number){
        return number % divisibleBy == 0;
    }
}
