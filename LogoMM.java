package logo;

public class LogoMM {
    private int n;
    private int rows;
    private int middle;
    private int x;
    private int y;
    private StringBuilder basic;

    public LogoMM(int n) {
        this.n = n;
        this.rows = n + 1;
        this.middle = rows/2;
        this.x = 0;
        this.y = 0;
        this.basic = new StringBuilder();
    }

    public void printMMLogo() {
        basic.append("*".repeat(Math.max(0, this.n)));
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
                (n - x), (2 * n + x), currentRowStars(basic, x).toString());
        printRow.replace(
                (3* n - x), (4* n + x), currentRowStars(basic, x).toString());
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
        printRow.replace((n - x), (n + y), basic.toString());
        printRow.replace((n + x), (3* n + y), currentRowStars(basic, y).toString());
        printRow.replace((3* n + x), (4* n + x), basic.toString());
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
        emptyRow.append("-".repeat(Math.max(0, 5 * n)));
        return emptyRow;
    }
}
