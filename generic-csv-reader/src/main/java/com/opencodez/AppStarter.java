/**
 * 
 */
package com.opencodez;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.opencodez.domain.CsvData;
import com.opencodez.util.csv.CustomCsvProcessor;
import com.opencodez.util.csv.CustomCsvReader;

/**
 * @author pavan.solapure
 *
 */
@Component
public class AppStarter implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		
		String file = "src/main/resources/sample-data.csv";
		List<String> ord = new ArrayList<String>();
		ord.add("id");
		ord.add("name");
		ord.add("series");
		
		CustomCsvReader<CsvData> reader = new CustomCsvReader<CsvData>(CsvData.class, file, true)
				.setOrder(ord)
				.read()
				.process(new CustomCsvProcessor());
		
		for(CsvData msg :reader.getData()) {
			System.out.println(msg);
		}		
	}

}
