package logo;

import java.util.Scanner;

public class LogoMMDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isPrinted = false;
        do {
            System.out.print("Please, enter desired letter thickness: ");
            int N = scanner.nextInt();
            if ((N > 2 && N < 10_000) && (N % 2 != 0)) {
                LogoMM logo = new LogoMM(N);
                logo.printMMLogo();
                isPrinted = true;
            } else {
                System.out.println("The number should be odd" +
                        " and from 2 to 10 000!");
            }
        } while (!isPrinted);
    }
}
