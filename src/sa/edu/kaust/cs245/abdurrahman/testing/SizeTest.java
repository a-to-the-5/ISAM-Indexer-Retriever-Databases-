package sa.edu.kaust.cs245.abdurrahman.testing;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;


public class SizeTest {
	public static void main(String[] args) throws IOException{
		File f = new File("a.txt");
		System.out.println(f.length());
		RandomAccessFile bw = new RandomAccessFile(f,"rw");
		//bw.writeUTF("Hellow world");
		//bw.flush();
		System.out.println(bw.readUTF());//f.length());
		//bw.writeUTF("Hellow world");
		System.out.println(bw.readUTF());
		bw.close();
	}
}
