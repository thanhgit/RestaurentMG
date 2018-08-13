package uit.com.restaurentmg.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import uit.com.restaurentmg.R;
import uit.com.restaurentmg.dialog.FoodMenuImageDialog;


public class FoodMenuImageRecycleViewAdapter extends RecyclerView.Adapter<FoodMenuImageRecycleViewAdapter.ImageHolder> {
    private List<Bitmap> menuFoods=new ArrayList<>();
    private Activity activity;

    public FoodMenuImageRecycleViewAdapter(List<Bitmap> images, Activity activity){
        super();
        this.menuFoods = images;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_menu_image, parent, false);

        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageHolder holder, int position) {
        final Bitmap img = menuFoods.get(position);
        holder.imageView.setImageBitmap(img);


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable)holder.imageView.getDrawable()).getBitmap();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                FoodMenuImageDialog dialog = new FoodMenuImageDialog();
                Bundle bundle = new Bundle();
                bundle.putByteArray("image", stream.toByteArray() );
                dialog.setArguments(bundle);
                dialog.show(activity.getFragmentManager(), FoodMenuImageDialog.class.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuFoods.size();
    }

    public static class ImageHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public ImageHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.food_menu_image_image_view);
        }
    }
}
