package com.example;

import org.junit.Test;

public class LionTest {

    IFeline feline;

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionOnUnsupportedSex() throws Exception {

        Lion lion = new Lion(feline, "Самка");
      }


}
