public class Gugudan {
    public static void main(String[] args) {
        final String SHORT_SPACE = "    ";
        final String LONG_SPACE = "     ";

        for (int i = 2; i <= 9; i += 3) {
            System.out.println( (i != 8) ?
                    (i + "단 출력  " + LONG_SPACE + (i + 1) + "단 출력  " + LONG_SPACE + (i + 2) + "단 출력") :
                    (i + "단 출력  " + LONG_SPACE + (i + 1) + "단 출력") );
            for (int j = 1; j <= 9; j++) {
                String nums[] = new String[3];
                for (int k = 0; k <= 2; k++)
                    nums[k] = ((i+k)*j < 10) ? ((i+k) + " * " + j + " = " + (i+k) * j + LONG_SPACE) : ((i+k) + " * " + j + " = " + (i+k) * j + SHORT_SPACE);

                System.out.println( (i != 8) ?
                        (nums[0] + nums[1] + nums[2]) :
                        (nums[0] + nums[1]) );
            }
            System.out.println("");
        }
    }
}
