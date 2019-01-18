package com.version.hub.moblegacy.repository;

import java.util.List;

import com.version.hub.moblegacy.model.MobileVersiondetails;

public interface MobileVersionRepository{
	
	public List<MobileVersiondetails> populateVersionDetail();
	
	public List<MobileVersiondetails> getAppNameWithLatestAPI();

}
