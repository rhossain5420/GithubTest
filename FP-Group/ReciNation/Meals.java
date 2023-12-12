//Rohed Hossain,Mohamed Abdalla,Michael Decoster
// 12/11/23
/**
This is designed to give the user the number of ingredients 
for the driver program.
*/


public class Meals
{
   private String strMeal;
   private String idMeal;
   private String strMealThumb;

/**
Constructor
@param strMeal variable is stored the this.strMeal 
@param idMeal variable is stored the this.idMeal 
@param strMealThumb variable is stored the this.strMealThumb
*/

   public Meals(String strMeal, String idMeal, String strMealThumb)
   {
      this.strMeal = strMeal;
      this.idMeal = idMeal;
      this.strMealThumb = strMealThumb;
   }
   
      /**
   The setStrMeal method 
   
   @param strMeal to format meal
   
   */
   
  
   public void setStrMeal(String strMeal)
   {
      this.strMeal = strMeal;
   }
    /**
   The setStrMealThumb method 
   
   @param strMealThumb is used for image
   
   */
   
   public void setStrMealThumb(String strMealThumb)
   {
      this.strMealThumb = strMealThumb;
   }
      /**
   The setIdMeal method 
   
   @param idMeal is used for the food id
   
   */
   

   public void setIdMeal(String idMeal)
   {
      this.idMeal = idMeal;
   }

   
/**
The getStrMeal method prints out the meal format
@return helps print the name of meal
*/
   public String getStrMeal()
   {
      return strMeal;
   }
    
/**
The getStrMeal prints out the image for the program
@return helps with the image view
*/
   public String getStrMeal()
   {
      return strMealThumb;
   }
      
/**
The getIdMeal method prints out the id of the meal
@return helps with the id
*/

   public String getIdMeal()
   {
      return idMeal;
   }

 
}

