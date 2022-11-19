import java.util.*;
import java.io.*;

class book_slot extends reg_cit
{
    book_slot() throws IOException, Exception 
    {
        super();
    }

    public void book(ArrayList<add_vac> vac, ArrayList<reg_hos> hos, ArrayList<reg_cit> cit) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        long patient_id;

        int flag=1;

        System.out.print("Enter patient Unique ID: ");
        patient_id=s.nextLong();

        for(reg_cit i:cit)
        {
            if (i.cit_id==patient_id)
            {
                flag=1;

                int choice;

                System.out.print("1. Search by area\n2. Search by vaccine\n3. Exit\nEnter option: ");
                choice=s.nextInt();

                if (choice==1)
                {
                    int pin;

                    System.out.print("Enter PinCode: ");
                    pin=s.nextInt();

                    int pincheck=0;

                    for(reg_hos j:hos)
                    {
                        if (pin==j.pin_code)
                        {
                            pincheck++;

                            System.out.printf("%d %s\n", j.hos_id, j.hos_name);
                        }
                    }

                    if (pincheck==0)
                    {
                        System.out.println("Please enter a valid ID");

                        break;
                    }

                    int hospital_id;

                    System.out.print("Enter hospital id: ");
                    hospital_id=s.nextInt();

                    int hos_flag=1;

                    for (reg_hos z:hos)
                    {
                        if (z.hos_id==hospital_id)
                        {
                            hos_flag=1;

                            for(int k=0; k<(z.day_num).length; k++)
                            {
                                if(z.quan_num[k]>0)
                                {
                                    System.out.printf("%d-> Day: %d Availabe Qty: %d Vaccine: %s\n", k, z.day_num[k], z.quan_num[k], z.vac_hos[k]);
                                }
                            }

                            int choose;

                            System.out.print("Choose Slot: ");
                            choose=s.nextInt();

                            if((i.vac_stat.equals("NOT VACCINATED")||i.vac_stat.equals("PARTIALLY VACCINATED"))&&(i.day_vac==0||(z.day_num[choose]-i.day_vac>=(vac.get(choose)).gap)))
                            {
                                if (i.doses<vac.get(choose).num_dose)
                                {
                                    z.quan_num[choose]--;

                                    i.vac_used=z.vac_hos[choose];

                                    i.vac_stat="PARTIALLY VACCINATED";

                                    i.day_vac=z.day_num[choose];

                                    i.doses++;

                                    if (i.doses==vac.get(choose).num_dose)
                                    {
                                        i.vac_stat="FULLY VACCINATED";
                                    }

                                    System.out.printf("%s vaccinated with %s\n", i.cit_name, vac.get(choose).vac_name);
                                }
                            }
                            else
                            {
                                System.out.println("Please enter valid query");

                                break;
                            }
        
                            break;
                        }
                        else
                        {
                            hos_flag=0;
                        }
                    }

                    if (hos_flag==0)
                    {
                        System.out.println("Please enter a valid ID");
                    }
                }
                else if (choice==2)
                {
                    String vaccine_name_by_user;

                    s.nextLine();

                    System.out.print("Enter Vaccine name: ");
                    vaccine_name_by_user=s.nextLine();

                    int vac_check=1;

                    for(add_vac v:vac)
                    {
                        if(v.vac_name.equals(vaccine_name_by_user))
                        {
                            vac_check=1;

                            for(reg_hos h:hos)
                            {
                                for(int k=0; k<h.vac_hos.length; k++)
                                {
                                    if (vaccine_name_by_user.equals(h.vac_hos[k]))
                                    {
                                        System.out.printf("%d %s\n", h.hos_id, h.hos_name);
                                    }
                                }
                            }

                            int hospital_id;

                            System.out.print("Enter hospital id: ");
                            hospital_id=s.nextInt();

                            int id_check=1;

                            for(reg_hos h:hos)
                            {
                                if (h.hos_id==hospital_id)
                                {
                                    id_check=1;

                                    int x=0;

                                    for (int z=0; z<h.vac_hos.length; z++)
                                    {
                                        if(vaccine_name_by_user.equals(h.vac_hos[z]))
                                        {
                                            System.out.printf("%d-> Day: %d Availabe Qty: %d Vaccine: %s\n", z, h.day_num[z], h.quan_num[z], h.vac_hos[z]);
                                        }

                                        x++;
                                    }

                                    int choose;

                                    System.out.print("Choose Slot: ");
                                    choose=s.nextInt();
        
                                    if((i.vac_stat.equals("NOT VACCINATED")||i.vac_stat.equals("PARTIALLY VACCINATED"))&&(i.day_vac==0||(h.day_num[choose]-i.day_vac>=(vac.get(choose)).gap)))
                                    {
                                        if (i.doses<vac.get(choose).num_dose)
                                        {
                                            h.quan_num[choose]--;
        
                                            i.vac_used=h.vac_hos[choose];
        
                                            i.vac_stat="PARTIALLY VACCINATED";
        
                                            i.day_vac=h.day_num[choose];
        
                                            i.doses++;
        
                                            if (i.doses==vac.get(choose).num_dose)
                                            {
                                                i.vac_stat="FULLY VACCINATED";
                                            }
        
                                            System.out.printf("%s vaccinated with %s\n", i.cit_name, vac.get(choose).vac_name);
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Please enter valid query");
        
                                        break;
                                    }

                                    break;
                                }
                                else
                                {
                                    id_check=0;
                                }
                            }  

                            if (id_check==0)
                            {
                                System.out.println("Please enter valid id");
                            }

                            break;
                        }
                        else
                        {
                            vac_check=0;
                        }
                    }

                    if (vac_check==0)
                    {
                        System.out.println("Please enter valid vaccine");
                    }
                }
                else if (choice==3)
                {
                    break;
                }
                else
                {
                    System.out.println("Please enter a valid choice.");
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