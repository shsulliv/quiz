import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/** Created by shannonsullivan on 6/9/17. */
public class QuizInterface implements ActionListener {
  private JFrame frame = new JFrame();
  private int score = 0;
  private List<Question> quiz;
  private int currentQuestionIndex;
  private String currentAnswer = "";

  public void startQuiz(List<Question> quiz) {
    this.quiz = quiz;
    currentQuestionIndex = 0;
    askQuestion(quiz.get(currentQuestionIndex));
  }

  private void askQuestion(Question question) {
    JPanel mainPanel = new JPanel();
    JPanel questionPanel = new JPanel();
    JPanel answersPanel = new JPanel();
    JPanel controlsPanel = new JPanel();
    JButton submitButton = new JButton();

    // Make the question
    JLabel questionLabel = new JLabel();
    questionLabel.setText(question.getText());
    questionPanel.add(questionLabel);

    // Make the answers
    String[] answers = question.getAnswers();
    ButtonGroup answerGroup = new ButtonGroup();
    JRadioButton[] answerButtons = new JRadioButton[answers.length];
    for (int i = 0; i < answers.length; i++) {
      answerButtons[i] = new JRadioButton(answers[i]);
      answerButtons[i].setText(answers[i]);
      answerButtons[i].addActionListener(this);
      answerGroup.add(answerButtons[i]);
      answersPanel.add(answerButtons[i]);
    }

    // Setup panels
    mainPanel.setLayout(new BorderLayout());
    questionPanel.setLayout(new GridLayout(0, 1));
    answersPanel.setLayout(new GridLayout(0, 1));
    controlsPanel.setLayout(new FlowLayout());

    // Setup the button
    submitButton.setText("next");
    submitButton.setActionCommand("submit");
    submitButton.addActionListener(this);
    submitButton.setEnabled(true);

    // Load panels, add them to to frame
    questionPanel.add(questionLabel);
    controlsPanel.add(submitButton);

    mainPanel.add(questionPanel, BorderLayout.NORTH);
    mainPanel.add(answersPanel, BorderLayout.CENTER);
    mainPanel.add(controlsPanel, BorderLayout.SOUTH);

    // Setup the frame
    frame.add(mainPanel);
    frame.setTitle("Quiz Game");
    frame.pack();
    frame.setSize(600, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("submit")) {
      handleSubmit(event);
    } else {
      handleSelection(event);
    }
  }

  private void handleSubmit(ActionEvent event) {
    checkAnswer();
    renderNextQuestion();
  }

  private void renderNextQuestion() {
    frame.dispose();
    frame = new JFrame();
    currentQuestionIndex += 1;
    askQuestion(quiz.get(currentQuestionIndex));
  }

  private void checkAnswer() {
    if (currentAnswer.equals(quiz.get(currentQuestionIndex).getRightAnswer())) {
      score += 1;
    }
  }

  private void handleSelection(ActionEvent event) {
    currentAnswer = event.getActionCommand();
  }

  private void showResults(int s, double p, List<Question> q) {
    JPanel mainPanel = new JPanel();
    JPanel resultsPanel = new JPanel();
    JLabel resultsLabel = new JLabel();

    if (p <= 50.0) {
      resultsLabel.setText(
          "Your score is " + s + "/" + q.size() + ". You got " + p + " percent right :(");
    } else {
      resultsLabel.setText(
          "Your score is " + s + "/" + q.size() + ". You got " + p + " percent right :)");
    }

    resultsPanel.add(resultsLabel);
    mainPanel.setLayout(new BorderLayout());
    mainPanel.add(resultsPanel, BorderLayout.CENTER);
    frame.add(mainPanel);
    frame.setTitle("Quiz Game");
    frame.pack();
    frame.setSize(600, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
