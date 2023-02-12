package MyPackgae;

public class GetSet {
	public static float balance;
	public static int cid;
	public static float getBalance() {
		return balance;
	}
	public static void setBalance(float balance) {
		GetSet.balance = balance;
	}
	public static int getCid() {
		return cid;
	}
	public GetSet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void setCid(int cid) {
		GetSet.cid = cid;
	}
	@Override
	public String toString() {
		return "GetSet [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
