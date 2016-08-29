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

import org.hibernate.SessionFactory;
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
	ProductDAO pd;
	@Autowired
     LoginDAO lg;
	@Autowired
	RegisterDAO rs;
	SessionFactory sessionFactory; 
	@RequestMapping("/")
	 public ModelAndView display()
	 {
	 ModelAndView m=new ModelAndView("home");
	 return m;
	 }
	 @RequestMapping("login")
	 public ModelAndView display1()
	 {
	 ModelAndView m1=new ModelAndView("login");
	 return m1;
	 }
	 @RequestMapping("register")
	 public ModelAndView display2()
	 {
	 ModelAndView m2=new ModelAndView("register");
	 return m2;
	 }
		@RequestMapping("AddProduct")
		public ModelAndView display4() {
			ModelAndView m4 = new ModelAndView("AddProduct");
			return m4;
		}
		@ModelAttribute("Product")
	    public Product createProduct()
	    {
	    	return new Product();
	    }

@RequestMapping("hai")
	 public String display7()
	 {
	 
	 return "home";
	 }
	 @RequestMapping("category")
	 public ModelAndView display3()
	 {
	 ModelAndView m3=new ModelAndView("category");
	 return m3;
	 }
	 @RequestMapping("display")
	 public ModelAndView display8()
	 {
	 ModelAndView m3=new ModelAndView("display");
	 return m3;
	 }

	 @RequestMapping("hello")
	 public String display11()
	 {
	 
	 return "home";
	 }
	 @RequestMapping("back")
	 public String display12()
	 {
	 
	 return "home";
	 }
	
	
	

	
@RequestMapping("storeproduct")
public String addmobile(HttpServletRequest request,@Valid @ModelAttribute("Product")Product product,BindingResult result)
       {
 System.out.println("hello niit...........................");
 System.out.println(product.getId());
	System.out.println(product.getName());
	System.out.println(product.getDescription());
	System.out.println(product.getPrice());
	System.out.println(product.getImg());
    	if(result.hasErrors())
    	{
    		return "AddProduct";
    	}
    	System.out.println(product);
    	String filename=product.getImg().getOriginalFilename();
    			//product.getImg().getOriginalFilename();
    	System.out.println("Shanth..........."+filename);
    	product.setImage(filename);
    	
    	try{
    		byte[] bytes=new byte[product.getImg().getInputStream().available()];
    		System.out.println("one");
    		product.getImg().getInputStream().read(bytes);
    		System.out.println("two");
    		BufferedInputStream buffer=new BufferedInputStream(product.getImg().getInputStream());
    		System.out.println("three");
    		MultipartFile file=product.getImg();
       		String path=request.getServletContext().getRealPath("/")+"resources/images";
    		
    		File rootPath=new File(path);
    		
    		if(!rootPath.exists())
    			rootPath.mkdirs();
    		
    		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
    		
    		System.out.println("Image path :"+path);
    		
    		OutputStream pd=new FileOutputStream(store);
    		
    		pd.write(bytes);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	  	pd.saveOrUpdate(product);
    	        	
    	return "display";
       }	

@ModelAttribute("Register")
public Register createregister()
{
	return new Register();
}
@RequestMapping(value = "/storeuser", method = RequestMethod.POST)
public String addUser(@Valid @ModelAttribute("Register")Register register,BindingResult result)
{
   	
	
	Login login=new Login();
	 rs.saveOrUpdate(register);
	 login.setId(register.getId());
	 login.setStatus(register.getStatus());
	 login.setUsername(register.getUsername());
	 login.setPassword(register.getPassword());
	 login.setMobile(register.getMobile());
	 lg.save(login);
	 return "home";
	
   }
@RequestMapping("retriveproduct")
public ModelAndView retriveRecords()
{  
	ModelAndView m1=new ModelAndView("retriveproduct");
	return m1;
}
@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
public ModelAndView loginerror(ModelMap model) {
	System.out.println("hello devi.....................");

	return new ModelAndView("login", "error", true);

}
@RequestMapping(value = "/logout", method = RequestMethod.GET)
public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	System.out.println("Logging out current user.....................");
	session.invalidate();
	return new ModelAndView("hai");

}
@RequestMapping(value = "/welcome", method = RequestMethod.GET)
public ModelAndView checkUserOne(HttpServletRequest request, HttpServletResponse response, HttpSession session)
		throws Exception {
	System.out.println("in homecontroller checkUserOne function");
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String str = auth.getName(); // get logged in username
	session = request.getSession(true);
	session.setAttribute("loggedInUser", str);

	if (request.isUserInRole("ROLE_ADMIN")) {
		session.setAttribute("userRole","ROLE_ADMIN");
		// session.invalidate();
		ModelAndView m5 = new ModelAndView("admin");
		return m5; 
	}
	else
	{
		
		ModelAndView m = new ModelAndView("home");
		session.setAttribute("userRole","ROLE_USER");
		return m;
	}
}

@RequestMapping(value="list",method=RequestMethod.GET,produces="application/json")
public @ResponseBody String showList(){
	List list=pd.list();
	Gson x=new Gson();
	String json=x.toJson(list);
	return json;
}
@RequestMapping("listproducts")
public ModelAndView retrieverecords()
{
ModelAndView m3=new ModelAndView("display");
return m3;
}

@RequestMapping(value="viewproduct",method=RequestMethod.GET)
    public ModelAndView viewproduct(@RequestParam int id, @ModelAttribute Product products){
    	Product product=pd.get(id);
    	return new ModelAndView("viewproduct","Product",product);
    
    }
@RequestMapping("editproduct")
public ModelAndView display5()
{
ModelAndView m6 = new ModelAndView("editproduct");
return m6;
}
@RequestMapping(value="editproduct",method=RequestMethod.GET)
public ModelAndView editproduct(@RequestParam int id){
System.out.println("hello niit.........................niit1............");	
Product product1=pd.get(id);
System.out.println("hello niit.........................niit2............");
System.out.println("eeee" +product1.getName());
return new ModelAndView("editproduct","Product",product1);
}
@RequestMapping(value="/editproduct",method=RequestMethod.POST)
public ModelAndView updateProduct(HttpServletRequest request,@Valid @ModelAttribute("product")Product product,BindingResult result)
{

String filename=product.getImg().getOriginalFilename();

product.setImage(filename);

try{
byte[] bytes=new byte[product.getImg().getInputStream().available()];
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
os.write(bytes);
}
catch(Exception e){
System.out.println(e.getMessage());
}
        
pd.saveOrUpdate(product);
return new ModelAndView("retriveproduct");
}

@RequestMapping("/delete")
public ModelAndView deleteProduct(@RequestParam int id)
{
System.out.println("hello welcome to niit");
pd.deleteProduct(id);
ModelAndView model=new ModelAndView("retriveproduct");
return model;
}
}
	
