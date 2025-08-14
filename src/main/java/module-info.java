module mainpkg.lawfirm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens mainpkg.lawfirm to javafx.fxml;

    opens mainpkg.lawfirm.rakin to javafx.fxml, javafx.base;
    opens mainpkg.lawfirm.arafat to javafx.fxml, javafx.base;
    opens mainpkg.lawfirm.turan to javafx.fxml, javafx.base;
    opens mainpkg.lawfirm.ronon to javafx.fxml, javafx.base;

    exports mainpkg.lawfirm;
}