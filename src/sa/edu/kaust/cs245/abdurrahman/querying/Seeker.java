package sa.edu.kaust.cs245.abdurrahman.querying;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Seeker {
	String path;
	
	ArrayList<Long> keys, positions;
	
	FileInputStream fisl2;
	DataInputStream disl2;
	
	FileInputStream fisl3;
	DataInputStream disl3;
	
	public Seeker(String path) throws IOException {
		//"/Users/abdulmaa/Desktop/DB_out/"
		this.path = path;
		keys = new ArrayList<Long>();
		positions = new ArrayList<Long>();
		
		FileInputStream fis = new FileInputStream(path+"index.1");
		DataInputStream dis = new DataInputStream(fis);
		
		while(true){
			try{
				keys.add(dis.readLong());
				positions.add(dis.readLong());
			}catch(EOFException e){
				break;
			}
		}
		
		dis.close();
		
		fisl2 = new FileInputStream(path+"index.2");
		//disl2 = new DataInputStream(fisl2);
		
		fisl3 = new FileInputStream(path+"index.3");
		//disl3 = new DataInputStream(fisl3);
	}
	
	void seek(long key, long[] ret) throws IOException{
		int i;
		
		for(i = 0; i<keys.size(); i++){
			if(keys.get(i)>=key) break;
		}
		
		if(i==keys.size()){
			i--;
		}
		
		long pos = positions.get(i);
		
		fisl2.getChannel().position(pos);
		disl2 = new DataInputStream(new BufferedInputStream(fisl2, 4096));
		
		while(true){
			try{
				long ckey = disl2.readLong();
				pos = disl2.readLong();
				if(ckey>=key) break;
			}catch(EOFException e){break;}
		}
		
		fisl3.getChannel().position(pos);
		disl3 = new DataInputStream(new BufferedInputStream(fisl3, 4096));
		
		while(true){
			try{
				long ckey = disl3.readLong();
				pos = disl3.readLong();
				if(ckey>=key) break;
			}catch(EOFException e){break;}
		}
		
		ret[0] = getFile(pos);
		ret[1] = getPosition(pos);
		
	}
	
	
	long getFile(long pos){
		long toand = ((long)(7))<<61;
		return (pos&toand)>>>61;
	}
	
	long getPosition(long pos){
		long toand = ((long)(7))<<61;
		return (pos&(~toand));
	}
}
