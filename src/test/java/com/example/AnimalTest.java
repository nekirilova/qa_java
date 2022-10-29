package com.example;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    @Test
    public void getFamilyReturnsCorrectString() {
        Animal animal = new Animal();
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actualString = animal.getFamily();

        Assert.assertEquals("Incorrect string", expectedString, actualString);
    }
}
