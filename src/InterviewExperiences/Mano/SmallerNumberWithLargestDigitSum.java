package InterviewExperiences.Mano;

public class SmallerNumberWithLargestDigitSum {
    public static String solution(String S) {
        int n = S.length();
        char[] digits = S.toCharArray();

        for (int i = 0; i < n; i++) {
            if (digits[i] > '0') {
                char[] result = digits.clone();

                result[i] = (char) (result[i] - 1);

                for (int j = i + 1; j < n; j++) {
                    result[j] = '9';
                }

                if (result[0] == '0') {
                    return new String(result, 1, n - 1);
                } else {
                    return new String(result);
                }
            }
        }

        return S;
    }
}
