package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import persistence.SMSInscrit;
import services.ISMSInscritService;
import services.SMSInscritService;

@Component
@Scope("session")
@Qualifier("sms_inscritCtrl")
public class SMSInscritCtrl {
	private SMSInscrit newSMSInscrit = new SMSInscrit();
	private SMSInscrit editSMSInscrit;
	private SimpleSelection selection;
	private ISMSInscritService sMSInscritService=SMSInscritService.instance;
	private String messageValnbrmsg;
	private HtmlExtendedDataTable table;
	private List<SMSInscrit> selectedSMSInscrits = new ArrayList<SMSInscrit>();
	private ExtendedTableDataModel<SMSInscrit> dataModel;
	private List<SMSInscrit> sMSInscrits = new ArrayList<SMSInscrit>();
	
	public void setSMSInscritService(ISMSInscritService sMSInscritService) {
		
		this.sMSInscritService = sMSInscritService;
	}
		public ISMSInscritService getSMSInscritService() {
		return sMSInscritService;
	}

////////////////////////////////////////
		public boolean isValid(String c){
			try{
				System.out.println(c);
				
			float d=Float.parseFloat(c);
			if (d!=0){
			return true;
			}
			return false;
			}
			catch (Exception e) {
				
			return false;
			}
		}

//////////////////////////////////////	
	
		
		public boolean isInteger(String s){
			try {
				
			int i=Integer.valueOf(s.toString());
			if(i!=0){
				return true;
			}
			return false;
			} catch (Exception e) {
				return false;
			}
		}
		
		
		
		
/////////////////////////////////////////
	public String clean(){
		setMessageValnbrmsg("");
		return "";
	}
	public String calculeNbrMsgEnvoyes(){
		List<SMSInscrit> smss = sMSInscritService.getAll();
		int nbr=0;
		for(int i=0;i<smss.size();i++)
		{
			nbr++;
		}
		String s="";
		s=String.valueOf(nbr);
		setMessageValnbrmsg(s);
		return "";
	}
	public String toAccueil(){
		return "list";
	}	
	public String createSMSInscrit() {
	
		sMSInscritService.save(newSMSInscrit);
		newSMSInscrit = new SMSInscrit();
		return "list";
}


	public String deleteSMSInscrit() {
		SMSInscrit e = (SMSInscrit) getSelectedSMSInscrits().iterator().next();
		sMSInscritService.delete(e);
		resetSelection();
		getSMSInscrits();
		return null;
	}

	public String editSMSInscrit() {
		editSMSInscrit = (SMSInscrit) getSelectedSMSInscrits().iterator().next();
	
		return "edit";
	}

	public String updateSMSInscrit() {
		sMSInscritService.update(editSMSInscrit);
		getSMSInscrits();
		return "list";
	}

	public List<SMSInscrit> getSMSInscrits() {
		sMSInscrits = sMSInscritService.getAll();
		return sMSInscrits;
	}
	
	public SMSInscrit getNewSMSInscrit() {
		return newSMSInscrit;
	}

	public void setNewSMSInscrit(SMSInscrit sMSInscrit) {
		this.newSMSInscrit = sMSInscrit;
	}

	public SMSInscrit getEditSMSInscrit() {
		return editSMSInscrit;
	}

	public void setEditSMSInscrit(SMSInscrit editSMSInscrit) {
		this.editSMSInscrit = editSMSInscrit;
	}

	public void takeSelection() {
		getSelectedSMSInscrits().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedSMSInscrits().add((SMSInscrit) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedSMSInscrits().clear();
	}

	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}

	public void setTable(HtmlExtendedDataTable table) {
		this.table = table;
	}

	public HtmlExtendedDataTable getTable() {
		return table;
	}

	public SimpleSelection getSelection() {
		return selection;
	}

	public List<SMSInscrit> getSelectedSMSInscrits() {
		return selectedSMSInscrits;
	}

	public void setSelectedSMSInscrits(List<SMSInscrit> selectedSMSInscrits) {
		this.selectedSMSInscrits = selectedSMSInscrits;
	}

	public void setSMSInscrits(List<SMSInscrit> sMSInscrits) {
		this.sMSInscrits = sMSInscrits;
	}

	public ExtendedTableDataModel<SMSInscrit> getSMSsDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<SMSInscrit>(
					new DataProvider<SMSInscrit>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public SMSInscrit getItemByKey(Object key) {
							for (SMSInscrit c : sMSInscrits) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<SMSInscrit> getItemsByRange(int firstRow,
								int endRow) {
							return sMSInscrits.subList(firstRow, endRow);
						}

						public Object getKey(SMSInscrit item) {
							return item.getCin();
						}

						public int getRowCount() {
							return sMSInscrits.size();
						}

					});
		}
		return dataModel;
	}
	public String getMessageValnbrmsg() {
		return messageValnbrmsg;
	}
	public void setMessageValnbrmsg(String messageValnbrmsg) {
		this.messageValnbrmsg = messageValnbrmsg;
	}
	
}
