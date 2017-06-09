/** Created by shannonsullivan on 5/30/17. */
import java.io.FileNotFoundException;
import java.util.List;

public class Quiz {
  public static void main(String[] args) throws FileNotFoundException {
    List<Question> quiz = QuizCompiler.compileQuiz();
    QuizInterface.startQuiz(quiz);
  }
}
