//name:Prathamesh Chougale
//roll no:TYCOA40

class assignment_1 {
    public static String multiply(String num1) {
        int n1 = num1.length();
        if (n1 == 0)
            return "0";
        int[] result = new int[n1 * 2];
        int i_n1 = 0;
        int i_n2 = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            int n_1 = num1.charAt(i) - '0';
            i_n2 = 0;
            for (int j = n1 - 1; j >= 0; j--) {
                int n_2 = num1.charAt(j) - '0';
                int sum = n_1 * n_2 + result[i_n1 + i_n2] + carry;
                carry = sum / 10;
                result[i_n1 + i_n2] = sum % 10;

                i_n2++;
            }
            if (carry > 0)
                result[i_n1 + i_n2] += carry;
            i_n1++;
        }
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;
        if (i == -1)
            return "0";
        String s = "";
        while (i >= 0)
            s += Integer.toString(result[i--]);

        return s;
    }

    public static void main(String[] args) {
        String str1 = "454545454545454545";
        System.out.println(multiply(str1));

    }
}
