package com.vti.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vti.utils.FileManager;

@Service
public class FileService implements IFileService {

	private FileManager fileManager = new FileManager();
	private String linkFolder = "D:\\\\BaiTest\\\\advance java\\\\lesson7\\\\Lesson 7_Resource\\\\1. HelloWorld\\\\HelloWorld\\\\anh";

	
	@Override
	public String uploadImage(MultipartFile image) throws IOException {

		String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());

		String path = linkFolder + "\\" + nameImage;

		fileManager.createNewMultiPartFile(path, image);

		// TODO save link file to database

		// return link uploaded file
		return path;
	}

	@Override
	public File dowwnloadImage(String nameImage) throws IOException {

		String path = linkFolder + "\\" + nameImage;

		return new File(path);
	}
}
