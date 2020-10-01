
/*
11. Design and implement in Java to find a subset of a given set S = {Sl, S2,.....,Sn} of n positive
integers whose SUM is equal to a given positive integer d. For example, if S ={1, 2, 5, 6, 8}
and d= 9, there are two solutions {1,2,6}and {1,8}. Display a suitable message, if the given
problem instance doesn't have a solution.
*/

import java.util.Scanner;

class Main {
    static int[] arr;
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value");
        int n = scanner.nextInt();
        arr = new int[n];

        System.out.println("Enter Elements of Set");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter Total Sum value");
        int total = scanner.nextInt();

        subSet(total, n - 1, new boolean[n]);

        if (count == 0) {
            System.out.println("No solution");
        }
    }

    static void subSet(int total, int index, boolean[] solution) {
        if (total == 0) {
            printSolution(solution);
        } else if (total < 0 || index < 0) {
            return;
        } else {
            boolean[] tempSolution = solution.clone();
            tempSolution[index] = false;
            subSet(total, index - 1, tempSolution);
            tempSolution[index] = true;
            subSet(total - arr[index], index - 1, tempSolution);
        }
    }

    static void printSolution(boolean[] solution) {
        count += 1;
        System.out.print("Solution: ");
        for (int i = 0; i < solution.length; i++) {
            if (solution[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}

// ///////
// Output:
//
// Enter n value
// 5
// Enter Elements of Set in Increasing Order
// 1 2 5 6 8
// Enter Total Sum value
// 9
// Solution: 1 2 6
// Solution: 1 8