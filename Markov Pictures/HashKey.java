public class HashKey{
 
 public Pixel down;
 public Pixel right;
 
 public HashKey(Pixel p1, Pixel p2){
  down = p1;
  right = p2;
 }
 
 public int hashCode(){
  	return down.hashCode() + right.hashCode();
 }
 
 public boolean equals(HashKey hk){
 	if(this.down.equals(hk.down) && this.right.equals(hk.right)){
 		return true;
 	}else{
 		return false;
 	}
 }
 
}