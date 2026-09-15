package com.arham.projectvisualize.core;

import java.util.List;

/**
 * All algorithm in the project will stick with this interface.
 * Makes UI ask for name and list of steps to treat all algorithms the same no matter what type of algorithm it is.
 */



public interface SortAlgorithm {
    //Gets the name which shows up in the UI
    String getName();

    //This runs the algorithm on the input given and shows ever step it took
    List<SortStep> sort(List<Integer> input);
}