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
    private final boolean hasMane;//поле для конструктора
//конструктор для тестовых данных
    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }


    @Parameterized.Parameters //создаем многомерный объект с тестовыми данными для метода doesHaveMane();
    public static Object[][] getHasMane() {
        Parameters parameters = new Parameters();
        return new Object[][] {
                {parameters.getMALE_SEX(), true},
                {parameters.getFEMALE_SEX(), false}
        };
    }

    @Before//подключаем мок через метод
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private IFeline feline;


    @Test//тестируем метод getKittens по умолчанию
    public void getKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedNumberOfKittens = 1;

        int actualNumberOfKittens = lion.getKittens();
        assertEquals("Incorrect number of kittens", expectedNumberOfKittens, actualNumberOfKittens);
    }
    @Test//тестируем метод doesHaveMane() в зависимости от пола
    public void doesHaveManeReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean expectedResult = hasMane;

        boolean actualResult = lion.doesHaveMane();

        assertEquals("Incorrect result", expectedResult, actualResult);
    }

    @Test//проверяем, что метод getFood возвращает список еды для хищника
    public void getFoodReturnsPredatorFoodList() throws Exception {
        Parameters parameters = new Parameters();
        Lion lion = new Lion(feline, parameters.getFEMALE_SEX());
        Mockito.when(feline.eatMeat()).thenReturn(parameters.getPREDATOR_FOOD_LIST());
        List<String> expectedFoodList = parameters.getPREDATOR_FOOD_LIST();

        List<String> actualFoodList = lion.getFood();
        assertEquals("Incorrect list of food", expectedFoodList, actualFoodList);
    }


    @Test(expected = Exception.class) //проверяем, что вызов метода doesHaveMane() с некорректным полом вызывает ошибку
    public void constructorThrowsExceptionOnUnsupportedSex() throws Exception {
        Parameters parameters = new Parameters();
        Lion lion = new Lion(feline, parameters.getINCORRECT_SEX()); //создаем объект Lion с некорректным полом
        lion.doesHaveMane(); //вызываем метод, чтобы отловить ошибку
      }

      @Test // проверяем текст исключения
    public void constructorExceptionTextIsCorrect() {
        Exception exception = null;
        try {
            Parameters parameters = new Parameters();
            Lion lion = new Lion(feline, parameters.getINCORRECT_SEX());
        } catch (Exception ex) {
            exception = ex;
        }
          assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
      }


}
