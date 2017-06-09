package algorithm.sort;

import java.util.Arrays;

/**
 * Created by KJB-001064 on 2017/5/27.
 */
public class Sort {

    public static void quickSort(Comparable[] a, int left, int right) {
        if (left >= right)
            return;
        Comparable key = a[left];
        int mid = (left + right) / 2;
        int i = left;
        int j = right;
        while (i < j) {
            while (j > i && a[j].compareTo(key) >= 0) {
                j--;
            }
            if (j > i) {
                Sort.exch(a, j, i);
                i++;
            }
            while (i < j && a[i].compareTo(key) <= 0) {
                i++;
            }
            if (j > i) {
                Sort.exch(a, i, j);
                j--;
            }
        }
        quickSort(a, left, i - 1);
        quickSort(a, j + 1, right);
    }

    public static void shellSort(Comparable[] a) { // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        System.out.println("h is:" + h);
        while (h >= 1) { // 将数组变为h有序
            for (int i = h; i < N; i++) { // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    System.out.println(Arrays.toString(a));
                }
            }
            h = h / 3;
        }
    }

    public static void mergeSort() {

    }

    public static void insertSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                show(a);
            }
        }
    }

    public static void selectSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[i])) {
                    exch(a, j, i);
                    show(a);
                }
            }
        }
    }

    /**
     * exchange a[i] and a[j] of an array
     *
     * @param a comparable array
     * @param i a[i]
     * @param j a[j]
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    /**
     * @param v
     * @param w
     * @return true if v &lt; w
     */
    public static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }


    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void show(Comparable[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Integer[] a = {49, 38, 49, 20, 97, 76};
        String[] b = {"123", "456"};
        Integer[] c = {5, 3, 6, 7, 2, 1};
        //Sort.isSorted(b);
//        Sort.quickSort(c, 0, c.length - 1);
//        System.out.println(Arrays.toString(c));
//        Sort.quickSort(a, 0, a.length - 1);
//        System.out.println(Arrays.toString(a));
//        Collections.sort(Arrays.asList(c));
//        System.out.println(Arrays.toString(c));
        Sort.insertSort(c);
        //Object
    }
}
