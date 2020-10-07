import java.util.Random;

public class Student implements StudentInterface{
    private int ID;
    private String questionAnswer; //this is the student's answer to the question
    private VotingService votingService;

    /**
     * Default constructor
     */
    public Student(){ }

    /**
     * Creates the student and the ID
     * @param votingService passed into Student
     */
    public Student(VotingService votingService){
        this.votingService = votingService;
        this.ID = this.hashCode(); //this randomly generates a unique and unrepeated code for the student
    }

    /**
     * Get the student ID
     * @return the student ID
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Creates answers based on the type of question form (type) and randomly generates those E
     */
    public void createAnswers() {
        //createAnswer String variable that allows for the
        String createAnswer = "";
        //gets the question form in votingService
        QuestionForm questionForm = votingService.getQuestionForm();
        //returns if the question is/isn't a single choice question
        boolean isSC = votingService.SCQuestion();
        switch(questionForm){
            case RIGHT_WRONG:
                Random r = new Random();
                //randomly chooses answers for a student's answers to be either right or wrong randomly
                createAnswer = createAnswer + (r.nextBoolean() ? "RIGHT" : "WRONG");
                break;
            case LETTERS:
                if(isSC){
                    String[] letters = {"A", "B", "C", "D", "E"}; //possible options for letters
                    Random random = new Random();
                    //random 0-4 indexes for the letters array
                    int randomIndex = random.nextInt(5);
                    //randomly creates answer based on random index in letters array
                    createAnswer += letters[randomIndex];
                }else{
                    //chooses random answer for the multiple choice letters (random for each letter)
                    Random rand = new Random();
                    createAnswer += (rand.nextBoolean() ? "A" : "");
                    createAnswer += (rand.nextBoolean() ? "B" : "");
                    createAnswer += (rand.nextBoolean() ? "C" : "");
                    createAnswer += (rand.nextBoolean() ? "D" : "");
                    createAnswer += (rand.nextBoolean() ? "E" : "");
                }
                break;
        }
        //sets the student's answer to the created answer from the switch statement
        this.questionAnswer = createAnswer;
    }

    /**
     * Enters answer or accepts changes to the answer based on a random selection (50%) of changing the answer
     */
    public void enterAnswers() {
        //retrieve the answer and student in order to enter/change the answer for the correct student
        votingService.obtainAnswer(this, this.questionAnswer);
        Random r = new Random();
        int num = r.nextInt(4); //0-3 values
        //if num = 3 or 4, the answer is changed to the other value (50% chance of changing answer)
        if(num == 3){
            createAnswers(); //allows for the answer to be resubmitted
            votingService.obtainAnswer(this, this.questionAnswer);
        }else if(num == 4){
            createAnswers(); //allows for the answer to be resubmitted
            votingService.obtainAnswer(this, this.questionAnswer);
        }
    }
}
