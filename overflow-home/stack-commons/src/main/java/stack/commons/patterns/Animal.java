package stack.commons.patterns;

public abstract class Animal {
	
	public abstract void roar();

    public abstract void run();
    
    public static void main(String[] args) {
		
	}

}

class AnimalAdapter extends Animal {

	@Override
	public void roar()  {
		
		throw new NotImplementedException();
		
	}

	@Override
	public void run() {
		
		
	}
	
	
	
}

class Sheep extends AnimalAdapter {
	
	@Override
	public void run() {
		System.out.println("I am a sheep I run, but I don't roar...");
	}
	
}

class NotImplementedException extends RuntimeException {
	
}



