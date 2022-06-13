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

import com.guillermo.restaurante.model.POJO.Trabajador;
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
public class TrabajadorDAO implements IOperationCRUD<Trabajador> {

    private Connection conn = ConexionDAO.getConnection();

    @Override
    public List<Trabajador> getAll() {
        List<Trabajador> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM trabajador";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int idAux = rs.getInt("id");
                String nombreAux = rs.getString("nombre");
                String apellidosAux = rs.getString("apellidos");
                String dniAux = rs.getString("dni");
                String telefonoAux = rs.getString("telefono");
                String usuarioAux = rs.getString("usuario");
                String passwordAux = rs.getString("password");

                Trabajador a = new Trabajador(idAux, nombreAux, apellidosAux,
                        dniAux, telefonoAux, usuarioAux, passwordAux);

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
    public Trabajador findById(Trabajador object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int add(Trabajador object) {
        String sql = "INSERT INTO trabajador(nombre,apellidos,dni,telefono,"
                + "usuario,password) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getNombre());
            ps.setString(2, object.getApellidos());
            ps.setString(3, object.getDni());
            ps.setString(4, object.getTelefono());
            ps.setString(5, object.getUsuario());
            ps.setString(6, object.getPassword());

            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (SQLException e) {
            return -1;
        }
    }

    @Override
    public int update(Trabajador object) {
        String sql = "UPDATE trabajador SET nombre=?, apellidos=?, telefono=?, "
                + "usuario=? WHERE dni=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getNombre());
            ps.setString(2, object.getApellidos());
            ps.setString(3, object.getTelefono());
            ps.setString(4, object.getUsuario());
            ps.setString(5, object.getDni());
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Trabajador object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Trabajador loginDAO(Trabajador aux) {
        Trabajador a = null;
        String sql = "select * from trabajador where usuario = ? and password = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aux.getUsuario());
            ps.setString(2, aux.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");

                a = new Trabajador(id, nombre, apellidos, dni, telefono,
                        usuario, password);

            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public int deleteAll() {
        String sql = "DELETE FROM trabajador;";
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
