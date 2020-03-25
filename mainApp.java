import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class mainApp {
			
	public static void main(String args[]) throws IOException{		
		//Initialization
		String cipherText = "4wrj898z51sbmda4f45";
		BigInteger encodedCipherText = Utils.encode(cipherText);
		
		//Initialization for the separated class Alice and Bob
		Alice alice = new Alice();
		Bob bob = new Bob();
		
		//Initialization for the variable that is going to be used in the calculation
		BigInteger ONE =  new BigInteger("1");
		String plainText;
		long aliceT, bobT, startAliceT, startBobT;
		
		//Alice's calculations and registraion of p, q, r, privateKey variable
		startAliceT = System.nanoTime();
		alice.setP(Utils.rho(alice.getModulus()));
		alice.setQ(alice.getModulus().divide(alice.getP()));
		alice.setR(alice.getP().subtract(ONE).multiply(alice.getQ().subtract(ONE)));
		alice.setPrivateKey(alice.getPublicKey().modInverse(alice.getR()));
		//Time calculation for alice's process
		aliceT = System.nanoTime() - startAliceT;
		
		
		//Bob's calculations and registraion of p, q, r, privateKey variable
		startBobT = System.nanoTime();
		bob.setP(Utils.rho(bob.getModulus()));
		bob.setQ(bob.getModulus().divide(bob.getP()));
		bob.setR(bob.getP().subtract(ONE).multiply(bob.getQ().subtract(ONE)));
		bob.setPrivateKey(bob.getPublicKey().modInverse(bob.getR()));
		//Time calculation for bob's process
		bobT = System.nanoTime() - startBobT;
		
		//Finding out the ciphertext
		plainText = Utils.decode(encodedCipherText.modPow(alice.getPublicKey(), alice.getModulus())
				.modPow(bob.getPrivateKey(), bob.getModulus()));
		
		//Write to json file
		Out out = new Out();
		out.setSrn("170282224");
		out.setName("LUKAS KAWIRA");
		out.setAlice(alice);
		out.setBob(bob);
		out.setPlainText(plainText);
		out.setCipherText(cipherText);
		
		//Proceding to json output
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //gson builder from google
		
		try {
			FileWriter file = new FileWriter("C:\\Users\\lukas\\Desktop\\LukasKawira_170282224_CO3326cw2.json");
			System.out.println(gson.toJson(out)); //Printing out the json file output in the console
			gson.toJson(out, file);
			file.flush();
	        file.close();
		} catch(Exception e) {
			throw e;
		}
		
		System.out.println("");
		
		//--Time calculations--//
		System.out.println("Alice's private key : " + alice.getPrivateKey());
		System.out.println("Alice time : " + aliceT/1000000000 + " seconds");
		System.out.println("------------------------------------------------");
		System.out.println("Bob's private key : " + bob.getPrivateKey());
		System.out.println("Bob time : " + bobT/1000000000 + " seconds");
		
		System.out.println("");
		
		//--Message output--//
		System.out.println("Cipher Text : " + cipherText);
		System.out.println("Plain Text : " + plainText);
	}
}
