import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{

    public static void main(String[] args)
    {
        String text = "LWFCOSYJYWTWHRYKUGKLHLLOMGMXLPYNABVJJLAWTCVGALUTQBUXLQUKOVZCLRBSNSETPRYPMFDTLEOXSSJILPFLGBULHIBJQBUXJLBAQFJEYIWZQBRTOILLEWTWKMYKQOIBLIOFESITYBMLMRKVSEOTFAZGDIHFUQYTBGBKMUVLPVBSNSETPRYOUFBAPGBKOVNTYITWUHMDYYHKMPVGEAYFZKZGKELSGTMDYFYJQWKTAWYAZKFASIHXPOECTYYKESELPVTMQFJIBRMWDSRCNWNVMJFGEEVDQUVCPGBKFSYTOMYJVSKOAZIJQITWCSYDXWXPUKMLRFVXDMYKASKLHAYAXWTWHRYLIOJMNPUMNSLCKMBJZWTWARYAZWTWZXYZQVZTYSBFQOEVZXQWUZZROINOMGEXJLNNQFXTZWYFTOSTEMWZTOSTUMWZFJVGNIMKQBUPZWCUTBZROXBAQFSXUAYYQBUTZAYYQGUTYZIJYWIAPIALECESLVHPISXTUHYKISXTZHYJNSITPXMZUBKTYQCJXWVVAMWZTOSTUMWZFJVGNIMKQBUPZWQADPVGLMNKJGVXALOFPSIIQEBJQBXTNIHVUSJTTEMUTWETUOUWYDWTUMWZTOSTUMWZFJVGNIMKQBUPZWMAQLJTPXBMZRVGANUZDSEXOVYSDAVTUWWZUQBTUYGMZGQJGILKFCVGLROFPBRROICFQAAPOVBMZRVGABXWEYIXLKYKTOSTPGBFUQYICILYQGJTUAUKPOJLPGBLUUJILMMLIWIHPRXFAQYWPILDMGJIBRMPTSLILRUUTHUXLWYJMFDTLZIFTWVGHYMWUBVQVXMUTOWIZGBAOYVCSEMKFIEHOIOLQBRROXRVUSJTOSYZXSEOBQYJLWKILVHTDWEVLRBWGHVCHGBLISISLRQADRZTZIBSXZVCHYMWDRVMZXUZXIESZXYAZSIQLFYFXOJHLRMAQGFASIHMZGYDLVYFHCDGVXYFWSICIMMRGAJROAUJLSEMOMGEQZYTBXYFMQYIDILVQBNXYHUXGSIHVVAWZRRHZWCWZWVBHPMNQFXTZWYFPOJXZXTAABLCKBQADVRQLREWUBVPUKML";

        int minSequenceLength = 3; // Mindestlänge der zu suchenden Sequenzen

        Map<String, List<Integer>> sequenceMap = findRepeatingSequences(text, minSequenceLength);
        List <Integer> posKeyLength = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : sequenceMap.entrySet())
        {
            List <Integer> pos = entry.getValue();

            if (pos.size()>2)
            {
                System.out.println("Sequenz: " + entry.getKey() + ", Positionen: " + entry.getValue());

                // Get Distance of the different Sequences
                List<Integer> distance = getDistance(entry.getValue());
                int gcd = calculateGCD(distance);
                if (gcd>2)
                {
                    posKeyLength.add(gcd);
                    System.out.println("ggT: " + calculateGCD(distance));
                }
            }
        }
        int keylength = calculateGCD(posKeyLength);
        System.out.println("Key Länge: " + keylength);

    }
    // Get the distance between two values
    public static List<Integer> getDistance (List<Integer> positions)
    {
        List <Integer> distance = new ArrayList<>();
        // Get distance between values
        for (int i = 0; i < positions.size() - 1; i++)
        {
            int current = positions.get(i);
            int next = positions.get(i + 1);
            int dis = next - current;
            distance.add(dis);
        }
        return distance;
    }
    // Calculate the greatestCommonDivisor of an List of Integers
    public static int calculateGCD(List<Integer> dis) {
        int result = dis.get(0);
        for (int i = 1; i < dis.size(); i++) {
            result = greatestCommonDivisor(result, dis.get(i));
        }
        return result;
    }

    public static int greatestCommonDivisor (int value1, int value2)
    {
        while (value2 != 0)
        {
            int temp = value2;
            value2 = value1 % value2;
            value1 = temp;
        }
        return value1;
    }

    public static Map<String, List<Integer>> findRepeatingSequences(String text, int minSequenceLength)
    {
        // Hash for saving sequences and postion of it
        Map<String, List<Integer>> sequenceMap = new HashMap<>();

        // Find sequence in text
        for (int i = 0; i < text.length() - minSequenceLength; i++)
        {
            String sequence = text.substring(i, i + minSequenceLength);
            int nextIndex = text.indexOf(sequence, i + minSequenceLength);
            // If sequence is found add sequence and postion to map
            if (nextIndex != -1)
            {
                // Get current index
                int currentIndex = text.indexOf(sequence);
                List<Integer> position = sequenceMap.getOrDefault(sequence, new ArrayList<>());
                // Add index if it is not in List
                if (!position.contains(currentIndex))
                {
                    position.add(currentIndex);
                }
                // Add next Position
                position.add(nextIndex);
                sequenceMap.put(sequence, position);
            }
        }
        return sequenceMap;
    }

}