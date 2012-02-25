package sample.postcount;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.junit.Test;


public class PostCountReducerTest {

	@Test
	public void testMapObjectTextContext() throws Exception {
		
		PostCountReducer wordCountReducer = new PostCountReducer();
		
		Iterator<IntWritable> values = Arrays.asList(new IntWritable(1), new IntWritable(2)).iterator();
		
		Text key = new Text("HOKKAIDO");
		
		OutputCollector output = mock(OutputCollector.class);
		
		wordCountReducer.reduce(key, values, output, null);
		verify(output).collect(key, new IntWritable(3));
		
	}

}
