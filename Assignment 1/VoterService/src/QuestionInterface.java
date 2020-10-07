public interface QuestionInterface {

    //gets the question message from the main class that is displayed to the students
    public String getQuestionDisplay();

    //gets the question answer
    public String getQuestionAnswer();

    //get the question type in terms of RIGHT_WRONG or LETTER form
    public QuestionForm getQuestionForm();

}
