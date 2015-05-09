package sa.edu.kaust.cs245.abdurrahman.preprocessing;

public class DBEntry implements Comparable<DBEntry> {
	long id;
	String string;
	
	
	public DBEntry(long id, java.lang.String string) {
		super();
		this.id = id;
		this.string = string;
	}

	public static DBEntry createEntry(String s){
		int ind = s.indexOf(' ');
		return new DBEntry(Long.parseLong(s.substring(0, ind)), s.substring(ind+1));
	}

	@Override
	public int compareTo(DBEntry o) {
		if(id>o.id)return 1;
		if(id<o.id)return -1;
		return string.compareTo(o.string);
	}
	
	@Override
	public String toString() {
		return id+" "+string;
	}
	
}
