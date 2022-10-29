package com.example;

import org.junit.Assert;
import org.junit.Test;

public class LionTest {
    //Сделать аннотацию before и вынести туда создание lion
    IFeline feline;

    @Test
    public void doesHaveManeSetMaleReturnsTrue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        boolean expectedResult = true;

        boolean actualResult = lion.doesHaveMane();

        Assert.assertEquals("Incorrect result", expectedResult, actualResult);
    }

    @Test
    public void doesHaveManeSetFemaleReturnsFalse() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean expectedResult = false;

        boolean actualResult = lion.doesHaveMane();

        Assert.assertEquals("Incorrect result", expectedResult, actualResult);
    }

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionOnUnsupportedSex() throws Exception {

        Lion lion = new Lion(feline, "Самочка");
        lion.doesHaveMane();
      }

      @Test
    public void constructorExceptionTextIsCorrect() {
        Exception exception = null;

        try {
            Lion lion = new Lion(feline, "Самочка");
        } catch (Exception ex) {
            exception = ex;
        }

          Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
      }

      @Test
    public void getKittensReturnsOneKitten() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expectedNumberOfKittens = 1;

        int actualNumberOfKittens = lion.getKittens();

        Assert.assertEquals("Incorrect number of kittens", expectedNumberOfKittens, actualNumberOfKittens);

      }
}
