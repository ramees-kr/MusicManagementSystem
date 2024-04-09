module dev.ramees.musicmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens dev.ramees.musicmanagementsystem to javafx.fxml;
    exports dev.ramees.musicmanagementsystem;
}