package edu.unm.cs564.movierental.service.impl;

import java.util.List;

import edu.unm.cs564.movierental.model.VknsSpriden;


public interface VknsSpridenService {

	void saveSpriden(VknsSpriden employee);

	List<VknsSpriden> findAllSpridens();

	void deleteSpridenById(String ssn);
}
