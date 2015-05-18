package stack.commons.polymorphism;

public abstract class Animal {
  
  private String type;
  private double x, y;
  
  public double getX() {
	  return x;
  }
  
  public double getY() {
	  return y;
  }
  
  protected void setX(double x) {
	  this.x = x;
  }
  
  protected void setY(double y) {
	  this.y = y;
  }
    
  public Animal (String type){
      this.type = type ;
  }
   
  public abstract int move ();
  
  public String toString (){
      return String.format(type);
  }
  
  public String position() {
	  return "[" + x + " , " + y + "]";
  }
   
}
