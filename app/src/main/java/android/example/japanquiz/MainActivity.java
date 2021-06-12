package android.example.japanquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public int currentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * For Question 1
     *
     * Checking whether or not the value from EditText is correct.
     */
    public void resultQ1() {
        // Getting the TextView and convert its text to string format
        EditText q1EditText = (EditText) findViewById(R.id.question1_editText_view);
        String typedAnswer = q1EditText.getText().toString();

        // Check if the entered answer is correct or not
        // trim() ignores the blank space
        if (typedAnswer.trim().equals("Tokyo")) {
            currentScore += 10;
        }
    }

    /**
     * For Question 2
     *
     * Checking whether or not the correct radiobutton is selected.
     */
    public void resultQ2() {
        // Getting the id of the correct answer RadioButton and check if it's been selected or not
        RadioButton q2CorrectRadioButton = (RadioButton) findViewById(R.id.question2_radio_correct);
        boolean answerSelected = q2CorrectRadioButton.isChecked();

        // If it's selected, add 10 to current score
        if(answerSelected) {
            currentScore += 10;
        }
    }

    /**
     * For Question 3
     *
     * Assign different scores depending on the options selected
     * Correct answers are checkbox 1 & checkbox 3
     */
    public void resultQ3() {
        //Getting the each Checkbox for Q3
        CheckBox q3CheckBox1 = (CheckBox) findViewById(R.id.question3_checkbox1);
        CheckBox q3CheckBox2 = (CheckBox) findViewById(R.id.question3_checkbox2);
        CheckBox q3CheckBox3 = (CheckBox) findViewById(R.id.question3_checkbox3);

        // Convert Checkboxes into boolean to see if they are checked
        boolean isChecked1 = q3CheckBox1.isChecked();
        boolean isChecked2 = q3CheckBox2.isChecked();
        boolean isChecked3 = q3CheckBox3.isChecked();

        //Assigning scores depending on the combination of selections
        if (isChecked1 && isChecked2 && isChecked3) {
            currentScore += 20;
        } else if (isChecked1 && isChecked3) {
            currentScore += 30;
        } else if ((isChecked1 || isChecked3) && isChecked2) {
            currentScore += 15;
        } else if (isChecked1 || isChecked3) {
            currentScore += 15;
        }
    }

    /**
     * For Question 4
     *
     * Checking whether or not the selected option is correct.
     */
    public void resultQ4() {
        // Getting the id of the correct answer RadioButton and check if it's been selected or not
        RadioButton q4CorrectRadioButton = (RadioButton) findViewById(R.id.question4_radio_correct);
        boolean answerSelected = q4CorrectRadioButton.isChecked();

        // If it's selected, add 10 to current score
        if (answerSelected) {
            currentScore += 20;
        }
    }

    /**
     * For Question 5
     *
     * Assign different scores depending on the options selected
     * Correct answers are checkbox 1 & checkbox 2
     */
    public void resultQ5() {
        //Getting the each Checkbox for Q5
        CheckBox q5CheckBox1 = (CheckBox) findViewById(R.id.question5_checkbox1);
        CheckBox q5CheckBox2 = (CheckBox) findViewById(R.id.question5_checkbox2);
        CheckBox q5CheckBox3 = (CheckBox) findViewById(R.id.question5_checkbox3);

        // Convert Checkboxes into boolean to see if they are checked
        boolean isChecked1 = q5CheckBox1.isChecked();
        boolean isChecked2 = q5CheckBox2.isChecked();
        boolean isChecked3 = q5CheckBox3.isChecked();

        //Assigning scores depending on the combination of selections
        if (isChecked1 && isChecked2 && isChecked3) {
            currentScore += 20;
        } else if (isChecked1 && isChecked2) {
            currentScore += 30;
        } else if ((isChecked1 || isChecked2) && isChecked3) {
            currentScore += 15;
        } else if (isChecked1 || isChecked2) {
            currentScore += 15;
        } else {
            currentScore += 0;
        }
    }

    /**
     * Displaying the last result message upon clicking the button
     */
    public void displayResult(View view) {
        // Calling methods for each question
        resultQ1();
        resultQ2();
        resultQ3();
        resultQ4();
        resultQ5();

        // Composing the result message and adding different message depending on the score gained
        String resultMessage = "Your final score is " + currentScore;
        if (currentScore >= 80) {
            resultMessage += "\nYou are a champion!";
        } else if (currentScore >= 40) {
            resultMessage += "\nYou did well on this!";
        } else {
            resultMessage += "\nHmm..Try again!";
        }

        // Display the message as Toast
        Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();

        // Reset the Score
        currentScore = 0;
    }
}

