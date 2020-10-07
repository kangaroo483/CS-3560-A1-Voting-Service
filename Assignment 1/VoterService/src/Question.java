public abstract class Question implements QuestionInterface {
    private QuestionForm questionForm;  //gets the question in terms of true false or letters
    private String questionAnswer; //the answer to the question
    private String questionDisplay; //displays the question for the user

    /**
     *Default constructor
     */
    public Question(){
    }

    /**
     *Sets the passed in parameters to the private variables in this class
     */
    public Question(QuestionForm questionForm, String questionDisplay, String questionAnswer){
        this.questionForm = questionForm;
        this.questionDisplay = questionDisplay;
        this.questionAnswer = questionAnswer;
    }

    /**
     * Gets the question format
     * @return the question form in terms of enum letters or right wrong
     */
    public QuestionForm getQuestionForm(){
        return this.questionForm;
    }

    /**
     * Sets the question format
     * @param questionForm
     */
    public void setQuestionForm(QuestionForm questionForm){
        this.questionForm = questionForm;
    }

    /**
     *
     * @return the string that is going to be displayed in the terminal
     */
    public String getQuestionDisplay(){
        return this.questionDisplay;
    }

    /**
     * Sets the question display
     * @param questionDisplay
     */
    public void setQuestionDisplay(String questionDisplay){
        this.questionDisplay = questionDisplay;
    }

    /**
     *
     * @return the question answer
     */
    public String getQuestionAnswer(){
        return this.questionAnswer;
    }

    /**
     * Sets the question answer
     * @param questionAnswer
     */
    public void setQuestionAnswer(String questionAnswer){
        this.questionAnswer = questionAnswer;
    }
}


