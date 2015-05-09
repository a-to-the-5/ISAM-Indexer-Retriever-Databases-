package sa.edu.kaust.cs245.abdurrahman.indexing;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ISAMBuilder {
	
	public static void main(String[] args) throws IOException {
		String p = "/Volumes/CS245-10/Data/";
		//indexCompress("/Users/abdulmaa/Desktop/index_attempt_3", p);
		levelCreator(p, 2);
		levelCreator(p, 1);
	}
	
	public static void indexCompress(String indexPath, String outPath) throws IOException{
		///Users/abdulmaa/Desktop/index_attempt_2
		FileInputStream fis = new FileInputStream(indexPath);
		DataInputStream dis = new DataInputStream(fis);
		
		///Users/abdulmaa/Desktop/Data2/
		FileOutputStream fos = new FileOutputStream(outPath+"index.3");
		DataOutputStream dos = new DataOutputStream(fos);
		
		int outer = 0;
		long pos = 0;// = fis.getChannel().position();
		
		out: while(true){
			outer++;
			if(outer%1000==0)
				System.out.println(outer);
			long key = -1;
			
			
			for(int i = 0; i<100; i++){
				try{
					key = dis.readLong();
					if(i==0)
						pos = dis.readLong();
					else
						dis.readLong();
				}catch(EOFException e){
					if(key!=-1){
						dos.writeLong(key);
						dos.writeLong(pos);
					}
					break out;
				}
			}
			
			if(key!=-1){
				dos.writeLong(key);
				dos.writeLong(pos);
			}
		}
		
		dos.close();
	}
	
	
	public static void levelCreator(String outPath, int level) throws IOException{
		///Users/abdulmaa/Desktop/DB_out/
		FileInputStream fis = new FileInputStream(outPath+"index."+(level+1));
		DataInputStream dis = new DataInputStream(fis);
		
		
		FileOutputStream fos = new FileOutputStream(outPath+"index."+level);
		DataOutputStream dos = new DataOutputStream(fos);
		
		int outer = 0;
		
		out: while(true){
			outer++;
			if(outer%1000==0)
				System.out.println(outer);
			long key = -1;
			
			long pos = fis.getChannel().position();
			
			for(int i = 0; i<256; i++){
				try{
					key = dis.readLong();
					dis.readLong();
				}catch(EOFException e){
					if(key!=-1){
						dos.writeLong(key);
						dos.writeLong(pos);
					}
					break out;
				}
			}
			
			if(key!=-1){
				dos.writeLong(key);
				dos.writeLong(pos);
			}
		}
		
		dos.close();
	}
}
