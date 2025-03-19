
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base10 = Integer.parseInt(sc.nextLine());
        String base2 = "";
        while (base10 > 0) {
            if (base10 % 2 == 0) {
                base2 += "0";
            } else {
                base2 += "1";
            }
            base10 /= 2;
        }
        StringBuilder sb = new StringBuilder(base2);
        base2 = sb.reverse().toString();
        System.out.println(base2);
    }
}