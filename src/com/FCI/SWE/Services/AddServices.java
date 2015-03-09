package com.FCI.SWE.Services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.FCI.SWE.Models.User;
import com.FCI.SWE.ServicesModels.RequestEntity;
import com.FCI.SWE.ServicesModels.UserEntity;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class AddServices {

	@POST
	@Path("/addFriendService")
	public String addFriend(@FormParam("uname") String send_name,@FormParam("uname2") String rec_name) {
		
        JSONObject json = new JSONObject();
        UserEntity userEntity = UserEntity.getUser(send_name);
        UserEntity userEntity2 = UserEntity.getUser(rec_name);
        
        if (userEntity==null && userEntity2==null) {
			json.put("Status", "Failed");
		}
		else {
			json.put("Status", "OK");
			RequestEntity requestEntity = new RequestEntity
					(send_name,userEntity.getId(),rec_name,userEntity2.getId(),"pinding");
			requestEntity.saveRequest();
		}
		
			return json.toString();
	
	
	}
		
	

}