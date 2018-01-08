package com.opencodez.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencodez.domain.Developer;

public class DeveloperDeserializer implements Deserializer<Developer> {

	@Override
	public Developer deserialize(String arg0, byte[] devBytes) {
		ObjectMapper mapper = new ObjectMapper();
		Developer developer = null;
		try {
			developer = mapper.readValue(devBytes, Developer.class);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return developer;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

}
