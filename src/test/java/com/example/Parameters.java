package com.example;

import java.util.List;
//класс с данными для параметризованных тестов
public class Parameters {

    private final String MALE_SEX = "Самец";
    private final String FEMALE_SEX = "Самка";
    private final String INCORRECT_SEX = "Самочка";

    private final List<String> PREDATOR_FOOD_LIST = List.of("Животные", "Птицы", "Рыба"); //список еды для Хищника

    public String getMALE_SEX() {
        return MALE_SEX;
    } //геттер, который возвращает пол "Самец"
    public String getFEMALE_SEX() {
        return FEMALE_SEX;
    } //геттер, который возвращает пол "Самка"
    public String getINCORRECT_SEX() {
        return INCORRECT_SEX;
    } // геттер, который возвращет некорректный пол

    public List<String> getPREDATOR_FOOD_LIST() {
        return PREDATOR_FOOD_LIST;
    }//геттер, который возвращает список еды для хищника
}
