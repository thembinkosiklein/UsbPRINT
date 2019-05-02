package cordova.plugin.usbprint;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Spinner;

public class UsbPRINT extends CordovaPlugin implements Activity {
    public static boolean isLAN = false;
    public static String portName = "USB";
    public static int portSettings = 0;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        boolean valid = false;
        if (action.equalsIgnoreCase("print")) {
            this.print(args.optJSONObject(0), callbackContext);
            return true;
        }
        return valid;
    }

    /**
     * Sends the provided content to the printing controller and opens them.
     * * @param content The content or file to print.
     * 
     * @param settings Additional settings how to render the content.
     * @param callback The plugin function to invoke with the result.
     */
    private void print(@Nullable String content, CallbackContext callbackContext) {
        if (isLAN) {
            PrinterFunctionsLAN.PrintSampleReceipt(portName, portSettings);
        } else {
            PrinterFunctions.PrintSampleReceipt(portName, portSettings);
        }
    }
}
