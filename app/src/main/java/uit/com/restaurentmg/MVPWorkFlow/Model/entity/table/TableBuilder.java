package uit.com.restaurentmg.MVPWorkFlow.Model.entity.table;

public class TableBuilder implements ITable {

    private static ITable iTable;
    private static Table table;

    public static ITable build(){
        iTable = new TableBuilder();
        table = new Table();
        return iTable;
    }
    @Override
    public ITable id(long id) {
        table.setId(id);
        return iTable;
    }

    @Override
    public ITable name(String name) {
        table.setName(name);
        return iTable;
    }

    @Override
    public ITable state(boolean state) {
        table.setState(state);
        return iTable;
    }

    @Override
    public ITable nRow(int nRow) {
        table.setnRow(nRow);
        return iTable;
    }

    @Override
    public ITable nCol(int nCol) {
        table.setnCol(nCol);
        return iTable;
    }

    @Override
    public Table create() {
        return table;
    }

}
