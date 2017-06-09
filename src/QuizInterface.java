import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** Created by shannonsullivan on 6/9/17. */
public class QuizInterface {
  public static void startQuiz(List<Question> quiz) {
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

    double percentage =
        (((double) score) / quiz.size()) * 100; // score must be converted to a double

    showResults(score, percentage, quiz);
  }

  private static void showResults(int s, double p, List<Question> q) {
    if (p <= 50.0) {
      System.out.println(
          "Your score is " + s + "/" + q.size() + ". You got " + p + " percent right :(");
    } else {
      System.out.println(
          "Your score is " + s + "/" + q.size() + ". You got " + p + " percent right :)");
    }
  }
}
