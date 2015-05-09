package sa.edu.kaust.cs245.abdurrahman.querying;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Select {
	/**
	 * 
	 * @param args {query_file_path, index_data_path}
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		String nl = "\n";
		String wd = Select.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("select.jar", "");
		//System.out.println(wd);
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		BufferedWriter bw = new BufferedWriter(new FileWriter(wd+"my_result.result"));
		QueryExecuter qe = new QueryExecuter(wd+"Data/");
		
		//ArrayList<Query> queries = new ArrayList<Query>();
		String s;
		while((s=br.readLine())!=null){
			String[] ss = s.split("\\s+");
			long min = Long.parseLong(ss[0]);
			long max = Long.parseLong(ss[1]);
			bw.write(".......... Query: "+min+" "+max+nl);
			ArrayList<String> out = qe.execQuery(min, max);
			for(String o:out){
				bw.write(o+nl);
			}
		}
		bw.close();
	}
}
