import java.util.ArrayList;
import java.util.List;

public class Divid
{


    public static void main (String [] args)
    {
        String text = "WENNHINTERGRIECHENGRIECHENKRIECHENKRIECHENGRIECHENGRIECHENNACH";
        int keyLength = 4;

        StringBuilder[] builders = new StringBuilder[keyLength];

        for (int i=0; i<keyLength;i++)
        {
            builders[i] = new StringBuilder();
        }
        int j=0;
        for (int i=0;i<text.length();i++)
        {

            if (j==keyLength)
            {
                j=0;
                builders[j].append(text.charAt(i));
                j++;
            }
            else
            {
                builders[j].append(text.charAt(i));
                j++;
            }

        }
        for (int i=0;i<builders.length; i++)
        {
            System.out.println("StringBuilder " + i + ": " + builders[i].toString());
        }














        /*
        List<String> lines = new ArrayList<>();

        for (int i=0; i<text.length();i=i+keyLength)
        {
            String out = text.substring(i, i+ keyLength);
            lines.add(out);

           // System.out.println(out);
        }
        String [][] diagramm = new String [lines.size()][keyLength];

        for (String value : lines)
        {
            for (int i=0;i<keyLength;i++)
            {
                diagramm [lines.indexOf(value)][i] = value.substring(i,i+1);
                //System.out.println(value.substring(i,i+1));
            }
        }

        for(int i=0;i< diagramm[i].length;i++)
        {
            for (int j=0;j<diagramm.length;j++)
            {
                if (diagramm[j][i] != null)
                {
                    System.out.print(diagramm[j][i]);
                }
            }
            System.out.println();
        }

         */
    }

}


//morpheus
