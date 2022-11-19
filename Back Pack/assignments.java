import java.util.*;
import java.io.*;

interface a
{
    public void ass_input(assignments as, String name, int id_as) throws IOException, Exception;
}

public class assignments implements a
{
    String statement;
    String prof_name;

    int marks;
    int open=1;
    int ass_id;

    public void ass_input(assignments as, String name, int id_as) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Enter problem statement: ");
        as.statement=s.nextLine();

        System.out.print("Enter max marks: ");
        as.marks=s.nextInt();

        as.ass_id=id_as;

        as.prof_name=name;
    }
}