module mainpkg.rakin.mainpkg {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg to javafx.fxml;

    opens mainpkg.rakin to javafx.fxml, javafx.base;
    opens mainpkg.arafat to javafx.fxml, javafx.base;
    opens mainpkg.turan to javafx.fxml, javafx.base;
    opens mainpkg.ronon to javafx.fxml, javafx.base;

    exports mainpkg;
}