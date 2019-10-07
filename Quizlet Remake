import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MakeshiftQuizlet {
    public MakeshiftQuizlet() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        ArrayList<String> inputWords = new ArrayList<>();
        ArrayList<String> inputDefinition = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        String readOrWrite;
        String changeWord;
        String wordOrDef;
        String wordReplace;
        String defReplace;
        String originalWord;
        String originalDef;
        String flashcardsEndInput;
        String writeOrWrong;
        String startDefStartWord;
        int whichWord;
        int whichDef;
        int numWords = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        //make a vocab word class, getters and setters, program can create those items
        System.out.println("How many words are you going to use?");
        numWords = sc.nextInt();
       
        for(int i = 1; i <= numWords; i++) {
            System.out.println("Enter word " + i);
            inputWords.add(sc.next());
            System.out.println("Enter the definition for word " + i);
            inputDefinition.add(sc.next());
        }
       
        do {
            System.out.println("Would you like to change any words or definitions? Y/N");
            changeWord = sc.next();
           
            if(changeWord.equalsIgnoreCase("Y")) {
                do {
                    System.out.println("Would you like to change a word or definition? word/definition");
                    wordOrDef = sc.next();
                    if(wordOrDef.equalsIgnoreCase("Word")) {
                        System.out.println("Which word will you change? #");
                        whichWord = sc.nextInt();
                        whichWord--;
                        System.out.println("What will you change it to?");
                        wordReplace = sc.next();
                        originalWord = inputWords.get(whichWord);
                        inputWords.set(whichWord, wordReplace);
                        System.out.println("You replaced " + originalWord + " with " + wordReplace);
                        y = 0;
                    }
                    else if(wordOrDef.equalsIgnoreCase("Definition")) {
                        System.out.println("Which definition will you change? #");
                        whichDef = sc.nextInt();
                        whichDef--;
                        System.out.println("What will you change it to?");
                        defReplace = sc.next();
                        originalDef = inputDefinition.get(whichDef);
                        inputDefinition.set(whichDef, defReplace);
                        System.out.println("You replaced " + originalDef + " with " + defReplace);
                        y = 0;
                    }
                    else {
                        System.out.println("That is an invalid response. Please type 'word' or 'definition'.");
                        y = 1;
                    }
                } while(y == 1);
                x = 1; //keeps program running
            }
            else if(changeWord.equalsIgnoreCase("N")) {
                x = 0;
            }
            else {
                System.out.println("That is an invalid response. Please use 'Y' or 'N'.");
                x = 1;
            }
        } while(x == 1);
        
        do {
            System.out.println("Would you like to see your words or do a writing test? flashcards/writing");
            System.out.println("If you would like to finish using the program, type 'done'.");
            readOrWrite = sc.next();
            if(readOrWrite.equalsIgnoreCase("flashcards")) {
                for(int j = 0; j < inputWords.size(); j++) {
                    System.out.println("Word " + (j + 1) + ": " + (inputWords.get(j)));
                    System.out.println("Definition " + (j + 1) + ": " + (inputDefinition.get(j)));
                }
                System.out.println("Here are the words and definitions!");
                do {
                    System.out.println("When you are done viewing the flashcards, type 'done'!");
                    flashcardsEndInput = sc.next();
                    if(flashcardsEndInput.equalsIgnoreCase("done")) {
                        y = 0;
                    }
                    else {
                        System.out.println("That is an invalid response. Please type 'done'.");
                        y = 1;
                    }
                } while(y == 1);
                x = 1;
            }
            else if(readOrWrite.equalsIgnoreCase("writing")) {
                System.out.println("Do you want to start with the word or definition? word/definition");
                System.out.println("If you wish to finish, type 'done'.");
                startDefStartWord = sc.next();
                if(startDefStartWord.equalsIgnoreCase("word")) {
                    System.out.println("If you don't know the definition, type 'skipskip'.");
                    for(int k = 0; k < inputWords.size(); k++) {
                        list.add(new Integer(k));
                    }
                    Collections.shuffle(list);
                    for(int k = 0; k < inputWords.size(); k++) {
                        System.out.println("What word goes with " + (inputWords.get(list.get(k))) + "?");
                        do {
                            writeOrWrong = sc.next();
                            if(writeOrWrong.equalsIgnoreCase(inputDefinition.get(list.get(k)))) {
                                System.out.println("You got ther answer right!");
                                y = 0;
                            }
                            else if(writeOrWrong.equalsIgnoreCase("skipskip")) {
                                y = 0;
                            }
                            else {
                                System.out.println("You got the answer wrong. Try again");
                                y = 1;
                            }
                        } while(y == 1);
                        x = 1;
                    }
                }
                
                else if(startDefStartWord.equalsIgnoreCase("definition")) {
                    System.out.println("If you don't know the word, type 'skipskip'.");
                    for(int k = 0; k < inputWords.size(); k++) {
                        list.add(new Integer(k));
                    }
                    Collections.shuffle(list);
                    for(int k = 0; k < inputWords.size(); k++) {
                        System.out.println("What word goes with " + (inputDefinition.get(list.get(k))) + "?");
                        do {
                            writeOrWrong = sc.next();
                            if(writeOrWrong.equalsIgnoreCase(inputWords.get(list.get(k)))) {
                                System.out.println("You got the answer right!");
                                y = 0;
                            }
                            else if(writeOrWrong.equalsIgnoreCase("skipskip")) {
                                y = 0;
                            }
                            else {
                                System.out.println("You got the answer wrong. Try again");
                                y = 1;
                            }
                        } while(y == 1);
                        x = 1;
                    }
                }
            
                else {
                    System.out.println("That is an invalid response. Please type 'flashcards' or 'definition'.");
                    x = 1;
                }
            }
            else if(readOrWrite.equalsIgnoreCase("done")) {
                System.out.println("Hope you enjoyed the program!");
                x = 0;
            }
            else {
                System.out.println("That is an invalid response. Please type 'flashcards', 'writing', or 'done'.");
                x = 1;
            }
        } while(x == 1);
    }
}
