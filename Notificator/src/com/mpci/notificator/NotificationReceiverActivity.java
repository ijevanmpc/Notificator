package com.mpci.notificator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * This activity is used to demonstrate example activity and show dialog after clicking on
 * notification....
 * 
 * @author Artak and Artush
 */
public class NotificationReceiverActivity extends Activity {
	static final String A = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		Dialog();

	}
	/**
	 * @brief - This function used to create alert dialog when notification is clicked
	 * 
	 */
	void Dialog() {
		Intent intent = getIntent();
		final String message = intent.getStringExtra(A);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Test Dialog!")
				.setMessage(message)
				.setIcon(R.drawable.ic_launcher)
				.setCancelable(true)
				.setPositiveButton("Okay",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();

	}

}
