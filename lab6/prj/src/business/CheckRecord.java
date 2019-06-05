package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4975700961163341938L;
	private List<CheckRecordEntry> checkRecordEntrys = new ArrayList<CheckRecordEntry>();

	public void addReorceEntry(CheckRecordEntry entry) {
		checkRecordEntrys.add(entry);
	}
}
