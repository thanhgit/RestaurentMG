package uit.com.restaurentmg.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.table.Table;
import uit.com.restaurentmg.activity.SearchActivity;

public class TableRoomRecycleViewAdapter extends RecyclerView.Adapter<TableRoomRecycleViewAdapter.RoomHolder> {

    private List<Table> room = new ArrayList<>();
    private Context context;

    public TableRoomRecycleViewAdapter(Context context,List<Table> room) {
        this.room = room;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table_room, parent, false);


        return new RoomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHolder holder, int position) {
        final Table table = room.get(position);

        if(table.isState()){
            holder.state.setBackgroundColor(Color.argb(80,255,255,255));
            holder.state.setImageResource(R.drawable.icon_emptytable);

        }else{
            holder.state.setBackgroundColor(Color.rgb(255,255,255));
            holder.state.setImageResource(R.drawable.icon_orderedtable);
        }

        holder.state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putLong("table_id", table.getnCol()*table.getnRow());
                intent.putExtra("data", bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return room.size();
    }

    static class RoomHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.table_room_state)
        ImageView state;

        public RoomHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
