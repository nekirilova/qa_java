package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
public class CatTest {
//private Feline feline;
    @Test
    public void getSoundReturnsMeaow() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        Assert.assertEquals("Incorrect cat sound", expectedSound, actualSound);
    }
    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualListOfFood = cat.getFood();

        Assert.assertEquals("Incorrect list of food", expectedListOfFood, actualListOfFood);
    }
}
