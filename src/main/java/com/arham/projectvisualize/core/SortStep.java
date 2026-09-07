package com.arham.projectvisualize.core;

import java.util.List;


/**
 * Shows a single point in time when sorting algorithm is executed.
 * The algorithms return a list of these steps rather than returning a final sorted array
 * so the UI can visually replay the sorting process step at a time.
 */
public record SortStep(
        List<Integer> arrayState,     // the entire array in its current state at this step.
        int indexA,                  // the first index involved in this step.
        int indexB,                 // the second index involved in this step.
        StepType type              // what type of action this step shows.
)


{
    public enum StepType {
        COMPARE,          // two elements being compared
        SWAP,            // two elements that got swapped
        SORTED_MARK     // element got confirmed in its final sorted position
    }
}