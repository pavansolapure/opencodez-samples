package com.opencodez.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencodez.domain.Developer;

public class DeveloperSerializer implements Serializer<Developer> {

	@Override
	public byte[] serialize(String arg0, Developer developer) {
		byte[] serializedBytes = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			serializedBytes = objectMapper.writeValueAsString(developer).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serializedBytes;
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
