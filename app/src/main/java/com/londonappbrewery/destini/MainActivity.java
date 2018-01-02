package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryText;
    Button mTopButton;
    Button mBottomButton;
    private StoryAnswer [] mStory;
    private int mIndex;
    private int mTopState; // Number of time top button was click
    private int mBottomState;// Number of time bottom button was click


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText= (TextView) findViewById(R.id.storyTextView);
        mTopButton= (Button) findViewById(R.id.buttonTop);
        mBottomButton= (Button) findViewById(R.id.buttonBottom);
        mStory = new StoryAnswer[]{ new StoryAnswer(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
                                    new StoryAnswer(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
                                    new StoryAnswer(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
                                    new StoryAnswer(R.string.T4_End,R.string.NO_BUTTON, R.string.NO_BUTTON),
                                    new StoryAnswer(R.string.T5_End,R.string.NO_BUTTON, R.string.NO_BUTTON),
                                    new StoryAnswer(R.string.T6_End, R.string.NO_BUTTON, R.string.NO_BUTTON)
                                    };

        if (savedInstanceState !=  null){
            mIndex=    savedInstanceState.getInt("INDEX");
            mTopState=    savedInstanceState.getInt("TOPSTATE");
            mBottomState=    savedInstanceState.getInt("BUTTOMSTATE");
        }

        setTextView(mStory[mIndex].getmStory(), mStory[mIndex].getmTopButton(), mStory[mIndex].getmBottomButton());



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if( mTopState == 0 && mBottomState == 0 ) {
                    mIndex = 2;
                    setTextView(mStory[mIndex].getmStory(), mStory[mIndex].getmTopButton(), mStory[mIndex].getmBottomButton());
                }
                else  {
                    if(mTopState == 1){
                        mIndex = 5;
                        setTextView(mStory[mIndex].getmStory(), mStory[mIndex].getmTopButton(), mStory[mIndex].getmBottomButton());
                      }
                    if(mBottomState == 1){
                        mIndex = 2;
                        setTextView(mStory[mIndex].getmStory(), mStory[mIndex].getmTopButton(), mStory[mIndex].getmBottomButton());
                    }
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                }
                mTopState++;
            }
        });
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mTopState == 0 && mBottomState == 0 ) {
                    mIndex = 1;
                    setTextView(mStory[mIndex].getmStory(), mStory[mIndex].getmTopButton(), mStory[mIndex].getmBottomButton());
                }
                else {
                        if(mTopState == 1){
                            mIndex = 4;
                            setTextView(mStory[mIndex].getmStory(), mStory[mIndex].getmTopButton(), mStory[mIndex].getmBottomButton());
                        }
                        if(mBottomState == 1) {
                            mIndex = 3;
                            setTextView(mStory[mIndex].getmStory(), mStory[mIndex].getmTopButton(), mStory[mIndex].getmBottomButton());
                        }
                        mTopButton.setVisibility(View.GONE);
                        mBottomButton.setVisibility(View.GONE);
                    }
                mBottomState++;
            }

        });
    }
    private void setTextView(int Story, int Top, int Buttom){
        mStoryText.setText(Story);
        mTopButton.setText(Top);
        mBottomButton.setText(Buttom);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if((mTopState == 1 && mBottomState == 1)  || (mTopState == 2 || mBottomState == 2 ) ) {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("INDEX", mIndex);
        outState.putInt("TOPSTATE", mTopState);
        outState.putInt("BUTTOMSTATE", mBottomState);
    }
}
