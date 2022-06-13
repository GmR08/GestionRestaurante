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

import com.guillermo.restaurante.model.POJO.Plato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class PlatoDAO implements IOperationCRUD<Plato> {

    private Connection conn = ConexionDAO.getConnection();

    @Override
    public List<Plato> getAll() {
        List<Plato> lista = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM plato";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int idAux = rs.getInt("id");
                String nombreAux = rs.getString("nombre");
                float caloriasAux = rs.getFloat("calorias");
                float precioAux = rs.getFloat("precio");

                Plato a = new Plato(idAux, nombreAux, caloriasAux, precioAux);
                
                lista.add(a);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Plato findById(Plato object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int add(Plato object) {
        String sql = "INSERT INTO plato(nombre,calorias,precio) VALUES (?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getNombre());
            ps.setFloat(2, object.getCalorias());
            ps.setFloat(3, object.getPrecio());
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public int update(Plato object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Plato object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int deleteAll() {
        String sql = "DELETE FROM plato;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (SQLException e) {
            return -1;
        }
    }

}
