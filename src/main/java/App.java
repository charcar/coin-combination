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
          model.put("template", "templates/home.vtl");

          String sCents = request.queryParams("sCents");
          Integer cents = Integer.parseInt(sCents);
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



    }
    public static String coinCounter(Integer cents) {
      Integer quarters = 0;
      Integer dimes = 0;
      Integer nickels = 0;

      while ( cents >= 25 ) {
        cents = cents - 25;
        quarters++;
      }
      while ( cents >= 10) {
        cents = cents - 10;
        dimes++;
      }
      while ( cents >= 5 ) {
        cents = cents - 5;
        nickels++;
      }

      Integer pennies = cents;

      String quarterName = "";
      String dimeName = "";
      String nickelName = "";
      String pennyName = "";

      if (quarters > 1) {
        quarterName = " quarters, ";
      } else {
        quarterName = " quarter, ";
      }

      if (dimes > 1) {
        dimeName = " dimes, ";
      } else {
        dimeName = " dime, ";
      }

      if (nickels > 1) {
        nickelName = " nickels and ";
      } else {
        nickelName = " nickel and ";
      }

      if (pennies > 1) {
        pennyName = " pennies.";
      } else {
        pennyName = " penny.";
      }

      String coinCount = (quarters + quarterName + dimes + dimeName + nickels + nickelName + pennies + pennyName);

      return coinCount;


    }
}
