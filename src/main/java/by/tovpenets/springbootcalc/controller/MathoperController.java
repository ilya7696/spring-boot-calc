package by.tovpenets.springbootcalc.controller;

import by.tovpenets.springbootcalc.model.Expression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

@Slf4j
@Controller
public class MathoperController {

    @GetMapping("/mathoper")
    public String test(ModelMap model) {
        model.addAttribute("expression", new Expression());
        return "index";
    }

    @PostMapping("/mathoper")
    public String submit(@ModelAttribute Expression expression, ModelMap model) {
        String expr = expression.getExpr();
        try {
            System.out.println("Expression: " + expr);

            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine js = manager.getEngineByName("js");

            String result = js.eval(expr).toString();
            model.addAttribute("answer", "Answer is " + result);
        } catch (Exception e) {
            model.addAttribute("answer", "Error: " + expr);
            log.error("Something wrong while evaluating expression {}", expr);
        }
        return "index";
    }

}
