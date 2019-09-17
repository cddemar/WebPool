/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Dependencies
 */
import com.google.gson.Gson;
import com.mycompany.models.Response;
import com.mycompany.models.ServerAddress;

/**
 *
 * @author user
 */
@Path("files")
public class FileController 
{
    private final Gson gson;
    
    public FileController() {
        this.gson = new Gson();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listAllFiles() throws UnknownHostException{
        ServerAddress serverAddress = new ServerAddress(InetAddress.getLocalHost().getHostAddress());
        return gson.toJson(new Response(true, "", this.gson.toJson(serverAddress)));
    }
}
