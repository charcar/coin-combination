import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/home.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/results", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/results.vtl");

          String sCents = request.queryParams("cents");
          Integer cents = Integer.parseInt(sCents);
          String correctChange = coinCounter(cents);
          model.put("correctChange", correctChange);
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



    }
    public static String coinCounter(Integer cents) {
      Integer quarters = 0;
      Integer dimes = 0;
      Integer nickels = 0;

      Integer quarterStack = 10;
      Integer dimeStack = 10;
      Integer nickelStack = 10;

      while ( cents >= 25 && quarterStack > 0 ) {
        cents = cents - 25;
        quarters++;
        quarterStack--;
      }
      while ( cents >= 10 && dimeStack > 0 ) {
        cents = cents - 10;
        dimeStack--;
        dimes++;
      }
      while ( cents >= 5 && nickelStack > 0 ) {
        cents = cents - 5;
        nickels++;
        nickelStack--;
      }

      Integer pennies = cents;

      String quarterName = "";
      String dimeName = "";
      String nickelName = "";
      String pennyName = "";

      if (quarters != 1) {
        quarterName = " quarters, ";
      } else {
        quarterName = " quarter, ";
      }

      if (dimes != 1) {
        dimeName = " dimes, ";
      } else {
        dimeName = " dime, ";
      }

      if (nickels != 1) {
        nickelName = " nickels and ";
      } else {
        nickelName = " nickel and ";
      }

      if (pennies != 1) {
        pennyName = " pennies.";
      } else {
        pennyName = " penny.";
      }

      String coinCount = (quarters + quarterName + dimes + dimeName + nickels + nickelName + pennies + pennyName);

      return coinCount;


    }
}
