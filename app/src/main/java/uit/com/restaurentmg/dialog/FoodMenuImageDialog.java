package uit.com.restaurentmg.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.R;

public class FoodMenuImageDialog extends DialogFragment {

    public static FoodMenuImageDialog newInstance() {

        Bundle args = new Bundle();

        FoodMenuImageDialog fragment = new FoodMenuImageDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.image_list_dialog_quit)
    ImageView quit;
    @BindView(R.id.image_list_dialog_image)
    ImageView image;

    byte[] arrByte;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrByte = getArguments().getByteArray("image");
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_menu_image_dialog, container, false);
        ButterKnife.bind(this, view);
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        final Window window = getDialog().getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        window.setBackgroundDrawableResource(R.color.transcolor);
        window.setGravity(Gravity.CENTER);

        Bitmap bitmap = BitmapFactory.decodeByteArray(arrByte, 0 , arrByte.length);
        image.setImageBitmap(bitmap);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        return view;
    }
}
