package br.edu.infnet.pos.java.trabalhodebloco.dominio.entidades.estruturainterna;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author 00175142
 */

@Named("excelController")
@SessionScoped

public class ExcelController  implements Serializable {

       
  private String db = "projeto_bloco_final";
  private String user = "root";
  /** contraseña de MySql*/
  private String password = "root";
  /** Cadena de conexion */
  private String url = "jdbc:mysql://localhost/"+db;
  /** variable para trabajar con la conexion a la base de datos */
  private Connection conn = null;  
  
    /**
 * Constructor de clase
 */

  

    
    public ExcelController()
    {
      this.url = "jdbc:mysql://localhost/"+this.db;
       try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = (Connection) DriverManager.getConnection( this.url, this.user , this.password );
         if ( conn!=null ){
            System.out.println("Conectando a base de dados " + this.db);
         }
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }catch(ClassNotFoundException e){
         System.err.println( e.getMessage() );
      }
    }
    
   

    /**
 * Metodo para obtener los registros de la base de datos y crear el archivo excel
 */
    public void writeExcel(Modulo modulo) throws WriteException, IOException
    {
            FacesContext context = FacesContext.getCurrentInstance();
    //
        int row=0;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont( WritableFont.ARIAL, 12, WritableFont.NO_BOLD );
        WritableCellFormat cf = new WritableCellFormat(wf);    

        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));

        try {
            String caminhoAtual = getClass().getResource(getClass().getSimpleName() + ".class").getPath();
            String caminhoExcel = caminhoAtual.replace("build/web/WEB-INF/classes/br/edu/infnet/pos/java/trabalhodebloco/dominio/entidades/estruturainterna/ExcelController.class", "src/java/br/edu/infnet/pos/java/trabalhodebloco/excel");
            File file = new File(caminhoExcel + "/avaliacao_modulo_"+modulo.getNome()+".xls");
            workbook = Workbook.createWorkbook( file, wbSettings );
            //hoja con nombre de la tabla
            workbook.createSheet( "avaliacao", 0 );
//            // Cabeçalhos
//			String cabecalho[] = new String[5];
//			cabecalho[0] = "Id";
//			cabecalho[1] = "Objetivo";
//			cabecalho[2] = "Topico";
//			cabecalho[3] = "Questao";
//			cabecalho[4] = "Resposta";
// 
//                        
//                        Colour bckcolor = Colour.DARK_GREEN;
//			WritableCellFormat cellFormat = new WritableCellFormat();
//			cellFormat.setBackground(bckcolor);
// 
//			// Cor e tipo de fonte
//			WritableFont fonte = new WritableFont(WritableFont.ARIAL);
//			fonte.setColour(Colour.GOLD);
//			cellFormat.setFont(fonte);
//                        
//                        
//            excelSheet = workbook.getSheet(0);
//            
//            for (int i = 0; i < cabecalho.length; i++) {
//				Label label = new Label(i, 0, cabecalho[i]);
//				excelSheet.addCell(label);
//				WritableCell cell = excelSheet.getWritableCell(i, 0);
//                                cell.setCellFormat(cellFormat);
//			}
            
            System.out.println("criando excel...pronto"); 
            System.out.println("caminho onde foi salvo o arquivo: " + file.getAbsolutePath());
        } catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }

        //Consulta SQL 
       // String sql = "SELECT ci , nombre , apellido , fechanac, DATE_FORMAT(fechanac,'%Y-%m-%d %h:%i:%s') AS fecha , salario FROM persona ";
       // String sql = "select a.id AS id, a.objetivo AS objetivo, b.texto AS topico, c.texto AS questao, d.valor_likert AS resposta from avaliacao a,topico b,questao c,resposta d where a.id = b.id_avaliacao ";
        String sql = "select a.id AS id,a.objetivo,b.texto AS topico,c.texto AS questao, d.valor_likert AS resposta , d.id_modulo as modulo,f.nome as professor " +
"from avaliacao a,topico b,questao c,resposta d, turma e, pessoa f where a.id = b.id_avaliacao " +
"           and   a.id = c.id_avaliacao " +
"                and   b.id = c.id_topico " +
"               and   a.id = d.id_avaliacao " +
"               and   c.id = d.id_questao " +
"               and   e.id = d.id_turma " +
"               and   e.id_professor = f.id " +
"               and   d.id_modulo = " + modulo.getId();

        try{
             java.sql.PreparedStatement pstm = conn.prepareStatement( sql );
             ResultSet res = pstm.executeQuery();
             System.out.println(  "obtendo registros...pronto"  );
              while(res.next())
              {
                  System.out.println("teste = " + res.toString());
                  Label id     = new Label( 0 , row, res.getString("id" ) , cf );
                  Label objetivo  = new Label( 1 , row, res.getString( "objetivo" ) , cf );                  
                  Label topico= new Label( 2 , row, res.getString( "topico" ) , cf );                  
                  Label questao= new Label( 3 , row, res.getString( "questao" ) , cf );
                  Label resposta= new  Label ( 4 , row, res.getString("resposta" ) , cf );     
                  Label modulo1= new  Label ( 5 , row, res.getString("modulo" ) , cf );  
                  Label professor= new  Label ( 6 , row, res.getString("professor" ) , cf );  
                  row ++;                  
                 try {
                     
                                 // Cabeçalhos
			String cabecalho[] = new String[7];
			cabecalho[0] = "Id";
			cabecalho[1] = "Objetivo";
			cabecalho[2] = "Topico";
			cabecalho[3] = "Questao";
			cabecalho[4] = "Resposta";
                        cabecalho[5] = "Módulo";
                        cabecalho[6] = "Professor";
 
                        
                        Colour bckcolor = Colour.DARK_GREEN;
			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setBackground(bckcolor);
 
			// Cor e tipo de fonte
			WritableFont fonte = new WritableFont(WritableFont.ARIAL);
			fonte.setColour(Colour.GOLD);
			cellFormat.setFont(fonte);
                        
                        
            excelSheet = workbook.getSheet(0);
            
            for (int i = 0; i < cabecalho.length; i++) {
				Label label = new Label(i, 0, cabecalho[i]);
				excelSheet.addCell(label);
				WritableCell cell = excelSheet.getWritableCell(i, 0);
                                cell.setCellFormat(cellFormat);
			}
    
                    
                     excelSheet.addCell( id );
                     excelSheet.addCell( objetivo );
                     excelSheet.addCell( topico );
                     excelSheet.addCell( questao );
                     excelSheet.addCell(resposta);
                      excelSheet.addCell(modulo1);
                       excelSheet.addCell(professor);
                 } catch (WriteException ex) {
                     System.err.println(  ex.getMessage() );
                 } 
              }
             res.close();         
         }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }

        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println(  "Escrevendo no arquivo...pronto"  );         
        } catch (IOException ex) {
            System.err.println(  ex.getMessage() );
        }
        catch (WriteException ex) {
           System.err.println(  ex.getMessage() );
        }

        System.out.println(  "Finalizado"  );
        
//           FacesContext context = FacesContext.getCurrentInstance();
//        context.getExternalContext().redirect("index.xhtml");
        
    }

    
}