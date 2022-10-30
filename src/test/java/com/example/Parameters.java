package com.example;

import java.util.List;

public class Parameters {

    private final String MALE_SEX = "Самец";
    private final String FEMALE_SEX = "Самка";
    private final String INCORRECT_SEX = "Самочка";

    private final List<String> PREDATOR_FOOD_LIST = List.of("Животные", "Птицы", "Рыба");

    public String getMALE_SEX() {
        return MALE_SEX;
    }
    public String getFEMALE_SEX() {
        return FEMALE_SEX;
    }
    public String getINCORRECT_SEX() {
        return INCORRECT_SEX;
    }

    public List<String> getPREDATOR_FOOD_LIST() {
        return PREDATOR_FOOD_LIST;
    }
}
