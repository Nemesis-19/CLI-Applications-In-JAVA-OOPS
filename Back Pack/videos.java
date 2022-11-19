import java.util.*;
import java.io.*;

interface vide
{
    public void vid_input(videos vi, String name) throws IOException, Exception;
}

public class videos implements vide
{
    String vid_topic;
    String file_name;
    String ins_upload;

    Date date=new Date();

    public void vid_input(videos vi, String name) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Enter topic of video: ");
        vi.vid_topic=s.nextLine();

        System.out.print("Enter filename of video: ");
        vi.file_name=s.nextLine();

        vi.ins_upload=name;
        vi.date=date;
    }
}