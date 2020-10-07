public interface VotingServiceInterface {
    //creates the question in voting service
    public void constructQuestion(Question q);

    //gets all the students and their answers
    public void obtainAnswer(Student s, String ans);

    //used to get question type in voting service class (also in the student class)
    public QuestionForm getQuestionForm();

    //decides if the question is or isn't Single Choice
    public boolean SCQuestion();

    //finds the distribution of each answer
    public void distribution();

    //clears all data (hashmaps and question) to start new question
    public void clearAll();
}
