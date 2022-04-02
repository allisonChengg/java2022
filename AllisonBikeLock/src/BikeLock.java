
public class BikeLock {

	private int[] bikeDials;
	private int[] secretCode;
	private int openAttempts;
	public static final int maxOpenAttempts = 3;
	private boolean lockedOut = false;
	
	public BikeLock() {
		bikeDials = new int[4];
		setSecretCode();
	}
	
	private void setSecretCode() {
		
		if (lockedOut) {
			return;
		}
		
		secretCode = new int[4];
		for (int i = 0; i < 4; i++) {
			secretCode[i] = (int)(Math.random() * 9);
		}
	}
	
	public void dialForward(int dialNum) {
		
		if (lockedOut) {
			return;
		}
		
		int currentValue = bikeDials[dialNum];
		
		currentValue++;
		if (currentValue > 9) {
			bikeDials[dialNum] = 0;
		}
	}
	
	public void dialBackward(int dialNum) {
		
		if (lockedOut) {
			return;
		}
		
		int currentValue = bikeDials[dialNum];
		
		currentValue--;
		if (currentValue < 0) {
			bikeDials[dialNum] = 9;
		}
	}
	
	public boolean openLock() {
		for (int i = 0; i < 4; i++) {
			if (bikeDials[i] != secretCode[i]) {
				openAttempts++;
				
				if (openAttempts >= 3) {
					lockedOut = true;
				}
				return false;
			}
		}
		openAttempts = 0;
		return true;
		
		
	}
	
	public String toString() {
		String string = "Bike Dial: [" + bikeDials[0] + ", " + bikeDials[1] + ", " + bikeDials[2] + ", " + bikeDials[3] + "]" + 
				" Secret Code: [" + secretCode[0] + ", " + secretCode[1] + ", " + secretCode[2] + ", " + secretCode[3] + "]";
		return string;
	}
	
}
