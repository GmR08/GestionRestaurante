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

public class FactoriaDAO {

    private static TrabajadorDAO trabajadorDAO = null;
    private static PlatoDAO platoDAO = null;
    private static EstablecimientoDAO establecimientoDAO = null;

    public static TrabajadorDAO getTrabajadorDAO() {
        if (trabajadorDAO == null) {
            trabajadorDAO = new TrabajadorDAO();
        }
        return trabajadorDAO;
    }

    public static PlatoDAO getPlatoDAO() {
        if (platoDAO == null) {
            platoDAO = new PlatoDAO();
        }
        return platoDAO;
    }

    public static EstablecimientoDAO getEstablecimientoDAO() {
        if (establecimientoDAO == null) {
            establecimientoDAO = new EstablecimientoDAO();
        }
        return establecimientoDAO;
    }
}
