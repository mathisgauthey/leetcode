import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.leetcode.problems.Solution;

public class SolutionTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({ "52,5", "4206,''", "35427,35427", "10133890, 1013389" })
    void largestOddNumber_Case_1(String arg, String expectResult) {
        // Arrange

        // Act
        String actualResult = Solution.largestOddNumber(arg);

        // Assert
        assertEquals(expectResult, actualResult);
    }

}
