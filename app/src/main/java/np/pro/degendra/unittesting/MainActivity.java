package np.pro.degendra.unittesting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;


public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getName();
    Button button;
    EditText editText;
    TextView textView;

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx = this;

        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                networkMock();
            }
        });

    }

    private void networkMock() {
        textView.setText("Async Start");
        Toast.makeText(getApplicationContext(), "async start", Toast.LENGTH_SHORT).show();
        new DownloadFilesTask().execute(null, null, null);
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

    private class DownloadFilesTask extends AsyncTask<URL, String, Long> {
        protected Long doInBackground(URL... urls) {
            long totalSize = 0;
            try {
                Log.d(TAG, "Time to sleep for 10sec!");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return totalSize;
        }

        protected void onPostExecute(Long result) {
            Toast.makeText(getApplicationContext(), "async complete", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ctx, ViewActivity.class);
            startActivity(i);
        }
    }

}
