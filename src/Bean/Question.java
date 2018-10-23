
package Bean;

/**
 *
 * @author Noman
 */
public class Question {
    private String srno;
    private String question;
    private String answer;

    public Question() {
    }

    
    public Question(String srno, String question, String answer) {
        this.srno = srno;
        this.question = question;
        this.answer = answer;
    }

    public String getSrno() {
        return srno;
    }

    public void setSrno(String srno) {
        this.srno = srno;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
    
}
