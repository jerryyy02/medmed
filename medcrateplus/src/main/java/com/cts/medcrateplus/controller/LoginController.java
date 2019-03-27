package com.cts.medcrateplus.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.medcrateplus.bean.Login;
import com.cts.medcrateplus.bean.Medicine;
import com.cts.medcrateplus.dao.MedicineDAO;
import com.cts.medcrateplus.service.DoctorService;
import com.cts.medcrateplus.service.LoginService;
import com.cts.medcrateplus.service.MedicineService;



@Controller
public class LoginController {

	
	
	@Autowired
	//@Qualifier("loginService")
	LoginService loginService;
	
	@Autowired
	MedicineService medicineService;
	
	@Autowired
	DoctorService doctorService;
	
	@RequestMapping(value="login.html")                //GetMapping(value="login.html", method= RequestMethod.GET) could also be done
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping(value="login.html", method= RequestMethod.POST)						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView validateUser(@ModelAttribute Login login, HttpSession httpsession){
		ModelAndView modelAndView = new ModelAndView();
		if(loginService.authenticate(login.getUserId(),login.getPassword())!=null){
			if(loginService.getUserType(login.getUserId()).equals("A")){
				Login login2  = loginService.authenticate(login.getUserId(), login.getPassword());
				modelAndView.addObject("user", login2);
				httpsession.setAttribute("user", login2);
				modelAndView.addObject("medicines", medicineService.getAllMedicine());
		
				modelAndView.setViewName("Admin-Control");
				return modelAndView;
			}
			else if(loginService.getUserType(login.getUserId()).equals("U")){
				Login login2  = loginService.authenticate(login.getUserId(), login.getPassword());
				modelAndView.addObject("user", login2);
				httpsession.setAttribute("user", login2);
				modelAndView.addObject("medicines", medicineService.getMedicineByStatus());
				modelAndView.setViewName("User-Control");
				return modelAndView;
			}	
			else{
				Login login2  = loginService.authenticate(login.getUserId(), login.getPassword());
				modelAndView.addObject("user", login2);
				httpsession.setAttribute("user", login2);
				modelAndView.setViewName("Doctor-Control");
				return modelAndView;
			}
	}
	else{
		modelAndView.setViewName("LoginError2");
		return modelAndView;
	}

}
	
	@RequestMapping(value="searchDoc.html", method= RequestMethod.POST)
	public ModelAndView searchDoctorAdmin(@ModelAttribute Login login, @RequestParam("SearchBy") String search_by,@RequestParam("Search") String search_value){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(search_by);
		System.out.println(search_value);
			List<Login> login1= doctorService.searchDoctorByValues(search_by, search_value);
			modelAndView.addObject("doctor", login1);
			modelAndView.setViewName("DoctorList");
			return modelAndView;
	
	}
	
	@RequestMapping(value="searchUserDoc.html", method= RequestMethod.POST)
	public ModelAndView searchDoctorUser(@ModelAttribute Login login, @RequestParam("SearchBy") String search_by,@RequestParam("Search") String search_value){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(search_by);
		System.out.println(search_value);
			List<Login> login1= doctorService.searchDoctorByValues(search_by, search_value);
			modelAndView.addObject("doctor", login1);
			modelAndView.setViewName("AdminDoctorList");
			return modelAndView;
	
	}
	
	@RequestMapping(value="searchGroup.html", method= RequestMethod.POST)
	public ModelAndView searchBloodGroup(@ModelAttribute Login login,@RequestParam("Search") String search_value){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(search_value);
			List<Login> login1= loginService.searchGroupByValues(search_value);
			modelAndView.addObject("blood", login1);
			modelAndView.setViewName("BloodList");
			return modelAndView;
	
	}

}
