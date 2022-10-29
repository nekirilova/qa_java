package com.example;

import org.junit.Assert;
import org.junit.Test;

public class FelineTest {
    @Test
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assert.assertEquals("Incorrect family", expectedFamily, actualFamily);
    }
}
