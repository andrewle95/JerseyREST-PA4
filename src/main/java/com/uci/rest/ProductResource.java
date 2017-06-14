package com.uci.rest;

import com.uci.rest.model.Product;
import com.uci.rest.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductResource {
	//This method represents an endpoint with the URL /todos/{id} and a GET request ( Note that {id} is a placeholder for a path parameter)
    @Path("{id}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getProductById(@PathParam("id") int id/* The {id} placeholder parameter is resolved */) {
        //invokes the DB method which will fetch a todo_list item object by id
        Product product = ProductService.getProductById(id);

        //Respond with a 404 if there is no such todo_list item for the id provided
        if(product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a todo_list_item object to return as response
        return Response.ok(product).build();
    }

    //This method represents an endpoint with the URL /todos and a GET request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a GET request will invoke this method.
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getAllTodos() {
        List<Product> productList = ProductService.getAllProducts();

        if(productList == null || productList.isEmpty()) {

        }

        return Response.ok(productList).build();
    }

}
