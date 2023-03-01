import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//This problem was recently asked by Google.
// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
// Bonus: Can you do this in one pass?

class Problem1{

    static boolean twosum(int[] arr, int k){
        if (arr == null || arr.length < 2)
            return false;

        Set<Integer> tmp = new HashSet<>();

        for (int val : arr) {
            if (tmp.contains(val))
                return true;
            tmp.add(k - val);
        }

        return false;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(twosum(arr,k));
        sc.close();
    }
}