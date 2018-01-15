package kr.ac.hansung.aspstudy.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.ac.hansung.aspstudy.Problem.Problems;
import kr.ac.hansung.aspstudy.R;


public class TextViewFragment extends Fragment implements MyFragmentInterface {
    private Problems problem;
    private String problemText;

    private TextView textView;

    public TextViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_text_view, container, false);
        textView = (TextView) v.findViewById(R.id.ResultTextView);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setProblem(Problems p) {
        this.problem = p;
        this.problemText = p.setProvlem();
        textView.setText(this.problemText);
    }

    @Override
    public void runProblem() {

    }
}
