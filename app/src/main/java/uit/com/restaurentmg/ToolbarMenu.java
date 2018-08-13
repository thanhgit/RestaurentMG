package uit.com.restaurentmg;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ToolbarMenu {

    AppCompatButton leftButton,rightButton;
    ToolBarMenuListener listener;
    Toolbar toolbar;
    AppCompatActivity refActivity;

    int numtab;


    public interface ToolBarMenuListener{
        void LeftButton(View view);
        void RightButton(View view);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setNumtab(int numtab) {
        this.numtab = numtab;
        if(this.numtab == 0){
            leftButton.callOnClick();
        }else if(this.numtab ==1){
            rightButton.callOnClick();
        }
    }

    public ToolbarMenu(final AppCompatActivity activity){
        if(activity instanceof ToolBarMenuListener) {
            listener = (ToolBarMenuListener) activity;
            refActivity = activity;
            leftButton = (AppCompatButton) activity.findViewById(R.id.toolbar_menu_image);
            rightButton = (AppCompatButton) activity.findViewById(R.id.toolbar_menu_menu);
            toolbar =(Toolbar) activity.findViewById(R.id.toolbar_menu);

            leftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        listener.LeftButton(v);
                        leftButton.setBackgroundColor(activity.getResources().getColor(R.color.secondaryLightColor));
                        rightButton.setBackgroundColor(activity.getResources().getColor(R.color.primaryDarkColor));
                    }
                }
            });

            rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        listener.RightButton(v);

                        leftButton.setBackgroundColor(activity.getResources().getColor(R.color.primaryDarkColor));
                        rightButton.setBackgroundColor(activity.getResources().getColor(R.color.secondaryLightColor));
                    }
                }
            });
        }
    }

}
