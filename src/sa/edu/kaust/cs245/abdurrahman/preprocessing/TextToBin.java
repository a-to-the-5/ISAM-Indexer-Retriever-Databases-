package sa.edu.kaust.cs245.abdurrahman.preprocessing;

import java.io.*;
import java.util.ArrayList;


public class TextToBin {
	public static void main(String[] args) throws IOException{
		File input = new File("/Users/abdulmaa/Desktop/Data.0.0");
		BufferedReader br = new BufferedReader(new FileReader(input));
		
		FileOutputStream fos = new FileOutputStream("/Users/abdulmaa/Desktop/index_attempt_3");
		DataOutputStream indexWriter = new DataOutputStream(new BufferedOutputStream(fos));
		
		FileOutputStream fos2 = null;
		DataOutputStream rac = null;
		
		String s;
		
		long filenum = 0;
		fos2 = nextFile(fos2, filenum++);
		rac = new DataOutputStream(new BufferedOutputStream(fos2));
		
		DBEntry current = DBEntry.createEntry(br.readLine()),temp;
		ArrayList<String> strs = new ArrayList<String>();
		strs.add(current.string);
		
		int read = 1;
		
		while((s=br.readLine())!=null){
			read++;
			if(read%100000==0) System.out.println(read);
			temp = DBEntry.createEntry(s);
			if(temp.id==current.id){
				strs.add(temp.string);
			}else{
				//rac.flush();
				writeIndexEntry(current.id, filenum-1, fos2.getChannel().position(), indexWriter);
				flush(current.id,strs,rac);
				if(read>=33000000){
					fos2 = nextFile(fos2, filenum++);
					rac = new DataOutputStream(new BufferedOutputStream(fos2));
					read = 1;
				}
				current = temp;
				strs = new ArrayList<String>();
				strs.add(current.string);
			}
		}
		
		flush(current.id,strs,rac);
		
		indexWriter.close();
		rac.close();
		
	}

	private static void flush(long id, ArrayList<String> strs,
			DataOutputStream rac) throws IOException {
		rac.writeLong(id);
		rac.writeByte(strs.size());
		//rac.writeInt(strs.size());
		for(String s:strs){
			rac.writeUTF(s);
		}
		rac.flush();
	}

	private static void writeIndexEntry(long id, long filenum,
			long offset, DataOutputStream indexWriter) throws IOException{
		long address = filenum<<61;
		address = address|offset;
		indexWriter.writeLong(id);
		indexWriter.writeLong(address);
	}

	private static FileOutputStream nextFile(FileOutputStream rac, long l) throws IOException {
		if(rac!=null) rac.close();
		System.out.println("/Volumes/CS245-10/Data/Data."+l);
		return new FileOutputStream("/Volumes/CS245-10/Data/Data."+l);
	}
}
