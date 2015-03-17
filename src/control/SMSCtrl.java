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

import persistence.SMS;
import services.ISMSService;
import services.SMSService;

@Component
@Scope("session")
@Qualifier("smsCtrl")
public class SMSCtrl {
	private SMS newSMS = new SMS();
	private SMS editSMS;
	private SimpleSelection selection;
	private ISMSService sMSService=SMSService.instance;
	private String messageValOoredoo;
	private String messageValOrange;
	private String messageValTelecom;
	private HtmlExtendedDataTable table;
	private List<SMS> selectedSMSs = new ArrayList<SMS>();
	private ExtendedTableDataModel<SMS> dataModel;
	private List<SMS> sMSs = new ArrayList<SMS>();
	
	public void setSMSService(ISMSService sMSService) {
		
		this.sMSService = sMSService;
	}
		public ISMSService getSMSService() {
		return sMSService;
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
		setMessageValOoredoo("");
		setMessageValOrange("");
		setMessageValTelecom("");
		return "";
		
	}
	public String toAccueil(){
		return "list";
	}
	public String calculeParOperateur(){
		List<SMS> smss = sMSService.getAll();
		int nbr1=0;int nbr2=0;int nbr3=0;
		for(int i=0;i<smss.size();i++)
		{
			
					if(smss.get(i).getOperateur().compareToIgnoreCase("Ooredoo")==0){
						nbr1++;
					}else if(smss.get(i).getOperateur().compareToIgnoreCase("Orange")==0){
						nbr2++;
					}else if(smss.get(i).getOperateur().compareToIgnoreCase("Telecom")==0){
						nbr3++;
					}
		}
			
		String s1="";
		String s2="";
		String s3="";
		s1=String.valueOf(nbr1);
		setMessageValOoredoo(s1);
		s2=String.valueOf(nbr2);
		setMessageValOrange(s2);
		s3=String.valueOf(nbr3);
		setMessageValTelecom(s3);
		return "";
	}	
	
	public String createSMS() {
	
		sMSService.save(newSMS);
		newSMS = new SMS();
		return "list";
}


	public String deleteSMS() {
		SMS e = (SMS) getSelectedSMSs().iterator().next();
		sMSService.delete(e);
		resetSelection();
		getSMSs();
		return null;
	}

	public String editSMS() {
		editSMS = (SMS) getSelectedSMSs().iterator().next();
	
		return "edit";
	}

	public String updateSMS() {
		sMSService.update(editSMS);
		getSMSs();
		return "list";
	}

	public List<SMS> getSMSs() {
		sMSs = sMSService.getAll();
		return sMSs;
	}
	
	public SMS getNewSMS() {
		return newSMS;
	}

	public void setNewSMS(SMS sMS) {
		this.newSMS = sMS;
	}

	public SMS getEditSMS() {
		return editSMS;
	}

	public void setEditSMS(SMS editSMS) {
		this.editSMS = editSMS;
	}

	public void takeSelection() {
		getSelectedSMSs().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedSMSs().add((SMS) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedSMSs().clear();
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

	public List<SMS> getSelectedSMSs() {
		return selectedSMSs;
	}

	public void setSelectedSMSs(List<SMS> selectedSMSs) {
		this.selectedSMSs = selectedSMSs;
	}

	public void setSMSs(List<SMS> sMSs) {
		this.sMSs = sMSs;
	}

	public ExtendedTableDataModel<SMS> getSMSsDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<SMS>(
					new DataProvider<SMS>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public SMS getItemByKey(Object key) {
							for (SMS c : sMSs) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<SMS> getItemsByRange(int firstRow,
								int endRow) {
							return sMSs.subList(firstRow, endRow);
						}

						public Object getKey(SMS item) {
							return item.getCin();
						}

						public int getRowCount() {
							return sMSs.size();
						}

					});
		}
		return dataModel;
	}
	public String getMessageValOoredoo() {
		return messageValOoredoo;
	}
	public void setMessageValOoredoo(String messageValOoredoo) {
		this.messageValOoredoo = messageValOoredoo;
	}
	public String getMessageValOrange() {
		return messageValOrange;
	}
	public void setMessageValOrange(String messageValOrange) {
		this.messageValOrange = messageValOrange;
	}
	public String getMessageValTelecom() {
		return messageValTelecom;
	}
	public void setMessageValTelecom(String messageValTelecom) {
		this.messageValTelecom = messageValTelecom;
	}
	
}
