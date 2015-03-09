package com.FCI.SWE.Services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;





import com.FCI.SWE.ServicesModels.RequestEntity;
import com.FCI.SWE.ServicesModels.UserEntity;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class AcceptServices {

	@POST
	@Path("/acceptFriendService")
	public String acceptFriend(@FormParam("uname") String send_name,@FormParam("uname2") String rec_name) {
		
		RequestEntity request=new RequestEntity(send_name,rec_name);
        JSONObject json = new JSONObject();
		
		if (!request.getRequest(send_name, rec_name)) {
			json.put("Status", "Failed");
		}
		else {
			
		
			json.put("Status", "OK");
			
		}
		
			return json.toString();
	
	
	}

}