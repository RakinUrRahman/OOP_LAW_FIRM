module mainpkg.lawfirm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens mainpkg.lawfirm to javafx.fxml;

    opens mainpkg.lawfirm.rakin to javafx.fxml, javafx.base;
    opens mainpkg.lawfirm.Sojib.Client to javafx.fxml, javafx.base;
    opens mainpkg.lawfirm.Sojib.Legal_Intern to javafx.fxml, javafx.base;
    opens mainpkg.lawfirm.turan to javafx.fxml, javafx.base;
    opens mainpkg.lawfirm.ronon to javafx.fxml, javafx.base;

    exports mainpkg.lawfirm;
}