import java.util.*;
import java.io.*;
import java.lang.Math;

public class reg_hos
{
    String hos_name;

    int pin_code;
    int hos_id;

    int day_num[];

    void set_day_num(int n)
    {
        day_num=new int[n];
    }

    int quan_num[];

    void set_quan_num(int n)
    {
        quan_num=new int[n];
    }

    String vac_hos[];

    void set_vac_hose(int n)
    {
        vac_hos=new String[n];
    }

    public void hos_input(reg_hos hos) throws IOException, java.lang.Exception
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Hospital Name: ");
        hos.hos_name=s.nextLine();
        
        System.out.print("PinCode: ");
        hos.pin_code=s.nextInt();

        hos.hos_id=(int)(Math.random()*(999999-100000+1)+100000);
    }
}