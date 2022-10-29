package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;
    @Test
    public void getSoundReturnsMeaow() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        assertEquals("Incorrect cat sound", expectedSound, actualSound);
    }
    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {

        Cat cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualListOfFood = cat.getFood();

        assertEquals("Incorrect list of food", expectedListOfFood, actualListOfFood);
    }
}
