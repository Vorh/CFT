package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import model.*;

public class Controller {

    //<editor-fold desc="Solution">

    Solution solution = new Solution();
    private String[] split;

    @FXML
    Button click_1 = new Button();
    @FXML
    Button click_2 = new Button();
    @FXML
    Button click_3 = new Button();
    @FXML
    Button click_4 = new Button();
    @FXML
    Button click_5 = new Button();
    @FXML
    Button click_6 = new Button();
    @FXML
    Button click_7 = new Button();
    @FXML
    Button click_8 = new Button();
    @FXML
    Button click_9 = new Button();
    @FXML
    Button click_0 = new Button();
    @FXML
    Button equally = new Button();
    @FXML
    Button leftB = new Button();
    @FXML
    Button rightB = new Button();
    @FXML
    Button c = new Button();
    @FXML
    Button ce = new Button();
    @FXML
    Button minus = new Button();
    @FXML
    Button plus = new Button();
    @FXML
    Button division = new Button();
    @FXML
    Button multiplication = new Button();
    @FXML
    Button percent = new Button();

    @FXML
    TextField fieldInput = new TextField();
    @FXML
    TextField fieldOutput = new TextField();


    public void click_1(){
        fieldInput.appendText("1");
        start();
    }
    public void click_2(){
        fieldInput.appendText("2");
        start();
    }
    public void click_3(){
        fieldInput.appendText("3");
        start();
    }
    public void click_4(){
        fieldInput.appendText("4");
        start();
    }
    public void click_5(){
        fieldInput.appendText("5");
        start();
    }
    public void click_6(){
        fieldInput.appendText("6");
        start();
    }
    public void click_7(){
        fieldInput.appendText("7");
        start();
    }
    public void click_8(){
        fieldInput.appendText("8");
        start();
    }
    public void click_9(){
        fieldInput.appendText("9");
        start();
    }
    public void click_0(){
        fieldInput.appendText("0");
        start();
    }
    public void click_RightB(){
        fieldInput.appendText("(");
        start();
    }
    public void click_LeftB(){
        fieldInput.appendText(")");
        start();
    }
    public void click_minus(){
        fieldInput.appendText("-");
        start();
    }
    public void click_plus(){
        fieldInput.appendText("+");
        start();
    }
    public void click_multiplication(){
        fieldInput.appendText("*");
        start();
    }
    public void click_comma(){
        fieldInput.appendText(".");
        start();
    }
    public void click_percent(){
        fieldInput.appendText("^");
        start();

    }
    public void click_c(){
        String text = fieldInput.getText().substring(0,fieldInput.getText().length()-1);
        fieldInput.setText(text);
        start();
    }
    public void click_ce(){
        fieldInput.clear();
        fieldOutput.clear();
        Solution.line.clear();
        start();

    }
    public void click_division(){
        fieldInput.appendText("/");
        start();
    }
    public void click_equally(){
        start();
    }

    // Метод отвечающий за решение
    public void start() {
        Solution.line.clear();

        //Костыль
        String s = fieldInput.getText();
        s = "(" + s + ")";
        split = s.split("");

        fieldOutput.setText(solution.process(split));
        Solution.line.clear();

    }

    public void fieldOutput_copy(){
        fieldOutput.copy();
    }
    //</editor-fold>

    //<editor-fold desc="Transfer">

    Transfer transfer = new Transfer();
    @FXML
    TextField fieldInputT = new TextField();
    @FXML
    TextField fieldOutputT = new TextField();

    @FXML
    Button transferT = new Button();

    @FXML
    SplitMenuButton spInput = new SplitMenuButton();
    @FXML
    SplitMenuButton spOutput = new SplitMenuButton();

    ListSystem input;
    ListSystem output;

    public void click_transferT(){
        fieldOutputT.clear();
        fieldOutputT.setText(transfer.transferMain(input, output, fieldInputT.getText()));
    }

    public void mi_binary_1(){
        spInput.setText("BINARY");
        input = ListSystem.BINARY;
    }

    public void mi_decimal_1(){
        spInput.setText("DECIMAL");
        input = ListSystem.DECIMAL;
    }

    public void mi_binary_2(){
        spOutput.setText("BINARY");
        output = ListSystem.BINARY;
    }

    public void mi_decimal_2(){
        spOutput.setText("DECIMAL");
        output = ListSystem.DECIMAL;
    }

    public void fieldOutputT_copy(){
        fieldOutputT.copy();
    }
    //</editor-fold>

    //<editor-fold desc="Finance">


    Finance finance = new Finance();

    @FXML
    TextField textUSD = new TextField();
    @FXML
    TextField textUAH = new TextField();
    @FXML
    TextField textCNY = new TextField();
    @FXML
    TextField textEUR = new TextField();

    @FXML
    TextField textInputF1 = new TextField();
    @FXML
    TextField textOutputF1 = new TextField();

    @FXML
    TextField textInputF2 = new TextField();
    @FXML
    TextField textOutputF2 = new TextField();

    @FXML
    SplitMenuButton menuF1 = new SplitMenuButton();
    @FXML
    SplitMenuButton menuF2 = new SplitMenuButton();

    private Currency currency1;
    private Currency currency2;

    public void initialize(){
        textUAH.setText(ParseFinance.parseUAH());
        textEUR.setText(ParseFinance.parseEUR());
        textCNY.setText(ParseFinance.parseCNY());
        textUSD.setText(ParseFinance.parseUSD());
    }



    public void butF1(){
        textOutputF1.setText(finance.transfer(textInputF1.getText(), currency1,true));
    }
    public void butF2(){
        textOutputF2.setText(finance.transfer(textInputF2.getText(),currency2,false));
    }

    public void miUSD1() {
        menuF1.setText("Доллар");
        currency1 = Currency.USD;
    }

    public void miEUR1() {
        menuF1.setText("Евро");
        currency1 = Currency.EUR;
    }

    public void miCNY1() {
        menuF1.setText("Юань");
        currency1 = Currency.CNY;
    }

    public void miUAH1() {
        menuF1.setText("Гривна");
        currency1 = Currency.UAH;
    }

    public void miUSD2() {
        menuF2.setText("Доллар");
        currency2 = Currency.USD;
    }

    public void miEUR2() {
        menuF2.setText("Евро");
        currency2 = Currency.EUR;
    }

    public void miCNY2() {
        menuF2.setText("Юань");
        currency2 = Currency.CNY;
    }

    public void miUAH2() {
        menuF2.setText("Гривна");
        currency2 = Currency.UAH;
    }
    //</editor-fold>







}
