package stack.commons.objects;

public class FinalizeOverloader {
	
	protected void finalize(String userId) {
		System.out.println("I could overload finalize...");
	}
	
	public static void main(String[] args) {
		FinalizeOverloader fO = new FinalizeOverloader();
		fO.finalize("AbC");
	}

}
