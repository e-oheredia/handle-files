package com.exact.handle.files.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exact.handle.files.interfaces.IManageFile;

@Service
@Configurable
public class ManageFileService {
	
	@Autowired
	@Qualifier("ManageFileLocal")
	private IManageFile manageFile;
	
	public int updateFile(MultipartFile file) {		
		return manageFile.upload(file);
	}
	
	public int deleteFile(String fileName) {
		return manageFile.delete(fileName);
	}

}
