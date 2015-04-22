package edu.unm.cs564.movierental.dao;

import java.util.List;

import edu.unm.cs564.movierental.model.VknsSpriden;


public interface VknsSpridenDao {

	void saveSpriden(VknsSpriden employee);
	
	List<VknsSpriden> findAllSpridens();
	
	void deleteSpridenbyId(String ssn);
}
