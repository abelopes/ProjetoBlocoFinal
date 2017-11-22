/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author thiago
 */

@Named("excelController")
@SessionScoped
public class ExcelController implements Serializable{

    /**
     * Creates a new instance of ExcelController
     */
    public ExcelController() {
    }
    
    public void createCsvFile() throws IOException {
         try {


            BufferedWriter StrW = new BufferedWriter(new FileWriter("/tmp/tabela.csv")); //C:\\tabela.csv


            StrW.write("Nome;Telefone;Idade\n");
            StrW.write("Juliana;6783-8490;23\n");
            StrW.write("Tatiana;6743-7480;45\n");
            StrW.write("Janice;6909-9380;21");


            StrW.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("index.xhtml");
    }
    
}
