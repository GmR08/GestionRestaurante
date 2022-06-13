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

import com.guillermo.restaurante.model.DAO.FactoriaDAO;
import com.guillermo.restaurante.model.DAO.PlatoDAO;
import com.guillermo.restaurante.model.POJO.Plato;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class PlatoBLL {

    private PlatoDAO platoDAO = FactoriaDAO.getPlatoDAO();

    public void cargarPlatos(File platos) throws FileNotFoundException,
            IOException {
        BufferedReader br = new BufferedReader(new FileReader(platos));

        String texto = "";

        while ((texto = br.readLine()) != null) {
            String[] datos = texto.split(";", -1);
            String nombre = datos[0];
            String calorias = datos[1];
            String precio = datos[2];

            Plato aux = new Plato(0, nombre, Float.valueOf(calorias),
                    Float.valueOf(precio));

            platoDAO.add(aux);
        }
        
        br.close();
    }

    public List<Plato> obtenerPlatos() {
        return platoDAO.getAll();
    }

    public int limpiarPlatos() {
        return platoDAO.deleteAll();
    }

}
