package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("menuItemService") // 
public class MenuItemServiceImpl implements MenuItemService {
	
	@Autowired
	private MenultemDao itemDao;

	@Override
	public void addMenuItem(MenuItem item) {
		itemDao.save(item);
	}

	@Override
	public List<MenuItem> findAllMenuItem() {		
		return itemDao.findAllMenuItemList();
	}

	@Override
	public MenuItem findMenuItemByName(String name) {		
		return itemDao.findByName(name);
	}
}
