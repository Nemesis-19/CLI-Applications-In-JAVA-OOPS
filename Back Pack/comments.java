import java.util.*;
import java.io.*;

interface comm
{
    void input(comments c, String n) throws IOException, Exception;
}

public class comments implements comm
{
    String body;
    String name;

    Date date=new Date();

    public void input(comments c, String n) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Enter comment: ");
        c.body=s.nextLine();
        c.name=n;
        c.date=date;
    }
}