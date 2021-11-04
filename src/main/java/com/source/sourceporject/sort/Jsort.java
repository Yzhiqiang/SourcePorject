package com.source.sourceporject.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 8:35 2021/11/3
 * @Modified By:
 */
public class Jsort {
    private int[] array;
    private int length;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public Jsort(int[] array){
        this.array = array;
        this.length = array.length;
    }

    public  void radixSort() {

        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 很明确的表示，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][array.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这么理解 比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        //1. 得到数组中最大的数的位数
        int max = array[0]; //假设第一数就是最大数
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        /**
         * @Description: 针对每个元素的个位数进行排序处理
         * @Param: [arr]
         * @Author: xz
         * @return: void
         * @Date: 2020/8/12 22:29
         */
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对数应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < array.length; j++) {
                //取出每个元素的个位的值
                int digitElement = array[j] / n % 10;
                //放入到对应的桶中
                //1、bucket[digitElement] 表示个位数对应的第个位数的桶
                //2、bucketElementCounts[digitElement] 表示个位数对应的第个位数的桶的数据个数
                bucket[digitElement][bucketElementCounts[digitElement]] = array[j];
                bucketElementCounts[digitElement]++;
            }

            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            //遍历每一桶，并将桶中是数据，放入到原数组
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int m = 0; m < bucketElementCounts[k]; m++) {
                        //取出元素放入到arr
                        array[index] = bucket[k][m];
                        index++;
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;
            }
        }
    }
    public  void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
