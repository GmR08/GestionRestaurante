/*
 * Copyright 2022 Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guillermo.restaurante.model.DAO;


/**
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */


import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionDAO {
    private final String USER = "DAW";
    private final String PASSWORD = "admin";
    private final String URL = 
            "jdbc:mysql://localhost:3306/restaurante";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection conexion = null;
    
    // Cambio la visibilidad para controlar la construccion
    private ConexionDAO(){

        try{
            // Carga del driver
            Class.forName(DRIVER);
            // Establecer la conexión con la BD
            conexion = 
                    DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Mi propio constructor
    public static Connection getConnection() {
        if(conexion == null){
            new ConexionDAO();
        }
        return conexion;

    }
    
    public static void closeConnection(){
        try{
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
