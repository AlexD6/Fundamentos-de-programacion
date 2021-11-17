package fp.tipos.test;

import fp.tipos.AlbumImpl;
import fp.tipos.TipoAlbum;

public class TestAlbum {

	public static void main(String[] args) {
		AlbumImpl a = new AlbumImpl("Black or White", "qwertyuiopasdfghjklñzx", 99,1991,TipoAlbum.ALBUM);
		System.out.println(a);
	}
}
