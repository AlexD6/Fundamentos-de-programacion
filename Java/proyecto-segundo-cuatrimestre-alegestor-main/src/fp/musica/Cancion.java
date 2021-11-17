package fp.musica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public class Cancion implements Comparable<Cancion>{
//	Name;Artist;Decade;Rank;valence;duration_ms;Country;Release date
//	The Twist;Chubby Checker;60;1;937;153760;United States;11/05/1960
	private String name;
	private String artist;
	private Integer decade;
	private Integer rank;
	private Integer valence;
	private Integer durationMS;
	private String country;
	private LocalDate releaseDate;
	
	public Cancion(String name, String artist, Integer decade, Integer rank, Integer valence, Integer durationMS,
			String country, LocalDate releaseDate) {
		this.name = name;
		this.artist = artist;
		Checkers.check("La década tiene que ser un número positivo", decade >= 0);
		this.decade = decade;
		setRank(rank);
		Checkers.check("La valencia tiene que ser un número positivo", valence >= 0);
		this.valence = valence;
		Checkers.check("La duración(ms) tiene que ser un número positivo", durationMS >= 0);
		this.durationMS = durationMS;
		this.country = country;
		setReleaseDate(releaseDate);
	}

	public Cancion(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.rank = null;
		this.valence = null;
		this.durationMS = null;
		this.country = null;
		this.releaseDate = null;
	}

	public String getName() {
		return name;
	}

	public String getArtist() {
		return artist;
	}

	public Integer getDecade() {
		return decade;
	}

	public Integer getRank() {
		return rank;
	}

	public Integer getValence() {
		return valence;
	}

	public Integer getDurationMS() {
		return durationMS;
	}

	public String getCountry() {
		return country;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setRank(Integer rank) {
		Checkers.check("La posicion del ranking tiene que estar entre 1 y 20", rank > 0 && rank < 21);
		this.rank = rank;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		Checkers.check("La fecha tiene que ser anterior a la actual", releaseDate.isBefore(LocalDate.now()));
		this.releaseDate = releaseDate;
	}
	
	public Double getSpotifyValence() {
		return getValence().doubleValue()/1000;
	}
	
	public String getDurationString() {
		Integer segundos = getDurationMS()/1000;
		Integer min = segundos/60;
		Integer seg = segundos%60;
		return min.toString() + ":" + seg.toString();
	}
	
	public Boolean getEsAlegre() {
		Boolean res = false;
		if (getSpotifyValence() >= 0.65) res = true;
		return res;
	}
	
	public Alegria getAlegria() {
		if(this.getSpotifyValence() >= 0.65) return Alegria.ALEGRE;
		else if(this.getSpotifyValence() <= 0.35) return Alegria.TRISTE;
		else return Alegria.NORMAL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cancion))
			return false;
		Cancion other = (Cancion) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cancion c) {
		int res = this.getName().compareTo(c.getName());
		if (res == 0) {
			res = this.getArtist().compareTo(c.getArtist());
		}
		return res;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha = getReleaseDate().format(formato);
		
		return String.format("Canción: %s, Artista: %s", getName(), getArtist());
//		return String.format("Canción: %s, Artista: %s, Decade: %s, Rank: %s, Valence: %s (%s), Duration: %s (%s),"
//				+ " Country: %s, ReleaseDate: %s, EsAlegre: %s, Alegria: %s", getName(), getArtist(), getDecade().toString(), getRank().toString(),
//				getValence().toString(), getSpotifyValence().toString(), getDurationMS().toString(), getDurationString(),
//				getCountry(), fecha, getEsAlegre().toString(), getAlegria().toString().toLowerCase());
	}
	
}
