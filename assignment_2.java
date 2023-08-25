// Java program to multiply two numbers
// represented as strings.

class assignment_2 {

    // Multiplies str1 and str2, and prints result.
    public static String multiply(String num) {
        int n = num.length();
        if (n == 0)
            return "0";
        int[] result = new int[2 * n];
        int i_n = 0;
        for (int i = n - 1; i >= 0; i--) {
            int carry = 0;
            int n_1 = num.charAt(i) - '0';
            i_n = 0;

            // Go from right to left in num2
            for (int j = n - 1; j >= 0; j--) {

                int n_2 = num.charAt(j) - '0';

                int sum = n_1 * n_2 + result[i_n + i_n] + carry;
                carry = sum / 10;
                result[i_n + i_n] = sum % 10;

                i_n++;
            }
            if (carry > 0)
                result[2 * i_n] += carry;
            i_n++;
        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;
        if (i == -1)
            return "0";

        // generate the result string
        String s = "";
        while (i >= 0)
            s += Integer.toString(result[i--]);

        return s;
    }

    // Driver code
    public static void main(String[] args) {
        String str1 = "454545454545454545";
        System.out.println(multiply(str1));

    }
}

// This code is contributed by
// sanjeev2552
