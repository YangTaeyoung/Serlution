package hadoopWordcount;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.File;




public class Test {
	
	
	public static void main(String args[]) throws ClassNotFoundException, IOException, InterruptedException
	{
		
		WordCount wd = new WordCount("/home/ubuntu/set.txt","/home/ubuntu/babo/");
		List <KeyCount> list = wd.execute();
		for(KeyCount e : list)
		{
			System.out.println(e);
		}
		deletef();
	}

	static void deletef() {
		String path ="/home/ubuntu/babo";
		
		try {
			File folder = new File(path);
			while(folder.exists()) {
				File[] folder_list = folder.listFiles();
				
				for (int j = 0; j < folder_list.length; j++) {
					folder_list[j].delete();
				}
				if(folder_list.length==0&&folder.isDirectory()) folder.delete();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}