package logo;

public class LogoMM {
    private int n;
    private int rows;
    private int middle;
    private int countdown;
    private StringBuilder basicStars;

    public LogoMM(int n) {
        this.n = n;
        this.rows = n + 1;
        this.middle = rows/2;
        this.countdown = 0;
        this.basicStars = new StringBuilder();
    }

    public void printMMLogo() {
        basicStars.append("*".repeat(n));
        for (int i = 0; i < rows; i++) {
            StringBuilder startRow = emptyRow();
            if (i < middle) {
                printFirsHalf(startRow, i);
            } else {
                printSecondHalf(startRow, i);
            }
        }
    }

    /*
    method takes as parameter the start row, replacing
    stars on the right places
    after the replacement it is printing the final row
     */
    private void printFirsHalf(StringBuilder printRow, int currentRowNum) {
        printRow.replace(
                (n - currentRowNum), (2*n + currentRowNum), currentRowStars(basicStars, currentRowNum).toString());
        printRow.replace(
                (3*n - currentRowNum), (4*n + currentRowNum), currentRowStars(basicStars, currentRowNum).toString());
        printRow.append(printRow);
        System.out.println(printRow);
        //countdown is counting for the method printSecondHalf()
        countdown++;
    }

    /*
    method takes as parameter the start row, replacing
    stars on the right places
    after the replacement it is printing the final row
     */
    private void printSecondHalf(StringBuilder printRow, int currentRowNum) {
        countdown--;
        printRow.replace((n - currentRowNum), (n + countdown), basicStars.toString());
        printRow.replace((n + currentRowNum), (3*n + countdown), currentRowStars(basicStars, countdown).toString());
        printRow.replace((3*n + currentRowNum), (4*n + currentRowNum), basicStars.toString());
        printRow.append(printRow);
        System.out.println(printRow);
    }

    /*
    creating the stars for each row, taking as parameter
    the basic N*stars StringBuilder and counter
    for first half the counter is the current row,
    for the second half the counter is countdown
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
