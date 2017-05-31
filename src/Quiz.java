/** Created by shannonsullivan on 5/30/17. */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz {
  public static void main(String[] args) {
    List<Question> quiz = compileQuiz();
    startQuiz(quiz);
  }

  private static void startQuiz(List<Question> quiz) {
    int score = 0;
    Scanner reader = new Scanner(System.in);

    for (Question question : quiz) {
      System.out.println(question.getText() + "\n");
      System.out.print(Arrays.toString(question.getAnswers()) + "\n");
      String input = reader.nextLine();

      if (input.equals(question.getRightAnswer())) {
        score += 1;
      }
    }

    System.out.println("Your score is " + score + "/5");
  }

  private static List<Question> compileQuiz() {
    String[] questions = {
      "What makes Baklava sweet?",
      "Chantilly refers to which dessert item?",
      "Shaved ice originated in which country?",
      "What is the primary ingredient in Horchata?",
      "Chocolate was first consumed as a(n)?"
    };

    String[][] answers = {
      {"Vinegar", "Sugar", "Pistachio", "Honey"}, // Honey
      {"Whipped Cream", "Ice Cream", "Custard", "Meringue"}, // Whipped Cream
      {"Italy", "China", "Japan", "Russia"}, // Japan
      {"Cow Milk", "Tiger Nut", "Almond", "Sheep Milk"}, // Tiger Nut
      {"Candy Bar", "Soup", "Alcoholic Beverage", "Milkshake"} // Alcoholic Beverage
    };

    int[] indices = {3, 0, 2, 1, 2};

    List<Question> quiz = new ArrayList<>();

    for (int i = 0; i < questions.length; i++) {
      String questionText = questions[i];
      String[] possibleAnswers = answers[i];
      int rightAnswer = indices[i];

      Question currentQuestion = new Question(questionText, possibleAnswers, rightAnswer);

      quiz.add(currentQuestion);
    }

    return quiz;
  }
}
