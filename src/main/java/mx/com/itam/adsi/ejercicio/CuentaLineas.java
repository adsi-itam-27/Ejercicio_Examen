package mx.com.itam.adsi.ejercicio;
import java.io.*;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class CuentaLineas{
    private final static Logger LOG = Logger.getLogger(CuentaLineas.class);

    public int codigo = 0,comentarios = 0,lineas = 0;
    private String fileName;
    private boolean esMultilinea =false;


    public void clear(){
    	codigo = 0;
    	comentarios = 0;
    	lineas = 0;

	LOG.info("limpia los contadores");
    }

    public void cuenta(String fileName){
	LOG.info("lee archivo");
        try{
            File file=new File(fileName);
            Scanner sc=new Scanner(file);
            int index;

            String linea;

            while(sc.hasNext()){
                linea=sc.nextLine();
                linea = linea.trim();
                //System.out.println(linea);

		LOG.info("pregunta si es un comentario multilinea");
                if(esMultilinea){
                    lineas++;
                    comentarios++;

                    if(linea.contains("*/"))
                        esMultilinea=false;
                
                }else if (linea.contains("/*")){
                    comentarios++;
                    lineas++;

                    if(!linea.contains("*/"))
                    	esMultilinea = true;
                    
                    if(linea.indexOf("/*")>0)
                        codigo++;
                }else if (!linea.isEmpty()){

                	if(!checaComentario(linea)){
                		codigo++;
                	}

                	lineas ++;
                }
            }

            sc.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    private boolean checaComentario(String linea){
        boolean res =false;

	linea = linea.replaceAll("\".*?\"","");
        if(linea.contains("//")){
	    comentarios++;
            if(linea.indexOf("//") > 0)
		codigo++;
	    res = true;
        }
 
	return res;
    }

}
