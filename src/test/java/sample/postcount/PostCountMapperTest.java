package sample.postcount;

import static org.mockito.Mockito.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.junit.Test;


public class PostCountMapperTest {

	@Test
	public void testMapObjectTextContext() throws Exception {
		
		PostCountMapper wordCountMapper = new PostCountMapper();
		
		Text value = new Text("01101,0600000,IKANIKEISAIGANAIBAAI,CHUO-KU SAPPORO-SHI,HOKKAIDO,0,0,0,0,0,0");
		
		OutputCollector output = mock(OutputCollector.class);
		
		wordCountMapper.map(null, value, output, null);
		
		verify(output).collect(new Text("HOKKAIDO"), new IntWritable(1));
		
	}

}
