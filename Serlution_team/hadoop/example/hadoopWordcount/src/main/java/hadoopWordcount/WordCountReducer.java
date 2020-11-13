package hadoopWordcount;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
 
public class WordCountReducer extends 
Reducer<Text, IntWritable, Text, IntWritable> {


    private IntWritable res = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,
            Context context)
            throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        int sum = 0;
        for(IntWritable val : values)
        {
            sum += val.get();
            //sum++;
        }
       res.set(sum);
         context.write(key, res);
    
       }
}

