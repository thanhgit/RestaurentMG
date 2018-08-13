package uit.com.restaurentmg.MVPWorkFlow.Model.entity.table;

public interface ITable {
    ITable id(long id);
    ITable name(String name);
    ITable state(boolean state);
    ITable nRow(int nRow);
    ITable nCol(int nCol);
    Table create();
}
