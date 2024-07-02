package com.cdac.training.productrest.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.training.productrest.model.Image;
import com.cdac.training.productrest.repository.ImageRepository;
import com.cdac.training.productrest.service.ImageService;

import jakarta.servlet.http.HttpServletResponse;


@RestController
public class ImageController 
{
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ImageRepository imageRepo;
	
	@Value("${project.image}")
	private String path;
	
	@GetMapping("/Users")
	public List<Image> getAllUsers()
	{
		List<Image> user1 = imageRepo.findAll();
		return user1;
	}
	
//	@PostMapping("/insertUser")
//	public void createUser(@RequestBody Image user2)
//	{
//		imageRepo.save(user2);
//	}
	
	@PostMapping("/save")
	public String saveIMageOrFile(@RequestParam("event") String event, @RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("email") String email, @RequestParam("phoneNo") String phoneNo,@RequestParam("description") String description, @RequestParam("file") MultipartFile file, @RequestParam("bestbefore") String bestbefore) throws IOException
	{
		return imageService.saveImage(event, fname, lname, email, phoneNo,description, file, bestbefore, path);
	}
	
//	@GetMapping("/save/{imageName}")
//	public void getImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
//	     
//   
//	  /*  InputStream resource = this.imageService.getImage(path, imageName, event, fname, lname, email, phoneNo, description, bestBefore);
//	    
//	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//	    
//	    if (resource != null ) {
//	        // Use IOUtils.copy here
//	    	
//	    	 IOUtils.copy(resource, response.getOutputStream());
//	    } else {
//	        // Handle the case where resource is not a valid InputStream
//	    }
//	   */
//	}
	
	@GetMapping("/saved")
	public List<Image>  showUserData(Model model)
	{
	 List<Image> events=imageService.getAllData();	
	 model.addAttribute("events", events);
	 return events;
	}

	


	
}
