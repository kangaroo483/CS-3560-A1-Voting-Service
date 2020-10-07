/**
 * Single Choice Question Class
 */
public class SCQuestion extends Question{
    //default constructor
    public SCQuestion(){
    }

    /**
     * Passed question type, display, answer to the Question Class
     * The questionForm cannot be directly identified since SC Questions can be either letters or T/F
     * @param qForm questionForm in Question Class
     * @param qDisplay questionDisplay in Question Class
     * @param qAns questionAnswer in Question Class
     */
    public SCQuestion(QuestionForm qForm, String qDisplay, String qAns){
        super(qForm, qDisplay, qAns);
    }
}
