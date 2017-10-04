package org.pltw.examples.synthesizer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;

import java.util.ArrayList;

public class SynthesizerActivity extends AppCompatActivity {

    private final int WHOLE_NOTE = 1000;
    private final int HALF_NOTE = 500;
    private Button fButton;
    private Button Challenge2;
    private Button Challenge1;
    private Button Twinkle;
    private Button March;
    private NumberPicker notePicker;
    private NumberPicker amountPicker;
    private NumberPicker ch1notes;
    private CheckBox line2;
    private static final String TAG = SynthesizerActivity.class.getName();
    MediaPlayer mpE;
    MediaPlayer mpFs;
    MediaPlayer mpG;
    MediaPlayer mpA;
    MediaPlayer mpB;
    MediaPlayer mpCs;
    MediaPlayer mpD;
    MediaPlayer mpHighe;
    MediaPlayer mpBB;
    MediaPlayer mpC;
    MediaPlayer mpDS;
    MediaPlayer mpGS;
    MediaPlayer mpHighf;
    MediaPlayer mpHighfs;
    MediaPlayer mpHighg;

    ArrayList<MediaPlayer> twinkle2player;
    ArrayList<MediaPlayer> twinkleplayer;
    ArrayList<MediaPlayer> mediaplayers;
    ArrayList<MediaPlayer> challengeoneplayer;
    ArrayList<MediaPlayer> marchplayer;

