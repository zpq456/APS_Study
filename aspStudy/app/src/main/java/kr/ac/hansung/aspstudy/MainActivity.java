package kr.ac.hansung.aspstudy;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.ac.hansung.aspstudy.Adapter.ExpandableListAdapter;
import kr.ac.hansung.aspstudy.Fragment.TextViewFragment;
import kr.ac.hansung.aspstudy.Problem.Problem01_Picnic;

public class MainActivity extends AppCompatActivity {

    //Fragment
    private FragmentManager fragmentManager;
    private static final TextViewFragment textViewFragment = new TextViewFragment();

    //problemListView
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.problemSetList);
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
//        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView expandableListView, View view,
//                                        int groupPosition, int childPosition, long id) {
//                String problemName = listDataChild.get(listDataHeader.get(groupPosition))
//                        .get(childPosition).toString();
//                setProblem(problemName);
//                return false;
//            }
//        });

        fragmentManager = getSupportFragmentManager();
        changeFragment("TextViewFragment");
    }

    private void setProblem(String problemName) {
        switch (problemName){
            case "Problem01_Picnic":
                Problem01_Picnic problem = new Problem01_Picnic();
                textViewFragment.setProblem(problem);
                changeFragment("TextViewFragment");
                break;
            case "problem02_BoardCover":
                break;
            case "problem03_ClockSync":
                break;
        }
    }

    public void changeFragment(String fragment) {
        switch (fragment){
            case "TextViewFragment":
                fragmentManager.beginTransaction().replace(R.id.container, textViewFragment).commit();
                break;

        }
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Select Problem");

        // Adding child data
        List<String> selectProblem = new ArrayList<String>();
        selectProblem.add("Problem01_Picnic");
        selectProblem.add("problem02_BoardCover");
        selectProblem.add("problem03_ClockSync");

        listDataChild.put(listDataHeader.get(0), selectProblem);
    }
}
