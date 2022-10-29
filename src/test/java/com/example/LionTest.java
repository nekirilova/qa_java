package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    //Сделать аннотацию before и вынести туда создание lion
    @Mock
    private IFeline feline;

    @Test
    public void getKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedNumberOfKittens = 1;

        int actualNumberOfKittens = lion.getKittens();
        assertEquals("Incorrect number of kittens", expectedNumberOfKittens, actualNumberOfKittens);
    }
    @Test
    public void doesHaveManeSetMaleReturnsTrue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        boolean expectedResult = true;

        boolean actualResult = lion.doesHaveMane();

        assertEquals("Incorrect result", expectedResult, actualResult);
    }

    @Test
    public void getFoodReturnsPredatorFoodList() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFoodList = lion.getFood();
        assertEquals("Incorrect list of food", expectedFoodList, actualFoodList);
    }

    @Test
    public void doesHaveManeSetFemaleReturnsFalse() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean expectedResult = false;

        boolean actualResult = lion.doesHaveMane();

        assertEquals("Incorrect result", expectedResult, actualResult);
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

          assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
      }


}
