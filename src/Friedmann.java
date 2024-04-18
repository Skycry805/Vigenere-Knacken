import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Friedmann
{
    public static void main (String [] args)
    {
        String text = "LWFCOSYJYWTWHRYKUGKLHLLOMGMXLPYNABVJJLAWTCVGALUTQBUXLQUKOVZCLRBSNSETPRYPMFDTLEOXSSJILPFLGBULHIBJQBUXJLBAQFJEYIWZQBRTOILLEWTWKMYKQOIBLIOFESITYBMLMRKVSEOTFAZGDIHFUQYTBGBKMUVLPVBSNSETPRYOUFBAPGBKOVNTYITWUHMDYYHKMPVGEAYFZKZGKELSGTMDYFYJQWKTAWYAZKFASIHXPOECTYYKESELPVTMQFJIBRMWDSRCNWNVMJFGEEVDQUVCPGBKFSYTOMYJVSKOAZIJQITWCSYDXWXPUKMLRFVXDMYKASKLHAYAXWTWHRYLIOJMNPUMNSLCKMBJZWTWARYAZWTWZXYZQVZTYSBFQOEVZXQWUZZROINOMGEXJLNNQFXTZWYFTOSTEMWZTOSTUMWZFJVGNIMKQBUPZWCUTBZROXBAQFSXUAYYQBUTZAYYQGUTYZIJYWIAPIALECESLVHPISXTUHYKISXTZHYJNSITPXMZUBKTYQCJXWVVAMWZTOSTUMWZFJVGNIMKQBUPZWQADPVGLMNKJGVXALOFPSIIQEBJQBXTNIHVUSJTTEMUTWETUOUWYDWTUMWZTOSTUMWZFJVGNIMKQBUPZWMAQLJTPXBMZRVGANUZDSEXOVYSDAVTUWWZUQBTUYGMZGQJGILKFCVGLROFPBRROICFQAAPOVBMZRVGABXWEYIXLKYKTOSTPGBFUQYICILYQGJTUAUKPOJLPGBLUUJILMMLIWIHPRXFAQYWPILDMGJIBRMPTSLILRUUTHUXLWYJMFDTLZIFTWVGHYMWUBVQVXMUTOWIZGBAOYVCSEMKFIEHOIOLQBRROXRVUSJTOSYZXSEOBQYJLWKILVHTDWEVLRBWGHVCHGBLISISLRQADRZTZIBSXZVCHYMWDRVMZXUZXIESZXYAZSIQLFYFXOJHLRMAQGFASIHMZGYDLVYFHCDGVXYFWSICIMMRGAJROAUJLSEMOMGEQZYTBXYFMQYIDILVQBNXYHUXGSIHVVAWZRRHZWCWZWVBHPMNQFXTZWYFPOJXZXTAABLCKBQADVRQLREWUBVPUKML";

        Map<Character,Integer> alphabet = count(text);
        List <Integer> zerg = addValues(alphabet);


        double indexC = calcIndex(zerg,text);
        System.out.println(indexC);
        System.out.println(calcKeyLength(indexC,text.length()));

    }

    // clac the length of the key
    public static double calcKeyLength (double indexC, int textLength)
    {
        double indexD = 0.0762;
        double indexZ = 0.0385;
        double help1 = (indexD-indexZ)*textLength;
        double help2 = ((textLength-1)*indexC) +indexD - indexZ*textLength;

        double result = help1/help2;
        return  result;

    }

    public static double calcIndex (List <Integer> zerg, String text)
    {
        int help = 0;

        for (Integer value : zerg)
        {
            help = help + value;
        }

        double textLength = text.length();

        double help2 = (1/(textLength * (textLength-1)));
        double result = help * help2;

        return result;

    }
    //
    public static List<Integer> addValues (Map<Character,Integer> alphabet)
    {
        List <Integer> zerg = new ArrayList<>();
        for (Map.Entry<Character, Integer> letter : alphabet.entrySet())
        {
            zerg.add(letter.getValue() * (letter.getValue() - 1));
            System.out.println("Buchstabe: " + letter.getKey() + ", Häufigkeit: " + letter.getValue());
        }
        System.out.println(zerg.toString());
        return zerg;

    }

    // count every character in the text
    public static Map<Character, Integer> count (String text)
    {
        Map<Character,Integer> alphabet = new HashMap<>();
        for (int i=0; i<text.length(); i++)
        {
            char currentChar = text.charAt(i);
            if(alphabet.containsKey(currentChar))
            {
                alphabet.put(currentChar,alphabet.get(currentChar) + 1);
            }
            else
            {
                alphabet.put(currentChar,1);
            }
        }
        return alphabet;
    }






}
