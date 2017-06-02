package com.ttn.aem.mockito.demo.servlets;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.jcr.api.SlingRepository;

import java.io.IOException;
import java.rmi.ServerException;

/**
 * Created by ttn on 31/5/17.
 */
@SlingServlet(paths="/bin/mySearchServlet", methods = "POST", metatype=true)
public class ExampleServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
    private static final long serialVersionUID = 2598426539166789515L;

    @Override
    public void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {

        try
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");

            //Encode the submitted form data to JSON
            JSONObject obj=new JSONObject();

            obj.put("firstname",firstName);
            obj.put("lastname",lastName);
            obj.put("address",address);

            //Return the JSON formatted data
            if(obj != null && obj.length()>0) {
                response.setContentType("application/json");
                response.getWriter().write(obj.toString());
            }
        }
        catch(Exception e)
        {
            response.getWriter().write("Exception Occured");
        }
    }
}