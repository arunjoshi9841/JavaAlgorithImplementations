/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeshort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author arunj
 */
public class MergeShort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
 int i, n;
 Scanner scn = new Scanner(System.in);
 System.out.print("\nHow many values are in your array? ");
 
 n = scn.nextInt();
 int array[];
 array = new int[n];
 System.out.println("\nEnter the values ");
 for (i=0; i< n; i++)
 array[i] = scn.nextInt();
 scn.close();
 System.out.println("\nUnsorted array:");
  System.out.println(Arrays.toString(array));

System.out.println("\n========================================");
System.out.println("Sorted array:");
        mergeSort(array);
        System.out.println(Arrays.toString(array));
 
 }

    public static void  mergeSort(int[] array) {
         
        if (array.length>1){
            
        int left[] = leftHalf(array);
        int right[]=rightHalf(array);
        
   
       mergeSort(left);
        
        mergeSort(right);
           
      Merge (array,left,right);
        }}
    // Returns the first half of the given array.
    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        System.arraycopy(array, 0, left, 0, size1);
        return left;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        
        return right;
    }
    
    public static void Merge(int[] result, int[] left, int[] right) {
   
    int i =0;
    int j=0;
    for (int k =0; k<result.length; k++){
         if (j >= right.length || (i < left.length && 
                    left[i] >= right[j])) {
                result[k] = left[i];    // take from left
                i++;
            } else {
                result[k] = right[j];   // take from right
                j++;
            }
    }
 
    }
    }


    
    

