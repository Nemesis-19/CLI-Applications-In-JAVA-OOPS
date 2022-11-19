import java.util.*;
import java.io.*;

public class reg_cit
{
    String cit_name;

    int age;

    long cit_id;

    int age_check=1;

    String vac_used;

    int doses=0;

    String vac_stat="NOT VACCINATED";

    int day_vac=0;

    reg_cit() throws IOException, java.lang.Exception
    {

    }

    public void cit_input(reg_cit c) throws IOException, java.lang.Exception
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Citizen Name: ");
        c.cit_name=s.nextLine();
        
        System.out.print("Age: ");
        c.age=s.nextInt();

        if(age<18)
        {
            c.age_check=0;
        }
        
        System.out.print("Unique ID: ");
        c.cit_id=s.nextLong();
    }
}