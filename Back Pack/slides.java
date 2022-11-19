import java.util.*;
import java.io.*;

interface slid
{
    void sli_input(slides sl, String name) throws IOException, Exception;
}

public class slides implements slid
{
    String topic;

    int num_slides;

    String[] content=new String[num_slides];

    String ins_upload;

    Date date=new Date();

    public void sli_input(slides sl, String name) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Enter topic of slides: ");
        sl.topic=s.nextLine();

        System.out.print("Enter number of slides: ");
        sl.num_slides=s.nextInt();

        sl.content=new String[sl.num_slides];

        System.out.println("Enter content of slides");

        s.nextLine();

        for(int i=0; i<sl.num_slides; i++)
        {
            System.out.printf("Content of slide %d: ", i+1);
            sl.content[i]=s.nextLine();
        }

        sl.ins_upload=name;
        sl.date=date;
    }
}