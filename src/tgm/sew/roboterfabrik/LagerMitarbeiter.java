package tgm.sew.roboterfabrik;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class LagerMitarbeiter implements Mitarbeiter {

	private Lager lager;

	private int id;

    private ArrayBlockingQueue <Stringifyable> einlagernQueue;

    private boolean stop;
    /**
     * Erstellt einen LagerMitarbeiter welche an gegebenen filePfad ein Lager eröffnet
     *
     * @param filePfad Ort an dem gelagert werden soll
     */
    public LagerMitarbeiter(int id, String filePfad)
    {
        stop = false;
        this.id = id;
        try
        {
            this.lager = new Lager(filePfad);
        } catch (IOException e)
        {
            e.printStackTrace();  //ToDo Logger
        }
        einlagernQueue = new ArrayBlockingQueue<Stringifyable>(50);
    }

    /**
     * Gibt den LagerMitarbeiter die Anweisung im Lager nach einen bestimmten Artikel zu suchen
     *
     * @param type Typ des Artikels
     * @return Artikel oder null
     */
    public Stringifyable anfrage(Class<? extends Stringifyable> type) {
        Stringifyable item = null;

        if(type == Arm.class)
        {
            item = lager.pollArm();
        } else
        if(type == Auge.class)
        {
            item = lager.pollAuge();
        } else
        if(type == Kettenantrieb.class)
        {
            item = lager.pollKettenantrieb();
        } else
        if(type == Rumpf.class)
        {
            item = lager.pollRumpf();
        } else
        if(type == SpielzeugRoboter.class)
        {
            item = lager.pollThreadee();
        }
		return item;
	}

    /**
     * Ein Artikel wird dem Lagermitarbeiter zurückgeliefert
     * Arbeitet asynchron, item wird erst zwischen gespeichert und später eingelagert
     *
     * @param item Artikel der eingeliefert werden soll
     */
	public void einlagern(Stringifyable item) {
        this.einlagernQueue.add(item);
	}

	/**
	 * @see Stoppable#stop()
	 */
	public void stop() {

	}

    /**
     * @see Runnable#run()
     */
	public void run()
	{
	    while (!stop)
        {
            if(einlagernQueue.size() > 0)
            {
                Stringifyable item = einlagernQueue.poll();
                if(item instanceof Arm)
                {
                    lager.addArm((Arm)item);
                } else
                if(item instanceof Auge)
                {
                    lager.addAuge((Auge) item);
                } else
                if(item instanceof Kettenantrieb)
                {
                    lager.addKettenantrieb((Kettenantrieb) item);
                } else
                if(item instanceof Rumpf)
                {
                    lager.addRumpf((Rumpf) item);
                } else
                if(item instanceof SpielzeugRoboter)
                {
                    lager.addThreadee((SpielzeugRoboter) item);
                }
            }
        }
	}

    /**
     * Für was aucher immer der LagerMitarbeiter die id brauchen soll
     * @return eindeutige ID
     */
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Sekretariat getSekretariat() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
