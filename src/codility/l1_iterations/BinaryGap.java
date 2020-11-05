package codility.l1_iterations;

import java.util.Arrays;

/**
 * <h1>BinaryGap</h1>
 * Find longest sequence of zeros in binary representation of an integer.
 * @see <a href="https://app.codility.com/programmers/lessons/1-iterations/binary_gap/">Problem Detail</a>
 * @see <a href="https://app.codility.com/demo/results/training5FBEQS-UGC/">Codility report</a>
 * @author Sijan Maharjan
 * @since 2020-11-02
 */
public class BinaryGap {

    public static int solution(int N) {
        return Arrays.stream(
                Integer.toBinaryString(N)                        //converts to binary
                        .replace("0", " ")      // replaces 0s to whitespaces
                        .trim()                                    //trim to remove leading and trailing whitespaces(ie 0s)
                        .split("1+")                        //creates array of 0s (ie gaps)
        ).mapToInt(String::length)                                 //maps to array of length of 0s (length of gaps)
                .max()                                              //gets maximum gap length
                .orElse(0);                                 // otherwise the gap is 0
    }

    public static void main(String[] args) {
        System.out.println(solution(529));
    }
}
