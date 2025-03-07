import java.util.ArrayList;
import java.util.Scanner;

public class RecipeAnalyzer {

  private ArrayList<String> firstRecipe;    // The list of recipes
  private ArrayList<String> secondRecipe;    // The list of recipes
  
  public RecipeAnalyzer() {
    firstRecipe = createRecipeList("recipe1.txt");
    secondRecipe = createRecipeList("recipe2.txt");
  }
  
  public ArrayList<String> createRecipeList(String fileName) {
    TextProcessor tp = new TextProcessor(fileName);
    return tp.textToWords();
  }
  
    /**
   * This is a student developed method
   * Checks if a word is in one of the recipes
   * @param targetWord the word that is being use to find in the recipe
   * @param recipeList the list of words in all the recipe .txt files
   * @return the true or false based on wether the word entered by userInput is in recipeList or not
   */

  public boolean isInRecipeList(String targetWord, ArrayList<String> recipeList) {
    // 1. Traverse the ArrayList called recipeList (use int i = 0)
    for (int i = 0; i < recipeList.size(); i++) {
      // 2. Make a currentWord variable using recipeList.get(i)
      String currentWord = recipeList.get(i);
      // 3. Check if the word from recipeList equals the targetWord ( use .equals() )
      if (currentWord.equals(targetWord)) {
        // 4. If they are the same, return true 
        return true;
      }
    }

    // 5. If not match, return false
    return false;
  }


  /**
   * Starts the app and gets user input
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);

    System.out.println("Type a word to see if it is in one of my recipes:");
    String userInput = input.nextLine();

    if (isInRecipeList(userInput, firstRecipe)) {
      // TODO: What do you want to happen when the word is found in recipe1
      System.out.println("The word " + userInput + " is found in the first recipe.");
    } else if (isInRecipeList(userInput, secondRecipe)) {
      // TODO: What do you want to happen when the word is found in recipe2
     System.out.println("The word " + userInput + " is found in second recipe.");
    } else {
      // Error Handle: What if the word is not in the list
      System.out.println("Sorry, I don't think the word you entered is in any of the recipes. Please try again.");
    }

    input.close();
  }

  /**
   * Prints the summary of my NLP project
   */
  public void printSummary() {
    System.out.println(secondRecipe);
  }

}