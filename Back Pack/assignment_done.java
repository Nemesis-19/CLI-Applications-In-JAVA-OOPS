import java.util.*;
import java.io.*;

interface as_done
{
    void pending_ass_display(ArrayList<assignments> ass, ArrayList<assignment_done> ass_done, int id) throws IOException, Exception;

    void ass_sub(assignment_done asd, int choice, int id, String name) throws IOException, Exception;
}

public class assignment_done implements as_done
{
    String file_name;
    String ins_grade;
    String chi_name;

    int ass_id_done;
    int stu_id;
    int marks_obtained;
    int grade_flag=0;

    public void pending_ass_display(ArrayList<assignments> ass, ArrayList<assignment_done> ass_done, int id) throws IOException, Exception
    {
        for(assignments as:ass)
        {
            int flag_done=0;

            for(assignment_done j:ass_done)
            {
                if(as.ass_id==j.ass_id_done&&id==j.stu_id)
                {
                    flag_done=1;

                    break;
                }
            }

            if(flag_done==0)
            {
                System.out.printf("ID: %d Assignment: %s Max Marks: %d\n", as.ass_id, as.statement, as.marks);
            }
        }
    }

    public void ass_sub(assignment_done asd, int choice, int id, String name) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Enter filename of assignment: ");
        asd.file_name=s.nextLine();

        asd.ass_id_done=choice;
        asd.stu_id=id;
        asd.chi_name=name;
    }
}