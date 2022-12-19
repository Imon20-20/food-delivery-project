package com.project.fooddeliveryproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooddeliveryproject.exception.ResourceNotFoundException;
import com.project.fooddeliveryproject.model.Admin;
import com.project.fooddeliveryproject.repository.AdminRepository;
import com.project.fooddeliveryproject.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
private AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
	super();
	this.adminRepository = adminRepository;
}

	@Override
	public Admin saveAdmin(Admin admin) {
		System.out.println("admin register service"+admin);

		return adminRepository.save(admin);
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId,admin.adminPassword).orElseThrow(()->new ResourceNotFoundException("Admin ", "Id",admin.adminEmailId+"and password "+admin.adminPassword ));
	}

}
