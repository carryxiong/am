import sun.misc.VM;

import java.util.LinkedList;
import java.util.Scanner;

public class Yi {
    public void helper(LinkedList<String> list, String s)
    {
        int r=0;
        int l=0;
        boolean flag=false;
        while(r<s.length())
        {
            if(s.charAt(r)==' '&&flag==true)
            {
                String str=s.substring(l,r);
                list.push(str);
                flag=false;
                r++;
            }
            else if(s.charAt(r)==' '&&flag==false)
            {
                r++;
            }
            else if(s.charAt(r)!=' '&&flag==false)
            {
                flag=true;
                l=r;
                r++;
            }
            else
                r++;
        }
        if(flag)
            list.push(s.substring(l,r));
    }
    public static void main(String[] args) {
       /*String s="  ";
        Yi yi = new Yi();
        LinkedList<String> list=new LinkedList<>();
        yi.helper(list,s);
        System.out.println(list.isEmpty());*/
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(VM.maxDirectMemory()/1024/1024);

    }
}
