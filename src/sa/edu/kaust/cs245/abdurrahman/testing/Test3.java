package sa.edu.kaust.cs245.abdurrahman.testing;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import sa.edu.kaust.cs245.abdurrahman.querying.QueryExecuter;


public class Test3 {
	public static void main(String[] args) throws IOException{
		long time = new Date().getTime();
		QueryExecuter qe = new QueryExecuter("/Volumes/CS245-10/Data/");
		String p = "/Volumes/CS245-10/databases/";
		BufferedReader br = new BufferedReader(new FileReader(p+"example.query"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(p+"my_example.result"));
		String s;
		while((s=br.readLine())!=null){
			String[] ss = s.split("\\s+");
			long min = Long.parseLong(ss[0]);
			long max = Long.parseLong(ss[1]);
			String nl = "\r\n";
			ArrayList<String> res = qe.execQuery(min, max);
			bw.write(".......... Query: "+min+" "+max+nl);
			for(String temp:res)
				bw.write(temp+nl);
		}
		br.close();
		bw.close();
		System.out.println((new Date().getTime()-time)/1000.0);
	}
}
//260000000 1 6