package org.gentra.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMICalculatorActivity extends Activity {
	EditText height, weight;
	TextView yourBMI, title, text, textBMI;
	Button calculate, info, treat;

	double heightInt = 0;
	int weightInt = 0;
	double bmi = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		height = (EditText) findViewById(R.id.height);
		weight = (EditText) findViewById(R.id.weight);
		calculate = (Button) findViewById(R.id.calculateBtn);
		yourBMI = (TextView) findViewById(R.id.yourBMI);
		textBMI = (TextView) findViewById(R.id.textBMI);
		info = (Button) findViewById(R.id.infoBtn);
		treat = (Button) findViewById(R.id.treatBtn);

		calculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				heightInt = Double.parseDouble(height.getText().toString())/100;
				weightInt = Integer.parseInt(weight.getText().toString());
				bmi = weightInt/ (heightInt * heightInt);
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
				yourBMI.setText(bmiString);

			}
		});

		info.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.infotreat);

				title = (TextView) findViewById(R.id.title);
				text = (TextView) findViewById(R.id.text);

				title.setText("Your BMI Information");

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
			}
		});

		treat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.infotreat);

				title = (TextView) findViewById(R.id.title);
				text = (TextView) findViewById(R.id.text);

				title.setText("Treatment");

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
			}
		});
	}
}