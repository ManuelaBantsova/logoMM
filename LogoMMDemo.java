package logo;

import java.util.Scanner;

public class LogoMMDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isPrinted = false;
        do {
            System.out.print("Please, enter desired letter thickness: ");
            int n = scanner.nextInt();
            if ((n > 2 && n < 10_000) && (n % 2 != 0)) {
                LogoMM logo = new LogoMM(n);
                logo.printMMLogo();
                isPrinted = true;
            } else {
                System.out.println("The number should be odd" +
                        " and from 2 to 10 000!");
            }
        } while (!isPrinted);
    }
}
