package com.project.fooddeliveryproject.service;

import com.project.fooddeliveryproject.model.Admin;

public interface AdminService {

	Admin saveAdmin(Admin admin);
	Admin loginAdmin(Admin admin);

}
