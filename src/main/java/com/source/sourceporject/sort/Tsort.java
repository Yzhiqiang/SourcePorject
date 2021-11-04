package com.source.sourceporject.sort;

import java.util.*;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 8:08 2021/11/3
 * @Modified By:
 */
public class Tsort {
    private int[] array;
    private int length;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public Tsort(int[] array){
        this.array = array;
        this.length = array.length;
    }

    public  void bucketSort(){
        //1.计算出最大值和最小值，求出两者的差值
        double min = array[0];
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        double d = max - min;

        //2.初始化桶
        int bucketNum = array.length;
        List<LinkedList<Integer>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        //3.遍历数组中的元素，把所有元素都放入对应的桶当中
        for (int i = 0; i < array.length; i++) {
            //计算当前元素应该放在哪个桶里面
            int num = (int)((array[i] - min) / (d / (bucketNum - 1)));
            bucketList.get(num).add(array[i]);
        }

        //4.对每个桶里面的元素进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        int k = 0;
        for(LinkedList<Integer> doubles : bucketList){
            for (Integer aDouble : doubles) {
                array[k] = aDouble;
                k++;
            }
        }
    }

    public  void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}
