package util;

import model.ProductPage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SelectProductJTable extends AbstractTableModel {

    // 欄位：0 是勾選
    private final String[] columns = {"選取", "編號", "名稱", "價格", "庫存"};
    private List<ProductPage> data = new ArrayList<>();
    
    private void fillForm (ProductPage p) {
        if (p == null) {  return;  }
     }

    public void setData(List<ProductPage> list) {
        data = (list == null) ? new ArrayList<>() : new ArrayList<>(list);
        fireTableDataChanged();
    }

    public ProductPage getRow(int row) {
        if (row < 0 || row >= data.size()) return null;
        return data.get(row);
    }

    public List<ProductPage> getSelectedRows() {
        List<ProductPage> selected = new ArrayList<>();
        for (ProductPage p : data) {
            if (p.isSelected()) selected.add(p);
        }
        return selected;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Boolean.class; // 勾選
            case 1: return Integer.class; // id
            case 2: return String.class;  // productname
            case 3: return Integer.class; // price
            case 4: return Integer.class; // amount
            case 5: return String.class; // content
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // 只允許勾選欄可編輯
        return columnIndex == 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductPage p = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.isSelected();
            case 1: return p.getId();
            case 2: return p.getProductname();
            case 3: return p.getPrice();
            case 4: return p.getAmount();
            case 5: return p.getContent();
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            ProductPage p = data.get(rowIndex);
            boolean checked = (aValue instanceof Boolean) ? (Boolean) aValue : false;
            p.setSelected(checked);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}
