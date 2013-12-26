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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNotificationActivity extends Activity {
	Button mSend;
	EditText mText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
	}

	@SuppressLint("NewApi")
	public void createNotification(View view) {
		Context context = getApplicationContext();
		mText = (EditText) findViewById(R.id.editText);
		String message = mText.getText().toString();
		
		Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);

		// Prepare intent which is triggered if the
		// notification is selected
		NotificationManager nM = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Intent intent = new Intent(context, NotificationReceiverActivity.class);
		//intent.putExtra("com.mpci.notificator.NotificationReceiverActivity", message);
		PendingIntent pintent = PendingIntent
				.getActivity(context, 0, intent, 0);
		Notification notification = new Notification.Builder(context)
				.setContentTitle("Artush").setContentText(message)
				.setSmallIcon(R.drawable.ic_stat_notify_images)
				.setLargeIcon(largeIcon)
				.build();
		notification.contentIntent = pintent;
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);

		// hide the notification after its selected
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		//notification.setLatestEventInfo(context, "Artush", message, pintent);
		nM.notify(100, notification);

	}
}