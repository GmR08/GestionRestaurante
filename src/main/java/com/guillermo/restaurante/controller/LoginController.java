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
import com.guillermo.restaurante.model.BLL.FactoriaBLL;
import com.guillermo.restaurante.model.POJO.Trabajador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Guillermo Martínez Rosado - guillermo.martinez.alum@iescamp.es
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userNameTexfield;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button loginBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FactoriaBLL.getTrabajadorBLL().agregarEmpleado(new Trabajador(0, 
                "", "", "", "", "admin", "12345"));
        userNameTexfield.requestFocus();
    }

    @FXML
    private void cancelBtnClick(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loginBtnClick(ActionEvent event) throws IOException {
        if (enterPasswordField.getText().isEmpty()
                || userNameTexfield.getText().isEmpty()) {

            Alert alerta = new Alert(Alert.AlertType.WARNING, "Credenciales "
                    + "incorrectas.");
            alerta.showAndWait();

        } else {
            Trabajador aux = new Trabajador(0, "", "", "", "",
                    userNameTexfield.getText(), enterPasswordField.getText());

            aux = FactoriaBLL.getTrabajadorBLL().loginBLL(aux);

            if (aux != null) {
                App.swapScene(new Stage(), "menuusuarioview");
            }else{
                Alert alerta = new Alert(Alert.AlertType.WARNING, "El usuario "
                    + "no existe.");
                alerta.show();
            }
        }
    }

}
