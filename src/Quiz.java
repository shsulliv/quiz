/** Created by shannonsullivan on 5/30/17. */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz {
  public static void main(String[] args) throws FileNotFoundException {
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

  private static List<Question> compileQuiz() throws FileNotFoundException {
    File questionsFile = new File("./src/txt/questions.txt");
    File answersFile = new File("./src/txt/answers.txt");
    File rightAnswerFile = new File("./src/txt/right-answers.txt");

    List<Question> questions = new ArrayList<>();
    Scanner questionsReader = new Scanner(questionsFile);
    Scanner answersReader = new Scanner(answersFile);
    Scanner rightAnswerReader = new Scanner(rightAnswerFile);

    while (questionsReader.hasNextLine()) {
      String text = questionsReader.nextLine();
      String[] answers = new String[4];
      for (int i = 0; i < 4; i++) {
        answers[i] = answersReader.nextLine();
      }
      int answerIndex = Integer.parseInt(rightAnswerReader.nextLine());

      questions.add(new Question(text, answers, answerIndex));
    }

    return questions;
  }
}
