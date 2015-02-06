package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class CourseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);


    }


    public void addCourseClicked(View v) {
        Intent res = new Intent();

        RadioGroup gradeGroup = (RadioGroup)findViewById(R.id.radioGrade);
        int getGrade = gradeGroup.getCheckedRadioButtonId();

        RadioButton grade = (RadioButton)findViewById(getGrade);

        EditText etRetCode = (EditText)findViewById(R.id.etCode);
        EditText etRetCR = (EditText)findViewById(R.id.etCR);

        res.putExtra("retCode", etRetCode.getText().toString());
        res.putExtra("retCredit", Integer.parseInt(etRetCR.getText().toString()));
        res.putExtra("retGrade", grade.getText().toString());

        setResult(RESULT_OK, res);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
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
