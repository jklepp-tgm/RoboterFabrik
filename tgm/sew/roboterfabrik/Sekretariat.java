package tgm.sew.roboterfabrik;
import java.util.HashSet;
// Id f�r Roboter und Mitarbeiter wird vergeben
public class Sekretariat implements Runnable {
	
	private int id=100;
	
	private int mitarbeiterId=100;
	
	private HashSet mitarbeiterSet;

	private HashSet kundenSet;

	private HashSet liferantenSet;

	private LagerMitarbeiter lagerMitarbeiter;

	private SpielzeugRoboter spielzeugRoboter;

	private Lieferant lieferant;

	private Kunde kunde;

	private Mitarbeiter mitarbeiter;
	
	public Sekretariat(){
		
	}
	/**
	 * eine eindeutige ID f�r den Threadee wird erstellt
	 * @return eindeutige ID f�r Threadee
	 */
	public String getUniqueID() {
		id++;
		return "Threadee-ID"+id;
	}
	/**
	 * eine eindeutige ID f�r den Mitarbeiter wird erstellt
	 * @return eindeutige ID f�r Mitarbeiter
	 */
	public String getUniqueMitarbeiterID() {
		mitarbeiterId++;
		return "Mitarbeiter-ID"+mitarbeiterId;
	}
	public Sekretariat(int laufzeit, int numLieferanten, int numMonteure, String filePfad) {

	}

	public void run()
	{
		
	}
}
