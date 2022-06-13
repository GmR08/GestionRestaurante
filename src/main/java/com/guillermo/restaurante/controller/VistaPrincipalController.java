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

import com.guillermo.restaurante.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class VistaPrincipalController implements Initializable {

    @FXML
    private Button salirBtn;
    @FXML
    private Button iniciarSesionBtn;
    @FXML
    private Button acercaDeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void salirBtnClick(ActionEvent event) {
        Stage stage = (Stage) salirBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void iniciarSesionBtnClick(ActionEvent event) throws IOException {
        App.swapScene(new Stage(), "loginview");
    }

    @FXML
    private void acercaDeBtnClick(ActionEvent event) throws IOException {
        App.swapScene(new Stage(), "acercadeview");

    }

}
