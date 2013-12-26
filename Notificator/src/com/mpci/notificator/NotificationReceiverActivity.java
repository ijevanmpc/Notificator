package com.mpci.notificator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
/**
 * This activity is used to demonstrate example activity after clicking on notification....
 * 
 * @author Artak and Artush
 */
public class NotificationReceiverActivity extends Activity {
	//EditText mMessage;
	//TextView mText;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Dialog();
    /*Intent intent = new Intent(this, CreateNotificationActivity.class);
    startActivity(intent);
    */
   
  }
  
  void Dialog(){
	  AlertDialog.Builder builder = new AlertDialog.Builder(
				this);
		builder.setTitle("Notification!")
				.setMessage("message")
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
//	    Intent intent = new Intent(this, CreateNotificationActivity.class);
//		startActivity(intent);
  }
 
  
} 
