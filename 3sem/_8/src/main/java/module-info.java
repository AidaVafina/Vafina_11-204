module com.example._8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;


    opens com.example._8 to javafx.fxml;
    exports com.example._8;
}