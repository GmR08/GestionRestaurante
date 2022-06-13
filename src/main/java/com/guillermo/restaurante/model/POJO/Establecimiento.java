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

package com.guillermo.restaurante.model.POJO;

import java.util.ArrayList;


/**
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */

public class Establecimiento {
    private int id;
    private String nombre;
    private String localidad;
    private ArrayList<Trabajador> trabajadores;

    public Establecimiento() {
    }

    public Establecimiento(int id, String nombre, String localidad, 
            ArrayList<Trabajador> trabajadores) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.trabajadores = trabajadores;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Establecimiento{" + "id=" + id + ", nombre=" + nombre + 
                ", localidad=" + localidad + ", trabajadores=" + trabajadores + 
                '}';
    }
    
}
