package sa.edu.kaust.cs245.abdurrahman.preprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Sorter {
	public static void main(String[] args) throws IOException{
		File output = new File("/Users/abdulmaa/Desktop/DB_out");
		output.mkdir();
		File input = new File("/Volumes/CS245-10/Data");
		
		//int count = 0;
		
		for(File f:input.listFiles()){
			//if(count>1) break;
			if(f.getName().matches("Data.*")){
				System.out.println("in: "+f.getAbsolutePath());
				//count++;
				BufferedReader br = new BufferedReader(new FileReader(f));
				out: for(int j = 0;;j++){
					String s;
					ArrayList<DBEntry> dbes = new ArrayList<DBEntry>();
					File o = new File(output.getAbsolutePath()+"/"+f.getName()+"."+j);
					System.out.println("out: "+o.getAbsolutePath());
					o.createNewFile();
					BufferedWriter bw = new BufferedWriter(new FileWriter(o));
					for(int i = 0; i<500000; i++){
						if((s = br.readLine())==null) {
							Collections.sort(dbes);
							for(DBEntry e:dbes)
								bw.write(e.toString()+"\n");
							bw.close();
							break out;
						}
						dbes.add(DBEntry.createEntry(s));
					}
					Collections.sort(dbes);
					for(DBEntry e:dbes)
						bw.write(e.toString()+"\n");
					bw.close();
				}
				br.close();
			}
		}		
	}
}
