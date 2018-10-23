
package DbConnection;


import Bean.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SQLiteQueries {
	   static  String url = "jdbc:sqlite:D:\\Extras\\EnterpriseTest\\FifaChatBotByNoman\\test.db";;
    public static void createNewTable() throws SQLException {
        // SQLite connection string
    
          
            String QuestionAndAnswer = "CREATE TABLE IF NOT EXISTS QuestionAndAnswer (\n"
               + "	id integer PRIMARY KEY,\n"
                + "	Question text NOT NULL,\n"
                + "	Answer text NOT NULL\n"
                + ");";
//         
       
          
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        try  {
            // create a new table
            stmt.execute(QuestionAndAnswer);
            System.out.println("QuestionAndAnswer Table Created"); 
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            conn.close();
        }
      
    }
     
    public void InsertQuestionAnswer(Question fb) throws SQLException{
        ResultSet rs=null;
        int sr=0;

        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        
        String getid="select max(id) from QuestionAndAnswer";
        
        rs=stmt.executeQuery(getid);
        if(rs.next())
        {
            sr=rs.getInt(1);
        }
        sr=sr+1;
        String query = "INSERT INTO QuestionAndAnswer(id,Question,Answer) VALUES('"+sr+"','"+fb.getQuestion()+"','"+fb.getAnswer()+"')";
        try  {
            // create a new table
            stmt.executeUpdate(query);
            System.out.println("New Record Inserted");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            conn.close();
        }
    }
    
     public ArrayList<Question> GetAllQuestionAnswer() throws SQLException{
         
         ArrayList<Question> question=new ArrayList<>();
 
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        String query = "select * from QuestionAndAnswer";
        try  {
            // create a new table
            ResultSet rs=stmt.executeQuery(query);
            System.out.println("Record Fetched");
            
            while (rs.next()) {
                Question q=new Question();
                q.setSrno(rs.getString(1));
                q.setQuestion(rs.getString(2));
                q.setAnswer(rs.getString(3));
                question.add(q);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            conn.close();
        }
        return question;
    }
     public String GetAnswerByID(String id) throws SQLException{
         String answer="";
         Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        String query = "select answer from QuestionAndAnswer where id="+id+" ";
        try  {
            // create a new table
            ResultSet rs=stmt.executeQuery(query);
            System.out.println("Record Fetched");
            
            while (rs.next()) {
                answer=rs.getString("Answer");
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            conn.close();
        }
        return answer;
    }
    
     
          public String GetAnswerByID1(String id) throws SQLException{
         String question="";
         
 
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        String query = "select Question from QuestionAndAnswer where id="+id+" ";
        try  {
            // create a new table
            ResultSet rs=stmt.executeQuery(query);
            System.out.println("Record Fetched");
            
            while (rs.next()) {
                question=rs.getString("Question");
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            conn.close();
        }
        return question;
    }
    
    
    public static void DropTable() throws SQLException{
 
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        try  {
            // create a new table
                      
            String DropRegistration = "Drop table Registration;";
            stmt.execute(DropRegistration);
            System.out.println("Registration Table Dropped");
            
            String DropFeedback = "Drop table Feedback;";
            stmt.execute(DropFeedback);
            System.out.println("Feedback Table Dropped");
            
            String DropSetting = "Drop table Setting;";
            stmt.execute(DropSetting);
            System.out.println("Setting Table Dropped");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        finally{
            conn.close();
        }
        
    }
    
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        DropTable();
       createNewTable();
//        InsertIntoTable("3","Monika","23");
 

    }

    
}
