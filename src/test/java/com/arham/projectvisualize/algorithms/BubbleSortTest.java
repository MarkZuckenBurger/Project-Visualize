package com.arham.projectvisualize.algorithms;

import com.arham.projectvisualize.core.SortStep;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for BubbleSort, every method with @Test above it is its own test and JUnit runs each one separately.
 * A test passes as long as none of the asserts in it fail and nothing crashes.
 */
class BubbleSortTest {

    //One BubbleSort object shared by all the tests, fine to share since sort() doesn't save anything between calls
    private final BubbleSort bubbleSort = new BubbleSort();

    //Helper method not a test (no @Test on it).
    //sort() gives back a list of steps and not a sorted list so this grabs the last step which has the finished array
    private List<Integer> finalState(List<SortStep> steps) {
        return steps.get(steps.size() - 1).arrayState();
    }

    //Normal case: a jumbled list should come out in ascending order
    @Test
    void sortsUnsortedList() {
        List<SortStep> steps = bubbleSort.sort(List.of(5, 3, 1, 4, 2));

        //assertEquals(expected, actual) fails the test if they don't match, expected value always goes first
        assertEquals(List.of(1, 2, 3, 4, 5), finalState(steps));
    }

    //Already sorted list so nothing should get swapped and it should come out the same
    @Test
    void leavesSortedListSorted() {
        List<SortStep> steps = bubbleSort.sort(List.of(1, 2, 3, 4));

        assertEquals(List.of(1, 2, 3, 4), finalState(steps));
    }

    //Checks repeated values don't go missing or get doubled up.
    //Can't check if equal values keep their order due to two 3s looking exactly the same
    @Test
    void handlesDuplicates() {
        List<SortStep> steps = bubbleSort.sort(List.of(3, 1, 3, 2, 1));

        assertEquals(List.of(1, 1, 2, 3, 3), finalState(steps));
    }

    //sort() makes a copy of the input so the list we pass in should stay the same.
    //Using ArrayList instead of List.of on purpose: List.of can't be changed at all so it would just throw an
    //exception, with ArrayList the change would actually happen and assertEquals would catch it
    @Test
    void doesNotModifyOriginalInput() {
        List<Integer> input = new ArrayList<>(List.of(4, 2, 3, 1));

        bubbleSort.sort(input);

        //This fails if sort() changed the original list instead of the copy
        assertEquals(List.of(4, 2, 3, 1), input);
    }

    //0 or 1 elements means nothing to compare so there shouldn't be any steps.
    //Can't use finalState() here due to it crashing when trying to get the last step of an empty list
    @Test
    void emptyOrSingleElementProducesNoSteps() {
        //assertTrue(condition) fails the test if the condition is false
        assertTrue(bubbleSort.sort(List.of()).isEmpty());
        assertTrue(bubbleSort.sort(List.of(7)).isEmpty());
    }
}