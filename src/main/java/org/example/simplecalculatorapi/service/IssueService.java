package org.example.simplecalculatorapi.service;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.example.simplecalculatorapi.entity.Issue;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    public Issue solve(Issue issue){
        try {
            Expression expression = new ExpressionBuilder(issue.getExpression()).build();
            double result = expression.evaluate();
            issue.setResult(result);
            issue.setCorrectCalculated(true);
            String message = "No error";
            issue.setErrorMessage(message);


        } catch (IllegalArgumentException | ArithmeticException e) {
            issue.setCorrectCalculated(false);
            issue.setErrorMessage(e.getMessage());
        }

        return issue;
    }
}
