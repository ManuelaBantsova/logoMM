package logo;

public class LogoMM {
    private int n;
    private int rows;
    private int middle;
    private int x;
    private int y;
    private StringBuilder basicStars;

    public LogoMM(int n) {
        this.n = n;
        this.rows = n + 1;
        this.middle = rows/2;
        this.x = 0;
        this.y = 0;
        this.basicStars = new StringBuilder();
    }

    public void printMMLogo() {
        basicStars.append("*".repeat(n));
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
                (n - x), (2*n + x), currentRowStars(basicStars, x).toString());
        printRow.replace(
                (3*n - x), (4*n + x), currentRowStars(basicStars, x).toString());
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
        printRow.replace((n - x), (n + y), basicStars.toString());
        printRow.replace((n + x), (3*n + y), currentRowStars(basicStars, y).toString());
        printRow.replace((3*n + x), (4*n + x), basicStars.toString());
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
        int STARS_MULTIPLIER = 2;
        currentRowStars.append("*".repeat(STARS_MULTIPLIER * counter));
        return currentRowStars;
    }

    /*
    creating empty row with "-"
     */
    private StringBuilder emptyRow() {
        StringBuilder emptyRow = new StringBuilder();
        int WIDTH_MULTIPLIER = 5;
        emptyRow.append("-".repeat(WIDTH_MULTIPLIER * n));
        return emptyRow;
    }
}
