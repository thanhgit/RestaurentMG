package uit.com.restaurentmg.MVPWorkFlow.Model.entity.room;

import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.table.Table;

public class Room {
    private long id;
    private String name;
    private List<Table> tables;
    private int row;
    private int col;

    public Room(){

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
