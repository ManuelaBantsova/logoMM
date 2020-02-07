package logo;

import java.util.Scanner;

public class LogoMM {
    private int N;
    private int rows;
    private int middle;
    private int x;
    private int y;
    private StringBuilder basic;

    public LogoMM(int N) {
        this.N = N;
        this.rows = N + 1;
        this.middle = rows/2;
        this.x = 0;
        this.y = 0;
        this.basic = new StringBuilder();
    }

    public void printMMLogo() {
        basic.append("*".repeat(Math.max(0, this.N)));
        for (int i = 0; i < rows; i++) {
            StringBuilder startRow = emptyRow();
            if (i < middle) {
                printFirsHalf(startRow);
            } else {
                printSecondHalf(startRow);
            }
        }
    }

    /*
    method takes as parameter the start row, replacing
    stars on the right places
    after the replacement it is printing the final row
     */
    private void printFirsHalf(StringBuilder printRow) {
        printRow.replace(
                (N - x), (2 * N + x), currentRowStars(basic, x).toString());
        printRow.replace(
                (3*N - x), (4*N + x), currentRowStars(basic, x).toString());
        printRow.append(printRow);
        System.out.println(printRow);
        x++;
        //y is counting for the method printSecondHalf()
        y++;
    }

    /*
    method takes as parameter the start row, replacing
    stars on the right places
    after the replacement it is printing the final row
     */
    private void printSecondHalf(StringBuilder printRow) {
        y--;
        printRow.replace((N - x), (N + y), basic.toString());
        printRow.replace((N + x), (3*N + y), currentRowStars(basic, y).toString());
        printRow.replace((3*N + x), (4*N + x), basic.toString());
        printRow.append(printRow);
        System.out.println(printRow);
        x++;
    }

    /*
    creating the stars for each row, taking as parameter
    the basic N*stars StringBuilder and counter
    for first half the counter is x,
    for the second half the counter is y
     */
    private StringBuilder currentRowStars(StringBuilder basic, int counter) {
        StringBuilder currentRowStars = new StringBuilder(basic);
        currentRowStars.append("*".repeat(Math.max(0, 2 * counter)));
        return currentRowStars;
    }

    /*
    creating empty row with "-"
     */
    private StringBuilder emptyRow() {
        StringBuilder emptyRow = new StringBuilder();
        emptyRow.append("-".repeat(Math.max(0, 5 * N)));
        return emptyRow;
    }
}
