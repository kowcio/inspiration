package inspire.controllers;

import inspire.daos.MotivatorDAO;
import inspire.entities.Motivator;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Main controller.
 * @author TalentLab1
 *
 */

@Controller
public class AjaxMotivatorController {


/**
 * Load random motivator
 * http://adrianmejia.com/blog/2012/04/27/spring-mvc-3-plus-ajax-getjson-and-solving-406-not-accepted/
 */
	@RequestMapping(value="/getMotivator",method= RequestMethod.GET)
	@ResponseBody
	public Motivator indexWithoutLogin(
 			MotivatorDAO mdao,
 			Motivator loadedMot
			)
	{
		Random rand = new Random();
		int randomInt = mdao.getMotivatorsNumberInDBThatAreDisplayed(1);
		System.out.println("Number of motivators  - " +randomInt);
		randomInt = rand.nextInt( randomInt);
		System.out.println("Motivator number =  "+randomInt);
		
		if (randomInt ==0) randomInt=1;
		
		List<Motivator> ml = new ArrayList();		
		ml = mdao.getDisplayedMotivators();
		loadedMot = ml.get(randomInt);
		

		
		System.out.println(" linkType = "+loadedMot.getLinkType());
		System.out.println(" url = "+loadedMot.getUrl());
		return loadedMot;
}
	
	
	/**
	 * Load random motivator
	 * http://adrianmejia.com/blog/2012/04/27/spring-mvc-3-plus-ajax-getjson-and-solving-406-not-accepted/
	 */
		@RequestMapping(value="/addUrl/{url}",method= RequestMethod.POST)
		@ResponseBody
		public boolean loadQuote(
	 			MotivatorDAO mdao,
	 			Motivator motToSave,
	 			@PathVariable("url") String urlsimple,
				@RequestParam("json") String jsurl
				)
		{
			System.out.println("JSon URL = "+jsurl);
			System.out.println("Url for req = "+jsurl);
			String url = jsurl.replace("hereIsSlash", "/");
			System.out.println("Url = "+url);
			
			System.out.println(motToSave.toString());

			if (url.contains("youtube.com")) 	{
				motToSave.setLinkType("yt");	
				String id = "brak";
				String pattern = "(?<=\\?v=)([a-zA-Z0-9_-]+)";
				Matcher m = Pattern.compile(pattern).matcher(url);
				if (m.find()) System.out.print("znaleziono_id= = "+m.group(1)+" \n ");
					id = m.group(1);
					motToSave.setUrl("http://www.youtube.com/embed/"+id);
					System.out.println(motToSave.toString());

				}
			//check extensions for images 
			else if (  	
			//Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|tiff|jpeg))$)").matcher(url)!=null
					url.contains(".jpg")||
					url.contains(".bmp")||
					url.contains(".jpeg")||
					url.contains(".png")||
					url.contains(".gif")
			) 
			{	
				motToSave.setLinkType("img");	
				motToSave.setUrl(url);

				System.out.println(motToSave.toString());

				}
			else {
				motToSave.setLinkType("quote");		
				motToSave.setUrl(url);

				System.out.println(motToSave.toString());

				}
			
			mdao.saveMotivator(motToSave);
			
			
			return true;
			
	}

	
	
	
	

	}
	
	
