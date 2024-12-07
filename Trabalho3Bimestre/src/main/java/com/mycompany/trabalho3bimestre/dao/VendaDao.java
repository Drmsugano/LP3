/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.dao;

import com.mycompany.trabalho3bimestre.bean.Produto;
import com.mycompany.trabalho3bimestre.bean.Venda;
import com.mycompany.trabalho3bimestre.bean.Vendedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class VendaDao extends GenericDao<Venda,Long> {
    public VendaDao(){
        super(Venda.class);
    }
}
