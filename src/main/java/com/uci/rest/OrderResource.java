package com.uci.rest;

import com.uci.rest.model.Order;
import com.uci.rest.service.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/orders")
public class OrderResource {
    //This method represents an endpoint with the URL /todos/{id} and a GET request ( Note that {id} is a placeholder for a path parameter)
    @Path("{id}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getTodoById(@PathParam("id") int id/* The {id} placeholder parameter is resolved */) {
        //invokes the DB method which will fetch a todo_list item object by id
        Order order = OrderService.getOrderById(id);

        //Respond with a 404 if there is no such todo_list item for the id provided
        if(order == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a todo_list_item object to return as response
        return Response.ok(order).build();
    }

    //This method represents an endpoint with the URL /todos and a POST request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a POST request will invoke this method.
    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //This method accepts a request of the JSON type
    public Response addOrder(Order order) {

        //The todo object here is automatically constructed from the json request. Jersey is so cool!
        if(OrderService.AddOrder(order)) {
            return Response.ok().entity("Order Added Successfully").build();
        }

        // Return an Internal Server error because something wrong happened. This should never be executed
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //Similar to the method above.
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED}) //This method accepts form parameters.
    //If you were to send a POST through a form submit, this method would be called.
    public Response addTodo(@FormParam("firstName") String firstName,
                            @FormParam("lastName") String lastName,
                            @FormParam("phoneNumber") String phoneNumber,
                            @FormParam("streetAddress") String streetAddress,
                            @FormParam("city") String city,
                            @FormParam("state") String state,
                            @FormParam("90032") String zipCode,
                            @FormParam("creditCardNumber") String creditCardNumber,
                            @FormParam("shippingMethod") String shippingMethod){
                            //NEED TO WORK ON THIS @FormParam("items") String items) {
        Order order = new Order();
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setPhoneNumber(phoneNumber);
        order.setStreetAddress(streetAddress);
        order.setCity(city);
        order.setState(state);
        order.setZipCode(zipCode);
        order.setCreditCardNumber(creditCardNumber);
        order.setShippingMethod(shippingMethod);

        System.out.println(order);

        if(OrderService.AddOrder(order)) {
            return Response.ok().entity("Order Added Successfully").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

}
