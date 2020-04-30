package Course2.ch07;

import lab4.Str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class countingRadixSort {
    public static void main(String[] args) {
//        String[] arr = new String[]{"064", "008", "000", "001", "343", "010"};
//        countingRadixSort(arr, 3);
//        for (String s : arr)
//            System.out.print(s + " "); //输出：000 001 008 010 064 343
        int[] one = {6,1,6,8,6,8,2,1,9,26,7,15};
        int[] out =countingRadixSort3(one,2);
        for(int i=0;i<out.length;i++){
            System.out.println(out[i]);
        }


    }

    public static void countingRadixSort(String[] arr, int strinLen) {
        final int BUCKETS = 256;
        int N = arr.length;
        String[] buffer = new String[N];

        String[] in = arr;
        String[] out = buffer;

        for (int pos = strinLen - 1; pos >= 0; pos--) {
            int[] count = new int[BUCKETS + 1];
            for (int i = 0; i < N; i++) {
                count[in[i].charAt(pos) + 1]++;
            }
            for (int b = 1; b <= BUCKETS; b++)
                count[b] += count[b - 1];
            for (int i = 0; i < N; i++) {
                int k = count[in[i].charAt(pos)];
                out[count[in[i].charAt(pos)]++] = in[i];
            }
            // as the comparision demonstrated, the method below use the inverted
            // order to traverse each element
//            for (int i = arr.length - 1; i >= 0; i--) {
//                out[--count[arr[i]/n%10]] = arr[i];
//            }

            String[] tmp = in;
            in = out;
            out = tmp;

        }

        if (strinLen % 2 == 1)
            for (int i = 0; i < arr.length; i++)
                out[i] = in[i];
    }

    public static int[] countingRadixSort3(int[] arr, int num) {
        final int BUCKETS = 10;
        int[] out = new int[arr.length];
        int[] tmp = new int[arr.length];
        int[] count = new int[BUCKETS];
        for(int m =0,n =1;m<num;m++,n*=10) {
            for (int i = 0; i < arr.length; i++) {
                count[arr[i]/n % 10]++;
            }
            for (int i = 1; i < BUCKETS; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                out[--count[arr[i]/n%10]] = arr[i];
            }
            //arr = out; this is not right cuz arr points to out, insead of copying out
            for(int i=0;i<out.length;i++){
                arr[i] =out[i];
            }
            count = new int[BUCKETS];
        }
        return arr;
    }

    public static void countingRadixSort2(int[] arr, int strinLen) {
        final int BUCKETS = 10;
        int N = arr.length;
        int[] buffer = new int[N];
        int[] out = new int[arr.length];

        for (int pos = strinLen - 1, n = 1; pos >= 0; pos--, n *= 10) {
            int[] count = new int[BUCKETS];
            for (int i = 0; i < arr.length; i++) {
                count[arr[i] / n % 10]++;
            }
            for (int i = 1; i < BUCKETS; i++) {
                count[i] += count[i - 1];
            }
            for (int i = arr.length; i > 0; i--) {
                out[--count[arr[i]]] = arr[i];
            }

        }
//        for (int pos = strinLen - 1,n=0; pos >= 0; pos--,n*=10)
//        {
//            int [] count = new int[BUCKETS + 1];
//            for (int i = 0; i < N; i++) {
//                count[in[i].charAt(pos) + 1]++;
//            }
//            for (int b = 1; b <= BUCKETS; b++)
//                count[b] += count[b - 1];
//            for (int i = 0; i < N; i++) {
//                int k = count[in[i].charAt(pos)];
//                out[count[in[i].charAt(pos)]++] = in[i];
//            }
//            for(int i =arr.length-1;i>0;i--){
////                tsortArr[--sortArr[arr[i]-min]]=arr[i];
//                out[--arr[i]]=arr[i];
//            }
//            String [] tmp = in;
//            in = out;
//            out = tmp;
//        }

    }

    public static void main3(String[] args) {
//        {23, 6, 189, 45, 9, 287, 56, 1, 798, 34, 65, 652, 5};
        int[] arr = {23, 6, 189, 45, 9, 287, 56, 1, 798, 34, 65, 652, 5};
//                {6,21,123};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //存最数组中最大的数字
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //计算最大数字是几位数
        int maxLength = (max + "").length();
        //用于临时存储数据的数组
        int[][] temp = new int[10][arr.length];
        //用于记录在temp中相应的数组中存放的数字的数量
        int[] counts = new int[10];
        //根据最大长度的数决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //把每一个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                //计算余数
                int ys = arr[j] / n % 10;
                //把当前遍历的数据放入指定的数组中
                temp[ys][counts[ys]] = arr[j];
                //记录数量
                counts[ys]++;
            }
            //记录取的元素需要放的位置
            int index = 0;
            //把数字取出来
            for (int k = 0; k < counts.length; k++) {
                //记录数量的数组中当前余数记录的数量不为0
                if (counts[k] != 0) {
                    //循环取出元素
                    for (int l = 0; l < counts[k]; l++) {
                        //取出元素
                        arr[index] = temp[k][l];
                        //记录下一个位置
                        index++;
                    }
                    //把数量置为0
                    counts[k] = 0;
                }
            }
        }
    }

    /**
     * 桶排序 将待排序数列 放入n个桶中 对于每个数列有
     * 最大值 max     最小值 min        桶数 n(最后一个桶只存储最大值)        所以(1-(n-1))中每个桶的区间大小应为(max-min)/(n-1)
     * 　　　 此时有==> 元素i入桶的序列号为:int t=(arr[i]-min)*(n-1)/(max-min)
     *
     * @param arr 待排序数列
     * @param n   　　桶数
     */
    public static void buckSort(double[] arr, int n) {

        /* 创建n个桶 使用ArrayList作桶 */
        List <Double>[] bucks = new ArrayList[n];
        for (int i = 0; i < bucks.length; i++) {
            bucks[i] = new ArrayList <>();
        }

        /* 获取数列的最大值最小值 */
        double max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        /* 将元素以此放入桶中 */
        for (int i = 0; i < arr.length; i++) {
            /* 计算元素该入哪个桶 */
            int t = (int) ((arr[i] - min) * (n - 1) / (max - min));
            bucks[t].add(arr[i]);
        }
        /* 对每个桶单独排序 */
        for (int i = 0; i < bucks.length; i++) {
            Collections.sort(bucks[i]);
            System.out.println(bucks[i]);
        }

        /* 将桶中元素 放回原数组 */
        for (int i = 0, k = 0; i < bucks.length; i++) {
            for (int j = 0; j < bucks[i].size(); j++) {
                arr[k++] = bucks[i].get(j);
            }
        }
        System.out.println("排序数列: " + Arrays.toString(arr));
    }
}
