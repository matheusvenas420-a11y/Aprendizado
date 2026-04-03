package com.mycompany.aprendizado.test;

import com.mycompany.aprendizado.util.ConexaoBD;
import java.sql.Connection;

public class TesteConexaoBD {
    public static void main(String[] args) {
        Connection conn = ConexaoBD.conectar();
        
        if(conn != null){
            System.out.println("Conexao feita!");
        }else{
            System.out.println("Erro!");
        }
    }
}

