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
package com.guillermo.restaurante.model.BLL;

import com.guillermo.restaurante.model.DAO.TrabajadorDAO;
import com.guillermo.restaurante.model.POJO.Trabajador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class TrabajadorBLL {

    private TrabajadorDAO trabajadorDAO = new TrabajadorDAO();

    public Trabajador loginBLL(Trabajador aux) {
        return trabajadorDAO.loginDAO(aux);
    }

    public List<Trabajador> obtenerEmpleados() {
        return trabajadorDAO.getAll();
    }

    public int eliminarEmpleados() {
        return trabajadorDAO.deleteAll();
    }

    public void cargarEmpleados(File trabajadores) throws IOException,
            FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(trabajadores));

        String texto = "";

        while ((texto = br.readLine()) != null) {
            String[] datos = texto.split(";", -1);
            String nombre = datos[0];
            String apellidos = datos[1];
            String dni = datos[2];
            String telefono = datos[3];
            String ususario = datos[4];
            String password = datos[5];

            Trabajador aux = new Trabajador(0, nombre, apellidos, dni,
                    telefono, ususario, password);

            trabajadorDAO.add(aux);
        }

        br.close();
    }

    public void modificarEmpleado(Trabajador trabajador) {
        trabajadorDAO.update(trabajador);
    }

    public void guardarEmpleados(List<Trabajador> empleados, File archivo) {
        try {
            PrintWriter escribir = new PrintWriter(archivo);
            for (Trabajador trabajador : empleados) {
                escribir.println(trabajador.aFichero());
            }
            escribir.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int agregarEmpleado(Trabajador trabajador) {
        return trabajadorDAO.add(trabajador);
    }
}
