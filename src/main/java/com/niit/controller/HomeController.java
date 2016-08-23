package com.niit.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.RegisterDAO;
import com.niit.shoppingcart.model.Login;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Register;




@Controller
public class HomeController
{
@Autowired
ProductDAO productDAO;
@Autowired
RegisterDAO rs;
@Autowired
LoginDAO ld;
@RequestMapping("/")
public ModelAndView display(){
	ModelAndView m1=new ModelAndView("Home");
	return m1;
}
@RequestMapping("/login")
public ModelAndView display2(){
	ModelAndView m2=new ModelAndView("login");
	return m2;
}
@RequestMapping("/EditUser")
public ModelAndView display7() {
	ModelAndView m2 = new ModelAndView("EditUser");
	return m2;
}
@RequestMapping("/RetrieveUser")
public ModelAndView display8() {
	ModelAndView m2 = new ModelAndView("RetrieveUser");
	return m2;
}

@RequestMapping("/welcome")
public ModelAndView display3() {
	ModelAndView m9 = new ModelAndView("welcome");
	return m9;
}
@RequestMapping("/register")
public ModelAndView display5()
{
	ModelAndView m3=new ModelAndView("register");
	return m3;
}
@RequestMapping("/viewuser")
public ModelAndView display9() {
	ModelAndView m9 = new ModelAndView("viewuser");
	return m9;
}
@RequestMapping("/fail2login")
public ModelAndView display4() {
	ModelAndView m9 = new ModelAndView("fail2login");
	return m9;
}
public ModelAndView display6()
{
	ModelAndView m4=new ModelAndView("addwatch");
	return m4;
}



@ModelAttribute("Product")
public  Product addwatch()
{
	return new Product();
}
@RequestMapping("/hai")
public String display10()
{
	return "Home";
}
/*@RequestMapping("/storewatch")
public String addChairs(HttpServletRequest request,@Valid @ModelAttribute("Product")Product product,BindingResult result)
       {
System.out.println("hello niit...........................");
    	if(result.hasErrors())
    	{
    		return "addwatch";
    	}
    	String filename=product.getImage();
    	product.setImage(filename);
    	
    	try{
    		byte[] bytes=new byte[product.getImg().getInputStream().available()];
    	}
    		product.getImg().getInputStream().read(bytes);
    		BufferedInputStream buffer=new BufferedInputStream(product.getImg().getInputStream());
    		MultipartFile file=product.getImg();
    		String path=request.getServletContext().getRealPath("/")+"resources/images";
    		File rootPath=new File(path);
    		if(!rootPath.exists())
    			rootPath.mkdirs();
    		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
    		System.out.println("Image path :"+path);
    		OutputStream os=new FileOutputStream(store);
    		os.write(bytes);;
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	productDAO.saveOrUpdate(product);
    	return "ViewAll";
    	return "retrive";
    }*/
@ModelAttribute("Register")
public Register createuser(){
		return new Register();
}

@RequestMapping(value = "/storeuser", method = RequestMethod.POST)
public String addUser(@Valid @ModelAttribute("User")Login login,@Valid @ModelAttribute("UserDetails")Register register,BindingResult result, Model model){
   	
	if(result.hasErrors()) {
		
		return "register";
	}
	
	System.out.println("hello storeUser");
	System.out.println(register.getUsername()+ "hello @@@@@@");
	ld.save(login);
	ld.Update(login);
	login.setId(register.getId());
	login.setStatus(register.isStatus());
	
	return "Home";
   }
@RequestMapping(value = "/welcome", method = RequestMethod.GET)
public ModelAndView checkUserOne(HttpServletRequest request, HttpServletResponse response, HttpSession session)
		throws Exception {
	System.out.println("hi");
	if (request.isUserInRole("ROLE_ADMIN")) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String str = auth.getName(); // get logged in username
		session = request.getSession(true);
		session.setAttribute("loggedInUser", str);

		// session.invalidate();
		ModelAndView m1 = new ModelAndView("admin");
		return m1;
	}
	else
	{
		ModelAndView m2 = new ModelAndView("Home");
		return m2;
	}
	
	
}
@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
public ModelAndView loginerror(ModelMap model) {
	System.out.println("hello devi...........................................");

	return new ModelAndView("Login", "error", true);

}
@RequestMapping(value="/updateUser",method=RequestMethod.POST)
public ModelAndView updateuser(HttpServletRequest request, @Valid @ModelAttribute("Login")Login login)
{
	ld.Update(login);
	return new ModelAndView("EditUser");
}
 


/*@RequestMapping(value = "/list2", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody String showList2() {
	List list = ld.getAllLogin();
	Gson u = new Gson();
	String json = u.toJson(list);
	return json;
}
@RequestMapping(value="EditUser", method=RequestMethod.GET)
public ModelAndView edituser(@RequestParam int id){
 System.out.println("hello .........................vishnu............");	
 Login u1=ld.get(id);
 System.out.println("hello.........................reddy............");
 
	return new ModelAndView("EditUser","Login",u1);
}

@RequestMapping("/deleteUser")
public ModelAndView deleteuser(@RequestParam int id)
{
 System.out.println("hello");
    ld.delete(id);
    rs.delete(id);
	ModelAndView model2=new ModelAndView("RetrieveUser");
	return model2;
}*/

}


