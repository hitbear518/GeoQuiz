package senwang.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "senwang.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "senwang.geoquiz.answer_shown";

	public static final String KEY_IS_ANSWER_SHOWN = "is_answer_shown";

    private boolean mAnswerIsTrue;
	private boolean mIsAnswerShown;

    private TextView mAnswerTextView;
    private Button mShowAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

		mIsAnswerShown = false;
		if (savedInstanceState != null) {
			mIsAnswerShown = savedInstanceState.getBoolean(KEY_IS_ANSWER_SHOWN);
		}
        setAnswerShownResult(mIsAnswerShown);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
		if (mIsAnswerShown) {
			if (mAnswerIsTrue) {
				mAnswerTextView.setText(R.string.true_button);
			} else {
				mAnswerTextView.setText(R.string.false_button);
			}
		}

        mShowAnswerButton = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
				mIsAnswerShown = true;
                setAnswerShownResult(mIsAnswerShown);
            }
        });
    }

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(KEY_IS_ANSWER_SHOWN, mIsAnswerShown);
	}

	private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}
