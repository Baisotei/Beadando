/**
 * Ez az osztály tartalmazza az aktuális játéktáblát, felviszi a játkosok lépéseit
 * a táblára, és kirajzolja a táblát.
 * @author Bardócz Balázs
 *
 */
public class Tabla {
	/**
	 * Tömb amiben a játéktábla aktuális állapotát fogjuk tárolni.
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
	 * Az első játékos aktuális poziciójának 
	 * sorindexét tároló változó getter függvénye.
	 * @return a fent említett változó
	 */
	public int getA() {
		return a;
	}
	/**
	 * Az első játékos aktuális poziciójának 
	 * oszlopindexét tároló változó getter függvénye.
	 * @return a fent említett változó
	 */
	public int getB() {
		return b;
	}
	/**
	 * A második játékos aktuális poziciójának 
	 * sorindexét tároló változó getter függvénye.
	 * @return a fent említett változó
	 */
	public int getC() {
		return c;
	}
	/**
	 * A második játékos aktuális poziciójának 
	 * oszlopindexét tároló változó getter függvénye.
	 * @return a fent említett változó
	 */
	public int getD() {
		return d;
	}
	/**
	 * Az első és második játékos aktuális pozicióját tároló változók. 
	 */
	private int a, b, c, d;
	/**
	 * Konstruktor a Tabla osztály számára.
	 * 
	 * @param i az első játékos sorindexe
	 * @param j az első játékos oszlopindexe
	 * @param k a második játékos sorindexe
	 * @param l a második játékos oszlopindexe
	 */
	public Tabla(int i, int j, int k, int l){
	sajat[i][j]=1;
	a=i;
	b=j;
	sajat[k][l]=2;
	c=k;
	d=l;
	}
	/**
	 * Rögzíti a játékos lépését a játéktáblára.
	 * 
	 * @param i A lépni kívánt mező sorindexe
	 * @param j A lépni kívánt mező oszlopindexe
	 * @param k Az aktuális játékost jelölő változó
	 */
	public void felvisz(int i, int j, int k){
		if(k==0){
		sajat[i][j]=1;
		sajat[a][b]=9;
		a=i;
		b=j;
		}
		else{
			sajat[i][j]=2;
			sajat[c][d]=9;
			c=i;
			d=j;
		}
	}
	/**
	 * Kirajzolja a standard outputra az aktuális játéktáblát.
	 */
	public void kirajzol(){
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int i=0; i<8; i++){
			System.out.print(i+" ");
			for(int j=0; j<8; j++)
				System.out.print(sajat[i][j]+" ");
			System.out.println();
		}
	}
	/**
	 * Az aktuális játéktáblát visszaadó getter függvény.
	 * @return visszadja a játéktáblát
	 */
	public int[][] getSajat() {
		return sajat;
	}
	
	
}
