package sa.edu.kaust.cs245.abdurrahman.preprocessing;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;



public class Count {
	public static void main(String[] args) throws Exception {
		boolean[] ch = new boolean[3000];
		Arrays.fill(ch, false);
		File input = new File("/Volumes/CS245-10/Data");
		long min = Long.MAX_VALUE, max = 0, count = 0;
		for(File f:input.listFiles()){
			if(!f.getName().matches("Data.*"))continue;
			System.out.println(f.getName());
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s;
			while((s=br.readLine())!=null){
				DBEntry e = DBEntry.createEntry(s);
				count++;
				min = Math.min(min, e.id);
				max = Math.max(max, e.id);
				for(char c:e.string.toCharArray()){
					int i = (int)c;
					if(i<3000) ch[i] = true;
				}
			}
			br.close();
			System.out.println("min: "+min);
			System.out.println("max: "+max);
			System.out.println("count: "+count);
		}
		for (int i = 0; i < ch.length; i++) {
			System.out.println(i+" "+ch[i]);
		}
		System.out.println("min: "+min);
		System.out.println("max: "+max);
		System.out.println("count: "+count);
	}
}
