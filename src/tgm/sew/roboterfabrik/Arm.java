package tgm.sew.roboterfabrik;
/**
 * Ein Bauteil des Threadee
 */
public class Arm implements Teil {
	public String name;
	private int [] zahlen;

	/**
	 * F�llt zahlen mit Zufallszahlen
	 */
	public Arm() {
		name = "Arm";
        this.zahlen = new int[20];
        for(int i = 0;i<20;i++){
            zahlen[i] =(int)(Math.random() * (999 - 1+1)+1);
        }
	}

    @Override
    public String toCSV() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Zuffalszahlen um dem Montagemitarbeiter Arbeit zu bereiten
     */
    @Override
    public int[] getZahlen()
    {
        return new int[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int[] setZahlen()
    {
        return new int[0];  //To change body of implemented methods use File | Settings | File Templates.
    }
}
