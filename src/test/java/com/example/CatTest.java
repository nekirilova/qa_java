package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline; //мокаем класс Feline


    @Test
    public void getSoundReturnsMeaow() {
        Cat cat = new Cat(feline);//создаем объект класса Cat
        String expectedSound = "Мяу"; //создаем переменную с ожидаемым результатом

        String actualSound = cat.getSound(); //вызываем метод getSound и записываем фактический результат в переменную

        assertEquals("Incorrect cat sound", expectedSound, actualSound); //сравниваем ОР и ФР
    }
    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {

        Cat cat = new Cat(feline);//создаем объект класса Cat

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));//задаем список, который будет возвращать мок, когда вызывается метод eatMeat()
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");//создаем переменную с ожидаемым результатом

        List<String> actualListOfFood = cat.getFood();//вызываем метод getFood, чтобы получить список еды

        assertEquals("Incorrect list of food", expectedListOfFood, actualListOfFood); //сравниваем ОР и ФР
    }
}
