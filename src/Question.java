/** Created by shannonsullivan on 5/31/17. */
public class Question {
  private String text;
  private String[] answers;
  private String rightAnswer;

  public Question(String text, String[] answers, String rightAnswer) {
    this.text = text;
    this.answers = answers;
    this.rightAnswer = rightAnswer;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String[] getAnswers() {
    return answers;
  }

  public void setAnswers(String[] answers) {
    this.answers = answers;
  }

  public String getRightAnswer() {
    return rightAnswer;
  }

  public void setRightAnswer(String rightAnswer) {
    this.rightAnswer = rightAnswer;
  }
}
