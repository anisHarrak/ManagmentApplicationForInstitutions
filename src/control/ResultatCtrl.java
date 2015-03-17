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

import persistence.Resultat;
import services.IResultatService;
import services.ResultatService;

@Component
@Scope("session")
@Qualifier("resultatCtrl")
public class ResultatCtrl {
	private Resultat newResultat = new Resultat();
	private Resultat editResultat;
	private SimpleSelection selection;
	private IResultatService resultatService=ResultatService.instance;
	
	private HtmlExtendedDataTable table;
	private List<Resultat> selectedResultats = new ArrayList<Resultat>();
	private ExtendedTableDataModel<Resultat> dataModel;
	private List<Resultat> resultats = new ArrayList<Resultat>();
	
	public void setResultatService(IResultatService resultatService) {
		
		this.resultatService = resultatService;
	}
		public IResultatService getResultatService() {
		return resultatService;
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
	
		
	public String createResultat() {
	
		resultatService.save(newResultat);
		newResultat = new Resultat();
		return "list";
}


	public String deleteResultat() {
		Resultat e = (Resultat) getSelectedResultats().iterator().next();
		resultatService.delete(e);
		resetSelection();
		getResultats();
		return null;
	}

	public String editResultat() {
		editResultat = (Resultat) getSelectedResultats().iterator().next();
	
		return "edit";
	}

	public String updateResultat() {
		resultatService.update(editResultat);
		getResultats();
		return "list";
	}

	public List<Resultat> getResultats() {
		resultats = resultatService.getAll();
		return resultats;
	}
	
	public Resultat getNewResultat() {
		return newResultat;
	}

	public void setNewResultat(Resultat resultat) {
		this.newResultat = resultat;
	}

	public Resultat getEditResultat() {
		return editResultat;
	}

	public void setEditResultat(Resultat editResultat) {
		this.editResultat = editResultat;
	}

	public void takeSelection() {
		getSelectedResultats().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedResultats().add((Resultat) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedResultats().clear();
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

	public List<Resultat> getSelectedResultats() {
		return selectedResultats;
	}

	public void setSelectedResultats(List<Resultat> selectedResultats) {
		this.selectedResultats = selectedResultats;
	}

	public void setResultats(List<Resultat> resultats) {
		this.resultats = resultats;
	}

	public ExtendedTableDataModel<Resultat> getResultatsDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Resultat>(
					new DataProvider<Resultat>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public Resultat getItemByKey(Object key) {
							for (Resultat c : resultats) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<Resultat> getItemsByRange(int firstRow,
								int endRow) {
							return resultats.subList(firstRow, endRow);
						}

						public Object getKey(Resultat item) {
							return item.getCin_res();
						}

						public int getRowCount() {
							return resultats.size();
						}

					});
		}
		return dataModel;
	}
}
