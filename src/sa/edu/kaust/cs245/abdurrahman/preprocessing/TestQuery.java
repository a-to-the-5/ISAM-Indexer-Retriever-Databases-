package sa.edu.kaust.cs245.abdurrahman.preprocessing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class TestQuery {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("/Volumes/CS245-10/Data/example.query"));
		long[] lim1 = new long[4], lim2 = new long[4];
		String in; int i = 0;
		while((in=br.readLine())!=null){
			String[] sp = in.split(" ");
			lim1[i] = Long.parseLong(sp[0]);
			lim2[i] = Long.parseLong(sp[1]);
			i++;
		}
		
		///////////////////////////////////////
		
		ArrayList<ArrayList<DBEntry>> results1 = new ArrayList<ArrayList<DBEntry>>();
		for(i = 0; i<4; i++){
			results1.add(new ArrayList<DBEntry>());
		}
		
		for(i = 0; i<2; i++){
			System.out.println(i);
			br = new BufferedReader(new FileReader("/Volumes/CS245-10/Data/Data."+i));
			while((in=br.readLine())!=null){
				DBEntry e = DBEntry.createEntry(in);
				for(int j = 0; j<4; j++){
					if(e.id>=lim1[j] && e.id<=lim2[j])
						results1.get(j).add(e);
				}
			}
		}
		
		for(ArrayList<DBEntry> list:results1)
			Collections.sort(list);
		
		///////////////////////////////////////
		
		ArrayList<ArrayList<DBEntry>> results2 = new ArrayList<ArrayList<DBEntry>>();
		for(i = 0; i<4; i++){
			results2.add(new ArrayList<DBEntry>());
		}
		
		br = new BufferedReader(new FileReader("/Users/abdulmaa/Desktop/DB_out/Data.0.0"));
		while((in=br.readLine())!=null){
			DBEntry e = DBEntry.createEntry(in);
			for(int j = 0; j<4; j++){
				if(e.id>=lim1[j] && e.id<=lim2[j])
					results2.get(j).add(e);
			}
		}
		
		for(ArrayList<DBEntry> list:results2)
			Collections.sort(list);
		
		///////////////////////////////////////
		
		for(i = 0; i<results1.size(); i++){
			System.out.print(i+" ");
			System.out.print(results1.get(i).size()+" "+results2.get(i).size()+" ");
			for (int j = 0; j < results1.get(i).size(); j++) {
				if(! results1.get(i).get(j).equals(results2.get(i).get(j))){
					System.out.println("OH OH");
					return;
				}
			}
			System.out.println("equal");
		}
		
	}
}
