package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int givenNumOfKittens;
    private final int expectedNumOfKittens;

    public FelineTest(int givenNumOfKittens, int expectedNumOfKittens) {
        this.givenNumOfKittens = givenNumOfKittens;
        this.expectedNumOfKittens = expectedNumOfKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getKittens() {
        return new Object[][] {
                {1, 1},
                {5, 5},
                {12, 12}
        };
    }
    @Test//тестируем, что метод getKittens возвращает столько же котят, сколько в него передали
    public void getKittensReturnsCorrectNumberOfKittens() {
        Feline feline = new Feline();//создаем объект класса Feline
        int expectedNumberOfKittens = expectedNumOfKittens; //создаем переменную с ожидаемым результатом

        int actualNumberOfKittens = feline.getKittens(givenNumOfKittens);//создаем переменную с фактическим результатом

        assertEquals("Incorrect number of Kittens", expectedNumberOfKittens, actualNumberOfKittens);//сравниваем ОР и ФР
    }

    @Test//тестируем,что метод getKittens без параметров возвращает одного котенка по умолчанию
    public void getKittensReturnsOneKitten() {
        Feline feline = new Feline();//создаем объект класса Feline
        int expectedNumberOfKittens = 1; //создаем переменную с ожидаемым результатом

        int actualNumberOfKittens = feline.getKittens();//создаем переменную с фактическим результатом

        assertEquals("Incorrect number of Kittens", expectedNumberOfKittens, actualNumberOfKittens);//сравниваем ОР и ФР
    }

    @Test //тестируем, что метод getFamily возвращает правильное семейство
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();  //создаем объект класса Feline
        String expectedFamily = "Кошачьи"; //создаем переменную с ожидаемым результатом

        String actualFamily = feline.getFamily();//создаем переменную с фактическим результатом

        assertEquals("Incorrect family", expectedFamily, actualFamily); //сравниваем ОР и ФР
    }

    @Test //тестируем, что метод eatMeat возвращает список еды для хищника
    public void eatMeatReturnsPredatorList() throws Exception {
        Feline feline = new Feline(); //создаем объект класса Feline
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба"); //создаем переменную с ожидаемым результатом

        List<String> actualList = feline.eatMeat(); //создаем переменную с фактическим результатом

        assertEquals("Incorrect list", expectedList, actualList); //сравниваем ОР и ФР
    }


}
