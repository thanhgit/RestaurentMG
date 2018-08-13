package uit.com.restaurentmg.usersessionmg;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;

import uit.com.restaurentmg.R;

public class AlertDialogManager {
    public void showAlertDialog(Context context, String title, String message, Boolean status, final IAlertDialogFinishedListener alertDialogFinishedListener){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        if(status != null){
            alertDialog.setIcon((status)? R.drawable.icon_success:R.drawable.icon_fail);

            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialogFinishedListener.onFinshed();
                }
            });
        }

        alertDialog.show();
    }
}
