package interview;

import java.util.Arrays;

public class ProductArray {

	public static void main(String[] args) {

		int[] intArr1 = new int[]{2, 3, 4, 5, 6};
		int[] intArr2 = new int[]{2, 3, 0, 5, 6};
		int[] intArr3 = new int[]{2, 0, 4, 0, 6};
		
		
		System.out.println(Arrays.toString(intArr1));
		System.out.println(Arrays.toString(ProductArray.getProductOfArrayUsingDivision(intArr1)));
		System.out.println("==============================");
		System.out.println(Arrays.toString(intArr2));
		System.out.println(Arrays.toString(ProductArray.getProductOfArrayUsingDivision(intArr2)));
		System.out.println("==============================");
		System.out.println(Arrays.toString(intArr3));
		System.out.println(Arrays.toString(ProductArray.getProductOfArrayUsingDivision(intArr3)));
		System.out.println("==============================");
		System.out.println("==============================");
		System.out.println(Arrays.toString(intArr1));
		System.out.println(Arrays.toString(ProductArray.getProductUsingMultiplication(intArr1)));
		System.out.println("==============================");
		System.out.println(Arrays.toString(intArr2));
		System.out.println(Arrays.toString(ProductArray.getProductUsingMultiplication(intArr2)));
		System.out.println("==============================");
		System.out.println(Arrays.toString(intArr3));
		System.out.println(Arrays.toString(ProductArray.getProductUsingMultiplication(intArr3)));
		System.out.println("==============================");

	}
	
	public static int[] getProductOfArrayUsingDivision(int[] intArr){
		int[] intArr2 = new int[intArr.length];
		int noOfZeros = 0;
		int product = 1;
		for(int i=0;i<intArr.length;i++){
			if(intArr[i] == 0){
				noOfZeros++;
				continue;
			}
			product = product*intArr[i];
		}
		for(int i=0;i<intArr.length;i++){
			if(noOfZeros > 1){
				intArr2[i] = 0;
			}else if(noOfZeros == 1){
				if(intArr[i] != 0){
					intArr2[i] = 0;
				}else{
					intArr2[i] = product;
				}
			}else{
				intArr2[i] = product/intArr[i];
			}
		}
		return intArr2;
	}
	
	public static int[] getProductUsingMultiplication(int[] intArr){
		
		int[] intArr2 = new int[intArr.length];
		
		intArr2[0] = 1;
		for(int i=1; i<intArr.length; i++){
			intArr2[i] = intArr[i-1] * intArr2[i-1];
		}
		
		int product = 1;
		for(int i=intArr.length-2; i>=0; i--){
			product = product * intArr[i+1];
			intArr2[i] = intArr2[i] * product;
		}
		
		return intArr2;
	}

}
