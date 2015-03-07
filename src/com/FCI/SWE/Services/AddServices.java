package com.FCI.SWE.Services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.UserEntity;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class AddServices {

	@POST
	@Path("/addFriendService")
	public String addFriend(@FormParam("name") String name) {
		
		UserEntity userEntity = new UserEntity(null);
        JSONObject json = new JSONObject();
		ArrayList<UserEntity> Matches= userEntity.getUser(name);
		if (Matches.size() == 0) {
			json.put("Status", "Failed");
		}
		else {
			
		
			json.put("Status", "OK");
			for(int i=0; i<Matches.size(); i++){
				json.put("Name"+i,Matches.get(i).getName());
			}
		}
		
			return json.toString();
	
	
	}

}