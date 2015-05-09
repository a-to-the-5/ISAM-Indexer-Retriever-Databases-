package sa.edu.kaust.cs245.abdurrahman.querying;
import java.util.ArrayList;


public class BinDBEntry {
	long key;
	ArrayList<String> strings;
	
	public BinDBEntry() {
		strings = new ArrayList<String>();
	}
	
	public ArrayList<String> strings(){
		for(int i = 0; i<strings.size(); i++){
			strings.set(i, key+" "+strings.get(i));
		}
		return strings;
	}
}
