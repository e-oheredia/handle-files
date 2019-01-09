package com.exact.handle.files.beans;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.exact.handle.files.interfaces.IManageFile;

@Component("ManageFileLocal")
public class ManageFileLocal implements IManageFile {

	Logger logger = LoggerFactory.getLogger(ManageFileLocal.class);

	@Value("${urlLocal}")
	private String urlLocal;

	@Override
	public int upload(MultipartFile file, String ruta) {

		try {
			String filename = file.getOriginalFilename();
			String directory = urlLocal+ruta;
			String filepath = Paths.get(directory, filename).toString();

			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(file.getBytes());
			stream.close();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(String fileName) {

		try {
			String directory = urlLocal;
			String filepath = Paths.get(directory, fileName).toString();
			File file = new File(filepath);
			if (file.delete()) {
				return 1;
			} else {
				return -1;
			}
		} catch (Exception e) {
			return -1;
		}
	}

}
