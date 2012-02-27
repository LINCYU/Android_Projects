package lincyu.copypaste.example;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CopyPasteActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Button btn = (Button)findViewById(R.id.btn_share);
        btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, "Test");
				startActivity(Intent.createChooser(intent, "¤À¨É"));				
			}
        	
        });
        
        TextView tv_msg = (TextView)findViewById(R.id.tv_message);
        Intent intent = getIntent();
        Log.d("LINCYU", "ACTION: " + intent.getAction());
        if (intent.getAction().equals(Intent.ACTION_SEND)) {
        	
        	tv_msg.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
        }
        
    }
}