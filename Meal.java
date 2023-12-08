package CallRandomAPI;

public class Meal {
    private String strMeal;
    private String strCategory;
    private String strArea;
    
    public Meal(String strMeal, String strCategory, String strArea) {
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strArea = strArea;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }
    public String toString() {
        return 
                "MealName = " + strMeal + "\n" +
                "Type of Meal = " + strCategory + "\n" +
                "Counrty of Meal = " + strArea;
    }
}
