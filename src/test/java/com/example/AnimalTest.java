package com.example;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    //Тест для проверки метода getFamily()
    @Test
    public void getFamilyReturnsCorrectString() {
        Animal animal = new Animal(); //создаем объект класса Animal
        //Создаем переменную с ожидаемым результатом
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actualString = animal.getFamily();//создаем переменную с фактическим результатом

        Assert.assertEquals("Incorrect string", expectedString, actualString); //сравниваем ОР и ФР
    }
}
