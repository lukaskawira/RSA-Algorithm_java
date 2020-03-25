
public class Out {
	private String srn, name;
	private Alice alice;
	private Bob bob;
	private String plainText, cipherText;
	
	public void setSrn(String srn) {
		this.srn = srn;
	}
	
	public String getSrn() {
		return srn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}
	
	public String getCipherText() {
		return cipherText;
	}
	
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	
	public String getPlainText() {
		return plainText;
	}
	
	public void setAlice(Alice alice) {
		this.alice = alice;
	}
	
	public Alice getAlice() {
		return alice;
	}
	
	public void setBob(Bob bob) {
		this.bob = bob;
	}
	
	public Bob getBob() {
		return bob;
	}
}
