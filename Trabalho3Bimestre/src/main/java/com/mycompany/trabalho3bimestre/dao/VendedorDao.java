/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.dao;

import com.mycompany.trabalho3bimestre.bean.Equipe;
import com.mycompany.trabalho3bimestre.bean.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class VendedorDao extends GenericDao<Vendedor,Long> {
    public VendedorDao(){
        super(Vendedor.class);
    }
}
