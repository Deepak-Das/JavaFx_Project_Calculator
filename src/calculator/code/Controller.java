package calculator.code;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Controller {

    public Label answer;
    @FXML
    private Label expression;
    String[] s;


    public void setExpression(String exp) {
        expression.setText(expression.getText()+exp);
        answer.setText("");
//        System.out.println(expression.getText());



    }

    public void onNumClick(MouseEvent mouseEvent) {
        Button button= (Button) mouseEvent.getSource();
        switch (button.getText()){
            case "1":;
            case "2":;
            case "3":;
            case "4":;
            case "5":;
            case "6":;
            case "7":;
            case "8":;
            case "9":;
            case "0":
                setExpression(button.getText());
                break;
            case "/":;
            case "*":;
            case "+":;
            case "-":
                if(Character.isDigit(expression.getText().charAt(expression.getText().length()-1)))
                setExpression(button.getText());
                break;
        }
    }

    public void onResultClick(MouseEvent mouseEvent) throws ScriptException {
//        ScriptEngineManager scriptEngineManager=new ScriptEngineManager();
//        ScriptEngine scriptEngine=scriptEngineManager.getEngineByName("JavaScript");
//        Object result=scriptEngine.eval(expression.getText());
        answer.setText("= "+EvaluateString.evaluate(expression.getText()));
        expression.setText("");

    }
}
