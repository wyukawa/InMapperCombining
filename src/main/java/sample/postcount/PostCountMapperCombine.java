package sample.postcount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class PostCountMapperCombine extends
		Mapper<LongWritable, Text, Text, IntWritable> {

	private Map<String, Integer> countMap;

	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {
		super.setup(context);
		countMap = new HashMap<String, Integer>();
	}

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] records = value.toString().split(",");
		String todoufuken = records[4];
		if (countMap.containsKey(todoufuken)) {
			countMap.put(todoufuken, countMap.get(todoufuken) + 1);
		} else {
			countMap.put(todoufuken, 1);
		}
	}

	@Override
	protected void cleanup(Context context) throws IOException,
			InterruptedException {
		for (Entry<String, Integer> e : countMap.entrySet()) {
			context.write(new Text(e.getKey()), new IntWritable(e.getValue()));
		}
		super.cleanup(context);
	}

}
