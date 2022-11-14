module com.example.chessproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chessproject to javafx.fxml;
    exports com.example.chessproject;
}