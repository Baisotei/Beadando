import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ez az osztály megvizsgálja hogy a játékos lépése szabályos-e,táblán van-e,nem foglalt a hely
 * ahova lépne, és hogy a játékos tud-e olyan lépést tenni amire az előbbiek teljesülnek.
 * @author Bardócz Balázs
 *
 */
public class Lep {
	/**
	 * A logoláshoz szükséges változó.
	 */
	static final Logger logger = LoggerFactory.getLogger(Lep.class);
	/**
	 * Segédváltozók amikben a játékos aktuális pozicióját fogjuk tárolni.
	 * Az aktualispoz1 a sor, az aktualispoz2 az oszlopindex.
	 */
	private int aktualispoz1, aktualispoz2;
	/**
	 * Segédváltozók amikben annak mezőnek a sor és oszlopindexét fogjuk tárolni
	 * amire a játékos lépni szeretne.
	 */
	private int hovaakar1, hovaakar2;
	/**
	 * Segédtömb amiben a játéktábla aktuális állapotát fogjuk tárolni.
	 */
	private int[][] sajat={{ 0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0},	
							{0,0,0,0,0,0,0,0,0},	
							{0,0,0,0,0,0,0,0,0},	
							{0,0,0,0,0,0,0,0,0},	
								};
	/**
	 * Konstruktor a Lep osztály számára.
	 * @param i A játékos aktuális poziciójának a sor indexe.
	 * @param j A játékos aktuális poziciójának a oszlop indexe.
	 * @param k Annak a mezőnek a sor indexe ahova a játékos lépni szeretne.
	 * @param l Annak a mezőnek az oszlop indexe ahova a játékos lépni szeretne.
	 * @param t Az aktuális játéktábla.
	 */
	public Lep(int i, int j, int k, int l, int[][] t){
		logger.info("Meghívták a konstruktort.");
		aktualispoz1=i;
		aktualispoz2=j;
		hovaakar1=k;
		hovaakar2=l;
		for(int a=0; a<8; a++)
			for(int b=0; b<8; b++)
			  sajat[a][b]=t[a][b];
	}
	/**
	 * Megnézi hogy az adott lépés szabályos huszárlépés-e.
	 * @return true ha huszárlépés, false egyébként.
	 */
	public boolean szabalyose(){
		if(aktualispoz1+2==hovaakar1 || aktualispoz1-2==hovaakar1)
			if(aktualispoz2+1==hovaakar2 || aktualispoz2-1==hovaakar2)
				return true;
			else {logger.info("A lépés nem huszár lépés!");return false;}
		else
			if(aktualispoz2+2==hovaakar2 || aktualispoz2-2==hovaakar2)
				if(aktualispoz1+1==hovaakar1 || aktualispoz1-1==hovaakar1)
					return true;
				else {logger.info("A lépés nem huszár lépés!"); return false;}
		logger.info("A lépés nem huszár lépés!");
		return false;		
	}
	/**
	 * Megnézi hogy az adott lépés a sakktábla határain belül van-e.
	 * @return true ha belül van, false egyébként.
	 */
	public boolean tablanvan(){
		if(hovaakar1>-1 && hovaakar2>-1 && hovaakar1<8 && hovaakar2<8)
			return true;
		else {
		logger.info("A lépés nem a táblán van!");	
		return false;
		}
		
	}
	/**
	 * Megnézi hogy a mező ahova lépni kívánunk üres-e.
	 * @return true ha üres, false egyébként.
	 */
	public boolean nemfoglalt()
	{
		if(sajat[hovaakar1][hovaakar2]==0)
			return true;
		logger.info("A lépés foglalt mezőre lépne!");
		return false;
	}
	/**
	 * Megvizsgálja hogy teljesül-e a lépésre az, hogy a táblán van ahova lépni akar,
	 * hogy huszárlépésben lépett-e, vagy hogy a üres-e az a mező ahova lépni kíván.
	 * @return true ha a fenti feltételek teljesülnek, false egyébként.
	 */
	public boolean lepes(){
		if(szabalyose() && tablanvan() && nemfoglalt())
			return true;
		return false;
	}
	/**
	 * Megnézi hogy az adott játékosnak van-e még lépése hátra.
	 * @return true ha van, false ha nincs.
	 * 
	 */
	public boolean vanemeglepes(){
		if(aktualispoz1-2>-1 && aktualispoz2+1>-1 && aktualispoz1-2<8 && aktualispoz2+1<8)
			if(sajat[aktualispoz1-2][aktualispoz2+1]==0)return true; 
		
		if(aktualispoz1-2>-1 && aktualispoz2-1>-1 && aktualispoz1-2<8 && aktualispoz2-1<8)
			if(sajat[aktualispoz1-2][aktualispoz2-1]==0)return true;
		
		if(aktualispoz1+2>-1 && aktualispoz2+1>-1 && aktualispoz1+2<8 && aktualispoz2+1<8)
			if(sajat[aktualispoz1+2][aktualispoz2+1]==0)return true; 
		
		if(aktualispoz1+2>-1 && aktualispoz2-1>-1 && aktualispoz1+2<8 && aktualispoz2-1<8)
			if(sajat[aktualispoz1+2][aktualispoz2-1]==0)return true; 
		
		if(aktualispoz1-1>-1 && aktualispoz2+2>-1 && aktualispoz1-1<8&& aktualispoz2+2<8)
			if(sajat[aktualispoz1-1][aktualispoz2+2]==0)return true; 
		
		if(aktualispoz1+1>-1 && aktualispoz2+2>-1 && aktualispoz1+1<8 && aktualispoz2+2<8)
			if(sajat[aktualispoz1+1][aktualispoz2+2]==0)return true; 
		
		if(aktualispoz1+1>-1 && aktualispoz2-2>-1 && aktualispoz1+1<8 && aktualispoz2-2<8)
			if(sajat[aktualispoz1+1][aktualispoz2-2]==0)return true; 
		
		if(aktualispoz1-1>-1 && aktualispoz2-2>-1 && aktualispoz1-1<8 && aktualispoz2-2<8)
			if(sajat[aktualispoz1-1][aktualispoz2-2]==0)return true; 
		return false;
		
	}
	
	
}
