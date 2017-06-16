import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Created by shannonsullivan on 6/9/17. */
public class QuizCompiler {
  public static List<Question> compileQuiz() throws FileNotFoundException {
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
      String rightAnswer = rightAnswerReader.nextLine();

      questions.add(new Question(text, answers, rightAnswer));
    }

    return questions;
  }
}
