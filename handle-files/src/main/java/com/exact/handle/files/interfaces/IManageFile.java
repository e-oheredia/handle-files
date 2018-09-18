package com.exact.handle.files.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IManageFile {
	
	public int upload(MultipartFile file);
	public int delete(String fileName);
	
}
