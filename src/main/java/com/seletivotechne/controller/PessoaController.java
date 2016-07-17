package com.seletivotechne.controller;

import com.seletivotechne.dao.PessoaDao;
import com.seletivotechne.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author andre ulisses
 */
@Path("pessoa")
public class PessoaController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Pessoa> listPessoas() {

        PessoaDao pessoaDao = new PessoaDao();
        return pessoaDao.getAll();
        
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Pessoa getPessoas(@PathParam("id") Integer id) {

        PessoaDao pessoaDao = new PessoaDao();
        return pessoaDao.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response createPessoa(Pessoa pessoa) {
        
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.save(pessoa);
        
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response updatePessoa(Pessoa pessoa) {
        
        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.save(pessoa);

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response deletePessoa(@PathParam("id") Integer id) {

        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.delete(pessoaDao.getById(id));
        
        return Response.status(Response.Status.OK).build();
    }

}
