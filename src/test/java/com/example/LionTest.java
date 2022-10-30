package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;//поле для конструктора

    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;

        this.hasMane = hasMane;
    }


    @Parameterized.Parameters
    public static Object[][] getHasMane() {
        Parameters parameters = new Parameters();
        return new Object[][] {
                {parameters.getMALE_SEX(), true},
                {parameters.getFEMALE_SEX(), false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

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
        Lion lion = new Lion(feline, sex);
        boolean expectedResult = hasMane;

        boolean actualResult = lion.doesHaveMane();

        assertEquals("Incorrect result", expectedResult, actualResult);
    }

    @Test
    public void getFoodReturnsPredatorFoodList() throws Exception {
        Lion lion = new Lion(feline, sex);
        Parameters parameters = new Parameters();
        Mockito.when(feline.eatMeat()).thenReturn(parameters.getPREDATOR_FOOD_LIST());
        List<String> expectedFoodList = parameters.getPREDATOR_FOOD_LIST();

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
