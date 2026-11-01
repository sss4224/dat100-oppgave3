package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innlegg;
	private int nesteledig;

	public Blogg() {
		this.innlegg = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innlegg = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return this.nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return this.innlegg;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean finnes = false;
		int i = 0;
		int index = -1;

		while(i < this.nesteledig && finnes == false){
			finnes = this.innlegg[i].erLik(innlegg);
			i++;
		}
		if(finnes){
			index = i-1;
		}
		return index;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) > -1;
	}

	public boolean ledigPlass() {
		return this.nesteledig < this.innlegg.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(!ledigPlass()) return false;
		if(finnes(innlegg)) return false;

		this.innlegg[this.nesteledig] = innlegg;
		this.nesteledig++;
		return true;
	}
	
	public String toString() {

		String resultat = this.nesteledig + "\n";

		for(int i = 0; i < this.nesteledig; i++){
			resultat += this.innlegg[i].toString();
		}

		return resultat;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyInnlegg = new Innlegg[this.innlegg.length * 2];
		for(int i = 0; i < this.innlegg.length; i++){
			nyInnlegg[i] = this.innlegg[i];
		}
		this.innlegg = nyInnlegg;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if(!ledigPlass()){
			utvid();
		}
		if(finnes(innlegg)) return false;

		this.innlegg[this.nesteledig] = innlegg;
		this.nesteledig++;
		return true;
	}
	
	public boolean slett(Innlegg innlegg) {
		if(!finnes(innlegg)) return false;
		int index = finnInnlegg(innlegg);

		this.innlegg[index] = this.innlegg[this.nesteledig - 1];
		this.innlegg[nesteledig - 1] = null;
		this.nesteledig--;
		return true;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}