package com.nukernash.problems;

public class MaxStockProfit {

	public static void main(String[] args) {
		
		Integer[] intArr1 = {15, 17, 11, 18, 21, 19, 20, 9, 13};	//Single : 10, Multiple : 2 10 1 4 = 17
		Integer[] intArr2 = {15, 17, 11, 7, 15, 19, 20, 9, 13};		//Single : 13, Multiple : 2 12 1 4 = 19
		Integer[] intArr3 = {15, 17, 11, 7, 15, 19, 20, 9, 13};		//Single : 13, Multiple : 2 12 1 4 = 19
		
		System.out.println(MaxStockProfit.getMaxProfit(intArr1));
		System.out.println(MaxStockProfit.getMaxProfit(intArr2));
		System.out.println(MaxStockProfit.getMaxProfit(intArr3));
		
	}
	
	//Single sell and buy
	public static int getMaxProfit(Integer[] intArr){
		
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int i=0; i<intArr.length; i++){
			maxProfit = Math.max(maxProfit, intArr[i] - min);
			min = Math.min(intArr[i], min);
		}
		
		return maxProfit;
	}
	
	//Multiple sell and buy
	public static int getMaxProfitWIthMultipleTransactions(Integer[] intArr){
		
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int i=0; i<intArr.length; i++){
			maxProfit = Math.max(maxProfit, intArr[i] - min);
			min = Math.min(intArr[i], min);
		}
		
		return maxProfit;
	}

}
