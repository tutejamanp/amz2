package ooad.amazon.com.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import ooad.amazon.com.bean.Customer;
import ooad.amazon.com.bean.Product;
import ooad.amazon.com.bean.User;
import ooad.amazon.com.dao.CustomerDAO;
import ooad.amazon.com.dao.ProductDAO;
import ooad.amazon.com.dao.UserDAO;

@Path("/UserController")
public class UserController {
	
	@POST 
	@Path("/checkLogin")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLogin(
			@FormDataParam("email") String username,
			@FormDataParam("password1") String password){
		
 		System.out.println(username + " " + password);
		 List<Customer> resp = UserDAO.CheckLogin(username, password);
		 System.out.println("resp is "+resp);
		 if(!(resp == null))
		 {
			 GenericEntity<List<Customer>> cust  = new GenericEntity<List<Customer>>(resp){};
			 System.out.println("wassup 9090" + cust.toString());
			 return Response.status(200).entity(cust).build();			 
		 }
		 else
		 {
			 String result = "Customer not found";
			 return Response.status(404).entity(result).build();
		 }
		
	}
	
	@POST 
	@Path("/saveuser")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response registercus(
			@FormParam("fullname") String fname,
			@FormParam("email") String email,@FormParam("phonenumber") String phone,@FormParam("password1") String password){
		
 		System.out.println("wassup1");
		
		
		Customer cus = new Customer();
		cus.setFname(fname);
		cus.setEmailid(email);
		cus.setContact_no(phone);
		cus.setPassword(password);
		 int resp = CustomerDAO.registercustomer(cus);
			System.out.println("wassup2");

		 if(resp >0)
		 {
			 String result = resp+"";
			 return Response.status(201).entity(result).build();
		 }
		 else
		 {
			 String result = resp+"";
			 return Response.status(404).entity(result).build();
		 }
		
	}
	
	@Path("/customerdetails/{email}")
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	    public Response getProducts(@PathParam("email") String email) {

		 GenericEntity<Customer> customer;
	
		 customer  = new GenericEntity<Customer>(CustomerDAO.getcustomerbyemailid(email)) { };
		 return Response.ok(customer).build();
		 
	    }
	
	
	
	
	
	
	
}
