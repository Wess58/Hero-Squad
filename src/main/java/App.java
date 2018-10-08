import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

//Parse Index.vtl
        get( "/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

//Parse form.vtl to add heroes
        get("/form/new", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           model.put("template", "templates/form.vtl");
           return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());


//Parse heroes.vtl to display the heroes
       get("/heroes", (request,response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("heroes", Hero.all());
         model.put("template", "templates/heroes.vtl");
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());


    }
}
