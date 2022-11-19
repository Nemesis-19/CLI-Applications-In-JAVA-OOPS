import java.util.*;
import java.io.*;

public class add_vac
{
    String vac_name;

    int num_dose;
    int gap;

    Scanner s=new Scanner(System.in);

    add_vac() throws IOException, java.lang.Exception
    {
        System.out.print("Vaccine Name: ");
        vac_name=s.nextLine();
        
        System.out.print("Number of Doses: ");
        num_dose=s.nextInt();

        if (num_dose!=1)
        {
            System.out.print("Gap between Doses: ");
            gap=s.nextInt();
        }
        else
        {
            gap=0;
        }
    }
}