public interface StudentInterface {
    //returns the ID of the student
    public int getID();

    //Uses this to submit answers for students [Used in VotingService]
    public void enterAnswers();

    //Creates answers that match the questionForm: Letters or right_wrong
    public void createAnswers();
}
