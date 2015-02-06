package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    int cr = 0;         // Credits
    double gp = 0.0;    // Grade points
    double gpa = 0.0;   // Grade point average

    List<String> listCodes;
    List<Integer> listCredits;
    List<String> listGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCodes = new ArrayList<String>();
        listCredits = new ArrayList<Integer>();
        listGrades = new ArrayList<String>();

    }

    public void calculate(){

        double GradePoint = 0 ;
        int i;
        double GPA = 0.0 ;
        int credit = 0 ;
        for(i=0;i<listCredits.size();i++)
        {

            String resGrade = listGrades.get(i);
            if(resGrade.equals("A"))
            {
                GradePoint += 4.0 * listCredits.get(i) ;
            }
            else if(resGrade.equals("B+"))
            {
                GradePoint += 3.5 * listCredits.get(i);
            }
            else if(resGrade.equals("B"))
            {
                GradePoint += 3.0 * listCredits.get(i);
            }
            else if(resGrade.equals("C+"))
            {
                GradePoint += 2.5 * listCredits.get(i);
            }
            else if(resGrade.equals("C"))
            {
                GradePoint += 2.0 * listCredits.get(i);
            }
            else if(resGrade.equals("D+"))
            {
                GradePoint += 1.5 * listCredits.get(i);
            }
            else if(resGrade.equals("D"))
            {
                GradePoint += 1.0 * listCredits.get(i);
            }
            else if(resGrade.equals("F"))
            {
                GradePoint += 0.0 * listCredits.get(i);
            }
            credit += listCredits.get(i);
        }

        GPA = GradePoint/credit;
        if(credit ==0){
            GPA =0;
        }

        TextView tvGP = (TextView)findViewById(R.id.tvGP);
        TextView tvCr = (TextView)findViewById(R.id.tvCR);

        String total = String.valueOf(GPA);

        tvGP.setText(GradePoint+"");
        tvCr.setText(credit+"");

        gpa = GPA;

        TextView tvGPA = (TextView)findViewById(R.id.tvGPA);
        tvGPA.setText(Double.toString(gpa));

    }

    public void buttonClicked(View v) {

        int id = v.getId();

        switch(id){
            case R.id.button2:
                Intent i = new Intent(this, CourseActivity.class);
                startActivityForResult(i, 222);

                break;

            case R.id.button4:
                Intent l = new Intent(this, CourseListActivity.class);

                String s = "List of Courses \n";
                String code;
                int cr;
                String grade;

                for(int m=0 ; m < listCodes.size() ; m++){

                    code = listCodes.get(m);
                    cr = listCredits.get(m);
                    grade = listGrades.get(m);

                    s += code + " (" + cr + " credits) = " + grade + "\n";
                }


                l.putExtra("valueList", s);
                startActivity(l);

                break;

            case R.id.button:

                listCodes.clear();
                listGrades.clear();
                listCredits.clear();

                calculate();

                break;


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == 222) {
            if (resultCode == RESULT_OK) {
                String resCode = data.getStringExtra("retCode");
                int resCredit = data.getIntExtra("retCredit",0);
                String resGrade = data.getStringExtra("retGrade");

                listCodes.add(resCode);
                listCredits.add(resCredit);
                listGrades.add(resGrade);
                calculate();
            }
            else if (resultCode == RESULT_CANCELED) {

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
