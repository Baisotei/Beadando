
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ebben az osztályban történik a játék futása.
 * @author Bardócz Balázs
 *
 */
public class Main {
	/**
	 * A logoláshoz szükséges változó.
	 */
	static final Logger logger = LoggerFactory.getLogger(Main.class);
	
    /**
     * A játékot 2 játékos játsza, akik az elején megadják a huszáraik kezdőhelyét. 
     * Innentől kezdve a játék akkor ér véget, ha az egyik játékosnak már nincs hova lépnie.
     * A játékosok felváltva adják meg a kívánt lépést, ami ha megfelel a szabályoknak és üres
     * a mező akkor végrehajtódik.
     * @param args A parancssori argumentumokat tárolja.
     */
	public static void main(String[] args) {
		
		int jatekos=0;
		int lepes1 = 0, lepes2 = 0;
		Scanner rc = new Scanner(System.in);
		System.out.println("Adja meg az első játékos huszárának kezdőhelyét!");
		String seged;
		String[] seged2;
		while(true){
			seged=rc.nextLine();
			if(seged.length()>3){System.out.println("Nem megfelelő input! A helyes input:szám,szám!");continue;}
			seged2=seged.split(",");
			lepes1=Integer.parseInt(seged2[0]);
			lepes2=Integer.parseInt(seged2[1]);
			if(lepes1>-1 && lepes2>-1 && lepes1<8 && lepes2<8)break;
			else {logger.info("A tabla 8x8-as, az indexeles 0-7.ig tart.");System.out.println("A megadott kezdőhely nem a táblán található!");}
			

		}
		logger.info("A megadott pozició helyes");
		int ai1=lepes1, aj1=lepes2;
		System.out.println("Adja meg a második játékos huszárának kezdőhelyét!");
		while(true){
			seged=rc.nextLine();
			if(seged.length()>3){System.out.println("Nem megfelelő input! A helyes input:szám,szám!");continue;}
			seged2=seged.split(",");
			lepes1=Integer.parseInt(seged2[0]);
			lepes2=Integer.parseInt(seged2[1]);
		if(lepes1>-1 && lepes2>-1 && lepes1<8 && lepes2<8)break;
		else {logger.info("A tabla 8x8-as, az indexeles 0-7.ig tart.");System.out.println("A megadott kezdőhely nem a táblán található!");}
		
		}
		logger.info("A megadott pozició helyes");
		int ai2=lepes1, aj2=lepes2;
		Tabla jatek = new Tabla(ai1,aj1,ai2,aj2);
		while(true){
			jatek.kirajzol();
			System.out.println("Adja meg a lépését!");
			seged=rc.nextLine();
			if(seged.length()>3){System.out.println("Nem megfelelő input! A helyes input:szám,szám!");continue;}
			seged2=seged.split(",");
			lepes1=Integer.parseInt(seged2[0]);
			lepes2=Integer.parseInt(seged2[1]);
			if(jatekos==0){
			Lep x = new Lep(jatek.getA(),jatek.getB(),lepes1,lepes2, jatek.getSajat());
			if(x.lepes()){
				jatek.felvisz(lepes1,lepes2,jatekos);
				jatekos=1;
	
			}
			else {if(x.vanemeglepes()==false){System.out.println("A masodik jatekos nyert!");break;}
				System.out.println("Az ön lépése érvénytelen, adjon meg újat!");
			}
			}else{
				Lep x = new Lep(jatek.getC(),jatek.getD(),lepes1,lepes2,jatek.getSajat());
				if(x.lepes()){
					jatek.felvisz(lepes1, lepes2, jatekos);
					jatekos=0;
														}
				else {if(x.vanemeglepes()==false){System.out.println("Az elso jatekos nyert!");break;}
					System.out.println("Az ön lépése érvénytelen, adjon meg újat!");}
			
				}
			
					}
		
		
	rc.close();
	}

}
