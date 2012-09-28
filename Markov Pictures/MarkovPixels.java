import java.util.*;

public class MarkovPixels{

	public Hashtable<Pixel[],Vector> model = new Hashtable<Pixel[],Vector>();
	public Vector<ModelData> modelData;
	
	public MarkovPixels(Pixel[][] pic){
		hashPixels(pic);
	}
	
	public void hashPixels(Pixel[][] picture){
		Pixel[] hash;
		ModelData data;
		double prob = 0;
		int count = 0;
		
		for(int i = 0;i < picture.length - 1;i++){
			for(int j = 0;j < picture[0].length - 1;j++){
				hash = new Pixel[2];
				hash[0] = picture[i+1][j];
				hash[1] = picture[i][j+1];
				if(model.containsKey(hash)){
					//Update the count for this hash
					modelData = model.get(hash);
					//Go through the vector find if the current target matches any targets in the vector or not
					try{
						while(modelData.elementAt(count).getData(picture[i][j]) == false){
							count++;
						}
						modelData.elementAt(count).count += 1;
						model.put(hash,modelData);
					}catch(ArrayIndexOutOfBoundsException e){
						data = new ModelData(picture[i][j]);
						modelData.add(data);
						model.put(hash, modelData);
					}
					//Update the total number of the key in the hash table
					modelData = model.get(hash);
					for(int k = 0;k < modelData.size();k++){
						modelData.elementAt(k).total += 1;
					}
				}else{
					data = new ModelData(picture[i][j]);
					modelData = new Vector<ModelData>();
					modelData.add(data);
					model.put(hash,modelData);
				}
			}
		}
	}
}