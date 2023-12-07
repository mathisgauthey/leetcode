import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.leetcode.problems.Solution;

public class SolutionTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({ "52,5", "4206,''", "35427,35427", "10133890, 1013389" })
    void largestOddNumber_testCases(String arg, String expectResult) {
        // Arrange

        // Act
        String actualResult = Solution.largestOddNumber(arg);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    @Nested
    class arrayStringsAreEqual_testCases {
        @Test
        public void arrayStringsAreEqual_test1() {
            // Arrange
            String[] word1 = { "ab", "c" };
            String[] word2 = { "a", "bc" };

            // Act
            boolean res = Solution.arrayStringsAreEqual(word1, word2);

            // Assert
            assertTrue(res);
        }

        @Test
        public void arrayStringsAreEqual_test2() {
            // Arrange
            String[] word1 = { "a", "cb" };
            String[] word2 = { "ab", "c" };

            // Act
            boolean res = Solution.arrayStringsAreEqual(word1, word2);

            // Assert
            assertFalse(res);
        }

        @Test
        public void arrayStringsAreEqual_test3() {
            // Arrange
            String[] word1 = { "abc", "d", "defg" };
            String[] word2 = { "abcddefg" };

            // Act
            boolean res = Solution.arrayStringsAreEqual(word1, word2);

            // Assert
            assertTrue(res);
        }
    }

    @Nested
    class merge_testCases {
        @Test
        public void merge_twoNonEmptyArrays() {
            // Given
            int[] nums1 = { 1, 2, 3, 0, 0, 0 };
            int m = 3;
            int[] nums2 = { 2, 5, 6 };
            int n = 3;

            // When
            Solution.mergeSortedArrays(nums1, m, nums2, n);

            // Then
            int[] expectedArray = { 1, 2, 2, 3, 5, 6 };
            assertArrayEquals(expectedArray, nums1);
        }

        @Test
        public void merge_oneNonEmptyArray_andOneEmptyArrays() {
            // Given
            int[] nums1 = { 1 };
            int m = 1;
            int[] nums2 = {};
            int n = 0;

            // When
            Solution.mergeSortedArrays(nums1, m, nums2, n);

            // Then
            int[] expectedArray = { 1 };
            assertArrayEquals(expectedArray, nums1);
        }

        @Test
        public void merge_oneEmptyArray_andOneNonEmptyArray() {
            // Given
            int[] nums1 = { 0 };
            // Note that because m = 0, there are no elements in nums1. The 0 is only there
            // to ensure the merge result can fit in nums1.
            int m = 0;
            int[] nums2 = { 1 };
            int n = 1;

            // When
            Solution.mergeSortedArrays(nums1, m, nums2, n);

            // Then
            int[] expectedArray = { 1 };
            assertArrayEquals(expectedArray, nums1);
        }
    }

}
