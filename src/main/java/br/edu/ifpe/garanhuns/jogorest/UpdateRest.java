/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.jogorest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


/**
 *
 * @author João Witor
 */

@Path("jogo")
public class UpdateRest  {
    
    Update upd = new Update();
    
    @GET
    @Path("jogar")
    public String jogar(@QueryParam("jogada") String jogada){
        return upd.jogar(jogada);
    }
    
    @GET
    @Path("resetar")
    public String resetar(){
        return upd.resetarJogo();
    }
    
    @GET
    @Path("verificar")
    public String verificarVencedor(){
        return upd.verificarVencedor();
    }
}
