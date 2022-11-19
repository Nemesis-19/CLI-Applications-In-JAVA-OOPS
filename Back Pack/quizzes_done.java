import java.util.*;
import java.io.*;

interface q_don
{
    void pending_qui_display(ArrayList<quizzes> qui, ArrayList<quizzes_done> qui_done, int id);

    void qui_sub(quizzes_done qud, int choice, int id, String name);   
}

public class quizzes_done 
{
    String ans;
    String ins_grade;
    String chi_name;

    int qui_id_done;
    int stu_id;
    int marks_obtained;
    int grade_flag=0;

    public void pending_qui_display(ArrayList<quizzes> qui, ArrayList<quizzes_done> qui_done, int id)
    {
        for(quizzes qu:qui)
        {
            int flag_done=0;

            for(quizzes_done j:qui_done)
            {
                if(qu.qui_id==j.qui_id_done&&id==j.stu_id)
                {
                    flag_done=1;

                    break;
                }
            }

            if(flag_done==0)
            {
                System.out.printf("ID: %d Question: %s\n", qu.qui_id, qu.statement);
            }
        }
    }

    public void qui_sub(quizzes_done qud, int choice, int id, String name)
    {
        Scanner s=new Scanner(System.in);

        ans=s.nextLine();

        qud.qui_id_done=choice;
        qud.stu_id=id;
        qud.chi_name=name;
    }
}