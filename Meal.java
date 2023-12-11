//mport javafx.scene.image.Image;

public class Meal {
    public String strMeal;
    public String strCategory;
    public String strArea;
    public String strMealThumb;
    public String strYoutube;
    public String strIngredient1;
    public String strIngredient2;
    public String strIngredient3;
    public String strIngredient4;
    public String strIngredient5;
    public String strIngredient6;
    public String strIngredient7;
    public String strIngredient8;
    public String strIngredient9;
    public String strIngredient10;
    public String strIngredient11;
    public String strIngredient12;
    public String strIngredient13;
    public String strIngredient14;
    public String strIngredient15;
    public String strIngredient16;
    public String strIngredient17;
    public String strIngredient18;
    public String strIngredient19;
    public String strIngredient20;
    

   //  public Meal(String strMeal, String strCategory, String strArea) {
//         this.strMeal = strMeal;
//         this.strCategory = strCategory;
//         this.strArea = strArea;
//     }

//     public String getStrMeal() {
//         return strMeal;
//     }
// 
//     public void setStrMeal(String strMeal) {
//         this.strMeal = strMeal;
//     }
// 
//     public String getStrCategory() {
//         return strCategory;
//     }
// 
//     public void setStrCategory(String strCategory) {
//         this.strCategory = strCategory;
//     }
// 
//     public String getStrArea() {
//         return strArea;
//     }
// 
//     public void setStrArea(String strArea) {
//         this.strArea = strArea;
//     }
    public String toString() {
        return 
        strYoutube +
        strMealThumb +
        String.format("%-20s%-20s%-20s\n", "Country Name", "Meal Name", "Ingredients") +
        String.format("%-20s%-20s%-20s\n", strArea, strCategory, strMeal) +
        "-------------------------------------------\n" +
        String.format("%-20s%-20s\n", "Ingredient 1:", strIngredient1) +
        String.format("%-20s%-20s\n", "Ingredient 2:", strIngredient2) +
        String.format("%-20s%-20s\n", "Ingredient 3:", strIngredient3) +
        String.format("%-20s%-20s\n", "Ingredient 4:", strIngredient4) +
        String.format("%-20s%-20s\n", "Ingredient 5:", strIngredient5) +
        String.format("%-20s%-20s\n", "Ingredient 6:", strIngredient6) +
        String.format("%-20s%-20s\n", "Ingredient 7:", strIngredient7) +
        String.format("%-20s%-20s\n", "Ingredient 8:", strIngredient8) +
        String.format("%-20s%-20s\n", "Ingredient 9:", strIngredient9) +
        String.format("%-20s%-20s\n", "Ingredient 10:", strIngredient10) +
        String.format("%-20s%-20s\n", "Ingredient 11:", strIngredient11) +
        String.format("%-20s%-20s\n", "Ingredient 12:", strIngredient12) +
        String.format("%-20s%-20s\n", "Ingredient 13:", strIngredient13) +
        String.format("%-20s%-20s\n", "Ingredient 14:", strIngredient14) +
        String.format("%-20s%-20s\n", "Ingredient 15:", strIngredient15) +
        String.format("%-20s%-20s\n", "Ingredient 16:", strIngredient16) +
        String.format("%-20s%-20s\n", "Ingredient 17:", strIngredient17) +
        String.format("%-20s%-20s\n", "Ingredient 18:", strIngredient18) +
        String.format("%-20s%-20s\n", "Ingredient 19:", strIngredient19) +
        String.format("%-20s%-20s\n", "Ingredient 20:", strIngredient20);
}


    public String getStrYoutube() {
        return null;
    }


    public String getStrMealThumb() {
        return null;
    }
    
}
