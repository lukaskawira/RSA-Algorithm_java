import java.math.BigInteger;

public class Alice {
	private BigInteger p, q, r, modulus, privateKey, publicKey;
	
	public Alice() {
		this.modulus = new BigInteger("84299521234610382455617132349");
		this.publicKey = new BigInteger("57149124863567279999338638031");
	}
	
	public void setP(BigInteger p) {
		this.p = p;
	}
	
	public BigInteger getP() {
		return p;
	}
	
	public void setQ(BigInteger q) {
		this.q = q;
	}
	
	public BigInteger getQ() {
		return q;
	}
	
	public void setR(BigInteger r) {
		this.r = r;
	}
	
	public BigInteger getR() {
		return r;
	}
	
	public void setModulus(BigInteger modulus) {
		this.modulus = modulus;
	}
	
	public BigInteger getModulus() {
		return modulus;
	}
	
	public void setPrivateKey(BigInteger privateKey) {
		this.privateKey = privateKey;
	}
	
	public BigInteger getPrivateKey() {
		return privateKey;
	}
	
	public void setPublicKey(BigInteger publicKey) {
		this.publicKey = publicKey;
	}
	
	public BigInteger getPublicKey() {
		return publicKey;
	}
	
	@Override
		public String toString() {
			return "alice: {"+
					"p: "+ p +
					", q: "+ q +
					", r: "+ r +
					", modulus: "+ modulus +
					", privateKey: "+ privateKey +
					", publicKey: "+ publicKey +
					"}.";
	}
}
