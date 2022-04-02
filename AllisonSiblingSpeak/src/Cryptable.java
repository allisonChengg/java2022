/*
 * Allison Cheng
 * Cryptable: interface that holds 2 abstract methods: encrypt & decrypt
 */

public interface Cryptable {
	
	public String encrypt(String text);
	public String decrypt(String text);
}
