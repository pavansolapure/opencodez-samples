package com.version.hub.moblegacy.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.version.hub.moblegacy.model.MobileVersiondetails;
import com.version.hub.moblegacy.repository.MobileVersionRepository;

@Service("mobileVersiondetails")
public class MobileVersionService implements MobileVersionRepository{

	private static List<String> mobileList;
	private HashMap<String, Integer> hashMap = new HashMap<String, Integer>();;
	static {
		
		mobileList = new ArrayList<String>();
		try {
	        File file = ResourceUtils.getFile("classpath:mobileDetails.txt");
			mobileList = Files.readAllLines(Paths.get(file.getAbsolutePath()));
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	

	@Override
	public List<MobileVersiondetails> populateVersionDetail(){
		List<MobileVersiondetails> mobileVersiondetails = new ArrayList<MobileVersiondetails>();
		for (String string : mobileList) {
			String[] split = string.split(",");
			if(split.length != 3)
				continue;
			
			MobileVersiondetails mobileVersiondetail = new MobileVersiondetails();
			mobileVersiondetail.setMobileApp(split[0]);
			String mobileApi = split[1];
			mobileVersiondetail.setMobileApi(mobileApi);
			int version = Integer.parseInt(split[2].trim().substring(1));
			mobileVersiondetail.setVerison(version);
			
			mobileVersiondetails.add(mobileVersiondetail);

			if(hashMap.containsKey(mobileApi)) {
				Integer integer = hashMap.get(mobileApi);
				if(version > integer)
					hashMap.put(mobileApi, version);
			}
			else
			{
				hashMap.put(mobileApi, version);
			}
			
		}

		return mobileVersiondetails;
	}


	@Override
	public List<MobileVersiondetails> getAppNameWithLatestAPI() {
		List<MobileVersiondetails> populateVersionDetail = populateVersionDetail();
		List<MobileVersiondetails> list = new ArrayList<>();
		List<String> containsLegacyApp = new ArrayList<>();
		HashMap<String, List<MobileVersiondetails>> temp = new HashMap<String, List<MobileVersiondetails>>();
		for (MobileVersiondetails mobileVersiondetails : populateVersionDetail) {

			if((hashMap.get(mobileVersiondetails.getMobileApi()) == mobileVersiondetails.getVerison()) && !containsLegacyApp.contains(mobileVersiondetails.getMobileApp())) {
				list.add(mobileVersiondetails);
				temp.put(mobileVersiondetails.getMobileApp(),list);
			}
			else {
				containsLegacyApp.add(mobileVersiondetails.getMobileApp());
			}
		}
		return list;
	}
	
	
	
}
