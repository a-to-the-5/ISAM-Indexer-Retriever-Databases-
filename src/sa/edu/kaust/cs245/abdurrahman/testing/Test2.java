package sa.edu.kaust.cs245.abdurrahman.testing;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Test2 {
	public static void main(String[] args) throws IOException{
		int total = 0, nodups = 0;
		//log(254799872) / log(133)
		//1915789
		for(int i = 0; i<8; i++){
			System.out.println(i+":");
			FileInputStream fis = new FileInputStream("/Users/abdulmaa/Desktop/DB_out/Data."+i);
			DataInputStream dis2 = new DataInputStream(fis);
			//RandomAccessFile dis2 = new RandomAccessFile("/Users/abdulmaa/Desktop/DB_out/Data."+i, "r");
			while(true){
				try{
					long key = dis2.readLong();
					System.out.println(total);
					nodups++;
					int n = dis2.readInt();
					total+=n;
					for(int j = 0; j<n; j++)
						dis2.readUTF();
				}catch(EOFException e){
					break;
				}
			}
			System.out.println("\t"+nodups);
			System.out.println("\t"+total);
			System.out.println();
		}
	}
}
