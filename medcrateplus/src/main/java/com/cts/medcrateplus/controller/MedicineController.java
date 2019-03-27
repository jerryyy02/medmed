package com.cts.medcrateplus.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.medcrateplus.bean.Login;
import com.cts.medcrateplus.bean.Medicine;
import com.cts.medcrateplus.service.DoctorService;
import com.cts.medcrateplus.service.LoginService;
import com.cts.medcrateplus.service.MedicineService;

@Controller
public class MedicineController {
	
	@Autowired
	MedicineService medicineService;
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("lowtohigh.html")
	public ModelAndView validateUser(@ModelAttribute Medicine medicine, @RequestParam("order") String order){
		ModelAndView modelAndView = new ModelAndView();
		
			List<Medicine> medicines= medicineService.getAllMedicineByLowToHigh(order);
			modelAndView.addObject("medicines", medicines);
			
			modelAndView.setViewName("Admin-Control");
			return modelAndView;
	
	}
	
	@RequestMapping("hightolow.html")
	public ModelAndView validateVendor(@ModelAttribute Medicine medicine, @RequestParam("order") String order){
		ModelAndView modelAndView = new ModelAndView();
		
			List<Medicine> medicines= medicineService.getAllMedicineByHighToLow(order);
			modelAndView.addObject("medicines", medicines);
			
			modelAndView.setViewName("User-Control");
			return modelAndView;
	}
	
	@RequestMapping("block.html")
	public ModelAndView blockProduct(@ModelAttribute Medicine medicine, @RequestParam("id") String medId){
		ModelAndView modelAndView = new ModelAndView();
		
			medicineService.blockMedicine(medId);
			modelAndView.addObject("medicines", medicineService.getAllMedicine());
			modelAndView.setViewName("Admin-Control");
			return modelAndView;
	}
	
	@RequestMapping("unblock.html")
	public ModelAndView unblockProduct(@ModelAttribute Medicine medicine, @RequestParam("id") String medId){
		ModelAndView modelAndView = new ModelAndView();
		
			medicineService.blockMedicine(medId);
			modelAndView.addObject("medicines", medicineService.getAllMedicine());
			modelAndView.setViewName("Admin-Control");
			return modelAndView;
	}
	
	@RequestMapping("AddMedicine.html")						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView addPage(@ModelAttribute Medicine medicine){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AddMedicine");
		return modelAndView;
	}
	
	@RequestMapping(value="AddMedicines.html", method= RequestMethod.POST)						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView insertProduct(@ModelAttribute Medicine medicine){
		ModelAndView modelAndView = new ModelAndView();
	
		medicineService.insertMedicine(medicine);
	
		modelAndView.addObject("medicines", medicineService.getAllMedicine());
			modelAndView.setViewName("Admin-Control");
			//modelAndView.addObject("products",productService.getAllProduct());
		return modelAndView;
	}
	
	@RequestMapping(value="search.html", method= RequestMethod.POST)
	public ModelAndView searchMedicine(@ModelAttribute Medicine medicine, @RequestParam("browser") String search_by,@RequestParam("category") String search_value){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(search_by);
		System.out.println(search_value);
			List<Medicine> medicines= medicineService.searchMedicineByValues(search_by, search_value);
			modelAndView.addObject("medicines", medicines);
			modelAndView.setViewName("Admin-Control");
			return modelAndView;
	
	}
	
	@RequestMapping("remove.html")
	public ModelAndView removeProduct(@ModelAttribute Medicine medicine, @RequestParam("id") String medId){
		 	ModelAndView modelAndView = new ModelAndView();
			String medicines= medicineService.deleteMedicine(medId);
			if(medicines.equals("sucess")){
				modelAndView.addObject("medicines", medicineService.getAllMedicine());
			modelAndView.setViewName("Admin-Control");
			return modelAndView;
			}
			else{
				modelAndView.setViewName("Admin-Control");
				return modelAndView;
			}
		
	}
	
	@RequestMapping(value="show.html")
	public ModelAndView showDoctorList(@ModelAttribute Login login){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("doctor", doctorService.getAllDoctor());
			modelAndView.setViewName("DoctorList");
			return modelAndView;
	
	}
	
	@RequestMapping(value="showdoctorlist.html")
	public ModelAndView showDoctorListOnUser(@ModelAttribute Login login){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("doctor", doctorService.getAllDoctor());
			modelAndView.setViewName("AdminDoctorList");
			return modelAndView;
	
	}
	
	@RequestMapping("view.html")
	public ModelAndView viewProduct(@ModelAttribute Login login, @RequestParam("id") String userId, HttpSession httpsession){
		 	ModelAndView modelAndView = new ModelAndView();
		 	modelAndView.addObject("doctor", doctorService.viewDoctor(userId));
			modelAndView.setViewName("ViewDoctor");
			return modelAndView;
	}
	
	@RequestMapping(value="showbloodlist.html")
	public ModelAndView showBloodListOnUser(@ModelAttribute Login login){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("blood", loginService.getAllByBloodGroup());
			modelAndView.setViewName("BloodList");
			return modelAndView;
	
	}
	
	@RequestMapping("unavailable.html")
	public ModelAndView blockProduct(@ModelAttribute Login login, @RequestParam("id") String userId){
		ModelAndView modelAndView = new ModelAndView();
		
			loginService.unavailableDoctor(userId);
			/*modelAndView.addObject("products", productService.getAllProduct());*/
			modelAndView.setViewName("Doctor-Control");
			return modelAndView;
	}
	
	@RequestMapping("available.html")
	public ModelAndView unblockProduct(@ModelAttribute Login login, @RequestParam("id") String userId){
		ModelAndView modelAndView = new ModelAndView();
		
			loginService.unavailableDoctor(userId);
			/*modelAndView.addObject("products", productService.getAllProduct());*/
			modelAndView.setViewName("Doctor-Control");
			return modelAndView;
	}
}
