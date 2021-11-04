package com.source.sourceporject.sort;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 9:51 2021/11/2
 * @Modified By:
 */
public class Xsort {
    private int[] array;
    private int length;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public Xsort(int[] array){
        this.array = array;
        this.length = array.length;
    }

    public void display(){
        for(int a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    /*
     * 插入排序方法
     */
    public  void shellSort(){
        double gap = array.length;//增量长度
        int dk,sentinel,k;
        while(true){
            gap = (int)Math.ceil(gap/2);//逐渐减小增量长度
            dk = (int)gap;//确定增量长度
            for(int i=0;i<dk;i++){
                //用增量将序列分割，分别进行直接插入排序。随着增量变小为1，最后整体进行直接插入排序
                for(int j=i+dk;j<array.length;j = j+dk){
                    k = j-dk;
                    sentinel = array[j];
                    while(k>=0 && sentinel<array[k]){
                        array[k+dk] = array[k];
                        k = k-dk;
                    }
                    array[k+dk] = sentinel;
                }
            }
            //当dk为1的时候，整体进行直接插入排序
            if(dk==1){
                break;
            }
        }
    }
}
