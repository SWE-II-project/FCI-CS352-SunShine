package com.FCI.SWE.Services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.RequestEntity;
import com.FCI.SWE.ServicesModels.UserEntity;


public class SearchService {


	@POST
	@Path("/SearchService")
	public String search(@FormParam("uname") String name)
	 {
		
       
        UserEntity userEntity = new UserEntity("","","");
        ArrayList<UserEntity> matches = userEntity.getUsers(name);
        
        JSONArray returnedjson=new JSONArray();
        
		
			
			
			for(int i=0;i<matches.size();i++)
			{
				JSONObject json = new JSONObject();
				json.put("id", matches.get(i).getId());
				json.put("name", matches.get(i).getName());
				json.put("email", matches.get(i).getEmail());
				returnedjson.add(json);
				
			}
		
		
			return returnedjson.toString();
	
	
	}
		
	


	
}
