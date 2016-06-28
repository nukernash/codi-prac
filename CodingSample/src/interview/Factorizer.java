package interview;

public class Factorizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorizer.printFactors(16);
		System.out.println("++++++++++");
		
		Factorizer.printPrimefactors(15);
	}
	
	public static void printFactors(int num) {	
		for(int i=1; i < num/2; i++){
			if(num%i == 0 ){
				int factor = num/i;
				System.out.print(factor + " X " + i);
			}
		}
	}
	
	public static void printPrimefactors(long n){
        System.out.print("The prime factorization of " + n + " is: ");
        for (long i = 2; i*i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " "); 
                n = n / i;
            }
        }
        
        if (n > 1){
        	System.out.println(n);
        }else{
        	System.out.println();
        }
    }
	
}
