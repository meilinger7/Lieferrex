package com.htlimst.lieferrex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mandant")
public class Mandant {

        @Id
        @Column(name = "mandant_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotEmpty
        private String firmenname;
        @NotEmpty
        private String land;
        @NotEmpty
        private String ort;

        //@Size(min = 4, max = 6)
        private int plz;

        private String strasse;
        private String hausnummer;
        private int telefonnummer;

        private double umsatz_summe;
        private int seitenaufrufe_summe;

        // @Email
        private String email;
        private double mindestbestellwert;
        private double lieferkosten;

        /*
        @ManyToMany
        @JoinTable(name = "mandant_kategorie", joinColumns = @JoinColumn(name = "mandant_id"), inverseJoinColumns = @JoinColumn(name = "kategorie_id"))
        private Set<Kategorie> kategorie;
         */
        @ManyToOne
        @JoinColumn(name="kategorie_id")
        private Kategorie kategorie;


        @ManyToMany
        @JoinTable(name = "mandant_bestellart", joinColumns = @JoinColumn(name = "mandant_id"), inverseJoinColumns = @JoinColumn(name = "bestellart_id"))
        private Set<Bestellart> bestellart;

        @OneToMany(mappedBy = "mandant")
        private Set<Gericht> gerichte;

        @OneToMany(mappedBy = "mandant")
        private Set<Bestellung> bestellungen;

        @OneToMany(mappedBy = "mandant")
        private Set<Angestellter> angestellte;

        @OneToMany(mappedBy = "mandant")
        private Set<Umsatz> umsatz;

        @OneToMany(mappedBy = "mandant")
        private Set<Fragment> fragmente;


        @ManyToOne
        @JoinColumn(name="layout_id")
        private Layout layout;


        public Mandant(Long id, String firmenname, String land, String ort, int plz, String strasse, String hausnummer, int telefonnummer, double umsatz_summe, int seitenaufrufe_summe, String email, double mindestbestellwert, double lieferkosten, Kategorie kategorie, Set<Bestellart> bestellart, Layout layout) {
                this.id = id;
                this.firmenname = firmenname;
                this.land = land;
                this.ort = ort;
                this.plz = plz;
                this.strasse = strasse;
                this.hausnummer = hausnummer;
                this.telefonnummer = telefonnummer;
                this.umsatz_summe = umsatz_summe;
                this.seitenaufrufe_summe = seitenaufrufe_summe;
                this.email = email;
                this.mindestbestellwert = mindestbestellwert;
                this.lieferkosten = lieferkosten;
                this.kategorie = kategorie;
                this.bestellart = bestellart;
                this.layout = layout;
        }
}
