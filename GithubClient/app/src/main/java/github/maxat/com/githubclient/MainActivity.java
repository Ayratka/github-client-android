package github.maxat.com.githubclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


	@BindView (R.id.tvTitle)
	TextView tvTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);

		ButterKnife.bind (this);

		tvTitle.setText ("Hello, Android applicaiton");
	}
}
