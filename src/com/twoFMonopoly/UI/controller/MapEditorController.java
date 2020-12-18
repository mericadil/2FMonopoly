package com.twoFMonopoly.UI.controller;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MapEditorController{
    @FXML
    private Rectangle property1;
    @FXML
    private Rectangle property2;
    @FXML
    private Rectangle property3;
    @FXML
    private Rectangle property4;
    @FXML
    private Rectangle property5;
    @FXML
    private Rectangle property6;
    @FXML
    private Rectangle property7;
    @FXML
    private Rectangle property8;
    @FXML
    private Rectangle property9;
    @FXML
    private Rectangle property10;
    @FXML
    private Rectangle property11;
    @FXML
    private Rectangle property12;
    @FXML
    private Rectangle property13;
    @FXML
    private Rectangle property14;
    @FXML
    private Rectangle property15;
    @FXML
    private Rectangle property16;
    @FXML
    private Rectangle property17;
    @FXML
    private Rectangle property18;
    @FXML
    private Rectangle property19;

    @FXML
    private Text propertyField1;
    @FXML
    private Text propertyField2;
    @FXML
    private Text propertyField3;
    @FXML
    private Text propertyField4;
    @FXML
    private Text propertyField5;
    @FXML
    private Text propertyField6;
    @FXML
    private Text propertyField7;
    @FXML
    private Text propertyField8;
    @FXML
    private Text propertyField9;
    @FXML
    private Text propertyField10;
    @FXML
    private Text propertyField11;
    @FXML
    private Text propertyField12;
    @FXML
    private Text propertyField13;
    @FXML
    private Text propertyField14;
    @FXML
    private Text propertyField15;
    @FXML
    private Text propertyField16;
    @FXML
    private Text propertyField17;
    @FXML
    private Text propertyField18;
    @FXML
    private Text propertyField19;
    @FXML
    private TextField propertyCardNameField;
    @FXML
    private AnchorPane propertyPane;

    private Rectangle selectedProperty;
    private Text selectedText;
    int selectedPropertyNumber;
    private ArrayList<Rectangle> properties ;
    private ArrayList<Text> propertyTextFields ;

    public void init(){
        propertyPane.setVisible(false);

        propertyTextFields = new ArrayList<>(Arrays.asList(     propertyField1, propertyField2, propertyField3, propertyField4, propertyField5,
                propertyField6, propertyField7, propertyField8, propertyField9, propertyField10,
                propertyField11, propertyField12, propertyField13, propertyField14, propertyField15,
                propertyField16, propertyField17, propertyField18, propertyField19))   ;

        properties = new ArrayList<>(Arrays.asList(    property1, property2, property3, property4, property5,
                property6, property7, property8, property9, property10,
                property11, property12, property13, property14, property15,
                property16, property17, property18, property19))   ;
    }

    @FXML
    public void finishDesignAndGoToMainMenu(ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/mainMenu.fxml"));
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void saveButtonPushed(ActionEvent actionEvent){
        String newPropertyName = propertyCardNameField.getText();
        selectedText.setText(newPropertyName);
        propertyPane.setVisible(false);
        propertyCardNameField.setText("");
    }
    @FXML
    public void pauseAndReturnMainMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FX/mainMenu.fxml"));
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.getScene().setRoot(root); window.show();
            System.out.println(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void closePropertyPaneButtonPushed(ActionEvent event) {
        propertyPane.setVisible(false);
    }

    @FXML
    public void mouseClickedOnPropertyRectangle(MouseEvent mouseEvent) {
        propertyPane.setVisible(true);
        if(mouseEvent.getSource().getClass() == Rectangle.class) {
            selectedProperty = (Rectangle) mouseEvent.getSource();
            selectedPropertyNumber = Integer.parseInt(selectedProperty.getId().substring(8));
            for (int i = 0; i < 19; i++) {
                int textFieldsNumber = Integer.parseInt(propertyTextFields.get(i).getId().substring(13));
                if (textFieldsNumber == selectedPropertyNumber) {
                    selectedText = propertyTextFields.get(i);
                }
            }
        }
        else {
            selectedText = (Text) mouseEvent.getSource();
        }
    }

}
