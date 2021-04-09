package app.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.repository.UserHasImageJpaRepository;
import app.repository.UserJpaRepo;

import model.User;
import model.UsersHasImage;

@Controller
public class UserController {

	@Autowired
	UserJpaRepo userJpaRepo;
	@Autowired
	UserHasImageJpaRepository userHasImageJpaRepo;

	@RequestMapping(value = "/clicks", method = RequestMethod.POST)
	public String login(User u, HttpServletRequest request, Model m) {
		
		User user = userJpaRepo.findByUsernameAndPassword(u.getUsername(), u.getPassword());
		if (user != null) {
			
			List<UsersHasImage> uhi = user.getUsersHasImages();
			
			// sortiranje4 listu objekata po img_ordinal
			uhi.sort((o1, o2) -> o1.getImgOrdinal().compareTo(o2.getImgOrdinal()));

			request.getSession().setAttribute("list", uhi);
			request.getSession().setAttribute("user", user);
			return "kliktanje";
		} else {
			m.addAttribute("poruka", "ERROR: invalid username or password!");
			return "index";			
		}
	}

	

	@RequestMapping(value = "/next", method = RequestMethod.POST)
	public @ResponseBody String getUrl(@RequestBody List<String> rows, @RequestParam("ind") int i,HttpServletRequest request) {		
		List<UsersHasImage> uhi = (List<UsersHasImage>) request.getSession().getAttribute("list");
		UsersHasImage userhasimage = uhi.get(i - 1);
		String username = userhasimage.getUser().getUsername();		
		int idImage = userhasimage.getImage().getId();		
		
		//snimanje file-a na server
		String resultPath = saveToCsv(rows, username, idImage, request);
		//upis path-a u bazu 		
		userhasimage.setResultsPath(resultPath);
		userHasImageJpaRepo.save(userhasimage);
		
		if (i < uhi.size()) {
			userhasimage = uhi.get(i);
			return userhasimage.getImage().getUrl();
		} else
			return "http://www.protech.rs";
	}

	static String saveToCsv(List<String> rows, String username, int idImage, HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		String filename = username.toUpperCase() + "_" + idImage+"_clicks.csv";
		//String absPath = request.getSession().getServletContext().getRealPath("/results");		
		String path = "D:\\nastava\\IS2Vezbanje\\KlikWeb\\WebContent\\results";		
		File file = new File(path, filename);		
		try {
			file.createNewFile();			
		} catch (IOException e2) {			
			e2.printStackTrace();
		}
		PrintWriter printWriter;
		for (String str : rows)
			sb.append(str+"\n");
		String contentFile = sb.toString();
		System.out.println(contentFile);
		try {
			printWriter = new PrintWriter(file);
			if (!file.exists()) {
				try {
					file.createNewFile();
					printWriter.print(contentFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				printWriter.print(contentFile);
			}
			printWriter.close();
		} catch (FileNotFoundException e1) {			
			e1.printStackTrace();
		}
		return path+"\\"+filename;
	}
}
