package com.cdac.training.productrest.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.training.productrest.model.Image;
import com.cdac.training.productrest.repository.ImageRepository;


@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;
	

	public String saveImage(String event, String fname, String lname, String email, String phoneNo, String description, MultipartFile file, String bestbefore ,String path) throws IOException
    {
		Image image = new Image();
		image.setEvent(event);
		image.setFname(fname);
		image.setLname(lname);
		image.setEmail(email);
		image.setPhoneNo(phoneNo);
		image.setDescription(description);
		String name=file.getOriginalFilename();
		
		String randomID=UUID.randomUUID().toString();
		System.out.println(randomID);
		String fileName1=randomID.concat(name.substring(name.lastIndexOf(".")));
		System.out.println("tusahr"+fileName1);
		image.setImage(fileName1);
		
		String filePath=path+File.separator+fileName1;
		
		
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		Files.copy(file.getInputStream(), Paths.get(filePath));
		image.setBestbefore(bestbefore);
		imageRepository.save(image);
		return "Image saved in DB";
	}
	
//	public Image getImage(String path, String fileName, String event, String fname, String lname, String email, String phoneNo, String description, String bestBefore) throws FileNotFoundException {
//	    String fullPath = path + File.separator + fileName;
//	    InputStream is = new FileInputStream(fullPath);
//	    return new Image(null, event, fname, lname, email, phoneNo, description, bestBefore, fullPath, null);
//	}
	
	public List<Image> getAllData()
	{
		return imageRepository.findAll();
	}
}
