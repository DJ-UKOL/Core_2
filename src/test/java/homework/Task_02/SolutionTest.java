package homework.Task_02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    int[] nums = {3, 4, 2, 7};
    int target = 10;

    @Test
    public void findOneFirstPairTest() {
        int[] rightResult = new int[]{3, 7};
        assertArrayEquals(rightResult, Solution.findOneFirstPair(nums, target));
    }

    @Test
    public void findOneFirstPairWithStreamTest() {
        int[] rightResult = new int[]{3, 7};
        assertArrayEquals(rightResult, Solution.findOneFirstPairWithStream(nums, target));
    }

}