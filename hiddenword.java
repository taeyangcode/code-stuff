/*
Answer with recursion:
*/

public class HiddenWord {
    private String answer, ans;
    
    public HiddenWord(String answer) {
        this.answer = answer;
        this.ans = answer;
    }
    
    public String getHint(String guess) {
        if(guess.length() == 0) return guess;
        String ansFL = answer.substring(0, 1), guessFL = guess.substring(0, 1), newGuess = guess.substring(1);
        answer = answer.substring(1);
        return ansFL.equals(guessFL) ? guessFL + getHint(newGuess) : ans.contains(guessFL) ? "+" + getHint(newGuess) : "*" + getHint(newGuess);
    }
}

/*
Answer without recursion:
*/

public class HiddenWord {
    private String answer;
    
    public HiddenWord(String answer) {
        this.answer = answer;
    }
    
    public String getHint(String guess) {
        String ans = "";
        for(int i = 0; i < answer.length(); i++) {
            String answerPos = answer.substring(i, i + 1), guessPos = guess.substring(i, i + 1);
            ans += answerPos.equals(guessPos) ? answerPos : answer.contains(guessPos) ? "+" : "*";
        }
        return ans;
    }
}