    String[] notes = {"mpE", "mpFs", "mpG", "mpA", "mpB", "mpCs", "mpD", "mpHighe", "mpBB", "mpC", "mpDS", "mpGS", "mpHighf", "mpHighfs", "mpHighg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);
        twinkle2player = new ArrayList<>();
        fButton = (Button) findViewById(R.id.button1);
        Challenge2 = (Button) findViewById(R.id.button2);
        Challenge1 = (Button) findViewById(R.id.button3);
        Twinkle = (Button) findViewById(R.id.button4);
        March = (Button) findViewById(R.id.buttonm);
        notePicker = (NumberPicker) findViewById(R.id.numberPicker);
        amountPicker = (NumberPicker) findViewById(R.id.numberPicker3);
        ch1notes = (NumberPicker) findViewById(R.id.numberPicker) ;
        line2 = (CheckBox) findViewById(R.id.checkBox);
        mpE = MediaPlayer.create(this, R.raw.scalee);
        mpFs = MediaPlayer.create(this, R.raw.scalef);
        mpG = MediaPlayer.create(this, R.raw.scaleg);
        mpA = MediaPlayer.create(this, R.raw.scalea);
        mpB = MediaPlayer.create(this, R.raw.scaleb);
        mpCs = MediaPlayer.create(this, R.raw.scalecs);
        mpD = MediaPlayer.create(this, R.raw.scaled);
        mpHighe = MediaPlayer.create(this, R.raw.scalehighe);
        mpBB = MediaPlayer.create(this, R.raw.scalebb);
        mpC = MediaPlayer.create(this, R.raw.scalec);
        mpDS = MediaPlayer.create(this, R.raw.scaleds);
        mpGS = MediaPlayer.create(this, R.raw.scalegs);
        mpHighf = MediaPlayer.create(this, R.raw.scalehighf);
        mpHighfs = MediaPlayer.create(this, R.raw.scalehighfs);
        mpHighg = MediaPlayer.create(this, R.raw.scalehighg);

        notePicker.setMinValue(0);
        notePicker.setMaxValue(14);
        notePicker.setDisplayedValues(notes);

        ch1notes.setMinValue(0);
        ch1notes.setMaxValue(7);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(20);

        mediaplayers = new ArrayList<>();

        mediaplayers.add(mpE);
        mediaplayers.add(mpFs);
        mediaplayers.add(mpG);
        mediaplayers.add(mpB);
        mediaplayers.add(mpCs);
        mediaplayers.add(mpD);
        mediaplayers.add(mpHighe);
        mediaplayers.add(mpBB);
        mediaplayers.add(mpC);
        mediaplayers.add(mpDS);
        mediaplayers.add(mpGS);
        mediaplayers.add(mpHighf);
        mediaplayers.add(mpHighfs);
        mediaplayers.add(mpHighg);

        challengeoneplayer = new ArrayList<>();

        challengeoneplayer.add(mpE);
        challengeoneplayer.add(mpFs);
        challengeoneplayer.add(mpG);
        challengeoneplayer.add(mpA);
        challengeoneplayer.add(mpB);
        challengeoneplayer.add(mpCs);
        challengeoneplayer.add(mpD);
        challengeoneplayer.add(mpE);

        twinkleplayer = new ArrayList<>();

        twinkleplayer.add(mpA);
        twinkleplayer.add(mpA);
        twinkleplayer.add(mpHighe);
        twinkleplayer.add(mpHighe);
        twinkleplayer.add(mpHighfs);
        twinkleplayer.add(mpHighfs);
        twinkleplayer.add(mpHighe);
        twinkleplayer.add(mpD);
        twinkleplayer.add(mpD);
        twinkleplayer.add(mpCs);
        twinkleplayer.add(mpCs);
        twinkleplayer.add(mpB);
        twinkleplayer.add(mpB);
        twinkleplayer.add(mpA);

        // A, A, High E, High E, High F Sharp, High F Sharp, High E, D, D, C Sharp, C Sharp, B, B, A

        twinkle2player.add(mpHighe);
        twinkle2player.add(mpHighe);
        twinkle2player.add(mpD);
        twinkle2player.add(mpD);
        twinkle2player.add(mpCs);
        twinkle2player.add(mpCs);
        twinkle2player.add(mpB);

        // High E, High E, D, D, C Sharp, C Sharp, B

        marchplayer = new ArrayList<>();

        marchplayer.add(mpA);
        marchplayer.add(mpA);
        marchplayer.add(mpA);
        marchplayer.add(mpFs);
        marchplayer.add(mpC);
        marchplayer.add(mpA);
        marchplayer.add(mpFs);
        marchplayer.add(mpC);
        marchplayer.add(mpA);
        marchplayer.add(mpD);
        marchplayer.add(mpD);
        marchplayer.add(mpD);
        marchplayer.add(mpDS);
        marchplayer.add(mpC);
        marchplayer.add(mpA);
        marchplayer.add(mpFs);
        marchplayer.add(mpC);
        marchplayer.add(mpA);


        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "This worked! Button 1 pressed.");
                mpFs.start();
            }
        });
        Challenge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int value = amountPicker.getValue();
                int notes = notePicker.getValue();
                for (int i = 0; i<value; i++) {
                    mediaplayers.get(notes).seekTo(0);
                    mediaplayers.get(notes).start();
                    delayPlaying(WHOLE_NOTE);


            }
                }

        });


        Challenge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i<challengeoneplayer.size(); i++){
                    challengeoneplayer.get(i).seekTo(0);
                    challengeoneplayer.get(i).start();
                    delayPlaying(HALF_NOTE);
                }

            }
        });

        March.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         for (int i = 0; i < marchplayer.size(); i++) {
                                             int notelength = HALF_NOTE;

                                             if (i == 8) {
                                                 notelength = WHOLE_NOTE*2;
                                             }
                                             if (marchplayer.get(i) == mpC) {
                                                 notelength = HALF_NOTE/2;
                                             }
                                             notePlayer(marchplayer.get(i), notelength);
                                         }
                                     }
                                 });


        Twinkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < twinkleplayer.size(); i++) {
                    int notelength = HALF_NOTE;
                    if (i == 6) {
                        notelength = WHOLE_NOTE;
                    }
                    notePlayer(twinkleplayer.get(i), notelength);
                }
                    if (line2.isChecked())
                        for (int i3 = 0; i3 < amountPicker.getValue(); i3++){
                            for (int i2 = 0; i2 < twinkle2player.size(); i2++) {
                                int notelength = HALF_NOTE;
                                        if (i2 == 6){
                                            notelength = WHOLE_NOTE;
                                        }
                                notePlayer(twinkle2player.get(i2), notelength);
                                }
                            }
                    for (int i4 = 0; i4 < twinkleplayer.size(); i4++) {
                        int notelength = HALF_NOTE;
                        if (i4 == 6) {
                            notelength = WHOLE_NOTE;
                        }
                        notePlayer(twinkleplayer.get(i4), notelength);
                    }
                    }
        });
    }

    private void delayPlaying(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notePlayer(MediaPlayer m, int delay){
        m.seekTo(0);
        m.start();
        delayPlaying(delay);


    }

}
