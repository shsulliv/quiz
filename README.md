# Programming Coursework

## PART I: GUI-based Online Testing System

By Shannon Sullivan

### Project overview

#### Object Oriented Structure

To give the project a logical structure it divides functionality into four classes:

`Quiz.java` - Similar to a `main` class, this class runs the entire program

`QuizCompiler.java` - Manages all file interaction. Reads questions and answers from text files and converts them into the correct data structures.

`QuizInterface.java` - Handles the mechanics of asking questions and accepting answers. Implements the UI and UI logic, using the Java Swing framework.

`Question.java` - Gives a java-like interface to interact with the data

#### Features

The project implements all of the standard requirements of this assignment, as specified in exercises 1 - 8 of the specs.

### Test Plan

|  | Test  | Method | Expected Result | Result |  Evidence |
| --- |:----:| :-----:| :-----:| :-----:| :---:|
| 1 | The first question and its answers are shown correctly | Run the quiz from the terminal | 1. What makes baklava sweet? | As expected | See Appendix A |
| 2 | The user can select only one answer| Clicks on several radio buttons | Only one radio button can be selected | As expected | See Appendix A |
| 3 | The next question and its answers are shown correctly | Click the "next" button after selecting an answer |2. Chantilly refers to which dessert item? | As expected | See Appendix A |
| 4 | The user's score is calculated correctly | Complete all ten quiz questions and click "next" | You scored 10/10. You got 100 percent :)| As expected | See Appendix A |
| 5 | The user's percentage is calculated correctly | Complete all ten quiz questions and click "next" | You scored 10/10. You got 100 percent :) | As expected | See Appendix A |
| 6 | The user can exit the quiz at any time | Click on the "x" button at the top of the window | The window closes | As expected | See Appendix A |

### Appendix A
| Test Number | Evidence |
| --- |:----:|
| 1 | ![alt text](img/test_1.png)|
| 2 | ![alt text](img/test_2.png)|
| 3 | ![alt text](img/test_3.png)|
| 4 | ![alt text](img/test_4.png)|
| 5 | ![alt text](img/test_5.png)|
| 6 | ![alt text](img/test_6.png)|
