import java.awt.image.*;
import java.awt.*;
 
public class GetImageData{
 	
	public Pixel[][] parsedImage;
 	
	public GetImageData(String imageName,int width,int height){
		parsedImage = new Pixel[width][height];
		retrieveImage(imageName,width,height);
 	}
 	
 	
	 public Pixel handleSinglePixel(int x, int y, int pixel) {
	        int alpha = (pixel >> 24) & 0xff;
	        int red   = (pixel >> 16) & 0xff;
	        int green = (pixel >>  8) & 0xff;
	        int blue  = (pixel      ) & 0xff;
	        return new Pixel(red,green,blue,alpha);
	 }
	
	 public void handlePixels(Image img, int x, int y, int w, int h) {
	        int[] pixels = new int[w * h];
	        PixelGrabber pg = new PixelGrabber(img, x, y, w, h, pixels, 0, w);
	        
	        try {
	            pg.grabPixels();
	        } catch (InterruptedException e) {
	            System.err.println("Interrupted waiting for pixels!");
	            return;
	        }
	        if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
	            System.err.println("Image fetch aborted or errored");
	            return;
	        }
	        for (int j = 0; j < h; j++) {
	            for (int i = 0; i < w; i++) {
	                parsedImage[i][j] = handleSinglePixel(x+i, y+j, pixels[j * w + i]);
	            }
	        }
	 }
	 
	 public void retrieveImage(String imageName,int width,int height){
	 	
	 	Image rawImage = Toolkit.getDefaultToolkit().getImage(imageName);
	 	
	 	System.out.println("Getting Image, takes 10 seconds");
	 	try{
	 		Thread.sleep(10000);
	 	}catch(InterruptedException e){
	 		System.out.println("Image retrieval interrupted");
	 	}
	 	System.out.println("Image Retrieved");
	 	
	 	//int width = rawImage.getWidth(this);
	 	//int height = rawImage.getHeight(this);
	 	
		handlePixels(rawImage,0,0,width,height);
		System.out.println("Processing Complete");
	 }
 
 }