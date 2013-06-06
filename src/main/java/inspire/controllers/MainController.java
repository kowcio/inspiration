package inspire.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Main controller.
 * @author TalentLab1
 *
 */

@Controller
public class MainController {

	//test 4 nte template
	
	
	
	
	
	
/**
 * Intercept URL for loggin part in spring security		<br /> 
 * value={"/login","/logout","/loginFAIL"}				<br />
 * basic url after login is the login requested 		<br />
 * @param mav
 * @return
 */
	@RequestMapping(value={"/login","/logout","/loginFAIL"},method= RequestMethod.GET)
	public ModelAndView indexWithLoginFormn(ModelAndView mav) 
	{	//maybe add a msg for each url 
		mav.setViewName("index");
		return mav;
	}

	
	/**
	 * 	MAIN INDEX OF THE SITE 
	 * 
	 * @param user - form from spring security 
	 * @param principal -  form from spring security
	 * @param result 
	 * @param mav 
	 * @return View of the main site.
	 */
	@RequestMapping(value="/",method= RequestMethod.GET)
	public ModelAndView indexWithoutLogin(
 			ModelAndView mav
			)
	{
			      mav.setViewName("index");
	    
	     	return mav;
	} // end main index
	

	
	
	
	

	}
	
	
