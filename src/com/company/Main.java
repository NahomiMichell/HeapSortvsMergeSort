package com.company;

import java.util.PriorityQueue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Random R = new Random();
        int size = 4;
        int[] arreglo = new int[size];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = R.nextInt();
        }

        long go = System.currentTimeMillis();
        mergeSort(arreglo);
        long end = System.currentTimeMillis();
        System.out.println("El tiempo de ejecucion del MergeSort es de: "+ (( end - go )/ 1000.0) + " segundos");

        long go1 = System.currentTimeMillis();
        for (int x : arreglo) {
            queue.offer(x);
        }

        while (!queue.isEmpty()){
           queue.remove();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("El tiempo de ejecucion del HeapSort es de: "+ (( end1 - go1 ) / 1000.0) + " segundos");


    }
    public  static int[] mergeSort(int[] arr){

        if(arr.length <= 1){
            return arr;
        }

        int medio = arr.length /2;
        int[] inferior = new int[medio];
        int[] superior = new int[arr.length - medio];

        for (int i = 0; i < medio; i++) {
            inferior[i] = arr[i];
        }

        for (int i = 0; i < superior.length ; i++) {
            superior[i] = arr[i + inferior.length];
        }
        return  merge(mergeSort(inferior), mergeSort(superior));
    }


    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0, j = 0, k = 0;

        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }
        while (j < a.length){
            retval[i++] = a[j++];
        }

        while (k < b.length){
            retval[i++] = b[k++];
        }

        return retval;
    }
}
