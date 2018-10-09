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

//to view Squad Form
        get("/squad-form/new", (request, response) -> {
              Map<String, Object> model = new HashMap<String, Object>();
              model.put("template", "templates/squad-form.vtl");
              return new ModelAndView(model, layout);
            }, new VelocityTemplateEngine());

//to post properties of Squad
          post("/squads", (request, response) -> {
              Map<String, Object> model = new HashMap<String, Object>();
              String name = request.queryParams("squadName");
              String description = request.queryParams("description");
              Squad newSquad = new Squad(name, description);
              model.put("template", "templates/Squad-success.vtl");
              return new ModelAndView(model, layout);
            }, new VelocityTemplateEngine());

//to display posted squad
            get("/squads", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("squads", Squad.all());
                model.put("template", "templates/squads.vtl");
                return new ModelAndView(model, layout);
              }, new VelocityTemplateEngine());

//to view specific Squad detail page
              get("/squad/:id", (request, response) -> {
                  Map<String, Object> model = new HashMap<String, Object>();
                  Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
                  model.put("squad", squad);
                  model.put("template", "templates/squad.vtl");
                  return new ModelAndView(model, layout);
                }, new VelocityTemplateEngine());

//Parse form.vtl to add heroes
        get("squads/:id/form/new", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
           model.put("squad", squad);
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


        // get("/heroes/:id", (request, response) -> {
        //     HashMap<String, Object> model = new HashMap<String, Object>();
        //     Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
        //     model.put("hero", hero);
        //     model.put("template", "templates/hero.vtl");
        //     return new ModelAndView(model, layout);
        // }, new VelocityTemplateEngine());


//to update addition of the heroes
        post("/heroes", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();

            // Squad squad = Squad.find(Integer.parseInt(request.queryParams("SquadId")));


          String alias = request.queryParams("alias");
          String age = request.queryParams("age");
          String specialPower = request.queryParams("specialPower");
          String weakness = request.queryParams("weakness");
          Hero newHero = new Hero(alias, age, specialPower, weakness);

          // squad.addHero(newHero);
          // model.put("squad", squad);
          model.put("template", "templates/success.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


    }
}
