import java.util.*;
import java.io.*;

public class main_class
{
    public static void main(String[] args) throws IOException, Exception
    {
        Scanner s=new Scanner(System.in);

        int num;

        ArrayList<add_vac> vac=new ArrayList<>();
        ArrayList<reg_cit> cit=new ArrayList<>();
        ArrayList<reg_hos> hos=new ArrayList<>();
        
        System.out.println("CoWin Portal initialized....");

        while(true)
        {
            System.out.println("--------------------------------");
            System.out.println("1. Add Vaccine\n2. Register Hospital\n3. Register Citizen\n4. Add Slot for Vaccination");
            System.out.println(("5. Book Slot for Vaccination\n6. List all slots for a hospital\n7. Check Vaccination Status\n8. Exit"));
            System.out.println("--------------------------------");
            
            num=s.nextInt();

            if (num==1)
            {
                add_vac v=new add_vac();

                int flag=1;

                s.nextLine();

                for(add_vac i:vac)
                {
                    if (i.vac_name.equals(v.vac_name))
                    {
                        flag=0;

                        break;
                    }
                }

                if (flag==0)
                {
                    System.out.println("Please enter a valid Vaccine");
                }
                else
                {
                    vac.add(v);

                    System.out.printf("Vaccine Name: %s, Number of Doses: %d, Gap Between Doses: %d\n", v.vac_name, v.num_dose, v.gap);
                }
            }
            else if (num==2)
            {
                reg_hos h=new reg_hos();

                h.hos_input(h);

                int flag=1;

                for(reg_hos i:hos)
                {
                    if (i.hos_name.equals(h.hos_name))
                    {
                        if (i.pin_code==h.pin_code)
                        {
                            flag=0;

                            break;
                        }
                    }
                }
                if (flag==0)
                {
                    System.out.println("Please enter a valid PinCode");
                }
                else
                {
                    hos.add(h);

                    System.out.printf("Hospital Name: %s, PinCode: %d, Unique ID: %d\n", h.hos_name, h.pin_code, h.hos_id);
                }
            }
            else if (num==3)
            {
                reg_cit r=new reg_cit();

                r.cit_input(r);

                int flag=1;

                for (reg_cit i:cit)
                {
                    if (i.cit_id==r.cit_id)
                    {
                        flag=0;
                        
                        break;
                    }
                }

                if (flag==0)
                {
                    System.out.println("Please enter a valid ID");
                }
                else
                {
                    cit.add(r);

                    System.out.printf("Citizen Name: %s, Age: %d, Unique ID: %d\n", r.cit_name, r.age, r.cit_id);

                    if (r.age<18)
                    {
                        System.out.println("Only above 18 are allowed");
                    }
                }
            }
            else if (num==4)
            {
                add_slot a=new add_slot();

                a.input_slot(hos, vac);
            }
            else if (num==5)
            {
                book_slot b=new book_slot();

                b.book(vac, hos, cit);
            }
            else if (num==6)
            {
                list_slot l=new list_slot();
                
                l.list(hos);
            }
            else if (num==7)
            {
                check_stat c=new check_stat();

                c.check(vac, cit);
            }
            else if (num==8)
            {
                break;
            }
            else
            {
                System.out.println("Please enter valid input");
            }
        }
    }
}