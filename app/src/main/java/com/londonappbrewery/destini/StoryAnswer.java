package com.londonappbrewery.destini;

/**
 * Created by nicho on 1/1/2018.
 */

public class StoryAnswer {
    int mStory;
    int mTopButton;
    int mBottomButton;

    public StoryAnswer(int mStory, int mTopButton, int mBottomButton){
        this.mStory = mStory;
        this.mTopButton = mTopButton;
        this.mBottomButton= mBottomButton;
    }


    public int getmStory() {return mStory;}
    public int getmTopButton() {return mTopButton;}
    public int getmBottomButton() {return mBottomButton;}


    public void setmStory(int mStory) {this.mStory = mStory;}
    public void setmTopButton(int mTopButton) {this.mTopButton = mTopButton;}
    public void setmBottomButton(int mBottomButton) {this.mBottomButton = mBottomButton;}
}
