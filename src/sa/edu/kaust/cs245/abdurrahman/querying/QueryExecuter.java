package sa.edu.kaust.cs245.abdurrahman.querying;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class QueryExecuter {
	FileInputStream[] fistreams;
	DataInputStream[] distreams;
	Seeker seeker;
	String path;
	
	public QueryExecuter(String path)throws IOException {
		this.path = path;
		seeker = new Seeker(path);
		fistreams = new FileInputStream[8];
		distreams = new DataInputStream[8];
		
		for(int i = 0; i<8; i++){
			fistreams[i] = new FileInputStream(path+"Data."+i);
			distreams[i] = new DataInputStream(fistreams[i]);
		}
	}
	
	public void execQueries(ArrayList<Query> queries) throws IOException{
		Query[] qs = new Query[queries.size()];
		for(int i = 0; i<queries.size(); i++)
			qs[i] = queries.get(i);
		
		Arrays.sort(qs);
		
		for(Query q:qs){
			q.out = execQuery(q.min, q.max);
		}
	}
	
	public ArrayList<String> execQuery(long min, long max) throws IOException{
		ArrayList<String> res = new ArrayList<String>();
		
		long[] pos = new long[2]; 
		seeker.seek(min, pos);
		
		int file = (int)(pos[0]);
		if(file==-1) return res;
		FileInputStream fis = fistreams[file];
		DataInputStream dis = new DataInputStream(new BufferedInputStream(fis, 4096));//distreams[file];
		
		fis.getChannel().position(pos[1]);
		
		BinDBEntry entry = new BinDBEntry();
		
		while(true){
			try{
				readEntry(dis, entry);
			} catch(EOFException e){
				file++;
				if(file>7) break;
				else{
					fis = fistreams[file];
					fis.getChannel().position(0);
					dis = new DataInputStream(new BufferedInputStream(fis, 4096));//distreams[file];
					continue;
				}
			}
			if(entry.key>max) break;
			if(entry.key>=min) res.addAll(entry.strings());
		}
		
		return res;
	}
	
	private void readEntry(DataInputStream dis, BinDBEntry entry) throws IOException{
		entry.key = dis.readLong();
		int n = dis.read();
		entry.strings.clear();
		for(int i = 0; i<n; i++){
			entry.strings.add(dis.readUTF());
		}
	}
}

class Query implements Comparable<Query>{
	long min;
	long max;
	ArrayList<String> out;
	
	public Query(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	public int compareTo(Query o) {
		if(min>o.min) return 1;
		else if(min<o.min) return -1;
		return 0;
	}
}
