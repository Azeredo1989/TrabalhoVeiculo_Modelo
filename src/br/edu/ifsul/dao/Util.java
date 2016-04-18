/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

/**
 *
 * @author Ander
 */
public class Util {
    public static String trataErro(Exception e){
        String retorno = "";
        while (e.getCause() != null){
            e = (Exception) e.getCause();
        }
        retorno = e.getMessage();
        if (retorno.contains("viola restrição de chave estrangeira")){
            retorno = "Registro não pode ser excluido pois possui referencias em outros locais";
        }
        return retorno;
        
    }
}
