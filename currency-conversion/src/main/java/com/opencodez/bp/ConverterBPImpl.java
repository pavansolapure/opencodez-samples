package com.opencodez.bp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.opencodez.cache.RatesCache;
import com.opencodez.model.ConversionRates;
import com.opencodez.model.ConverterModel;
import com.opencodez.model.ResponseModel;
import com.opencodez.util.Constants;
import com.opencodez.util.Currency;

@Component
public class ConverterBPImpl implements ConverterBP {
	
	@Autowired
    private Environment env;
	
	@Autowired
	private RatesCache cache;

	@Override
	public ConverterModel getConverterModel() {
		ConverterModel cm = new ConverterModel();
		return cm;
	}

	@Override
	public ResponseModel getConvertedValue(Currency source, Currency target, BigDecimal amount) {

		ResponseModel rm = new ResponseModel();
		
		String rateKey = source.getCode()+target.getCode();
		
		BigDecimal cachedRate = cache.getCachedRate(rateKey);
		if(null != cachedRate) {
			rm.setConvertedValue(cachedRate.multiply(amount));
			System.out.println("Returing data for " + rateKey + " from Cache");
			return rm;
		}
		
		MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<String, String>();
		uriVariables.add("access_key", env.getProperty(Constants.API_KEY));
		uriVariables.add("currencies", target.getCode());
		uriVariables.add("source", source.getCode());
		uriVariables.add("format", "1");
		
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(env.getProperty(Constants.API_BASE_URL)).queryParams(uriVariables).build();

		RestTemplate restTemplate = new RestTemplate();
		ConversionRates rates = restTemplate.getForObject(uriComponents.toUri(), ConversionRates.class);
				
		if(rates.getSuccess()) {
			String cRate = rates.getQuotes().get(rateKey);
			BigDecimal bdr = new BigDecimal(cRate);
			rm.setConvertedValue(bdr.multiply(amount));
			cache.cacheRate(rateKey, bdr);
		} else {
			rm.setError(rates.getError());
			rm.setConvertedValue(BigDecimal.ZERO);
		}
		
		return rm;
	}

	

}
