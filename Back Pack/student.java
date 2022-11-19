import java.util.*;
import java.io.*;

interface stu
{
    public void stu_input(student st, ArrayList<slides> sli, ArrayList<videos> vid, ArrayList<assignments> ass, ArrayList<quizzes> qui, ArrayList<assignment_done> ass_done, ArrayList<quizzes_done> qui_done, ArrayList<comments> com) throws IOException, Exception;
}

public class student implements stu
{
    student()
    {

    }

    public void stu_input(student st, ArrayList<slides> sli, ArrayList<videos> vid, ArrayList<assignments> ass, ArrayList<quizzes> qui, ArrayList<assignment_done> ass_done, ArrayList<quizzes_done> qui_done, ArrayList<comments> com) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        String[] stu_name={"S0", "S1", "S2"};

        System.out.print("Students:\n0 - S0\n1 - S1\n2 - S2\nChoose id: ");

        int id=s.nextInt();

        while(true)
        {
            System.out.println("Welcome "+stu_name[id]);
            System.out.println("1. View lecture materials\n2. View assessments\n3. Submit assessment");
            System.out.println("4. View grades\n5. View comments\n6. Add comments\n7. Logout");

            int st_choice=s.nextInt();

            if(st_choice==1)
            {
                for(slides sl:sli)
                {
                    System.out.printf("Title: %s\n", sl.topic);

                    int j=1;

                    for(String str:sl.content)
                    {
                        System.out.printf("Slide %d: %s\n", j, str);

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
            else if(st_choice==2)
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
            else if(st_choice==3)
            {
                int count=0;

                for(assignment_done asd:ass_done)
                {
                    if(asd.stu_id==id)
                    {
                        count++;
                    }
                }

                for(quizzes_done qud:qui_done)
                {
                    if(qud.stu_id==id)
                    {
                        count++;
                    }
                }

                if(count==ass.size()+qui.size())
                {
                    System.out.println("No pending assessments");
                }
                else
                {
                    System.out.println("Pending assessments");

                    assignment_done asd=new assignment_done();

                    quizzes_done qud=new quizzes_done();

                    asd.pending_ass_display(ass, ass_done, id);

                    qud.pending_qui_display(qui, qui_done, id);

                    System.out.print("Enter ID of assessment: ");
                    int choice=s.nextInt();

                    for(assignments as:ass)
                    {
                        if(as.ass_id==choice)
                        {
                            asd.ass_sub(asd, choice, id, stu_name[id]);

                            int num=asd.file_name.length();

                            if(asd.file_name.charAt(num-4)=='.'&&asd.file_name.charAt(num-3)=='z'&&asd.file_name.charAt(num-2)=='i'&&asd.file_name.charAt(num-1)=='p')
                            {
                                ass_done.add(asd);

                                break;
                            }
                            else
                            {
                                System.out.println("Please enter valid input");
                            }
                        }
                    }

                    for(quizzes qu:qui)
                    {
                        if(qu.qui_id==choice)
                        {
                            System.out.print(qu.statement+" ");

                            qud.qui_sub(qud, choice, id, stu_name[id]);

                            qui_done.add(qud);

                            break;
                        }
                    }
                }
            }
            else if(st_choice==4)
            {
                assignment_done asd=new assignment_done();

                quizzes_done qud=new quizzes_done();

                System.out.println("Graded submissions");
                
                for(assignment_done ad:ass_done)
                {
                    if(ad.stu_id==id&&ad.grade_flag==1)
                    {
                        System.out.printf("Submission: %s\nMarks scored: %d\nGraded by: %s\n", ad.file_name, ad.marks_obtained, ad.ins_grade);
                        
                        System.out.println("----------------");
                    }
                }

                for(quizzes_done qd:qui_done)
                {
                    if(qd.stu_id==id&&qd.grade_flag==1)
                    {
                        System.out.printf("Answer: %s\nMarks scored: %d\nGraded by: %s\n", qd.ans, qd.marks_obtained, qd.ins_grade);

                        System.out.println("----------------");
                    }
                }

                System.out.println("\nUngraded submissions");

                for(assignment_done ad:ass_done)
                {
                    if(ad.stu_id==id&&ad.grade_flag==0)
                    {
                        System.out.printf("Submission: %s\n", ad.file_name);
                        
                        System.out.println("----------------");
                    }
                }

                for(quizzes_done qd:qui_done)
                {
                    if(qd.stu_id==id&&qd.grade_flag==0)
                    {
                        System.out.printf("Answer: %s\n", qd.ans);

                        System.out.println("----------------");
                    }
                }                
            }
            else if(st_choice==5)
            {
                for(comments c:com)
                {
                    System.out.printf("%s - %s\n%s\n\n", c.body, c.name, c.date.toString());
                }
            }
            else if(st_choice==6)
            {
                comments c=new comments();

                c.input(c, stu_name[id]);

                com.add(c);
            }
            else if(st_choice==7)
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