package sa.edu.kaust.cs245.abdurrahman.testing;
import java.io.IOException;
import java.io.RandomAccessFile;


public class WriterTest {
	public static void main(String[] args) throws IOException{
		RandomAccessFile dataWriter = new RandomAccessFile("test_data.txt", "rw");
		RandomAccessFile indexWriter = new RandomAccessFile("test_index.txt", "rw");
		
		for(int i = 0; i<10; i++){
			indexWriter.writeInt(i);
			indexWriter.writeLong(dataWriter.getFilePointer());
			
			dataWriter.writeInt(i);
			dataWriter.writeUTF(""+((char)('a'+i)));
		}
		dataWriter.close();
		indexWriter.close();
		
		RandomAccessFile dataReader = new RandomAccessFile("test_data.txt", "r");
		RandomAccessFile indexReader = new RandomAccessFile("test_index.txt", "r");
		
		for(int i = 0; i<10; i+=2){
			int read = indexReader.readInt();
			long pos = indexReader.readLong();
			
			dataReader.seek(pos);
			System.out.println(dataReader.readInt()+" "+dataReader.readUTF());
		}
	}
}
