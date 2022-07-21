package com.varxyz.jvx330.di.example6;

import java.util.List;

public interface MenuItemService {
	
	public void addMenuItem(MenuItem Item);
	public List<MenuItem> findAllMenuItem();
	public MenuItem findMenuItemByName(String name);
	
}
