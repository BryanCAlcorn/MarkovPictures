public class Tester{
	
	public static void main(String[] args){
		GetImageData gid = new GetImageData("test.jpg",551,390);
		MarkovPixels mp = new MarkovPixels(gid.parsedImage);
		System.out.println(mp.model.size());
	}
}