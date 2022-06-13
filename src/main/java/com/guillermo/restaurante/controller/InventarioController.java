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

import com.guillermo.restaurante.model.BLL.FactoriaBLL;
import com.guillermo.restaurante.model.POJO.Plato;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class InventarioController implements Initializable {

    @FXML
    private Button cargarPlatosBtn;
    @FXML
    private Button generarMenuBtn;
    @FXML
    private Button salirBtn;
    @FXML
    private TableView tablaInventario;
    @FXML
    private TableColumn nombre;
    @FXML
    private TableColumn calorias;
    @FXML
    private TableColumn precio;

    private ObservableList<Plato> listaPlatosObs
            = FXCollections.observableArrayList();

    File platos = new File("./datos/platos.txt");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaPlatosObs.clear();
        FactoriaBLL.getPlatoBLL().limpiarPlatos();
    }

    @FXML
    private void cargarPlatosBtnClick(ActionEvent event) throws IOException {
        FactoriaBLL.getPlatoBLL().cargarPlatos(platos);

        List<Plato> platos = FactoriaBLL.getPlatoBLL().obtenerPlatos();

        listaPlatosObs.addAll(platos);

        nombre.setCellValueFactory(new PropertyValueFactory<Plato, Integer>("nombre"));
        calorias.setCellValueFactory(new PropertyValueFactory<Plato, Float>("calorias"));
        precio.setCellValueFactory(new PropertyValueFactory<Plato, Float>("precio"));

        tablaInventario.setItems(listaPlatosObs);
    }

    @FXML
    private void generarMenuBtnClick(ActionEvent event) {
        
    }

    @FXML
    private void salirBtnClick(ActionEvent event) {
        Stage stage = (Stage) salirBtn.getScene().getWindow();
        stage.close();
    }

}
