package edu.unm.cs564.movierental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unm.cs564.movierental.dao.VknsSpridenDao;
import edu.unm.cs564.movierental.model.VknsSpriden;


@Service("spridenService")
@Transactional
public class VknsSpridenServiceImpl implements VknsSpridenService{

	@Autowired
	private VknsSpridenDao dao;
	
	public void saveSpriden(VknsSpriden spriden) {
		dao.saveSpriden(spriden);
	}

	public List<VknsSpriden> findAllSpridens() {
		return dao.findAllSpridens();
	}

	public void deleteSpridenById(String id) {
		dao.deleteSpridenbyId(id);
	}

}
