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
	
}