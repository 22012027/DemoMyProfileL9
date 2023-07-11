package sg.edu.rp.c346.id22012027.demomyprofilel9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextGPA;

    @Override
    protected void onPause() {
        super.onPause();
        String strName= editTextName.getText().toString();
        float gpa= Float.parseFloat(editTextGPA.getText().toString());
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor preEdit= prefs.edit();
        preEdit.putString("name", strName);
        preEdit.putFloat("gpa", gpa);
        preEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        String strName= prefs.getString("name", "john");
        float gpa= prefs.getFloat("gpa", 3);
        editTextName.setText(strName);
        editTextGPA.setText(gpa);
        Toast.makeText(MainActivity.this, strName, Toast.LENGTH_LONG);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName= findViewById(R.id.editTextName);
        editTextGPA= findViewById(R.id.editTextGPA);
    }
}