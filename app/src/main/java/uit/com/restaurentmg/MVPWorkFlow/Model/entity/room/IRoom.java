package uit.com.restaurentmg.MVPWorkFlow.Model.entity.room;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.table.Table;

public interface IRoom {
    IRoom id(long id);
    IRoom name(String name);
    IRoom row(int row);
    IRoom col(int col);
    IRoom tables(List<Table> tables);
    IRoom tables(int[] tables);
    Room create();
}
