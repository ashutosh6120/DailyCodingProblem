import java.util.Arrays;
import java.util.Scanner;

// This problem was asked by Uber.
// Given an array of integers, return a new array such that each element at index i of the new array 
//         is the product of all the numbers in the original array except the one at i.
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. 
//         If our input was [3, 2, 1], the expected output would be [2, 3, 6].
// Follow-up: what if you can't use division?



class Problem2 {

    //brute force method
    static int[] product(int[] arr,int size){
        int[] res = new int[size];
        int prod =  1;
        for(int i=0;i<size;i++){
            prod*=arr[i];
        }
        for(int i=0;i<size;i++){
            res[i] = (int) prod / (arr[i]);
        }
        return res;
    }


    // efficient approach
    static int[] product(int[] arr,int size){
        int[] res = new int[size];
        
        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = 1;
        right[size-1] = 1;

        //calculate left product
        for(int i=1;i<size;i++){
            left[i] = arr[i-1] * left[i-1];
        }

        //calculate right product
        for(int i=size-2;i>=0;i--){
            right[i] = arr[i+1] * right[i+1];
        }

        //calculate result
        for(int i=0;i<size;i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(product(arr,size)));
        sc.close();
    }
}
