package com.htlimst.lieferrex.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "fragmentmap")
public class Fragmentmap {


    @Id
    @Column(name = "fragmentmap_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String longitude;

    @NotEmpty
    private String latitude;

    @OneToOne
    @JoinColumn(name="fragment_id", nullable=false, insertable=false, updatable=false)
    private Fragment fragment;

}

