package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ProductPage;




/*
 * 參考 model與資料庫的table
 * 定義jtable物件
*/
public class JTableModel extends AbstractTableModel{
	//欄位標題
	private final String[] columns = {"產品編號","產品名稱", "價格", "數量", "內容"};	
	
    private List<ProductPage> data = new ArrayList<>();  

	public JTableModel(List<ProductPage> data) {
		super();
		this.data = data;
	}
	public List<ProductPage> getData() {
		return data;
	}
	public void setData(List<ProductPage> data) {
		 this.data = (data == null) ? new ArrayList<>() : new ArrayList<>(data);
	        fireTableDataChanged();
	}
	
	 public ProductPage getRow(int rowIndex) {
	        if (rowIndex < 0 || rowIndex >= data.size()) return null;
	        return data.get(rowIndex);
	    }


	public String[] getColumns() {
		return columns;
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

    @Override//欄位類型-->參考 model
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return Integer.class;
            case 3: return Integer.class;
            case 4: return String.class;
            default: return Object.class;
        }
    }

    @Override//定義欄位的值
    public Object getValueAt(int rowIndex, int columnIndex) {
    	ProductPage product = data.get(rowIndex);
        switch (columnIndex) {
            
        	case 0: return product.getId();
            case 1: return product.getProductname();
            case 2: return product.getPrice();
            case 3: return product.getAmount();
            case 4: return product.getContent();
            
            default: return null;
        }
    }
}