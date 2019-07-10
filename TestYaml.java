package Hris;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;
//import com.mms.mja.blog.demo.yaml.User;

public class TestYaml 
{



	TimesheetAction login;
	 @BeforeClass
	  public void beforeClass()
	 {
			login=new TimesheetAction();
			login.initialiseWebDriver();
			login.LaunchUrl();
			
	  }
	 
	 @Test
	  public void f() throws InterruptedException {
		 

			final String fileName = "YmlLoginTest.yml";
		    ArrayList<String> key = new ArrayList<String>();
		    ArrayList<String> value = new ArrayList<String>();
		    Yaml yaml = new Yaml();

		   try
		   
		   {
			  
		   
		        InputStream ios = new FileInputStream(new File(fileName));

		        Map< String, Object> result = (Map< String, Object>) yaml.load(ios);
		       // for (Object name : result.keySet()) 
		       // { 
		        	//Object name=result.keySet();
		       //     key.add(name.toString());
		           //
		        //}
		        String u_name= result.get("username").toString();
		        String pa_ss= result.get("pass").toString();

		       // System.out.println(result.get("pass"));

		        
		    	
		 //   System.out.println(key + " " + value);
		    
		 	login.inputUserName(u_name);
		 	login.inputPassword(pa_ss);
		 	login.clickOnLoginButton();
		 	login.extractWorkHours();
		   }catch (Exception e) {
		        e.printStackTrace();
		    } 
}
}
