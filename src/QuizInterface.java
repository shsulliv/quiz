import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/** Created by shannonsullivan on 6/9/17. */
public class QuizInterface implements ActionListener {
  private JFrame frame = new JFrame();
  private final String SUBMIT_ACTION = "submit";
  private final String SKIP_ACTION = "skip";

  public void startQuiz(List<Question> quiz) {
    int score = 0;
    for (Question question : quiz) {
      askQuestion(question);
    }

    double percentage =
        (((double) score) / quiz.size()) * 100; // score must be converted to a double

    showResults(score, percentage, quiz);
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
      answerButtons[i] = new JRadioButton();
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
    submitButton.setActionCommand(SUBMIT_ACTION);
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

    //    if (input.equals(question.getRightAnswer())) {
    //      score += 1;
    //    }
  }

  public void actionPerformed(ActionEvent event) {
    switch (event.getActionCommand()) {
      case SUBMIT_ACTION:
        System.out.println("Clicked");
        break;
      default:
        System.out.println(event.getActionCommand());
    }
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
