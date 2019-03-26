package home.com.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView ntd;
    private TextView us;
    private TextView jp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findview();
    }

    private void findview() {
        ntd = findViewById(R.id.ntd);
        us = findViewById(R.id.us);
        jp = findViewById(R.id.jp);
    }
    public void change(View view){
        String t = ntd.getText().toString();

        if(t.equals("")){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.no_info)
                    .setPositiveButton("OK", null)
                    .show();
        }else {
            float tmoney = Float.parseFloat(t);
            float umoney;
            float jmoney;
            umoney = tmoney / 30.9f;
            jmoney = tmoney / 0.26f;
            us.setText(String.valueOf(umoney));
            jp.setText(String.valueOf(jmoney));
            Log.d("MainActivity", getString(R.string.usd_is) + umoney);
            new AlertDialog.Builder(this)
                .setTitle(R.string.result)
                .setMessage(getString(R.string.usd_is)+ umoney)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        ntd.setText("");
                    }
                })
                .show();
        Toast.makeText(this,getString(R.string.usd_is) + umoney,Toast.LENGTH_LONG).show();
        }
    }
}
