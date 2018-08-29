package com.nao.nao_scale;

public class HuoQuZuiZhi {  
    public static void main(String[] args){  
        int arr[] = new int[]{1,2,3,4,-9,5,-6,74,52,-13,11};  
        printArr(arr);  //调用遍历数组的函数  
        System.out.println("最大值: arr["+getMaxIndex(arr)+"] = "+getMaxNum(arr));  
        System.out.println("最小值: arr["+getMinIndex(arr)+"] = "+getMinNum(arr));  
    }  
      
    //遍历数组  
    public static void printArr(int[] arr){  
        System.out.print("原数组：  arr["+arr.length+"] = {");  
        for(int i=0; i<arr.length; i++){  
            if(i==arr.length-1){  
                System.out.print(arr[i]+"}\n");  
            }else{  
                System.out.print(arr[i]+",");  
            }  
        }         
    }  
      
    //获取最大值的下标  
    public static int getMaxIndex(int[] arr){  
        int maxIndex = 0;   //获取到的最大值的角标  
        for(int i=0; i<arr.length; i++){  
            if(arr[i] > arr[maxIndex]){  
                maxIndex = i;  
            }  
        }  
        return maxIndex;  
    }  
      
    //获取最大值  
    public static int getMaxNum(int[] arr){  
        int maxNum = arr[0];  
        for(int i=0; i<arr.length; i++){  
            if(arr[i] > maxNum){  
                maxNum = arr[i];  
            }  
        }  
        return maxNum;  
    }  
      
    //获取最大值的下标  
    public static int getMinIndex(int[] arr){  
        int minIndex = 0;  
        for(int i=0; i<arr.length; i++){  
            if(arr[i] < arr[minIndex]){  
                minIndex = i;  
            }  
        }  
        return minIndex;  
    }  
      
    //获取最小值  
    public static int getMinNum(int[] arr){  
        int minNum = arr[0];  
        for(int i=0; i<arr.length; i++){  
            if(arr[i] < minNum){  
                minNum = arr[i];  
            }  
        }  
        return minNum;  
    }  
}  
