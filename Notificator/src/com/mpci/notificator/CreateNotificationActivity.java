package com.mpci.notificator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This activity is used to create simple notification....
 * 
 * @author Artak and Artush
 */
public class CreateNotificationActivity extends Activity {
	@SuppressWarnings("unused")
	private Button mSend;
	private EditText mText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	}

	/**
	 * @brief - This function used to run notification and change activity after
	 *        clicking on it buttons
	 * 
	 */
	@SuppressLint("NewApi")
	public void createNotification(View view) {
		Context context = getApplicationContext();
		mText = (EditText) findViewById(R.id.editText);
		String message = mText.getText().toString();
		
		//this tool allow to use icon as Bitmap
		Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);

		
		// notification is selected
		NotificationManager nM = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		
		// Prepare intent which is triggered if the notification is clicked
		Intent intent = new Intent(context, NotificationReceiverActivity.class);
		intent.putExtra(NotificationReceiverActivity.A, message);
		
		//pintent will pend created intent
		PendingIntent pintent = PendingIntent
				.getActivity(context, 0, intent, 0);
		//Creating new notification
		Notification notification = new NotificationCompat.Builder(context)
				.setContentTitle("Artush").setContentText(message)
				.setSmallIcon(R.drawable.ic_stat_notify_images)
				.setLargeIcon(largeIcon).build();

		notification.contentIntent = pintent;
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);

		// hide the notification after its selected
		notification.flags |= Notification.FLAG_AUTO_CANCEL;

		nM.notify(1, notification);

	}

}