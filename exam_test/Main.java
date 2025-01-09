
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String number[] = data.split(" ");
        System.out.println(Integer.parseInt(number[0]) - Integer.parseInt(number[1]));
    }
}
