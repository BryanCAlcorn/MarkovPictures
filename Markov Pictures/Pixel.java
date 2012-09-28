public class Pixel{
 
 public int red;
 public int green;
 public int blue;
 public int alpha;
 
 public Pixel(int r,int g,int b,int a){
  red = r;
  green = g;
  blue = b;
  alpha = a;
 }
 
 public void Debug(){
  System.out.println("R: " + this.red + " G: " + this.green + " B: " + this.blue + " A: " + this.alpha);
 }
 
 public int hashCode(){
   return this.red + this.green + this.blue + this.alpha;
 }
 
 public boolean equals(Pixel p1){
 	if(this.red == p1.red && this.green == p1.green && this.blue == p1.blue && this.alpha == p1.alpha){
 		return true;
 	}else{
 		return false;
 	}
 	
 }
 
}