 //Rohed Hossain,Mohamed Abdalla,Michael Decoster
// 12/11/23
/**
This is designed to give the users the meal list of the ingredients
*/
  

import java.util.List;

public class MealsResponse {

   private List<Meal> meals;
     
   /**
   MealResponse 
   
   gives you the list of meals
   */
   public MealsResponse(List<Meal> meals) {
      this.meals = meals;
   }
/**
getMeals

@return the list of meals

*/
   public List<Meal> getMeals() {
      return meals;
   }
/**
setMeals

@param meals the list of meals

*/
   public void setMeals(List<Meal> meals) {
      this.meals = meals;
   }
  /**
setText

sets the text for the app

*/

   public void setText(String string) {
   }
    
}