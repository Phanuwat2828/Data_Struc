
import java.util.Scanner;

class exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String number[] = data.split("\\s+");
        System.out.println(Integer.parseInt(number[0]) + Integer.parseInt(number[1]) + Integer.parseInt(number[2]));
    }
}