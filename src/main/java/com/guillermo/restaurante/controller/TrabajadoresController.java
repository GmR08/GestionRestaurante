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
import com.guillermo.restaurante.model.POJO.Trabajador;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class TrabajadoresController implements Initializable {

    @FXML
    private TableView tablaEmpleados;
    @FXML
    private TableColumn nombre;
    @FXML
    private TableColumn apellidos;
    @FXML
    private TableColumn dni;
    @FXML
    private TableColumn telefono;
    @FXML
    private TableColumn usuario;
    @FXML
    private Button salirBtn;
    @FXML
    private Button cargarEmpleadosBtn;
    @FXML
    private Button modificarEmpleadoBtn;
    @FXML
    private Button borrarEmpleadosBtn;
    @FXML
    private Button guardarEmpleadosBtn;

    private ObservableList<Trabajador> listaTrabajadoresObs
            = FXCollections.observableArrayList();

    File trabajadores = new File("./datos/trabajadores.txt");
    @FXML
    private TextField introducirNombre;
    @FXML
    private TextField introducirApellidos;
    @FXML
    private TextField introducirTelefono;
    @FXML
    private TextField introducirDni;
    @FXML
    private TextField introducirUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Limpiamos las listas y la BD a modo de prueba, en una logica de
        //negocio real no tendríamos esta práctica
        
        listaTrabajadoresObs.clear();
        FactoriaBLL.getTrabajadorBLL().eliminarEmpleados();

    }

    @FXML
    private void salirBtnClick(ActionEvent event) {
        Stage stage = (Stage) salirBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cargarEmpleadosBtnClick(ActionEvent event) throws IOException {
        FactoriaBLL.getTrabajadorBLL().cargarEmpleados(trabajadores);

        List<Trabajador> empleados = FactoriaBLL.getTrabajadorBLL().obtenerEmpleados();

        listaTrabajadoresObs.addAll(empleados);

        nombre.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("nombre"));
        apellidos.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("apellidos"));
        dni.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("dni"));
        telefono.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("telefono"));
        usuario.setCellValueFactory(new PropertyValueFactory<Trabajador, String>("usuario"));

        tablaEmpleados.setItems(listaTrabajadoresObs);
    }

    @FXML
    private void modificarEmpleadoBtnClick(ActionEvent event) {
        Trabajador modificable = new Trabajador(0, 
                introducirNombre.getText(), introducirApellidos.getText(), 
                introducirDni.getText(), introducirTelefono.getText(), 
                introducirUsuario.getText(), "");
        
        FactoriaBLL.getTrabajadorBLL().modificarEmpleado(modificable);
        listaTrabajadoresObs.clear();
        
        listaTrabajadoresObs.addAll(FactoriaBLL.getTrabajadorBLL().
                obtenerEmpleados());
        
        tablaEmpleados.setItems(listaTrabajadoresObs);
    }

    @FXML
    private void borrarEmpleadosBtnClick(ActionEvent event) {
        FactoriaBLL.getTrabajadorBLL().eliminarEmpleados();
        listaTrabajadoresObs.clear();
        
        tablaEmpleados.setItems(listaTrabajadoresObs);
    }

    @FXML
    private void guardarEmpleadosBtnClick(ActionEvent event) {
        FactoriaBLL.getTrabajadorBLL().guardarEmpleados(listaTrabajadoresObs,
                trabajadores);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, "Datos guardados"
                + " correctamente.");
        alerta.show();
    }

}
