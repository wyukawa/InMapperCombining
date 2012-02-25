package sample.postcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class PostCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	
	private final static IntWritable one = new IntWritable(1);

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		String[] records = value.toString().split(",");
		output.collect(new Text(records[4]), one);
	}


}
