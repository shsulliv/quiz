import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/** Created by shannonsullivan on 6/9/17. */
public class QuizInterface implements ActionListener {
  private JFrame frame;
  private int score;
  private List<Question> quiz;
  private int currentQuestionIndex;
  private String currentAnswer;

  public QuizInterface(List<Question> quiz) {
    this.quiz = quiz;
    this.currentQuestionIndex = 0;
    this.currentAnswer = "";
    this.score = 0;
    this.frame = new JFrame();
  }

  public void startQuiz() {
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
    frame.setTitle("Dessert Quiz");
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
    frame.dispose();
    frame = new JFrame();
    checkAnswer();
    if (currentQuestionIndex == quiz.size() - 1) {
      showResults();
    } else {
      askNextQuestion();
    }
  }

  private void askNextQuestion() {
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

  private double calculatePercentage() {
    return ((double) score) / quiz.size() * 100;
  }

  private void showResults() {
    JPanel mainPanel = new JPanel();
    JPanel resultsPanel = new JPanel();
    JLabel resultsLabel = new JLabel();

    double percentage = calculatePercentage();

    if (percentage <= 50.0) {
      resultsLabel.setText(
          "Your score is "
              + score
              + "/"
              + quiz.size()
              + ". You got "
              + percentage
              + " percent right :(");
    } else {
      resultsLabel.setText(
          "Your score is "
              + score
              + "/"
              + quiz.size()
              + ". You got "
              + percentage
              + " percent right :)");
    }

    resultsPanel.add(resultsLabel);
    mainPanel.setLayout(new BorderLayout());
    mainPanel.add(resultsPanel, BorderLayout.CENTER);
    frame.add(mainPanel);
    frame.setTitle("Dessert Quiz");
    frame.pack();
    frame.setSize(600, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
