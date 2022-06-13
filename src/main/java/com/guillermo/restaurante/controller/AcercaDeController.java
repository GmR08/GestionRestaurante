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
package com.guillermo.restaurante.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class AcercaDeController implements Initializable {

    @FXML
    private Label labAutor;
    @FXML
    private Label labEdicion;
    @FXML
    private Label labYear;
    @FXML
    private Button salirBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Properties configuracion = new Properties();
        try {
            configuracion.load(new FileInputStream("./datos/configuracion.props"));
            String autor = configuracion.getProperty("Autor");
            String edicion = configuracion.getProperty("Edicion");
            String year = configuracion.getProperty("Curso");

            labAutor.setText(autor);
            labEdicion.setText(edicion);
            labYear.setText(year);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void salirBtnClick(ActionEvent event) {
        Stage stage = (Stage) salirBtn.getScene().getWindow();
        stage.close();
    }

}
