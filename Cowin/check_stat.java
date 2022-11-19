import java.util.*;
import java.io.*;

class check_stat extends reg_cit
{
    check_stat() throws IOException, Exception 
    {
        super();
    }

    public void check(ArrayList<add_vac> vac, ArrayList<reg_cit> cit) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        long patient_id;

        System.out.print("Enter patient Unique ID: ");
        patient_id=s.nextLong();

        int flag=1;

        for (reg_cit c:cit)
        {
            if(c.cit_id==patient_id)
            {
                flag=1;

                if (c.vac_stat.equals("NOT VACCINATED"))
                {
                    System.out.println("Citizen REGISTERED");
                }
                else if(c.vac_stat.equals("PARTIALLY VACCINATED"))
                {
                    for(add_vac v:vac)
                    {
                        if(c.vac_used.equals(v.vac_name))
                        {
                            System.out.printf("%s\nVaccine Given: %s\nNumber of Doses given: %d\nNext Dose due date: %d\n", c.vac_stat, c.vac_used, c.doses, (c.day_vac+v.gap));
                        }
                    }
                }
                else
                {
                    System.out.printf("%s\nVaccine Given: %s\nNumber of Doses given: %d\n", c.vac_stat, c.vac_used, c.doses);
                }

                break;
            }
            else
            {
                flag=0;
            }
        }

        if (flag==0)
        {
            System.out.println("Please enter a valid ID");
        }  
    }
}