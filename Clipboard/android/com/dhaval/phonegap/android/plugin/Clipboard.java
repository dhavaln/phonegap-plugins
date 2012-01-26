package com.dhaval.phonegap.android.plugin;

import org.json.JSONArray;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;

import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.phonegap.api.PluginResult.Status;

public class Clipboard extends Plugin {

	private static final String ACTION_SET = "set";
	private static final String ACTION_GET = "get";

	@Override
	public PluginResult execute(String action, JSONArray data, String callback) {
		PluginResult result = null;
		if (ACTION_GET.equals(action)) {
			ClipboardManager clipboard = (ClipboardManager) this.ctx
					.getSystemService(Context.CLIPBOARD_SERVICE);

			String clipdata = "";
			if (clipboard.getText() != null) {
				clipdata = clipboard.getText().toString();
			}

			result = new PluginResult(Status.OK, clipdata);
		} else if (ACTION_SET.equals(action)) {
			try {
				ClipboardManager clipboard = (ClipboardManager) this.ctx
						.getSystemService(Context.CLIPBOARD_SERVICE);
				CharSequence cs = data.get(0).toString();
				clipboard.setText(cs);

				this.ctx.runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						CharSequence text = "Content copied to clipboard";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(ctx, text, duration);
						toast.show();
					}
				});
				
				
				result = new PluginResult(Status.OK, "text copied");
			} catch (Exception e) {
				result = new PluginResult(Status.ERROR, "error while copying - " + e.getMessage());
			}
		} else {
			result = new PluginResult(Status.ERROR, "unknown action");
		}
		return result;
	}
}
