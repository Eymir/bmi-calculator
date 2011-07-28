package org.gentra.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class BMICalculatorActivity extends Activity {
	EditText height, weight;
	TextView yourBMI, text, textBMI;
	Button calculate, info, treat;

	double heightInt = 0;
	int weightInt = 0;
	double bmi = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Create the adView
		AdView adView = new AdView(this, AdSize.BANNER, "a14e305fcf709f2");
		// Lookup your LinearLayout assuming it’s been given
		// the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout) findViewById(R.id.admob);
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		AdRequest request = new AdRequest();
		request.setTesting(false);
		adView.loadAd(request);

		height = (EditText) findViewById(R.id.height);
		weight = (EditText) findViewById(R.id.weight);
		calculate = (Button) findViewById(R.id.calculateBtn);
		yourBMI = (TextView) findViewById(R.id.yourBMI);
		textBMI = (TextView) findViewById(R.id.textBMI);
		info = (Button) findViewById(R.id.infoBtn);
		treat = (Button) findViewById(R.id.treatBtn);
		text = (TextView) findViewById(R.id.txt);

		calculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!height.getText().toString().equals("")
						&& !weight.getText().toString().equals("")) {

					heightInt = Double.parseDouble(height.getText().toString()) / 100;
					weightInt = Integer.parseInt(weight.getText().toString());
					bmi = weightInt / (heightInt * heightInt);
					String bmiString = "";

					if (bmi <= 18.5) {
						bmiString = String.valueOf(bmi).toString()
								+ "(Underweight)";
					} else if (bmi > 18.5 && bmi <= 24.99) {
						bmiString = String.valueOf(bmi) + " (Normal Weight)";
					} else if (bmi >= 25 && bmi <= 29.99) {
						bmiString = String.valueOf(bmi) + " (Overweight)";
					} else if (bmi >= 30 && bmi <= 34.99) {
						bmiString = String.valueOf(bmi) + " (Obesity Class 1)";
					} else if (bmi >= 35 && bmi <= 39.99) {
						bmiString = String.valueOf(bmi) + " (Obesity Class 2)";
					} else if (bmi >= 40) {
						bmiString = String.valueOf(bmi) + " (Morbid Obesity)";
					}

					textBMI.setVisibility(0); // 0 = Visible ; 4 = Invinsible
					info.setVisibility(0);
					treat.setVisibility(0);
					text.setVisibility(4);
					yourBMI.setText(bmiString);
				}

			}
		});

		info.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (bmi <= 18.5) {
					text.setText(R.string.underweight_info);
				} else if (bmi > 18.5 && bmi <= 24.99) {
					text.setText(R.string.normal_info);
				} else if (bmi >= 25 && bmi <= 29.99) {
					text.setText(R.string.overweight_info);
				} else if (bmi >= 30 && bmi <= 34.99) {
					text.setText(R.string.ob1_info);
				} else if (bmi >= 35 && bmi <= 39.99) {
					text.setText(R.string.ob2_info);
				} else if (bmi >= 40) {
					text.setText(R.string.ob3_info);
				}
				text.setVisibility(0);
			}
		});

		treat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (bmi <= 18.5) {
					text.setText(R.string.underweight_treat);
				} else if (bmi > 18.5 && bmi <= 24.99) {
					text.setText(R.string.normal_treat);
				} else if (bmi >= 25 && bmi <= 29.99) {
					text.setText(R.string.overweight_treat);
				} else if (bmi >= 30 && bmi <= 34.99) {
					text.setText(R.string.ob_treat);
				} else if (bmi >= 35 && bmi <= 39.99) {
					text.setText(R.string.ob_treat);
				} else if (bmi >= 40) {
					text.setText(R.string.ob_treat);
				}
				text.setVisibility(0);
			}
		});
	}
}