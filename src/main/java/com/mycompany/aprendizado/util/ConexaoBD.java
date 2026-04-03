package com.mycompany.aprendizado.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static final String URL = "jdbc:mariadb://localhost:3306/teste";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    public static Connection conectar(){
        try{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(SQLException e){
            System.out.println("Falha!" + e.getMessage());
            return null;
        }
    }
}
