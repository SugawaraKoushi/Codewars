public class SquareDigits {
    public static int squareDigits(int n) {
        String number = Integer.toString(n);
        String result = "";

        String[] digits = number.split("");

        for (String digit : digits) {
            int num = Integer.parseInt(digit);
            num *= num;

            result = result.concat(Integer.toString(num));
        }

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        System.out.println(squareDigits(9119));
    }
}
