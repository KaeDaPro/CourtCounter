package android.juntillak.courtcounter;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CourtCounter extends AppCompatActivity {

    private TextView points;
    private TextView goals;

    private EditText name1;
    private EditText name2;

    private AlertDialog gameOverAlert;

    private MediaPlayer soundFXthing;

    private int a = 0;
    private int b = 0;

    private String team1;
    private String team2;

    public void addPoint(View view) {
        a++;
        points.setText(String.valueOf(a));
        soundFXthing.start();

    }

    public void addPoint2(View view) {
        b++;
        goals.setText(String.valueOf(b));
        soundFXthing.start();
    }

    public void negativePoint(View view) {
        a--;
        points.setText(String.valueOf(a));
        soundFXthing.start();

    }

    public void negativePoint2 (View view){
        b--;
        points.setText(String.valueOf(a));
        soundFXthing.start();

    }

    public void reset(View view){
        if (a > b){
            team1 = name1.getText().toString();
            gameOverAlert.setMessage(team1 + " wins");

        }

        if (a < b){
            team2 = name2.getText().toString();
            gameOverAlert.setMessage(team2 + " wins");

        }

        if (a == b){

            gameOverAlert.setMessage("Draw!");

            b = 0;
            a = 0;

        }

        gameOverAlert.show();

        b = 0;
        a = 0;


        points.setText(String.valueOf(a));
        goals.setText(String.valueOf(b));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_counter);



        points = (TextView) findViewById(R.id.points);
        points.setText(String.valueOf(a));

        goals = (TextView) findViewById(R.id.goals);
        goals.setText(String.valueOf(b));

        name1 = (EditText) findViewById(R.id.Edit1);

        name2 = (EditText) findViewById(R.id.Edit2);

        gameOverAlert= new AlertDialog.Builder(CourtCounter.this).create();

        soundFXthing= MediaPlayer.create(this , R.raw.regularbell);

        gameOverAlert.setTitle("GameOver");

        gameOverAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

    }

}
