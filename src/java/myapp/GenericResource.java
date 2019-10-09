/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * REST Web Service
 *
 * @author 1894219
 */
@Path("mobile")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of myapp.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @GET
    @Path("shapesList")
    @Produces(MediaType.TEXT_PLAIN)
    public String getShapesList() {
        //TODO return proper representation object
        
        JSONArray mainArray = new JSONArray();
        JSONObject singleObject = new JSONObject();
        
        singleObject.accumulate("name", "Triangle");
        singleObject.accumulate("NumberofParam", 2);
        mainArray.add(singleObject);
        singleObject.clear();
        singleObject.accumulate("name", "Square");
        singleObject.accumulate("NumberofParam", 1);
        mainArray.add(singleObject);
        singleObject.clear();
        singleObject.accumulate("name", "Rectangle");
        singleObject.accumulate("NumberofParam", 2);
        mainArray.add(singleObject);
        singleObject.clear();
        singleObject.accumulate("name", "Parallelogram");
        singleObject.accumulate("NumberofParam", 2);
        mainArray.add(singleObject);
        singleObject.clear();
        singleObject.accumulate("name", "Trapezoid");
        singleObject.accumulate("NumberofParam", 3);
        mainArray.add(singleObject);
        singleObject.clear();
        singleObject.accumulate("name", "Circle");
        singleObject.accumulate("NumberofParam", 1);
        mainArray.add(singleObject);
        singleObject.clear();
        singleObject.accumulate("name", "Ellipse");
        singleObject.accumulate("NumberofParam", 2);
        mainArray.add(singleObject);
        singleObject.clear();
        singleObject.accumulate("name", "Sector");
        singleObject.accumulate("NumberofParam", 2);
        mainArray.add(singleObject);
        singleObject.clear();
        
        
        return mainArray.toString();
        
    }
    
    @GET
    @Path("shapesThree&{nameofshape}&{base1}&{base2}&{height}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getShapesThree(@PathParam("nameofshape")String nameofshape,@PathParam("base1")double base1,@PathParam("base2")double base2,@PathParam("height")double height) {
    
        JSONObject mainObject = new JSONObject();
        Date date = new Date();
        long time = date.getTime();
        
        if(nameofshape.equalsIgnoreCase("TRAPEZOID")){
           
            mainObject.accumulate("Status", "OK");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Base1", base1);
            mainObject.accumulate("Base2", base2);
            mainObject.accumulate("Height", height);

            double area = 0.5 * (base1 + base2) * height;

            mainObject.accumulate("area", area);
        
        }else{
        
            mainObject.accumulate("Status", "ERROR");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Message", "Not the good shape");
            
        }
        
        return mainObject.toString();
    }
    
    @GET
    @Path("shapesOne&{nameofshape}&{radius}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getShapesOne(@PathParam("nameofshape")String nameofshape,@PathParam("radius")double radius) {
    
        JSONObject mainObject = new JSONObject();
        Date date = new Date();
        long time = date.getTime();
        
        if(nameofshape.equalsIgnoreCase("CIRCLE")){
           
            mainObject.accumulate("Status", "OK");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("radius", radius);

            double area = 3.14 * radius * radius;

            mainObject.accumulate("area", area);
        
        }else if(nameofshape.equalsIgnoreCase("SQUARE")){
           
            mainObject.accumulate("Status", "OK");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("length", radius);

            double area = radius * radius;

            mainObject.accumulate("area", area);
        
        }else{
        
            mainObject.accumulate("Status", "ERROR");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Message", "Not the good shape");
            
        }
        
        return mainObject.toString();
    }
    
    @GET
    @Path("shapesTwo&{nameofshape}&{width}&{height}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getShapesTwo(@PathParam("nameofshape")String nameofshape,@PathParam("width")double width,@PathParam("height")double height) {
    
        JSONObject mainObject = new JSONObject();
        Date date = new Date();
        long time = date.getTime();
        
        if(nameofshape.equalsIgnoreCase("TRIANGLE")){
           
            mainObject.accumulate("Status", "OK");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Base", width);
            mainObject.accumulate("Height", height);

            double area = 0.5 * width * height;

            mainObject.accumulate("area", area);
        
        }else if(nameofshape.equalsIgnoreCase("RECTANGLE")){
           
            mainObject.accumulate("Status", "OK");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Width", width);
            mainObject.accumulate("Height", height);

            double area = width * height;

            mainObject.accumulate("area", area);
        
        }else if(nameofshape.equalsIgnoreCase("PARALLELOGRAM")){
           
            mainObject.accumulate("Status", "OK");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Base", width);
            mainObject.accumulate("Height", height);

            double area = width * height;

            mainObject.accumulate("area", area);
        
        }else if(nameofshape.equalsIgnoreCase("ELLIPSE")){
           
            mainObject.accumulate("Status", "OK");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Axis(A)", width);
            mainObject.accumulate("Axis(B)", height);

            double area = 3.14 * width * height;

            mainObject.accumulate("area", area);
        
        }else if(nameofshape.equalsIgnoreCase("SECTOR")){
           
            mainObject.accumulate("Status", "OK");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Radius", width);
            mainObject.accumulate("Angle", height);

            double area = 0.5 * width * width * height;

            mainObject.accumulate("area", area);
        
        }else{
        
            mainObject.accumulate("Status", "ERROR");
            mainObject.accumulate("Timestamp", time);
            mainObject.accumulate("Shape", nameofshape.toUpperCase());
            mainObject.accumulate("Message", "Not the good shape");
            
        }
        
        return mainObject.toString();
    }
}
