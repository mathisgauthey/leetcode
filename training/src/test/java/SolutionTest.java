import static org.assertj.core.api.Assertions.assertThat;
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
import java.util.Arrays;

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

    @Nested
    class maxProduct_testCases {

        @Test
        public void maxProduct_testCase1() {
            // GIVEN
            int[] num = { 3, 4, 5, 2 };

            // WHEN
            int res = Solution.maxProduct(num);

            // THEN
            assertThat(res).isEqualTo(12);
        }

        @Test
        public void maxProduct_testCase2() {
            // GIVEN
            int[] num = { 1, 5, 4, 5 };

            // WHEN
            int res = Solution.maxProduct(num);

            // THEN
            assertThat(res).isEqualTo(16);
        }

        @Test
        public void maxProduct_testCase3() {
            // GIVEN
            int[] num = { 3, 7 };

            // WHEN
            int res = Solution.maxProduct(num);

            // THEN
            assertThat(res).isEqualTo(12);
        }

    }

    @Nested
    class strStr_testCases {

        @Test
        public void strStr_testCase1() {
            // GIVEN
            String haystack = "sabutsad";
            String needle = "sad";

            // WHEN
            int result = Solution.strStr(haystack, needle);

            // THEN
            assertThat(result).isEqualTo(5);
        }

        @Test
        public void strStr_testCase2() {
            // GIVEN
            String haystack = "leetcode";
            String needle = "leeto";

            // WHEN
            int result = Solution.strStr(haystack, needle);

            // THEN
            assertThat(result).isEqualTo(-1);
        }

        @Test
        public void strStr_testCase3() {
            // GIVEN
            String haystack = "programming";
            String needle = "gram";

            // WHEN
            int result = Solution.strStr(haystack, needle);

            // THEN
            assertThat(result).isEqualTo(3);
        }

        @Test
        public void strStr_testCase4() {
            // GIVEN
            String haystack = "hello";
            String needle = "ll";

            // WHEN
            int result = Solution.strStr(haystack, needle);

            // THEN
            assertThat(result).isEqualTo(2);
        }

        @Test
        public void strStr_testCase5() {
            // GIVEN
            String haystack = "aaa";
            String needle = "aaaa";

            // WHEN
            int result = Solution.strStr(haystack, needle);

            // THEN
            assertThat(result).isEqualTo(-1);
        }

        @Test
        public void strStr_testCase6() {
            // GIVEN
            String haystack = "mississippi";
            String needle = "issip";

            // WHEN
            int result = Solution.strStr(haystack, needle);

            // THEN
            assertThat(result).isEqualTo(4);
        }
    }

    @Nested
    class removeElement_testCases {
        @Test
        public void testRemoveElementExample1() {
            // GIVEN
            int[] nums = { 3, 2, 2, 3 };
            int val = 3;
            int[] expectedNums = { 2, 2 };
            int expectedLength = 2;

            // WHEN
            int actualLength = Solution.removeElement(nums, val);

            // THEN
            assertEquals(expectedLength, actualLength);
            assertArrayEquals(Arrays.copyOfRange(nums, 0, expectedLength), expectedNums);
        }

        @Test
        public void testRemoveElementExample2() {
            // GIVEN
            int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
            int val = 2;
            int[] expectedNums = { 0, 1, 3, 0, 4 };
            int expectedLength = 5;

            // WHEN
            int actualLength = Solution.removeElement(nums, val);

            // THEN
            assertEquals(expectedLength, actualLength);
            assertArrayEquals(Arrays.copyOfRange(nums, 0, expectedLength), expectedNums);
        }
    }

    @Nested
    class removeDuplicates_testCases {
        @Test
        public void testRemoveDuplicates_Case1() {
            // GIVEN
            int[] nums = { 1, 1, 2 };
            int expectedLength = 2;
            int[] expectedNums = { 1, 2 };

            // WHEN
            int actualLength = Solution.removeDuplicates(nums);

            // THEN
            assertEquals(expectedLength, actualLength);
            assertArrayEquals(Arrays.copyOfRange(nums, 0, expectedLength), expectedNums);
        }

        @Test
        public void testRemoveDuplicates_Case2() {
            // GIVEN
            int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
            int expectedLength = 5;
            int[] expectedNums = { 0, 1, 2, 3, 4 };

            // WHEN
            int actualLength = Solution.removeDuplicates(nums);

            // THEN
            assertEquals(expectedLength, actualLength);
            assertArrayEquals(Arrays.copyOfRange(nums, 0, expectedLength), expectedNums);
        }
    }

}
