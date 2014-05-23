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
	 * Osztályváltozó amiben a játékteret tárolom.
	 */
	private static int[][] sakk;
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
		sakk = new int[8][8];
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				sakk[i][j] = 0;
			}
		}
		int jatekos=0;
		int lepes1, lepes2;
		Scanner rc = new Scanner(System.in);
		System.out.println("Adja meg az első játékos huszárának kezdőhelyét!");
		while(true){
		lepes1=rc.nextInt();
		lepes2=rc.nextInt();
			if(lepes1>-1 && lepes2>-1 && lepes1<8 && lepes2<8)break;
			else System.out.println("A megadott kezdőhely nem a táblán található!");
		}
		logger.info("A megadott pozició helyes");
		sakk[lepes1][lepes2]=1;
		int ai1=lepes1, aj1=lepes2;
		System.out.println("Adja meg a második játékos huszárának kezdőhelyét!");
		while(true){
		lepes1=rc.nextInt();
		lepes2=rc.nextInt();
		if(lepes1>-1 && lepes2>-1 && lepes1<8 && lepes2<8 && sakk[lepes1][lepes2]==0)break;
		else System.out.println("A megadott kezdőhely nem a táblán található!");
		}
		logger.info("A megadott pozició helyes");
		sakk[lepes1][lepes2]=2;
		int ai2=lepes1, aj2=lepes2;
		int i=0;
		while(true){
			for(i=0; i<8; i++){
				for(int j=0; j<8; j++)
					System.out.print(sakk[i][j]+" ");
				System.out.println();
			}
			System.out.println("Adja meg a lépését!");
			lepes1=rc.nextInt();
			lepes2=rc.nextInt();
			
			if(jatekos==0){
			Lep x = new Lep(ai1,aj1,lepes1,lepes2, sakk);
			if(x.lepes()){
				sakk[ai1][aj1]=9;
				sakk[lepes1][lepes2]=1;
				ai1=lepes1;
				aj1=lepes2;
				jatekos=1;
	
			}
			else {if(x.vanemeglepes()==false){System.out.println("A masodik jatekos nyert!");break;}
				System.out.println("Az ön lépése érvénytelen, adjon meg újat!");
			}
			}else{
				Lep x = new Lep(ai2,aj2,lepes1,lepes2,sakk);
				if(x.lepes()){
					sakk[ai2][aj2]=9;
					sakk[lepes1][lepes2]=2;
					ai2=lepes1;
					aj2=lepes2;
					jatekos=0;
														}
				else {if(x.vanemeglepes()==false){System.out.println("Az elso jatekos nyert!");break;}
					System.out.println("Az ön lépése érvénytelen, adjon meg újat!");}
			
				}
			
					}
		
		
	rc.close();
	}

}
