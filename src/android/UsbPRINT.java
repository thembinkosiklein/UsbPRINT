package cordova.plugin.usbprint;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import JOptionPane.showMessageDialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Spinner;

import android.util.Log;

public class UsbPRINT extends CordovaPlugin {
    public static String portName = "USB:";
    public static int portSettings = 0;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        boolean valid = false;
        if (action.equalsIgnoreCase("print")) {
            this.print(args.optString(0), callbackContext);
            return true;
        }
        return valid;
    }

    /**
     * Sends the provided content to the printing controller.
     * 
     * @param content  The content or file to print.
     * @param callback The plugin function to invoke with the result.
     */
    private void print(String content, CallbackContext callback) {
        if (content != null) {
            try {
                showMessageDialog(null, "suposed to print sample receipt after this");
                PrintSampleReceipt(portName, portSettings);
            } catch (Exception ex) {
                callback.error("An unexpected error occurred: " + ex);
            }
        } else {
            callback.error("Content cannot be null.");
        }
    }

    /**
     * Sends the provided content to the printing controller.
     * 
     * @param content  The content or file to print.
     * @param callback The plugin function to invoke with the result.
     */
    private void printSampleText(String content, CallbackContext callback) {
        if (content != null) {
            try {
                PrintText(portName, portSettings, 0, 0, 0, 0, 0, 0, 0, 0, "sample text");
            } catch (Exception ex) {
                callback.error("An unexpected error occurred: " + ex);
            }
        } else {
            callback.error("Content cannot be null.");
        }
    }

    public static native int PrintSampleReceipt(String portName, int portSettings);

    public static native int PrintText(String portName, int portSettings, int underline, int invertColor,
            int emphasized, int upsideDown, int heightExpansion, int widthExpansion, int leftMargin, int alignment,
            String textData);
}
