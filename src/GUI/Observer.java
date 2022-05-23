package GUI;

import java.util.List;

import edu.marius.Competenta;
import edu.marius.Persoana;

public interface Observer {
	
	public void update(List<Persoana> list);
	
	public void update_activi(List<Persoana> list);
	
	public void update_inactivi(List<Persoana> list);
	
	public void update_lista_detalii(List<Competenta> list);
}
