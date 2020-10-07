public class MCQuestion extends Question{
    //default constructor
    public MCQuestion(){
    }

    /**
     * Passed information to the Question Class and uses Letters since there can only be MC Ques. for option ABCDE
     * @param qDisplay questionDisplay in Question Class
     * @param qAns questionAnswer in Question Class
     */
    public MCQuestion(String qDisplay, String qAns){
        super(QuestionForm.LETTERS, qDisplay, qAns);
    }
}
