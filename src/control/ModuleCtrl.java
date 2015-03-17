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

import persistence.Module;
import services.IModuleService;
import services.ModuleService;

@Component
@Scope("session")
@Qualifier("moduleCtrl")
public class ModuleCtrl {
	private Module newModule = new Module();
	private Module editModule;
	private SimpleSelection selection;
	private IModuleService moduleService=ModuleService.instance;
	
	private HtmlExtendedDataTable table;
	private List<Module> selectedModules = new ArrayList<Module>();
	private ExtendedTableDataModel<Module> dataModel;
	private List<Module> modules = new ArrayList<Module>();
	
	public void setModuleService(IModuleService moduleService) {
		
		this.moduleService = moduleService;
	}
		public IModuleService getModuleService() {
		return moduleService;
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
	
		
	public String createAdmin() {
	
		moduleService.save(newModule);
		newModule = new Module();
		return "list";
}


	public String deleteModule() {
		Module e = (Module) getSelectedModules().iterator().next();
		moduleService.delete(e);
		resetSelection();
		getModules();
		return null;
	}

	public String editAdmin() {
		editModule = (Module) getSelectedModules().iterator().next();
	
		return "edit";
	}

	public String updateModule() {
		moduleService.update(editModule);
		getModules();
		return "list";
	}

	public List<Module> getModules() {
		modules = moduleService.getAll();
		return modules;
	}
	
	public Module getNewModule() {
		return newModule;
	}

	public void setNewModule(Module module) {
		this.newModule = module;
	}

	public Module getEditModule() {
		return editModule;
	}

	public void setEditModule(Module editModule) {
		this.editModule = editModule;
	}

	public void takeSelection() {
		getSelectedModules().clear();
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				getSelectedModules().add((Module) table.getRowData());
			}
		}
	}

	public void resetSelection() {
		getSelectedModules().clear();
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

	public List<Module> getSelectedModules() {
		return selectedModules;
	}

	public void setSelectedModules(List<Module> selectedModules) {
		this.selectedModules = selectedModules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public ExtendedTableDataModel<Module> getModulesDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Module>(
					new DataProvider<Module>() {

						private static final long serialVersionUID = 5054087821033164847L;

						public Module getItemByKey(Object key) {
							for (Module c : modules) {
								if (key.equals(getKey(c))) {
									return c;
								}
							}
							return null;
						}

						public List<Module> getItemsByRange(int firstRow,
								int endRow) {
							return modules.subList(firstRow, endRow);
						}

						public Object getKey(Module item) {
							return item.getTitre();
						}

						public int getRowCount() {
							return modules.size();
						}

					});
		}
		return dataModel;
	}
	
	
}
