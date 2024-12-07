package org.example.simplecalculatorapi.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    private String expression;
    private double result;
    private boolean correctCalculated;
    private String errorMessage;

    public Issue(String expression) {
        this.expression = expression;
        this.result = 0.0;
        this.correctCalculated = false;
        this.errorMessage = "";
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public boolean isCorrectCalculated() {
        return correctCalculated;
    }

    public void setCorrectCalculated(boolean correctCalculated) {
        this.correctCalculated = correctCalculated;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
