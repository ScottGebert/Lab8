package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        City c = new City("Estevan", "SK");
        list.addCity(c);
        assertEquals(list.hasCity(c), true);
        assertEquals(list.hasCity(new City("Edmonton", "AB")), false);
    }

    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City c = new City("Estevan", "SK");
        list.addCity(c);
        assertEquals(list.hasCity(c), true);
        list.deleteCity(c);
        assertEquals(list.hasCity(c), false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(new City("Calgary", "AB"));
        });
    }

    @Test
    public void countCityTest(){
        list = MockCityList();
        City c = new City("Estevan", "SK");
        list.addCity(c);
        assertEquals(list.getCount(), 1);
    }


}


