package uit.com.restaurentmg.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uit.com.restaurentmg.R;
import uit.com.restaurentmg.adapter.TableRoomRecycleViewAdapter;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.room.RoomBuilder;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.table.Table;

public class TableRoomFragment extends Fragment {

    public static TableRoomFragment newInstance(int row, int col, int[] options) {

        Bundle args = new Bundle();
        args.putInt("row", row);
        args.putInt("col", col);
        args.putIntArray("options", options);

        TableRoomFragment fragment = new TableRoomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.table_room_recycleview)
    RecyclerView recyclerView;

    int row;
    int col;
    int[] options;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        row = bundle.getInt("row");
        col = bundle.getInt("col");
        options = bundle.getIntArray("options");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table_room, container, false);
        ButterKnife.bind(this,view);

        List<Table> tables = RoomBuilder.build().id(1).name("tang").col(col)
                                    .row(row).tables(options).create().getTables();

        TableRoomRecycleViewAdapter adapter = new TableRoomRecycleViewAdapter(getContext(),tables);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),col);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
