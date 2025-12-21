/*Write a menu driven program in Java to perform insertion, deletion, linear search, binary
search, to find maximum value, to count even/ odd and to perform insertion sort operation in
one dimensional array. */

import java.util.*;

public class Prob2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Insert element");
            System.out.println("2. Delete element");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum Value");
            System.out.println("6. Count Even and Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: 
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();

                    if (pos < 0 || pos > n) {
                        System.out.println("Invalid position!");
                        break;
                    }

                    int[] newArr = new int[n + 1];
                    for (int i = 0, j = 0; i < newArr.length; i++) {
                        if (i == pos)
                            newArr[i] = val;
                        else
                            newArr[i] = arr[j++];
                    }
                    arr = newArr;
                    n++;
                    System.out.println("Element inserted successfully.");
                    break;

                case 2: 
                    System.out.print("Enter position to delete: ");
                    pos = sc.nextInt();

                    if (pos < 0 || pos >= n) {
                        System.out.println("Invalid position!");
                        break;
                    }

                    newArr = new int[n - 1];
                    for (int i = 0, j = 0; i < n; i++) {
                        if (i != pos)
                            newArr[j++] = arr[i];
                    }
                    arr = newArr;
                    n--;
                    System.out.println("Element deleted successfully.");
                    break;

                case 3: 
                    System.out.print("Enter element to search: ");
                    val = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (arr[i] == val) {
                            System.out.println("Element found at index " + i);
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Element not found.");
                    break;

                case 4:
                    Arrays.sort(arr);
                    System.out.print("Enter element to search: ");
                    val = sc.nextInt();

                    int low = 0, high = n - 1;
                    found = false;

                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (arr[mid] == val) {
                            System.out.println("Element found at index " + mid);
                            found = true;
                            break;
                        } else if (arr[mid] < val)
                            low = mid + 1;
                        else
                            high = mid - 1;
                    }

                    if (!found)
                        System.out.println("Element not found.");
                    break;

                case 5: 
                    int max = arr[0];
                    for (int i = 1; i < n; i++) {
                        if (arr[i] > max)
                            max = arr[i];
                    }
                    System.out.println("Maximum value: " + max);
                    break;

                case 6: 
                    int even = 0, odd = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 2 == 0)
                            even++;
                        else
                            odd++;
                    }
                    System.out.println("Even count: " + even);
                    System.out.println("Odd count: " + odd);
                    break;

                case 7: 
                    for (int i = 1; i < n; i++) {
                        int key = arr[i];
                        int j = i - 1;
                        while (j >= 0 && arr[j] > key) {
                            arr[j + 1] = arr[j];
                            j--;
                        }
                        arr[j + 1] = key;
                    }
                    System.out.println("Array sorted using Insertion Sort.");
                    break;

                case 8: 
                    System.out.println("Array elements:");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);
    }
}
