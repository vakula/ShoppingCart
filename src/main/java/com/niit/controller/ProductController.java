package com.niit.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO pd;
	@RequestMapping("addproduct")
	 public ModelAndView display5()
	 {
	 ModelAndView m5=new ModelAndView("addproduct");
	 return m5;
	 }
	 @ModelAttribute("Product")
	    public Product createProduct()
	    {
	    	return new Product();
	    }
	 @RequestMapping("/storeproduct")
	    public String addproduct(HttpServletRequest request,
	    		@Valid 
	    		@ModelAttribute("Product")
	              Product product,
	               BindingResult result)
	           {
		 System.out.println("hello niit...........................");
	        	if(result.hasErrors())
	        	{
	        		return "addproduct";
	        	}
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
	return "display";
	           }
	 @RequestMapping(value="view",method=RequestMethod.GET)
	 public ModelAndView view(@RequestParam int id, @ModelAttribute Product products){
	 Product product=pd.get(id);
	 	return new ModelAndView("view","Product",product);
	 }
	 @RequestMapping(value="editproduct",method=RequestMethod.GET)
	 public ModelAndView editproduct(@RequestParam int id){
	  System.out.println("hello niit.........................niit1............");	
	  Product product1=pd.get(id);
	  System.out.println("hello niit.........................niit2............");
	  System.out.println("eeee "+product1.getName());
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
	 	return new ModelAndView("display");
	 }
	 @RequestMapping("/delete")
	 public ModelAndView deleteChair(@RequestParam int id)
	 {
	  System.out.println("hello welcome to niit");
	     pd.delete(id);
	 	ModelAndView model=new ModelAndView("display");
	 	return model;
	 }
	 @RequestMapping("/display")
	 public ModelAndView retriveRecords()
	 {  
	 	ModelAndView m5=new ModelAndView("display");
	 	return m5;
	 } 
	 @RequestMapping("/displayproduct")
	 public ModelAndView retriveRecord()
	 {  
	 	ModelAndView m33=new ModelAndView("displayproduct");
	 	return m33;
	 } 
	 @RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
	 public @ResponseBody String showList()
	 {
	 	 List<Product> list=pd.list();
	 	System.out.println("Hello Niit---------- ---------------------");
	 	System.out.println(list);
	 	System.out.println("one");
	 	Gson x=new Gson();
	 	System.out.println("two");
	 	String json=x.toJson(list);
	 	System.out.println("three");
	 	return json;
	 }
}
