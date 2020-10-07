import java.util.Random;

public class SimulationDriver {
    public static void main (String[] args){
        //initialize the voting service to retrieve data of students
        VotingService votingService = new VotingService();
        //use random values in order to get a random # of students
        Random r = new Random();
        //10-20 students generated randomly
        int totalStudents = r.nextInt(10) + 10;
        //total # of students displayed
        System.out.println("Total number of students: " + totalStudents);
        //initializes array of students generated
        Student[] studentGroup = new Student[totalStudents];
        for(int i = 0; i < studentGroup.length; i++){
            studentGroup[i] = new Student(votingService); //creates students with unique ID's using the votingService
        }


        /** ~ Single Choice Question w/ RIGHT & WRONG or (T/F) ~ **/
        String question1 = "The girl added 5 pears and 2 apples to her bag. Should the girl have 8 fruits in her bag? \n" +
                "RIGHT\nWRONG";
        String questionAnswer1 = "WRONG";
        //Passing in all question form (Right or Wrong), question, correct answer
        Question rightAndWrongQ = new SCQuestion(QuestionForm.RIGHT_WRONG, question1, questionAnswer1);
        //passing in question to be initialized inside and used in VotingService
        votingService.constructQuestion(rightAndWrongQ);

        //printing questions and correct answer
        System.out.println("Single Choice Question (R&W/TF) : " + rightAndWrongQ.getQuestionDisplay());
        System.out.println("Correct Answer: " + rightAndWrongQ.getQuestionAnswer());

        //goes through each student and creates and submits/resubmits answers
        for(Student student : studentGroup){
            student.createAnswers(); //creates the possible answers given question type (form)
            student.enterAnswers(); //chances that the student resubmits and where submissions are received
        }

        votingService.distribution(); //find and print the final distribution of answers
        //2 lines below used for aesthetics for display
        System.out.println("");
        votingService.clearAll();



        /** ~ Single Choice Question w/ A, B, C, D, E (Letters) ~ **/
        String question2 = "What is 3! ? \nA)6 \tB)9 \tC)1 \tD)4 \tE)5";
        String questionAnswer2 = "A";
        //Passing in all question form (letters), question, correct answer
        Question singleChoiceQ = new SCQuestion(QuestionForm.LETTERS, question2, questionAnswer2);
        //passing in question to be initialized inside and used in VotingService
        votingService.constructQuestion(singleChoiceQ);

        //printing questions and correct answer
        System.out.println("Single Choice Question (Letters) :  " + singleChoiceQ.getQuestionDisplay());
        System.out.println("Correct Answer:  " + singleChoiceQ.getQuestionAnswer());

        //goes through each student and creates and submits/resubmits answers
        for(Student student : studentGroup){
            student.createAnswers(); //creates the possible answers given question type
            student.enterAnswers(); //chances that the student resubmits and where submissions are received
        }

        //find the distribution of scores and prints it out
        votingService.distribution();
        //2 lines below used for aesthetics for display
        System.out.println("");
        votingService.clearAll();



        /** ~ Multiple Choice Question w/ A, B, C, D, E ~ **/
        String question3 = "Which of the following are even numbers? \nA)1 \tB)2 \tC)3 \tD)5 \tE)8";
        String questionAnswer3 = "BD";
        //Passing in all question form (letters), question, correct answer
        Question multiChoiceQ = new MCQuestion(question3, questionAnswer3);
        //passing in question to be initialized inside and used in VotingService
        votingService.constructQuestion(multiChoiceQ);

        //printing questions and correct answer
        System.out.println("Multiple Choice Question (Letters) :  " + multiChoiceQ.getQuestionDisplay());
        System.out.println("Correct Answer:  " + multiChoiceQ.getQuestionAnswer());

        for(Student student : studentGroup){
            student.createAnswers(); //creates the possible answers given question type
            student.enterAnswers(); //chances that the student resubmits and where submissions are received
        }

        //find the distribution of scores and prints it out
        votingService.distribution();
        //2 lines below used for aesthetics for display
        System.out.println("");
        votingService.clearAll();



        /** ~ Another Multiple Choice Question w/ A, B, C, D, E ~ **/
        String question4 = "Which of the following are prime numbers? \nA)2 \tB)4 \tC)6 \tD)10 \tE)17";
        String questionAnswer4 = "AE";
        //Passing in all question form (letters), question, correct answer
        Question multiChoiceQ2 = new MCQuestion(question4, questionAnswer4);
        //passing in question to be initialized inside and used in VotingService
        votingService.constructQuestion(multiChoiceQ);

        //printing the question and correct answer
        System.out.println("Multiple Choice Question (Letters) :  " + multiChoiceQ2.getQuestionDisplay());
        System.out.println("Correct Answer:  " + multiChoiceQ.getQuestionAnswer());

        for(Student student : studentGroup){
            student.createAnswers(); //creates the possible answers given question type
            student.enterAnswers(); //chances that the student resubmits and where submissions are received
        }
        //find the distribution of scores and prints it out
        votingService.distribution();

        //End of program :)
        System.out.println("\n~ Thank you for running my program! ~ ");
    }
}
