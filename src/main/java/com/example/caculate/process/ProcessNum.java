package com.example.caculate.process;

public class ProcessNum {
    public void sort(int[] arrNum,int left,int right){
        if(left<right){
            int p=partition(arrNum,left,right);
            sort(arrNum,left,p-1);
            sort(arrNum,p+1,right);
        }

    }

    public int partition(int arr[], int left, int right)
    {
        int pivot = arr[right];
        int i = (left-1); // index of smaller element
        for (int j=left; j<right; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[right] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;

        return i+1;
    }
}
