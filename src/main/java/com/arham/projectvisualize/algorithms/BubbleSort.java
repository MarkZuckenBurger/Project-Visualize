package com.arham.projectvisualize.algorithms;

import com.arham.projectvisualize.core.SortAlgorithm;
import com.arham.projectvisualize.core.SortStep;
import com.arham.projectvisualize.core.SortStep.StepType;

import java.util.ArrayList;
import java.util.List;

/**
 * Normal bubble sort it looks through the array again and again to compare neighbour elements and swaps them if they
 * are in the wrong place.Simple enough to understand but important note: it can be very inefficient due to run time
 * increasing as the input increases 0(n^2).
 */



public class BubbleSort implements SortAlgorithm {
    @Override
    public String getName()
    {
        return "Bubble Sort";
    }

    @Override
    public List<SortStep> sort(List<Integer> input) {
        //make a copy of the input so we don't make changes to the callers original list
        List <Integer> array = new ArrayList<>(input);

        //Records every swap/comparrison so it can be replayed
        List<SortStep> steps = new ArrayList<>();

        //This is the outer loop: every full pass puts the next largest value into the correct place
        for (int i = 0; i < array.size() - 1; i++)
        {
            //This is the inner loop: compares each pair of neighbours and checks a smaller range
            //each pass due to last i elements already in place and not needing to be rechecked.
            for (int j = 0; j < array.size() - i - 1; j++)
            {
                steps.add(new SortStep(new ArrayList<>(array), j, j + 1, StepType.COMPARE));


                if (array.get(j) > array.get(j + 1))
                {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);


                    steps.add(new SortStep(new ArrayList<>(array), j, j + 1, StepType.SWAP));
                }
            }

        }
        return steps;
  }
}