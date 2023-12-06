
import com.google.gson.Gson;

public class JsonParsingExample {
    public static void main(String[] args) {
        //JSON data
        String jsonString =  "{\n" +
        "  \"meals\": [\n" +
        "    {\n" +
        "      \"strMeal\": \"Baingan Bharta\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/urtpqw1487341253.jpg\",\n" +
        "      \"idMeal\": \"52807\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Bread omelette\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/hqaejl1695738653.jpg\",\n" +
        "      \"idMeal\": \"53076\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Chicken Handi\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/wyxwsp1486979827.jpg\",\n" +
        "      \"idMeal\": \"52795\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Dal fry\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/wuxrtu1483564410.jpg\",\n" +
        "      \"idMeal\": \"52785\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Kidney Bean Curry\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/sywrsu1511463066.jpg\",\n" +
        "      \"idMeal\": \"52868\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Lamb Biryani\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/xrttsx1487339558.jpg\",\n" +
        "      \"idMeal\": \"52805\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Lamb Rogan josh\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/vvstvq1487342592.jpg\",\n" +
        "      \"idMeal\": \"52808\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Matar Paneer\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/xxpqsy1511452222.jpg\",\n" +
        "      \"idMeal\": \"52865\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Nutty Chicken Curry\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/yxsurp1511304301.jpg\",\n" +
        "      \"idMeal\": \"52851\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Recheado Masala Fish\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/uwxusv1487344500.jpg\",\n" +
        "      \"idMeal\": \"52809\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Smoked Haddock Kedgeree\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/1550441275.jpg\",\n" +
        "      \"idMeal\": \"52964\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"strMeal\": \"Tandoori chicken\",\n" +
        "      \"strMealThumb\": \"https://www.themealdb.com/images/media/meals/qptpvt1487339892.jpg\",\n" +
        "      \"idMeal\": \"52806\"\n" +
        "    }\n" +
        "  ]\n" +
        "}";


        // Use GSON to parse JSON into Java objects
        Gson gson = new Gson();
        MealsResponse mealsResponse = gson.fromJson(jsonString, MealsResponse.class);
        

   
       //printing the meal:
       //  System.out.println("First Meal: " + mealsResponse.getMeals().get(5));
         System.out.println("First Meal: " + mealsResponse.getMeals().get(4).toString());
    }
}
