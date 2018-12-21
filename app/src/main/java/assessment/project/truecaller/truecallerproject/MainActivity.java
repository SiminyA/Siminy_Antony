package assessment.project.truecaller.truecallerproject;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private Button AssignmentButton;
    private TextView textView10thCharacter;
    private TextView textViewEvery10thCharacter;
    private TextView textViewWordCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DownloadTruecaller(MainActivity.this,URLConstant.TRUE_CALLER_URL).execute();
        textView10thCharacter = (TextView) findViewById(R.id.text_view);
        textViewEvery10thCharacter = (TextView) findViewById(R.id.text_view_every_10th_character);
        textViewWordCounter = (TextView) findViewById(R.id.text_view_word_counter);
        AssignmentButton = (Button) findViewById(R.id.assignment_button);
    }


    public void onSuccess(String response) {
      TrueCallerAssignmentFactory dataParsedPerProblemStatement = new TrueCallerAssignmentFactory();

        StringBuilder everyTengthChar = new StringBuilder("Every 10th character response string :: ");
        StringBuilder wordsCount = new StringBuilder("Words Counter");

        // Get an object of find10thChar from the factory class.
        Find10thCharacter find10thChar = (Find10thCharacter)(dataParsedPerProblemStatement.getDataStructureType("find10thChar", response));
        StringBuilder tengthChar = find10thChar.getData();

        //get a map for every10thChar in the response from the factory class.
        Every10thCharacter every10thCharacter = (Every10thCharacter)(dataParsedPerProblemStatement.getDataStructureType("every10thChar", response));
        StringBuilder every10thCharResponse = every10thCharacter.getData();
        everyTengthChar.append(every10thCharResponse);

        //Get a map for words occurences in the response from the factory class.
        WordsCount wordsOccurencesCount = (WordsCount)(dataParsedPerProblemStatement.getDataStructureType("wordsCount", response));
        Map<String, Integer> occurrences = wordsOccurencesCount.getData();

        StringBuilder wordsCountResponse = new StringBuilder();
        for (String word : occurrences.keySet()) {
            if(word.equalsIgnoreCase("truecaller")) {
                Integer count = occurrences.get(word);
                wordsCountResponse.append("  Word : 'TrueCaller' " + " Count : '" + count + "'");
            }
        }
        wordsCount.append(wordsCountResponse);


     textView10thCharacter.setText(tengthChar);
     textViewEvery10thCharacter.setText(everyTengthChar);
     textViewWordCounter.setText(wordsCount.length());
    }

}
