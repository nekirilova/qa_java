package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {
    @Test
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assert.assertEquals("Incorrect family", expectedFamily, actualFamily);
    }

    @Test
    public void eatMeatReturnsPredatorList() throws Exception {
        Feline feline = new Feline();
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");

        List<String> actualList = feline.eatMeat();

        Assert.assertEquals("Incorrect list", expectedList, actualList);
    }

    @Test
    public void getKittensReturnsCorrectNumberOfKittens() {
        Feline feline = new Feline();
        int expectedNumberOfKittens = 5;

        int actualNumberOfKittens = feline.getKittens(5);

        Assert.assertEquals("Incorrect number of Kittens", expectedNumberOfKittens, actualNumberOfKittens);
    }

    @Test
    public void getKittensReturnsOneKitten() {
        Feline feline = new Feline();
        int expectedNumberOfKittens = 1;

        int actualNumberOfKittens = feline.getKittens();

        Assert.assertEquals("Incorrect number of Kittens", expectedNumberOfKittens, actualNumberOfKittens);
    }
}
