package sa.edu.kaust.cs245.abdurrahman.testing;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Test {
	static int readEntry(DataInputStream dis) throws IOException{
		dis.readLong();
		int n = dis.readInt();
		for(int i = 0; i<n; i++){
			dis.readUTF();
		}
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		int total = 0;
		int min = 1000, max = -1;;
		for(int i = 0; i<8; i++){
			FileInputStream fis = new FileInputStream("/Volumes/CS245-10/Data2/Data."+i);
			DataInputStream dis = new DataInputStream(fis);
			
			while(true){
				try{
					int n = readEntry(dis);
					total+=n;
					min = Math.min(min, n);
					max = Math.max(max, n);
				}catch(EOFException e){
					break;
				}
			}
		}
		
		System.out.println(total+" "+min+" "+max);
		
		
		//fis.getChannel().position(4076797952l-8);
//		for(int i = 0; i<10; i++)
//		System.out.println(dis.readLong()+" "+dis.readLong());
		
		
		/*long pos = -2305843007654677766l;
		long toand = ((long)(7))<<61;
		
		long file = (pos&toand)>>>61;
		
		pos = (pos&(~toand));
		
		System.out.println(file+" "+pos);
		
		fis = new FileInputStream("/Users/abdulmaa/Desktop/new_data/Data.7");
		dis = new DataInputStream(fis);
		fis.getChannel().position(pos);
		while(true){
			System.out.println(dis.readLong());
			int n = dis.readInt();
			while(n-->0){
				System.out.println(dis.readUTF());
			}
		}*/
		
		//7 1559016186
		
		//fis.getChannel().position(15070963719l-600);
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
//		System.out.println(dis.readLine());
		
		
//		long file = 7;
//		System.out.println(Long.toBinaryString(file));
//		//file = file<<61;
//		//System.out.println(Long.toBinaryString(file));
//		long offset = Integer.MAX_VALUE;
//		System.out.println(Long.toBinaryString(offset));
//		long address = file<<61;
//		//System.out.println(address);
//		address = address|offset;
//		System.out.println(Long.toBinaryString(address));
//		long toand = ((long)(7))<<61;
//		System.out.println(Long.toBinaryString(toand));
//		long newfile = (address&toand)>>>61;
//		System.out.println(Long.toBinaryString(newfile));
////		System.out.println(newfile);
//		long newoffset = (address&(~toand));
//		System.out.println(Long.toBinaryString(newoffset));
////		System.out.println(newoffset);
//		FileOutputStream fos = new FileOutputStream("k.out");
//		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(fos));
//		for(int i = 0; i<10; i++){
//			dos.writeInt(i);
//		}
		//21474 836251874835
		//21474 836251874835
//		//21474 836181607319
		//21474 834971037266
		//21474 791321453575
		
//		//fos.getChannel().position(4);
//		//dos.writeInt(11);
//		
//		dos.close();
//		
//		FileInputStream fis = new FileInputStream("k.out");
//		DataInputStream dis = new DataInputStream(new BufferedInputStream(fis));
//		for(int i = 0; i<10; i++){
//			System.out.println(dis.readInt());
//		}
//		dis.close();
//		BufferedReader br = new BufferedReader(new FileReader("/Users/abdulmaa/Desktop/DB_out/Data.0.0"));
//		for(int i = 0; i<10; i++)
//			System.out.println(br.readLine());
		
//		BufferedReader br = new BufferedReader(new FileReader("/Users/abdulmaa/Desktop/DB_out/Data.0.0"));
//		for(int i=0; i<10; i++){
//			System.out.println(br.readLine());
//		}
//		
//		System.out.println();System.out.println();
//		
		
//		for (int i = 0; i<10 ; i++){
//			System.out.println(dis2.readLong());
//			int n = dis2.readInt();
//			for(int j = 0; j<n; j++){
//				System.out.println(dis2.readUTF());
//			}
//		}
//		
		//FileInputStream fis = new FileInputStream("/Volumes/CS245-10/new_data/Data.0");
		//DataInputStream dis = new DataInputStream(fis);
//		
//		long key = dis.readLong();
//		long pos = -1;
//		
//		for(int i = 0; i<5; i++){
//			pos = dis.readLong();
//			System.out.println(pos);
//			key = dis.readLong();
//			System.out.println(key);
//		}
//		
//		System.out.println();System.out.println();
		
		//fis.getChannel().position(4000000008L);
		
//		for(int i = 0; i<10; i++){
//			long key = dis.readLong();
//			System.out.println(key);
//			int n = dis.readInt();
//			//long pos = dis.readLong();
//			//System.out.println(key+" "+pos);
//			
//			//long toand = ((long)(7))<<61;
//			//long newfile = (pos&toand)>>>61;
//			//System.out.println(newfile);
//			//pos = (pos&(~toand));
//			
//			//FileInputStream fis2 = new FileInputStream("/Users/abdulmaa/Desktop/DB_out/Data."+newfile);
//			//DataInputStream dis2 = new DataInputStream(fis2);
//			
//			//System.out.println(pos);
//			//fis2.getChannel().position(pos);
//			
//			//System.out.println(dis2.readLong());
//			//int n = dis2.readInt();
//			for(int j = 0; j<n; j++){
//				System.out.println(dis.readUTF());
//			}
//		}
		
//		long pos = dis.readLong();
//		long key = dis.readLong();
//
		
//		long filenum = 1, offset = 2;
//		long address = filenum<<61;
//		System.out.println(Long.toBinaryString(address));
//		address = address|offset;
//		System.out.println(Long.toBinaryString(address));
		
		//QueryExecuter qe = new QueryExecuter("/Volumes/CS245-10/new_data/");
//		Seeker seeker = new Seeker("/Volumes/CS245-10/new_data/");
//		long [] p = new long[2];
//		seeker.seek(7882229831043200l, p);
//		System.out.println(Arrays.toString(p));
//		
//		FileInputStream fis = new FileInputStream("/Volumes/CS245-10/new_data/Data."+p[0]);
//		DataInputStream dis = new DataInputStream(fis);
//		fis.getChannel().position(p[1]);
//		
//		System.out.println(dis.readLong());
		
		//ArrayList<String> res = qe.execQuery(7882229831043199l, 7882229831043200l);
		
		
		//for(String s:res){
		//	System.out.println(s);
		//}
		
		/*
		 * 	2740669
			$4cmSpp<5%chM}b>rk2q=GmJ0N'~TgS,_=TB"~a[1=b83XD
			5166471
			MAO8~EA]>*5)gyalY5XI9]3&BF=aA+-TN58Y~1|M
			6676589
			wMQU]7a<cc19oRvNVzk^wL5IYZ*>k:.N
			7317920
			H9z&T:qxNbe3v[02:In@>rR^*:,3WoJp{p&M>.\9%v[akQ<=4%
			7714940
			iP}rLvE_\\so}|8mIwnOtRh\w4&oHY-_`
			10804017
			>R2u\TpKwl06~VVktNptU!w@d;{WBVy5P
			]HdIm*jKS]'~g\Xf4M1ES.*Y`[C9]Q*7GqjSNuXX)s5
			16775083
			d@n*RJii|D*x]{R&e@2(w=|g~_IMg@B:ro$m>+nC'
			18726346
			.$xtW5pPB_c'qIIQGJ);NJ\Yz\R4c`v$ph+;)`BA$DBq$$:YP
			20316298
			MRX7CIU>,Im4hs&_fRkodS*EWP`zowPt%8rQOl.i(h4N+I\{_
			21347715
			)r&aIz}".Pj3LO?&_6,me0lHts[kDyjdm+q*kWm;I-V>(rww
		 */
		
	}
}
