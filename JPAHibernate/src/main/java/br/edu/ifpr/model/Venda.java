/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.model;

import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author drmsugano
 */
@Entity
class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    private Double valor;
    @OneToMany
    private List<Vendedor> vendedor_id;
    @ManyToOne
    private Gerente gerente;
}
