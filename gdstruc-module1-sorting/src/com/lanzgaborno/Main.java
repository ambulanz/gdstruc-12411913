package com.lanzgaborno;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] bubbleSortNumbers = new int[10];

        bubbleSortNumbers[0] = 35;
        bubbleSortNumbers[1] = 69;
        bubbleSortNumbers[2] = 1;
        bubbleSortNumbers[3] = 10;
        bubbleSortNumbers[4] = -50;
        bubbleSortNumbers[5] = 320;
        bubbleSortNumbers[6] = 63;
        bubbleSortNumbers[7] = 58;
        bubbleSortNumbers[8] = 26;
        bubbleSortNumbers[9] = 13;

        int[] selectionSortNumbers = new int[10];
        selectionSortNumbers[0] = 36;
        selectionSortNumbers[1] = 69;
        selectionSortNumbers[2] = 2;
        selectionSortNumbers[3] = 11;
        selectionSortNumbers[4] = -49;
        selectionSortNumbers[5] = 321;
        selectionSortNumbers[6] = 64;
        selectionSortNumbers[7] = 59;
        selectionSortNumbers[8] = 27;
        selectionSortNumbers[9] = 14;

        //Bubble Sort
        System.out.println("Before bubble sort:");
        printArrayElements(bubbleSortNumbers);

        bubbleSort(bubbleSortNumbers);

        System.out.println("\n\nAfter bubble sort:");
        printArrayElements(bubbleSortNumbers);

        //Selection Sort
        System.out.println("\n\nBefore selection sort:");
        printArrayElements(selectionSortNumbers);

        selectionSort(selectionSortNumbers);

        System.out.println("\n\nAfter selection sort:");
        printArrayElements(selectionSortNumbers);
    }

    private static void bubbleSort(int[] arr){
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                if (arr[i] < arr [i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

    }

    private static void selectionSort(int [] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            int smallestIndex = 0;
            for (int i = 1; i <= lastSortedIndex; i++)
            {
                if (arr[i] < arr[smallestIndex])
                {
                    smallestIndex = i;
                }
            }

            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr [smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    private static void printArrayElements(int[] arr)
    {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
