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

/**
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class FactoriaBLL {

    private static TrabajadorBLL trabajadorBLL = null;
    private static PlatoBLL platoBLL = null;
    private static EstablecimientoBLL establecimientoBLL = null;

    public static TrabajadorBLL getTrabajadorBLL() {
        if (trabajadorBLL == null) {
            trabajadorBLL = new TrabajadorBLL();
        }
        return trabajadorBLL;
    }

    public static PlatoBLL getPlatoBLL() {
        if (platoBLL == null) {
            platoBLL = new PlatoBLL();
        }
        return platoBLL;
    }

    public static EstablecimientoBLL getEstablecimientoBLL() {
        if (establecimientoBLL == null) {
            establecimientoBLL = new EstablecimientoBLL();
        }
        return establecimientoBLL;
    }

}
