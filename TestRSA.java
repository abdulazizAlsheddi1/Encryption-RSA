import java.math.BigInteger;
import java.util.Scanner;

public class TestRSA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p=0,q=0;
		int e=0;
		int euler=0;
		int message=0;
		
		RSA r1 = new RSA();
		Scanner s1 = new Scanner(System.in);
		boolean flag= true;

		
		do {
			boolean flag1=true;
			boolean flag2=true;
		System.out.println("enter p value: ");
		p=s1.nextInt();
		System.out.println("enter q value: ");
		q=s1.nextInt();
		
		if(p<=1||q<=1) {
			System.out.println("one of your inputs or both is equal or less than 1");
			continue;
		}
		
		for(int i=2;i<=p/2;i++) {
			if(p%i==0) {
				flag1=false;
			}
			
			
		}
		if(flag1==false) {
			System.out.println(p+" is not prime number, enter again: ");
			continue;
			
		}
			
			for(int j=2;j<= q/2;j++) {
				if(q%j==0) {
					flag2=false;
				}
			}
				if(flag2==false) {
					System.out.println(q+" is not prime number, enter again: ");
					continue;
				}
		 
			flag=false;
		}while(flag); 
		
		
		r1.setKey(p,q);
	
		
		euler=(p-1)*(q-1);
		System.out.println("choose e: ");
		e= s1.nextInt();
		while(e<=1 || e>euler) {
			
			System.out.println(e+" must be bigger than 1 and smaller than the euler, enter again: ");
			e= s1.nextInt();
		}
        while(r1.checkE(e, euler)==1) {
			
			System.out.println(e+" is not coprime of the euler, enter again: ");
			e= s1.nextInt();
		}
		
		int n = p*q ;
		String option=" ";
		do {
		System.out.println("You want to encrypt or decrypt ? type e for encrypt or d for decrypt"
				+ " if you finished select exit");
		option = s1.next();
		
		if (option.equalsIgnoreCase("e")) {
			r1.publickeyValue(p,q,e);
		System.out.println("Enter the message you want to encrypt: ");
		message= s1.nextInt();
		
		while(message>n) {
			System.out.println("The message must be less than n, Enter again:  ");
			message= s1.nextInt();
		}
		
		
		BigInteger M = BigInteger.valueOf(message);
		BigInteger E = BigInteger.valueOf(e);
		BigInteger N = BigInteger.valueOf(n);
		
		BigInteger ciphertext=r1.encryptMessage(M,E,N);
		
		System.out.println("Your ciphertext is = "+ciphertext);
		
		}
		if (option.equalsIgnoreCase("d")) {
		BigInteger E = BigInteger.valueOf(e);
		BigInteger Eu = BigInteger.valueOf(euler);
		BigInteger D =E.modInverse(Eu);
	
		BigInteger N = BigInteger.valueOf(n);
		System.out.println("d = "+D);
		r1.privateKeyValue(p, q, D);
		
		System.out.println("Enter the message you want to decrypt: ");
		message= s1.nextInt();
		while(message>n) {
			System.out.println("The message must be less than the n, Enter again:  ");
			message= s1.nextInt();
		}
		BigInteger M1 = BigInteger.valueOf(message);
        BigInteger plaintext=r1.decryptMessage(M1,D,N);
		System.out.println("Your plaintext is = "+plaintext);
      
		}
		else if(!option.equalsIgnoreCase("e")&&!option.equalsIgnoreCase("d")&&!option.equalsIgnoreCase("exit")){
			System.out.println("Your choice is invalid type again: ");
		}
		 
		}while(!option.equalsIgnoreCase("exit"));
		System.out.println("goodbye");
	

	}

}
