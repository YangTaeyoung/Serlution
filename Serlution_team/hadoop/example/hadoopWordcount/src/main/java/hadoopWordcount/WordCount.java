package hadoopWordcount;

import org.apache.hadoop.conf.Configuration;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import java.util.StringTokenizer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import java.io.*;
import java.util.Scanner;


public class WordCount{

	
	String inputPath;
	String outputPath;
  
	public WordCount(String inputPath, String outputPath)
	{
		this.inputPath = inputPath;
		this.outputPath = outputPath;
	}
	
	@SuppressWarnings("deprecation")
   public List<KeyCount> execute() throws IOException, ClassNotFoundException, InterruptedException
   {
		List<KeyCount> list = new ArrayList<KeyCount>();
        Configuration conf = new Configuration();
       
        Job job = new Job(conf, "WordCount");
        
        job.setJarByClass(WordCount.class);
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        
        TextInputFormat.addInputPath(job, new Path(inputPath));
        TextOutputFormat.setOutputPath(job, new Path(outputPath));
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        job.waitForCompletion(true);
        File file = new File("/home/ubuntu/babo/part-r-00000");
        Scanner scan = new Scanner(file);
        
        
        String tmp = null;
    
       do
       {
    	   KeyCount tmpKC  = new KeyCount();
    	   tmp = scan.next();
    	   if(tmp!= null)
    		   tmpKC.setName(tmp);
    	   tmp = scan.next();
    	   scan.
    	   if(tmp != null)
    	   		tmpKC.setCount(Integer.parseInt(tmp));
    	   list.add(tmpKC);
       }while(scan.hasNext());
        return list;
    }
 
}


