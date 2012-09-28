public class ModelData{
	
	public int count,total;
	public Pixel target;
	
	public ModelData(Pixel t){
		target = t;
		total = 1;
		count = 1;
	}
	
	public double getProb(){
		return total/count;
	}
	
	public boolean getData (Pixel intendedTarget){
		if(intendedTarget.equals(this.target)){
			return true;
		}else{
			return false;
		}
	}
	
}