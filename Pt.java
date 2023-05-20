import java.util.Scanner;

public class Pt {
    public static void main(String[] args) {
        boolean rerun = true;
        Scanner scanner = new Scanner(System.in);

        while (rerun) {
            System.out.println("Enter 1 to print Pascal's triangle using the iterative approach.");
            System.out.println("Enter 2 to print Pascal's triangle using the recursive approach.");
            System.out.println("Enter 3 to print Pascal's triangle using the memoization approach.");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();



            switch (choice) {
                case 1:

                    printPascalTriangleIterative();
                    break;
                case 2:

                    printPascalTriangleRecursive();
                    break;
                case 3:

                    printPascalTriangleMemoization();
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            rerun = rerunProgram();
        }
    }

    public static void printPascalTriangleIterative() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        for (int i = 0; i < numRows; i++) {
            int number = 1;
            System.out.format("%" + (numRows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void printPascalTriangleRecursive() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", calculatePascalRecursive(i, j));
            }
            System.out.println();
        }
    }

    public static void printPascalTriangleMemoization() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        int[][] memo = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", calculatePascalMemoization(i, j, memo));
            }
            System.out.println();
        }
    }

    public static int calculatePascalRecursive(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        } else {
            return calculatePascalRecursive(row - 1, col - 1) + calculatePascalRecursive(row - 1, col);
        }
    }

    public static int calculatePascalMemoization(int row, int col, int[][] memo) {
        if (col == 0 || col == row) {
            return 1;
        } else if (memo[row][col] != 0) {
            return memo[row][col];
        } else {
            int result = calculatePascalMemoization(row - 1, col - 1, memo) + calculatePascalMemoization(row - 1, col, memo);
            memo[row][col] = result;
            return result;
        }
    }

    public static boolean rerunProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to rerun the program? Type Y for Yes or any other key to exit: ");
        String runAgain = scanner.next();
        return runAgain.equalsIgnoreCase("Y");
    }
}