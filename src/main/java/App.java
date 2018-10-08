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

        ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

    setPort(port);
    
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


//to update addition of the heroes
        post("/heroes", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();

          // ArrayList<Hero> heroes = request.session().attribute("heroes");
          // if (heroes == null) {
          //   heroes = new ArrayList<Hero>();
          //   request.session().attribute("heroes", heroes);
          // }

          String alias = request.queryParams("alias");
          String age = request.queryParams("age");
          String specialPower = request.queryParams("specialPower");
          String weakness = request.queryParams("weakness");
          Hero newHero = new Hero(alias, age, specialPower, weakness);


          // request.session().attribute("hero", newHero);
          //  heroes.add(newHero);

          model.put("template", "templates/success.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


    }
}
