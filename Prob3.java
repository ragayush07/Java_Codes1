/*Write a program to perform addition, subtraction, multiplication, transpose, to check square
matrix, to check matrix is diagonal, and to check matrix is identity. */

import java.util.*;

public class Prob3 {

    static Scanner sc = new Scanner(System.in);

    //read matrix
    static int[][] readMatrix(int r, int c) {
        int[][] m = new int[r][c];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        return m;
    }

    // print matrix
    static void display(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static void addition(int[][] a, int[][] b, int r, int c) {
        int[][] sum = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                sum[i][j] = a[i][j] + b[i][j];

        System.out.println("Addition Result:");
        display(sum);
    }

  
    static void subtraction(int[][] a, int[][] b, int r, int c) {
        int[][] diff = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                diff[i][j] = a[i][j] - b[i][j];

        System.out.println("Subtraction Result:");
        display(diff);
    }

   
    static void multiplication(int[][] a, int[][] b, int r1, int c1, int c2) {
        int[][] mul = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    mul[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.out.println("Multiplication Result:");
        display(mul);
    }

    
    static void transpose(int[][] a, int r, int c) {
        int[][] t = new int[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                t[j][i] = a[i][j];

        System.out.println("Transpose Matrix:");
        display(t);
    }

    static boolean isSquare(int r, int c) {
        return r == c;
    }

    static boolean isDiagonal(int[][] a, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && a[i][j] != 0)
                    return false;
        return true;
    }

    
    static boolean isIdentity(int[][] a, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j && a[i][j] != 1) return false;
                if (i != j && a[i][j] != 0) return false;
            }
        return true;
    }

    public static void main(String[] args) {

        System.out.print("Enter rows and columns of matrix: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] A = readMatrix(r, c);

        System.out.println("\n1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Transpose");
        System.out.println("5. Check Square Matrix");
        System.out.println("6. Check Diagonal Matrix");
        System.out.println("7. Check Identity Matrix");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
            case 2:
                int[][] B = readMatrix(r, c);
                if (choice == 1)
                    addition(A, B, r, c);
                else
                    subtraction(A, B, r, c);
                break;

            case 3:
                System.out.print("Enter columns of second matrix: ");
                int c2 = sc.nextInt();
                int[][] C = readMatrix(c, c2);
                multiplication(A, C, r, c, c2);
                break;

            case 4:
                transpose(A, r, c);
                break;

            case 5:
                System.out.println(isSquare(r, c) ? "Square Matrix" : "Not a Square Matrix");
                break;

            case 6:
                if (isSquare(r, c))
                    System.out.println(isDiagonal(A, r) ? "Diagonal Matrix" : "Not a Diagonal Matrix");
                else
                    System.out.println("Not a Square Matrix");
                break;

            case 7:
                if (isSquare(r, c))
                    System.out.println(isIdentity(A, r) ? "Identity Matrix" : "Not an Identity Matrix");
                else
                    System.out.println("Not a Square Matrix");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}
