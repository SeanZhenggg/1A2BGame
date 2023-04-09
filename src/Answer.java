import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Answer {
    private String ans;
    private Map<Character, Integer> wordMap;

    public Answer() {
        this.ans = createAnswerString();
        this.wordMap = new HashMap<>();
        this.createWordMap();
    }

    public String getAns() {
        return ans;
    }

    public void createWordMap() {
        for(int i = 0; i < this.ans.length(); i++) {
            this.wordMap.put(this.ans.charAt(i), i);
        }
    }

    public String checkAnswer(String input) {
        char[] inputChars = input.toCharArray();
        String result = "";
        int[] ABCounts = new int[2];

        for(int i = 0; i < inputChars.length; i++) {
            if(wordMap.containsKey(inputChars[i])) {
                if (wordMap.get(inputChars[i]) == i) {
                    ABCounts[0] = ABCounts[0] == 0 ? 1 : ABCounts[0] + 1;
                } else {
                    ABCounts[1] = ABCounts[1] == 0 ? 1 : ABCounts[1] + 1;
                }
            }
        }

        result = (ABCounts[0] > 0 ? ABCounts[0] + "A" : "") + (ABCounts[1] > 0 ? ABCounts[1] + "B" : "");

        return result;
    }

    private String createAnswerString () {
        String result = "";
        Random random = new Random();
        int count = 0;
        boolean[] numberExist = new boolean[10];
        while (count < 4) {
            int randomNum = random.nextInt(10);
            if(numberExist[randomNum]) continue;

            numberExist[randomNum] = true;
            result += randomNum;
            count++;
        }

        return result;
    }
}
