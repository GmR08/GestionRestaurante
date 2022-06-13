module com.guillermo.restaurante {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.guillermo.restaurante.controller to javafx.fxml;
    opens com.guillermo.restaurante.model.POJO to javafx.fxml;
    opens com.guillermo.restaurante.model.DAO to javafx.fxml;
    opens com.guillermo.restaurante.model.BLL to javafx.fxml;
    opens com.guillermo.restaurante to javafx.fxml;
    exports com.guillermo.restaurante.controller;
    exports com.guillermo.restaurante.model.POJO;
    exports com.guillermo.restaurante.model.DAO;
    exports com.guillermo.restaurante.model.BLL;
}
