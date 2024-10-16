package org.example.calculator11;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private TextField myText; // TextField for weight
    @FXML
    private TextField myText1; // TextField for height
    @FXML
    private Label mylabel;
    @FXML
    private RadioButton english;

    @FXML
    private void onClick() {
            // для получения значений веса и роста из текстовых полей
            double weight = Double.parseDouble(myText.getText());
            double height = Double.parseDouble(myText1.getText());

            //считаем по формуле bmi
            double bmi = calculateBMI(weight, height);

            //формутируем до 4 знаков
            DecimalFormat df = new DecimalFormat("0.0000");
            mylabel.setText("BMI = " + df.format(bmi));

            //
            String c;
            if (bmi < 18.5) {
                c = "Underweight";
            } else if (bmi < 24.9) {
                c = "Normal";
            } else if (bmi < 29.9) {
                c = "Overweight";
            } else {
                c = "Obese";
            }
            mylabel.setText("BMI: " + df.format(bmi) + " / " + c);

    }
    // метод для расчета BMI калькулятора
    private double calculateBMI(double weight, double height) {
        if (english.isSelected()) {
            // преобразуем вес с  pounds в kilograms
            weight *= 0.453592;
            // преобразуем рост с inch  в метры
            height *= 0.0254;
        } else {
            //преобразуем рост в см
            height /= 100.0;
        }
        return weight / (height * height);
    }

    @FXML
    private void clearFields() {
        myText.clear();  // Очистить поле для ввода веса
        myText1.clear(); // Очистить поле для ввода роста
        mylabel.setText("BMI = ");
    }

    // Метод для закрытия приложения,используем Platform.exit()
    @FXML
    private void close() {
        Platform.exit();
    }

    // метод для помощи как вычислять и где что находиться
    @FXML
    private void help() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("BMI Calculator Help");

        alert.setContentText("Click button "+"English "+ "for English unit   \n"+
                "Please provide your weight (lbs or kg) and height (inches or cm) to calculate your BMI.).\n" +
                "Click 'Calculate' to see your BMI.\n" +
                "Use 'Clear' to reset the fields.\n" +
                "Click 'Close' to exit the application.");
        alert.showAndWait();
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
        // This method seems unused; consider removing or implementing it.
    }
}
