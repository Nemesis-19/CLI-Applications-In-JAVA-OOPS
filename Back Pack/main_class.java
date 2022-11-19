import java.util.*;
import java.io.*;

public class main_class
{
    public static void main(String [] args) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        ArrayList<slides> sli=new ArrayList<>();
        ArrayList<videos> vid=new ArrayList<>();
        ArrayList<assignments> ass=new ArrayList<>();
        ArrayList<quizzes> qui=new ArrayList<>();
        ArrayList<assignment_done> ass_done=new ArrayList<>();
        ArrayList<quizzes_done> qui_done=new ArrayList<>();
        ArrayList<comments> com=new ArrayList<>();

        int choice;

        while(true)
        {
            System.out.println("Welcome to Backpack\n1. Enter as instructor\n2. Enter as student\n3. Exit");

            choice=s.nextInt();

            if(choice==1)
            {
                instructor i=new instructor();

                i.ins_input(i, sli, vid, ass, qui, ass_done, qui_done, com);
            }
            else if(choice==2)
            {
                student st=new student();

                st.stu_input(st, sli, vid, ass, qui, ass_done, qui_done, com);
            }
            else if(choice==3)
            {
                break;
            }
            else
            {
                System.out.println("Please enter valid input");
            }
        }
    }
}