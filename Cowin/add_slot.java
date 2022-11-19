import java.util.*;
import java.io.*;

public class add_slot extends reg_hos
{
    add_slot() throws IOException, Exception 
    {
        super();
    }

    public void input_slot(ArrayList<reg_hos> hos, ArrayList<add_vac> vac) throws IOException, java.lang.Exception
    {
        Scanner s=new Scanner(System.in);

        int hos_id;

        int flag=1;

        System.out.print("Enter Hospital ID: ");
        hos_id=s.nextInt();

        for(reg_hos i:hos)
        {
            if (i.hos_id==hos_id)
            {
                flag=1;

                System.out.print("Enter number of Slots to be added: ");
                int num_slot=s.nextInt();

                i.set_day_num(num_slot);
                i.set_quan_num(num_slot);
                i.set_vac_hose(num_slot);

                for(int j=0; j<num_slot; j++)
                {
                    System.out.print("Enter Day Number (greater than 0): ");
                    i.day_num[j]=s.nextInt();

                    System.out.print("Enter Quantity (greater than 0): ");
                    i.quan_num[j]=s.nextInt();

                    System.out.println(("Select Vaccine"));

                    int x=0;

                    for(add_vac v:vac)
                    {
                        System.out.printf("%d. %s\n",x, v.vac_name);

                        x++;
                    }

                    s.nextLine();

                    int choice;

                    choice=s.nextInt();

                    i.vac_hos[j]=(vac.get(choice)).vac_name;

                    int vac_check=1;

                    for(add_vac v:vac)
                    {
                        if (i.vac_hos[j].equals(v.vac_name))
                        {
                            vac_check=1;

                            System.out.printf("Slot added by Hospital %d for Day: %d, Available Quantity: %d of Vaccine %s\n", i.hos_id, i.day_num[j], i.quan_num[j], i.vac_hos[j]);

                            break;
                        }
                        else
                        {
                            vac_check=0;
                        }
                    }

                    if (vac_check==0)
                    {
                        num_slot=0;

                        for(int z:i.day_num)
                        {
                            z=0;
                        }

                        for(int z:i.quan_num)
                        {
                            z=0;
                        }

                        for(String z:i.vac_hos)
                        {
                            z="";
                        }

                        System.out.println("Please enter valid vaccine");

                        break;
                    }
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