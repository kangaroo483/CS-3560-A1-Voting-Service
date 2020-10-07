import java.util.HashMap;
import java.util.Iterator;

public class VotingService implements VotingServiceInterface{
    private Question question;
    //used for keeping track of student int ID and string answer
    private HashMap<Integer, String> studentAnswers;
    //keeping track of string answers and total int votes for answers
    private HashMap<String, Integer> questionDistribution;

    /**
     * Initializes the hashmaps to be used in obtainAnswer() and distribution()
     */
    public VotingService(){
        studentAnswers = new HashMap<>();
        questionDistribution = new HashMap<>();
    }

    /**
     * Returns questionForm in terms of a QuestionForm type from Question Class
     * @return the questionForm in terms of either letters or WRONG_RIGHT
     */
    public QuestionForm getQuestionForm() {
        return question.getQuestionForm();
    }

    /**
     * Returns if question is a Single Choice question  true or false
     * @return question is single choice question (true/false)
     */
    public boolean SCQuestion() {
        return question instanceof SCQuestion;
    }

    /**
     * Sets the question in VotingService to the question passed into the method
     * @param question is passed into the method and set equal the question
     */
    public void constructQuestion(Question question) {
        this.question = question;
    }

    /**
     * Clears all of the hashmaps and question for the next question, answers, and distribution
     */
    public void clearAll() {
        question = null;
        studentAnswers = new HashMap<>();
        questionDistribution = new HashMap<>();
    }

    /**
     * This will accept the answer based on the student and answer that is passed
     * Hashmaps are used to make sure that the correct student ID and answer are changed and switched
     * @param student
     * @param ans
     */
    public void obtainAnswer(Student student, String ans) {
        if(studentAnswers.containsKey(student.getID())){ //the information checks for the student ID
            //insert a mapping into a map of StudentAnswers
            studentAnswers.put(student.getID(), ans);
            //print statement of student ID as well as the override answer message and if correct/incorrect
            System.out.println("Student " + student.getID() + " (override) resubmitted answer : " + ans +
                    (question.getQuestionAnswer().equals(ans) ? " [CORRECT!]" : " [INCORRECT...]"));
        }
        else {
            //assumes that the answer isn't being resubmitted
            studentAnswers.put(student.getID(), ans);
            //print statement of student ID and answer message and if correct/incorrect
            System.out.println("Student " + student.getID() + " submitted answer : " + ans +
                    (question.getQuestionAnswer().equals(ans) ? " [CORRECT!]" : " [INCORRECT...]"));
        }
    }

    /**
     * Uses hashmaps in order to find the amount of selected answers for each question form (letters or Right and Wrong)
     */
    public void distribution() {
        Iterator iteratorAnswers = studentAnswers.keySet().iterator();
        switch(question.getQuestionForm()) {
            case RIGHT_WRONG:
                //sets the information to 0 to count the total amount of right and wrong
                questionDistribution.put("RIGHT", 0);
                questionDistribution.put("WRONG", 0);
                //checks through each student answer
                while (iteratorAnswers.hasNext()){
                    Integer studentID = (Integer)iteratorAnswers.next(); //key of hashmap questionDistribution
                    String studentAns = studentAnswers.get(studentID); //key value of hashmap questionDistribution
                    //gets the count of each answer from the student
                    int questionDistributionVal = questionDistribution.get(studentAns);
                    //going to continue with next key value
                    questionDistribution.put(studentAns, questionDistributionVal + 1);
                }
                break;
            case LETTERS:
                //sets all letters to 0 to count total of each
                questionDistribution.put("A", 0);
                questionDistribution.put("B", 0);
                questionDistribution.put("C", 0);
                questionDistribution.put("D", 0);
                questionDistribution.put("E", 0);
                //checks through each student answer
                while (iteratorAnswers.hasNext()){
                    Integer studentID = (Integer)iteratorAnswers.next();
                    String studentAnswer = studentAnswers.get(studentID);
                    for (int i = 0; i < studentAnswer.length(); i++) {
                        String letter = Character.toString(studentAnswer.charAt(i)); //key of hashmap
                        int questionDistributionVal = questionDistribution.get(letter); //key value of hashmap
                        questionDistribution.put(letter, (questionDistributionVal + 1)); //going to next key values of letter
                    }
                }
                break;
        }
        //print the distribution of scores
        System.out.println("Distribution of Scores: ");
        Iterator distributionIterator = questionDistribution.keySet().iterator();
        //displays all info about distribution
        while (distributionIterator.hasNext()) {
            String ans = (String)distributionIterator.next(); //key of questionDistribution
            int amount = questionDistribution.get(ans); //key value questionDistribution
            System.out.println("(" + ans + ") : " + amount);
        }
    }
}
