/*package com.FCI.SWE.Services;

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
public class RequestServices {

	@POST
	@Path("/getRequestService")
	public String getRequest(@FormParam("id") long id) {
		
		RequestEntity requestEntity = new RequestEntity(null);
        JSONObject json = new JSONObject();
		ArrayList<RequestEntity> Request= RequestEntity.getRequest(id);
		if (Request.size() == 0) {
			json.put("Status", "Failed");
		}
		else {
			
		
			json.put("Status", "OK");
			for(int i=0; i<Request.size(); i++){
				json.put("Name"+i, Request.get(i).getsendName());
			}
		}
		
			return json.toString();
	
	
	}

}*/