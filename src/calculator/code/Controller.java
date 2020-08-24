package calculator.code;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javax.script.ScriptException;
import java.util.Stack;

public class Controller {

    public Label answer;
    @FXML
    private Label expression;
    String[] s;


    Stack<History> his = new Stack<>();

    public void setExpression(String exp) {
        expression.setText(expression.getText() + exp);
        answer.setText("");
//        System.out.println(expression.getText());


    }

    public void onNumClick(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        switch (button.getText()) {
            case "1":
                ;
            case "2":
                ;
            case "3":
                ;
            case "4":
                ;
            case "5":
                ;
            case "6":
                ;
            case "7":
                ;
            case "8":
                ;
            case "9":
                ;
            case "0":
                setExpression(button.getText());
                break;
            case "/":
                ;
            case "*":
                ;
            case "+":
                ;
            case "-":
                if (expression.getText().isEmpty())
                    break;
                if (Character.isDigit(expression.getText().charAt(expression.getText().length() - 1)))
                    setExpression(button.getText());
                break;
            case "His":
                if (his.isEmpty())
                    break;
                History lasthis = his.pop();
                expression.setText(lasthis.getExpression());
                answer.setText(lasthis.getAnswer());
                break;
            case "AC":
                expression.setText("");
                break;
            case "C":
                if (!expression.getText().isEmpty())
                    expression.setText(expression.getText().substring(0, expression.getText().length() - 1));
                break;
            case "ANS":
                expression.setText(his.peek().getAnswer());
                answer.setText("");
                break;

        }
    }

    public void onResultClick(MouseEvent mouseEvent) throws ScriptException {
//        ScriptEngineManager scriptEngineManager=new ScriptEngineManager();
//        ScriptEngine scriptEngine=scriptEngineManager.getEngineByName("JavaScript");
//        Object result=scriptEngine.eval(expression.getText());

        History history = new History();

        if (!Character.isDigit(expression.getText().charAt(expression.getText().length() - 1))) {
            answer.setText("syntax error");
            return;
        }
        String answer = EvaluateString.evaluate(expression.getText()).toString();
        double result = EvaluateString.evaluate(expression.getText());
        if (answer.indexOf(".") == answer.length() - 2) {
            this.answer.setText("= " + (int) result);
            history.setAnswer(String.valueOf((int) result));
        } else {
            history.setAnswer(answer);
            this.answer.setText("= " + answer);
        }


        history.setExpression(expression.getText());

        his.push(history);

        expression.setText("");

    }
}
