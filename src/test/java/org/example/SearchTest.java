package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class SearchTest {

    @Test
    public void testAlternateList() {
        String lineal = "3, 7, 1, 9, 2";
        List<Integer> expectedList = Arrays.asList(3, 7, 1, 9, 2);
        List<Integer> actualList = MathServices.alternateList(lineal);
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testLinealSearch() {
        List<Integer> linealList = Arrays.asList(3, 7, 1, 9, 2);
        int val = 9;
        int expectedSpot = 3;
        int actualSpot = MathServices.linealSearch(linealList, val);
        assertEquals(expectedSpot, actualSpot);
    }

    @Test
    public void testBinarySearch() {
        List<Integer> lineList = Arrays.asList(3, 7, 1, 9, 2);
        int val = 9;
        int expectedSpot = 4;
        int actualSpot = MathServices.binarySearch(lineList, val);
        assertEquals(expectedSpot, actualSpot);
    }
}

