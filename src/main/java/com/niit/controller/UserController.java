package com.niit.controller;
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
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Login;

@Controller
public class UserController
{
	@Autowired
	ProductDAO pd;
	@Autowired
	LoginDAO us;
	@RequestMapping(value="/list3",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody String showList3(){
		List<Login> list=us.list();
		Gson u=new Gson();
		String json=u.toJson(list);
		return json;
	}
	@RequestMapping("/edituser")
	public ModelAndView edituser()
	{  
		ModelAndView u4=new ModelAndView("edituser");
		return u4;
	} 
	@RequestMapping("/deleteuser")
    public ModelAndView deleteuser(@RequestParam int id)
    {
	 System.out.println("hello welcome to niit");
	    us.delete(id);
    	ModelAndView u2=new ModelAndView("displayuser");
    	return u2;
	}
	@RequestMapping(value="edituser", method=RequestMethod.GET)
	public ModelAndView editUser(@RequestParam int id){
	 System.out.println("hello .....................................");	
	 Login ld=us.get(id);
	 System.out.println("hiii............");
		return new ModelAndView("edituser","Login",ld);
	}
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
    public ModelAndView updateuser(HttpServletRequest request,@Valid @ModelAttribute("Login")Login login,BindingResult result)
    {
		us.update(login);
    	return new ModelAndView("edituser");
    }
	@RequestMapping("/displayuser")
	public ModelAndView displayuser()
	{  
		ModelAndView u3=new ModelAndView("displayuser");
		return u3;
	} 
}
