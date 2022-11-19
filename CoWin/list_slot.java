import java.util.*;
import java.io.*;


class list_slot extends reg_hos
{
    list_slot() throws IOException, Exception 
    {
        super();
    }

    public void list(ArrayList<reg_hos> hos) throws IOException, Exception
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

                for(int j=0; j<i.day_num.length; j++)
                {
                    System.out.printf("Day: %d Vaccine: %s Available Qty: %d\n", i.day_num[j], i.vac_hos[j], i.quan_num[j]);
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