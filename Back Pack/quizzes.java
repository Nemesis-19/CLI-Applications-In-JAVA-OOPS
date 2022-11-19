import java.util.*;
import java.io.*;

interface q
{
    void quiz_input(quizzes qu, String name, int id_qu) throws IOException, Exception;   
}

public class quizzes implements q
{
    String statement;
    String prof_name;

    int marks=1;
    int open=1; 
    int qui_id;
    
    public void quiz_input(quizzes qu, String name, int id_qu) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Enter quiz question: ");
        qu.statement=s.nextLine();

        qu.qui_id=id_qu;

        qu.prof_name=name;
    }
}