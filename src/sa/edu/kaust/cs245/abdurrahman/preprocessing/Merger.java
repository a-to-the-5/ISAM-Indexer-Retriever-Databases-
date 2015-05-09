package sa.edu.kaust.cs245.abdurrahman.preprocessing;

import java.io.*;
import java.util.ArrayList;

public class Merger{
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException{
		File input = new File("/Users/abdulmaa/Desktop/DB_out");
		File[] fs;
		
		out: while (true) {
			fs = input.listFiles();
			ArrayList<File> temp = new ArrayList<File>();
			for(File f:fs){
				if(f.getName().matches("Data.*"))
					temp.add(f);
			}
			fs = temp.toArray(new File[0]);
			if(fs.length==1) break;
			for (int i = 0; i<fs.length-1; i+=2) {
				merge(fs[i],fs[i+1]);
//				try{
//				}catch(Exception e){
//					System.out.println(fs[i].getName());
//					System.out.println(fs[i+1].getName());
//					return;
//				//	continue out;
//				}
			}
		}
	}
	
	public static void merge(File f1, File f2) throws IOException{
		System.out.println(f1.getAbsolutePath()+"\t"+f2.getAbsolutePath());
		BufferedReader br1 = new BufferedReader(new FileReader(f1));
		BufferedReader br2 = new BufferedReader(new FileReader(f2));
		File o = new File(f1.getAbsolutePath()+".tmp");
		bw = new BufferedWriter(new FileWriter(o));
		String s1 = br1.readLine(), s2 = br2.readLine();
		while (s1 != null && s2 != null) {
			DBEntry e1 = DBEntry.createEntry(s1);
			DBEntry e2 = DBEntry.createEntry(s2);
			if (e1.compareTo(e2) <= 0) {
				write(e1);
				s1 = br1.readLine();
			}else {
				write(e2);
				s2 = br2.readLine();
			}
		}
		while (s1 != null){
			write(DBEntry.createEntry(s1));
			s1 = br1.readLine();
		}
		while (s2 != null){
			write(DBEntry.createEntry(s2));
			s2 = br2.readLine();
		}
		f1.delete();
		f2.delete();							
		o.renameTo(f1);
		bw.close();
		br1.close();
		br2.close();
	}
	
	static void write(DBEntry e) throws IOException{
		bw.write(e.toString()+"\n");
	}
							   
}