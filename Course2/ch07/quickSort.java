package Course2.ch07;

//import static Course2.ch07.Sort.merge;
//import static java.lang.Integer.min;

public class quickSort {
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减 j一定要先走！
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

    public static void quickSort2(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[(low + high) / 2];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
//        arr[low] = arr[i];
//        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

    //    static<Any extends Comparable<? super Any>> void quickSort3(Any[] arr,int left, int right){
//        if(left<right){
//            int pivot =arr[(left+right)/2];
//            int i =left,j =right;
//            for(;;){
//                while (arr[i++])
//            }
//        }
//    }
    static void quickSort3(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[(left + right) / 2];
            int i = left, j = right;
            for (; ; ) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } else break;
                ;
            }
            quickSort3(arr, left, i - 1);
            quickSort3(arr, i + 1, right);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
//        quickSort(arr, 0, arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//        int[] arr2 = {10,7,2,4,7,62,3,4,2,1,8,9,19};
//        quickSort2(arr2, 0, arr2.length-1);
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.print(arr2[i]+" ");
//        }
//        {1, 21,56,3,81,45,5}
//        {10,7,2,4,7,62,3,4,2,1,8,9,19}
        int[] arr3 = {1, 21, 56, 3, 81, 45, 5, 22, 2, 81};
        quickSort(arr3, 0, arr3.length - 1);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }


}