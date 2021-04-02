import java.util.Scanner;
import java.math.*;
public class RSA {
	
  int n;int euler=0; int e;
  double c;
  int p,q;
	
	
   Scanner s = new Scanner(System.in);

   public RSA() {
	
             }

  void setKey(int p, int q ) {

     n=p*q;
     euler=(p-1)*(q-1);
     System.out.println("The n value: "+n);
     System.out.println("The euler value: "+euler);


}

  static int checkE(int e, int euler) {
	  
     e = e % euler; 
    for (int x = 1; x < euler; x++)   
    if ((e * x) % euler == 1) 
      return x; 
      return 1; 
      
    } 


   void publickeyValue( int p, int q, int e) {
	    n=p*q;
	    System.out.println("The public key= ("+e+","+n+")");
}

   void privateKeyValue(int p, int q, BigInteger d) {
	    n=p*q;
	    System.out.println("The private key= ("+d+","+n+")");
}


   BigInteger encryptMessage(BigInteger message,BigInteger e,BigInteger n) {
	
         return  message.modPow(e, n) ;
}

   BigInteger decryptMessage(BigInteger message,BigInteger d,BigInteger n) {

	     return  message.modPow(d, n) ;
}

}
