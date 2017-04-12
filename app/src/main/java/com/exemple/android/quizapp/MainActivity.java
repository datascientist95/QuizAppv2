package com.exemple.android.quizapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.graphics.Color.rgb;

/**
 * This app counts score received in the quiz.
 */

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int flag1 = 0;
    int flag2 = 0;
    int flag3 = 0;
    int flag4 = 0;
    int flag5 = 0;
    private CheckBox checkBoxWingChung;
    private CheckBox checkBoxTaiSing;
    private CheckBox checkBoxSambo;
    private CheckBox checkBoxWialiCuenku;
    private CheckBox checkBoxJeetKunDo;
    private CheckBox checkBoxThweiKrei;
    private EditText textName;
    private EditText textQuestion4;
    private RadioGroup radioQestion1;
    private RadioGroup radioQestion2;
    private Button buttonUdacity;
    private Button buttonYourDog;
    private Button buttonYourGrandMa;

    private static final String SCORE = "score";
    private static final String FLAG1 = "flag1";
    private static final String FLAG2 = "flag2";
    private static final String FLAG3 = "flag2";
    private static final String FLAG4 = "flag4";
    private static final String FLAG5 = "flag5";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt(SCORE);
            flag1 = savedInstanceState.getInt(FLAG1);
            flag2 = savedInstanceState.getInt(FLAG2);
            flag3 = savedInstanceState.getInt(FLAG3);
            flag4 = savedInstanceState.getInt(FLAG4);
            flag5 = savedInstanceState.getInt(FLAG5);

        }

        // app optimization put all findViewbyID here
        radioQestion1 = (RadioGroup)findViewById(R.id.radiogroup1);
        radioQestion2 = (RadioGroup)findViewById(R.id.radiogroup2);
        checkBoxWingChung = (CheckBox) findViewById(R.id.wing_chung);
        checkBoxTaiSing = (CheckBox) findViewById(R.id.tai_sing);
        checkBoxSambo = (CheckBox) findViewById(R.id.sambo);
        checkBoxWialiCuenku = (CheckBox) findViewById(R.id.wiali_cuenku);
        checkBoxJeetKunDo = (CheckBox) findViewById(R.id.jeet_kun_do);
        checkBoxThweiKrei = (CheckBox) findViewById(R.id.ithwei_krei);
        textName = (EditText) findViewById(R.id.name);
        textQuestion4 = (EditText) findViewById(R.id.question4);
        buttonUdacity = (Button) findViewById(R.id.udacity);
        buttonYourDog = (Button) findViewById(R.id.yourdog);
        buttonYourGrandMa = (Button) findViewById(R.id.yourgrandma);

    }


    /* check if radiobutton is checked for question 1
    * Check good answer is checked and add one point
    */
    public void question1(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.boxer:
                if (checked && (flag1 == 0))
                    score += 1;
                    flag1 = 1;
                break;
        }

    }

    /* check if radiobutton is checked for question 2
    * Check good answer is checked and add one point
    */
    public void question2(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.kangaroo:
                if (checked&& (flag2 == 0))
                    score += 1;
                    flag2 = 1;
                break;
        }

    }

    public int question3(View view) {

        //Checks whether the correct checkboxes are marked in Question 3
        boolean checkedWingChung = checkBoxWingChung.isChecked();
        boolean checkedTaiSing = checkBoxTaiSing.isChecked();
        boolean checkedSambo = checkBoxSambo.isChecked();
        boolean checkedWialiCuenku = checkBoxWialiCuenku.isChecked();
        boolean checkedJeetKunDo = checkBoxJeetKunDo.isChecked();
        boolean checkediThweiKrei = checkBoxThweiKrei.isChecked();

        if ((checkedWingChung && checkedSambo && checkedJeetKunDo) && (!checkedTaiSing && !checkediThweiKrei && !checkedWialiCuenku) && (flag3==0) )
            score += 1;
            flag3 = 1;
        return score;
    }

    public int question5(View view) {

        buttonYourGrandMa.setBackgroundColor(getResources().getColor(R.color.button));
        buttonYourDog.setBackgroundColor(getResources().getColor(R.color.button));
        // Is the correct button pushed
        if (flag5==0) {
            score += 1;
            buttonUdacity.setBackgroundColor(rgb(0, 255, 0));
            flag5 = 1;
        }else buttonUdacity.setBackgroundColor(rgb(0, 255, 0));

        return 1;
    }

    // Color button Your Dog when pushed and remove color on other button
    public int colorYourDog (View view) {
        //check if udacity has been pushed then remove one point
        if (flag5==1) {
            score -= 1;
            flag5 = 0;
        }
        buttonUdacity.setBackgroundColor(getResources().getColor(R.color.button));
        buttonYourGrandMa.setBackgroundColor(getResources().getColor(R.color.button));
        buttonYourDog.setBackgroundColor(rgb(0, 255, 0));
        return 1;
    }

    // Color button Your Grand MA when pushed and remove color on other button
    public int colorYourGrandMa(View view) {
        //check if udacity has been pushed then remove one point
        if (flag5==1) {
            score -= 1;
            flag5 = 0;
        }
        buttonUdacity.setBackgroundColor(getResources().getColor(R.color.button));
        buttonYourDog.setBackgroundColor(getResources().getColor(R.color.button));
        buttonYourGrandMa.setBackgroundColor(rgb(0, 255, 0));
        return 1;
    }

    /**
     * This method is called when the Reset button is clicked to erase everything
     */
    public void reset(View view) {
        score = flag1 = flag2 = flag4 = flag5 = 0;

        // erase name and question 4
        textName.setText(null);
        textQuestion4.setText(null);

        //erase question 1 and question 2
        radioQestion1.clearCheck();
        radioQestion2.clearCheck();

        //erase all answer for question 3
        checkBoxWingChung.setChecked(false);
        checkBoxTaiSing.setChecked(false);
        checkBoxSambo.setChecked(false);
        checkBoxWialiCuenku.setChecked(false);
        checkBoxJeetKunDo.setChecked(false);
        checkBoxThweiKrei.setChecked(false);

        //erase color for question 5
        buttonUdacity.setBackgroundColor(getResources().getColor(R.color.button));
        buttonYourDog.setBackgroundColor(getResources().getColor(R.color.button));
        buttonYourGrandMa.setBackgroundColor(getResources().getColor(R.color.button));
    }

    public int submit(View View) {
        String name =  textName.getText().toString();
        //check answer for question 4 and add one point
        textQuestion4 = (EditText) findViewById(R.id.question4);
        String result = textQuestion4.getText().toString();
        if ((result.equals("91")) && (flag4 ==0)) {
            score += 1;
            flag4 = 1;
        }

        Toast.makeText(getApplicationContext(),name + " " + getString(R.string.yougot)+ " " + score + " " +getString(R.string.score), Toast.LENGTH_LONG).show();
        return score;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.putInt(SCORE, score);

        savedInstanceState.putInt(FLAG1, flag1);
        savedInstanceState.putInt(FLAG2, flag2);
        savedInstanceState.putInt(FLAG3, flag3);
        savedInstanceState.putInt(FLAG4, flag4);
        savedInstanceState.putInt(FLAG5, flag5);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SCORE, score);
        savedInstanceState.putInt(FLAG1, flag1);
        savedInstanceState.putInt(FLAG2, flag2);
        savedInstanceState.putInt(FLAG3, flag3);
        savedInstanceState.putInt(FLAG4, flag4);
        savedInstanceState.putInt(FLAG5, flag5);
        super.onSaveInstanceState(savedInstanceState);
    }
}