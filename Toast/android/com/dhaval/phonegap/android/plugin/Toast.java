package com.dhaval.phonegap.android.plugin;

import org.json.JSONArray;

import android.util.Log;

import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.phonegap.api.PluginResult.Status;

public class Toast extends Plugin {

	private static final String ACTION_LONG = "long";
	private static final String ACTION_SHORT = "short";

	@Override
	public PluginResult execute(String action, final JSONArray data,
			String callback) {
		PluginResult result = null;

		if (ACTION_LONG.equals(action)) {

			this.ctx.runOnUiThread(new Runnable() {

				@Override
				public void run() {
					try {
						CharSequence text = data.get(0).toString();
						int duration = android.widget.Toast.LENGTH_LONG;

						android.widget.Toast toast = android.widget.Toast
								.makeText(ctx, text, duration);
						toast.show();
					} catch (Exception e) {
						Log.e("ToastPlugin", "", e);
					}
				}
			});

			result = new PluginResult(Status.OK);
		} else if (ACTION_SHORT.equals(action)) {

			this.ctx.runOnUiThread(new Runnable() {

				@Override
				public void run() {
					try {
						CharSequence text = data.get(0).toString();
						int duration = android.widget.Toast.LENGTH_SHORT;

						android.widget.Toast toast = android.widget.Toast
								.makeText(ctx, text, duration);
						toast.show();
					} catch (Exception e) {
						Log.e("ToastPlugin", "", e);
					}
				}
			});

			result = new PluginResult(Status.OK);
		}
		return result;

	}
}
