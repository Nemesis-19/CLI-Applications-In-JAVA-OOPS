import java.util.*;
import java.io.*;

interface inst
{
    public void ins_input(instructor i, ArrayList<slides> sli, ArrayList<videos> vid, ArrayList<assignments> ass, ArrayList<quizzes> qui, ArrayList<assignment_done> ass_done, ArrayList<quizzes_done> qui_done, ArrayList<comments> com) throws IOException, Exception;
}

public class instructor implements inst
{
    instructor()
    {

    }

    public void ins_input(instructor i, ArrayList<slides> sli, ArrayList<videos> vid, ArrayList<assignments> ass, ArrayList<quizzes> qui, ArrayList<assignment_done> ass_done, ArrayList<quizzes_done> qui_done, ArrayList<comments> com) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        String[] ins_name={"I0", "I1"};

        System.out.print("Instructors:\n0 - I0\n1 - I1\nChoose id: ");

        int id=s.nextInt();

        while(true)
        {
            System.out.println("Welcome "+ins_name[id]);
            System.out.println("1. Add class material\n2. Add assessments\n3. View lecture materials\n4. View assessments");
            System.out.println("5. Grade assessments\n6. Close assessment\n7. View comments\n8. Add comments\n9. Logout");

            int i_choice=s.nextInt();

            if(i_choice==1)
            {
                System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");

                int m_choice=s.nextInt();

                if(m_choice==1)
                {
                    slides sl=new slides();

                    sl.sli_input(sl, ins_name[id]);
                    sli.add(sl);
                }
                else if(m_choice==2)
                {
                    videos vi=new videos();

                    vi.vid_input(vi, ins_name[id]);
                    vid.add(vi);
                }
                else
                {
                    System.out.println("Please enter valid input");
                }
            }
            else if(i_choice==2)
            {
                System.out.println("1. Add Assignment\n2. Add Quiz");

                int m_choice=s.nextInt();

                if(m_choice==1)
                {
                    assignments as=new assignments();

                    int id_as=ass.size()+qui.size();

                    as.ass_input(as, ins_name[id], id_as);
                    ass.add(as);
                }
                else if(m_choice==2)
                {
                    quizzes qu=new quizzes();

                    int id_qu=ass.size()+qui.size();

                    qu.quiz_input(qu, ins_name[id], id_qu);
                    qui.add(qu);
                }
                else
                {
                    System.out.println("Please enter valid input");
                }
            }
            else if(i_choice==3)
            {
                for(slides sl:sli)
                {
                    System.out.printf("Title: %s\n", sl.topic);

                    int j=1;

                    for(String st:sl.content)
                    {
                        System.out.printf("Slide %d: %s\n", j, st);

                        j++;
                    }

                    System.out.printf("Number of slides: %d\nDate of upload: %s\nUploaded by: %s\n", sl.num_slides, sl.date.toString(), sl.ins_upload);

                    System.out.println("");
                }

                for(videos vi:vid)
                {
                    System.out.printf("Title of video: %s\nVideo file: %s\nDate of upload: %s\nUploaded by: %s\n", vi.vid_topic, vi.file_name, vi.date.toString(), vi.ins_upload);

                    System.out.println("");
                }
            }
            else if(i_choice==4)
            {
                for(assignments as:ass)
                {
                    System.out.printf("ID: %d Assignment: %s Max Marks: %d\n", as.ass_id, as.statement, as.marks);

                    System.out.println("----------------");
                }

                for(quizzes qu:qui)
                {
                    System.out.printf("ID: %d Question: %s\n", qu.qui_id, qu.statement);

                    System.out.println("----------------");
                }
            }
            else if(i_choice==5)
            {
                System.out.println("List of assessments");

                for(assignments as:ass)
                {
                    System.out.printf("ID: %d Assignment: %s Max Marks: %d\n", as.ass_id, as.statement, as.marks);

                    System.out.println("----------------");
                }

                for(quizzes qu:qui)
                {
                    System.out.printf("ID: %d Question: %s\n", qu.qui_id, qu.statement);

                    System.out.println("----------------");
                }

                System.out.print("Enter ID of assessment to view submissions: ");
                int choice=s.nextInt();

                System.out.println("Choose ID from these ungraded submissions");

                for(assignment_done asd:ass_done)
                {
                    if(asd.ass_id_done==choice)
                    {
                        System.out.printf("%d. %s\n", asd.stu_id, asd.chi_name);
                    }
                }

                for(quizzes_done qud:qui_done)
                {
                    if(qud.qui_id_done==choice)
                    {
                        System.out.printf("%d. %s\n", qud.stu_id, qud.chi_name);
                    }
                }

                int chosen=s.nextInt();

                System.out.println("Submission");

                for(assignment_done asd:ass_done)
                {
                    if(asd.ass_id_done==choice&&asd.stu_id==chosen)
                    {
                        System.out.printf("Submission: %s\n", asd.file_name);

                        System.out.println("----------------");
                    }
                }

                for(quizzes_done qud:qui_done)
                {
                    if(qud.qui_id_done==choice&&qud.stu_id==chosen)
                    {
                        System.out.printf("Submission: %s\n", qud.ans);

                        System.out.println("----------------");
                    }
                }

                for(assignments as:ass)
                {
                    if(as.ass_id==choice)
                    {
                        System.out.printf("Max Marks: %d\n", as.marks);
                    }
                }

                System.out.print("Marks scored: ");
                int marks_ob=s.nextInt();

                for(assignment_done asd:ass_done)
                {
                    if(asd.ass_id_done==choice&&asd.stu_id==chosen)
                    {
                        asd.marks_obtained=marks_ob;

                        asd.ins_grade=ins_name[id];

                        asd.grade_flag=1;
                    }
                }

                for(quizzes_done qud:qui_done)
                {
                    if(qud.qui_id_done==choice&&qud.stu_id==chosen)
                    {
                        qud.marks_obtained=marks_ob;

                        qud.ins_grade=ins_name[id];

                        qud.grade_flag=1;
                    }
                }                
            }
            else if(i_choice==6)
            {
                System.out.println("List of Open Assignments:");

                for(assignments as:ass)
                {
                    if(as.open==1)
                    {
                        System.out.printf("ID: %d Assignment: %s Max Marks: %d\n", as.ass_id, as.statement, as.marks);

                        System.out.println("----------------");
                    }
                }

                for(quizzes qu:qui)
                {
                    if(qu.open==1)
                    {
                        System.out.printf("ID: %d Question: %s\n", qu.qui_id, qu.statement);

                        System.out.println("----------------");
                    }
                }
                
                System.out.print("Enter id of assignment to close: ");
                int choice=s.nextInt();

                for(assignments as:ass)
                {
                    if(as.ass_id==choice)
                    {
                        as.open=0;
                    }
                }

                for(quizzes qu:qui)
                {
                    if(qu.qui_id==choice)
                    {
                        qu.open=0;
                    }
                }
            }
            else if(i_choice==7)
            {
                for(comments c:com)
                {
                    System.out.printf("%s - %s\n%s\n\n", c.body, c.name, c.date.toString());
                }
            }
            else if(i_choice==8)
            {
                comments c=new comments();

                c.input(c, ins_name[id]);

                com.add(c);
            }
            else if(i_choice==9)
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